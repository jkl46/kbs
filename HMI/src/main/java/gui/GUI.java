package gui;

import javax.swing.*;

import gui.screens.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    private JButton createOrderButton;
    private JButton ordersButton;
    private JButton archiveButton;
    private JButton treadmillButton;
    private JButton storageButton;

    public GUI() {
        this.setSize(new Dimension(600, 450));
        this.setLayout(new GridLayout(3,2));

        this.drawGUI();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void drawGUI() {
        createOrderButton = new JButton("Aanmaken order");
        add(createOrderButton);
        createOrderButton.addActionListener(this);
        ordersButton = new JButton("Orders");
        add(ordersButton);
        ordersButton.addActionListener(this);
        archiveButton = new JButton("Archief");
        add(archiveButton);
        archiveButton.addActionListener(this);
        treadmillButton = new JButton("Loopband");
        add(treadmillButton);
        treadmillButton.addActionListener(this);
        storageButton = new JButton("Voorraad");
        add(storageButton);
        storageButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ordersButton) {
                Orders newOrders = new Orders(this, true);
        } else if(e.getSource()==archiveButton) {
            Archief newArchief = new Archief(this, true);
        } else if(e.getSource()==treadmillButton){
            Loopband newLoopband = new Loopband(this, true);
        } else if(e.getSource()==storageButton){
            Voorraad newVoorraad = new Voorraad(this, true);
        } else if(e.getSource()==createOrderButton){
            OrderCreate newOrderCreate = new OrderCreate(this, true);
        }
    }
}
