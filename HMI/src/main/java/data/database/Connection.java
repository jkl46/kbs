package data.database;

import data.configuration.Config;
import data.configuration.DatabaseConfig;
import data.models.DataObject;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

abstract public class Connection {
    public java.sql.Connection connection;

    public Connection() {
        try {
            DatabaseConfig databaseConfig = loadConfiguration();
            if (databaseConfig == null) {
                return;
            }

            String myUrl = String.format("jdbc:mysql://%s/%s", databaseConfig.getHost(), databaseConfig.getDatabase());
            connection = DriverManager.getConnection(myUrl, databaseConfig.getUsername(), databaseConfig.getPassword());
        } catch (SQLException e) {
            System.out.println("Could not establish database connection");
            System.out.println(e.getMessage());
        }
    }

    public List<?> fetchModel(Class<?> dataObjectClass, ResultSet resultSet) {
        List<Object> dataObjects = new ArrayList<>();

        try {
            while (resultSet.next()) {
                Object dataObject = dataObjectClass.getDeclaredConstructor().newInstance();

                for (Method method : dataObject.getClass().getMethods()) {
                    if (method.getName().startsWith("set")) {
                        String attributeName = method.getName().replaceFirst("set", "");

                        Object value = null;
                        for (Parameter parameter : method.getParameters()) {
                            Method getMethod = resultSet.getClass().getDeclaredMethod(String.format("get%s", capitalize(parameter.getType().getSimpleName())), String.class);
                            if (getMethod != null) {
                                value = getMethod.invoke(resultSet, attributeName);
                            }
                        }

                        if (value == null) {
                            continue;
                        }

                        method.invoke(dataObject, value);
                    }
                }

                dataObjects.add(dataObject);
            }

            return dataObjects;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean saveModel(DataObject dataObject) {
        StringBuilder query = new StringBuilder("INSERT INTO " + dataObject.getTableName());

        List<Method> methods = Arrays.stream(dataObject.getClass().getMethods())
                .filter(x -> x.getName().startsWith("get"))
                .filter(x -> Arrays.stream(DataObject.class.getMethods()).noneMatch(y -> y.getName().equals(x.getName())))
                .filter(x -> x.getReturnType().equals(int.class) || x.getReturnType().equals(String.class))
                .collect(Collectors.toList());

        List<String> fields = new ArrayList<>();

        for (Method method : methods) {
            fields.add(method.getName().replaceFirst("get", ""));
        }

        List<String> values = new ArrayList<>();
        for (Method method : methods) {
            try {
                String value = String.valueOf(method.invoke(dataObject));
                if (value.equals("0")) {
                    value = null;
                }
                values.add(value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        query.append(String.format("(%s) VALUES (%s)", String.join(",", fields), String.join(",", values)));

        Statement statement = this.createStatement();

        System.out.println(query);

        try {
            statement.executeUpdate(query.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private DatabaseConfig loadConfiguration() {
        Config config = Config.loadConfiguration();

        if (config != null) {
            return config.getDatabase();
        }

        return null;
    }

    public Statement createStatement() {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
