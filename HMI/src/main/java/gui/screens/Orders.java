package gui.screens;

import data.database.OrderLinesTable;
import data.database.OrdersTable;
import data.models.OrderLine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Orders extends JDialog implements ActionListener {
    OrderLinesTable orderLines = new OrderLinesTable();
    JButton jbZoek;
    JTextField jtOrderId = new JTextField();
    ArrayList<JButton> editButtons;
    ArrayList<JButton> startButtons;
    ArrayList<JLabel> orderIds;
    ArrayList<JLabel> itemCounters;
    int page = 1;

    public Orders(JFrame frame, boolean modal) {
        super(frame, modal);
        setSize(600, 600);
        setTitle("Orders");
        setLayout(new GridLayout(7, 4));

        editButtons = new ArrayList<>();
        startButtons = new ArrayList<>();
        orderIds = new ArrayList<>();
        itemCounters = new ArrayList<>();

        add(new JLabel("Zoek order id: "));
        add(jtOrderId);
        add(jbZoek = new JButton("Zoek"));
        jbZoek.addActionListener(this);
        add(new JLabel());

        for (int i = 0; i < 5; i++) {
            editButtons.add(new JButton());
            startButtons.add(new JButton());
            orderIds.add(new JLabel());
            itemCounters.add(new JLabel());

            add(orderIds.get(i));
            add(itemCounters.get(i));
            add(startButtons.get(i));
            startButtons.get(i).setText("Starten");
            add(editButtons.get(i));
            editButtons.get(i).setText("Bijwerken");
        }

        updateOrders(0);

        JButton jbPrevious;
        add(jbPrevious = new JButton("Vorige 5"));
        jbPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(page > 0) {
                    page--;
                    updateOrders(page * 5);
                }
            }
        });

        JButton jbNext;
        add(jbNext = new JButton("Volgende 5"));
        jbNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateOrders(page * 5);
                page++;
            }
        });

        setVisible(true);
    }

    public void updateOrders(int startId) {
        int counter = 0;
        for (int i = startId + 1; i < startId + 6; i++) {
            List<OrderLine> order = orderLines.loadOrderLinesByOrderId(i);
            JButton editButton = editButtons.get(counter);
            JButton startButton = startButtons.get(counter);
            JLabel orderId = orderIds.get(counter);
            JLabel itemCount = itemCounters.get(counter);
            int finalI = i;

            for (ActionListener al : editButton.getActionListeners()) {
                editButton.removeActionListener(al);
            }

            editButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new OrderEdit(finalI);
                }
            });

            for (ActionListener al : startButton.getActionListeners()) {
                startButton.removeActionListener(al);
            }

            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new OrderStart(finalI);
                }
            });

            orderId.setText("Order " + i);
            itemCount.setText("Aantal items " + order.size());

            counter++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int id = Integer.parseInt(jtOrderId.getText());
        if (e.getSource() == jbZoek && !jtOrderId.getText().equals("") && id < 1001 && id > 0) {
            try {
                new OrderEdit(id);
            } catch (Exception ex) {
                System.out.println("Error: must enter valid syntax");
            }
        }else{
            System.out.println("Error: order doesn't exist");
        }
    }
}
