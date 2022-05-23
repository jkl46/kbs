package data.models;

import data.database.OrderLinesTable;

import java.util.Date;
import java.util.List;

public class Order extends DataObject {
    private int OrderID;
    private int CustomerID;
    private Date OrderDate;

    @Override
    public String getTableName() {
        return "orders";
    }

    @Override
    public int getId() {
        return this.getOrderID();
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public List<OrderLine> getOrderLines()
    {
        return (new OrderLinesTable()).loadOrderLinesByOrderId(this.OrderID);
    }
}
