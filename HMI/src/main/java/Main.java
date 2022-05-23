import data.database.OrdersTable;
import data.models.Order;
import data.models.OrderLine;
import gui.GUI;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();

        OrdersTable ordersTable = new OrdersTable();
        List<Order> orderList = ordersTable.loadOrders();
        ordersTable.saveOrder(orderList.stream().findFirst().get());

        for (OrderLine orderLine : orderList.stream().findFirst().get().getOrderLines()) {
            System.out.println(orderLine.getDescription());
        }
    }
}
