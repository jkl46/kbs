package gui.screens;

import data.database.OrdersTable;
import data.models.Order;
import data.models.OrderLine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OrderCreate extends JDialog implements ActionListener {
    public static int RED = 228;
    public static int GREEN = 228;
    public static int BLUE = 228;

    public JTextField red = new JTextField(5);
    public JTextField green = new JTextField(5);
    public JTextField blue = new JTextField(5);

    public JButton createButton = new JButton("Aanmaken");

    public OrderCreate(JFrame frame, boolean modal) {
        super(frame, modal);
        setSize(600, 200);
        setTitle("Order Aanmaken");

        this.setLayout(new FlowLayout());

        add(new JLabel("Rood: "));
        add(red);
        add(new JLabel("Groen: "));
        add(green);
        add(new JLabel("Blauw: "));
        add(blue);

        this.setLayout(new FlowLayout());
        createButton.addActionListener(this);
        add(createButton);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            Order order = new Order();
            order.setCustomerID(1);
            List<OrderLine> orderLines = order.getOrderLines();

            OrdersTable ordersTable = new OrdersTable();
            ordersTable.saveOrder(order);

            try {
                orderLines.add(OrderLine.create().setStockItemId(RED).setQuantity(Integer.parseInt(red.getText())));
                orderLines.add(OrderLine.create().setStockItemId(GREEN).setQuantity(Integer.parseInt(green.getText())));
                orderLines.add(OrderLine.create().setStockItemId(BLUE).setQuantity(Integer.parseInt(blue.getText())));

                orderLines.stream().forEach(ordersTable::saveModel);
            } catch (Exception exception) {

            }
        }
    }
}

