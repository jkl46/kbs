package gui.screens;

import data.database.OrderLinesTable;
import data.models.OrderLine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OrderStart extends JDialog {
    public OrderStart(int id){
        setModal(true);
        setTitle("Start order nr."+ id);

        OrderLinesTable orderLines = new OrderLinesTable();
        List<OrderLine> order = orderLines.loadOrderLinesByOrderId(id);

        setSize(300, 200);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Order Id: "+ id));
        add(new JLabel("Aantal items "+ order.size()));
        add(new JLabel("Aantal Rood:"));
        add(new JLabel());
        add(new JLabel("Aantal Groen:"));
        add(new JLabel());
        add(new JLabel("Aantal Blauw:"));
        add(new JLabel());

        JButton jbStart;
        add(jbStart = new JButton("Starten"));
        jbStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //start order
                System.out.println("Start order number: "+ id);
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
