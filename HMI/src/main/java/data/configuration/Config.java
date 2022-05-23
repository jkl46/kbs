package data.configuration;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Config {
    private DatabaseConfig database;
    private String arduino1port;
    private String arduino2port;

    public static Config loadConfiguration()
    {
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream("config.yml");
        } catch (FileNotFoundException e) {
            System.out.println("Please create a config.yml file");
        }

        if (inputStream == null) {
            return null;
        }

        Yaml yaml = new Yaml(new Constructor(Config.class));
        Config data = yaml.load(inputStream);

        return data;
    }

    public DatabaseConfig getDatabase() {
        return database;
    }

    public String getArduino1Port() {
        return this.arduino1port;
    }

    public void setArduino1port(String arduino1port) {
        this.arduino1port = arduino1port;
    }

    public String getArduino2Port() {
        return this.arduino2port;
    }

    public void setArduino2port(String arduino2port) {
        this.arduino2port = arduino2port;
    }

    public void setDatabase(DatabaseConfig database) {
        this.database = database;
    }
}
