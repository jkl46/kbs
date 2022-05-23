package data.database;

import data.models.OrderLine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class OrderLinesTable extends Connection {
    public OrderLinesTable() {
    }

    public List<OrderLine> loadOrderLinesByOrderId(int id) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM orderlines WHERE OrderId=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            return (List<OrderLine>) this.fetchModel(OrderLine.class, rs);
        } catch (Exception e) {
            return null;
        }
    }
}
