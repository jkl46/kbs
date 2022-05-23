package gui.screens;

import data.database.OrderLinesTable;
import data.models.OrderLine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OrderEdit extends JDialog {
    public OrderEdit(int id){
        setModal(true);
        setTitle("Edit order nr."+ id);

        OrderLinesTable orderLines = new OrderLinesTable();
        List<OrderLine> order = orderLines.loadOrderLinesByOrderId(id);

        setSize(300, 100 + order.size() * 60);
        setLayout(new GridLayout(2 + order.size() * 2, 2));

        add(new JLabel("Order Id: "+ id));
        add(new JLabel("Aantal items "+ order.size()));

        for (OrderLine line:order) {
            add(new JLabel("StockItemid:"+ line.getStockItemId()));
            add(new JLabel());

            add(new JLabel("Aantal"));
            JTextField jtQuantity;
            add(jtQuantity = new JTextField());
            jtQuantity.setText(String.valueOf(line.getQuantity()));
        }

        JButton jbEdit;
        add(jbEdit = new JButton("Bijwerken"));
        jbEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //apply changes
                System.out.println("Edit order number: "+ id);
            }
        });

        JButton jbCancel;
        add(jbCancel = new JButton("Annuleren"));
        jbCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}
