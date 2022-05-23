package data.database;

import data.models.Order;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class OrdersTable extends Connection {
    public OrdersTable() {
    }

    public List<Order> loadOrders() {
        try {
            Statement statement = createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM orders");
            return (List<Order>) this.fetchModel(Order.class, rs);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean saveOrder(Order order) {
        return this.saveModel(order);
    }
}
