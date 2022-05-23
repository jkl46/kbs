package data.models;

import java.util.Date;

public class OrderLine extends DataObject {
    private int OrderLineID;
    private int OrderId;
    private int StockItemId;
    private String Description;
    private int PackageTypeId;
    private int Quantity;
    private double UnitPrice;
    private double TaxRate;
    private int PickedQuantity;
    private Date PickingCompletedWhen;

    @Override
    public String getTableName() {
        return "orderlines";
    }

    @Override
    public int getId() {
        return this.getOrderId();
    }

    public static OrderLine create() {
        return new OrderLine();
    }

    public int getOrderLineID() {
        return OrderLineID;
    }

    public OrderLine setOrderLineID(int orderLineID) {
        OrderLineID = orderLineID;
        return this;
    }

    public int getOrderId() {
        return OrderId;
    }

    public OrderLine setOrderId(int orderId) {
        OrderId = orderId;
        return this;
    }

    public int getStockItemId() {
        return StockItemId;
    }

    public OrderLine setStockItemId(int stockItemId) {
        StockItemId = stockItemId;
        return this;
    }

    public String getDescription() {
        return Description;
    }

    public OrderLine setDescription(String description) {
        Description = description;
        return this;
    }

    public int getPackageTypeId() {
        return PackageTypeId;
    }

    public OrderLine setPackageTypeId(int packageTypeId) {
        PackageTypeId = packageTypeId;
        return this;
    }

    public int getQuantity() {
        return Quantity;
    }

    public OrderLine setQuantity(int quantity) {
        Quantity = quantity;
        return this;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public OrderLine setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
        return this;
    }

    public double getTaxRate() {
        return TaxRate;
    }

    public OrderLine setTaxRate(double taxRate) {
        TaxRate = taxRate;
        return this;
    }

    public int getPickedQuantity() {
        return PickedQuantity;
    }

    public OrderLine setPickedQuantity(int pickedQuantity) {
        PickedQuantity = pickedQuantity;
        return this;
    }

    public Date getPickingCompletedWhen() {
        return PickingCompletedWhen;
    }

    public OrderLine setPickingCompletedWhen(Date pickingCompleteWhen) {
        PickingCompletedWhen = pickingCompleteWhen;
        return this;
    }
}
