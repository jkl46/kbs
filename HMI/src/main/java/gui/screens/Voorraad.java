package gui.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Voorraad extends JDialog implements ActionListener  {
    JTextField Rood2,Blauw2,Groen2;
    int voorraadRood = 4, voorraadBlauw = 6, voorraadGroen = 1;
    JButton refreshButton,returnButton;
    ImageIcon image1 = new ImageIcon("src/main/resources/IMAGES/BLAUWE_LEGO.png");
    ImageIcon image2 = new ImageIcon("src/main/resources/IMAGES/RODE_LEGO.png");
    ImageIcon image3 = new ImageIcon("src/main/resources/IMAGES/GROENE_LEGO.png");
    public Voorraad(JFrame frame, boolean modal) {
        super(frame, modal);
        this.setSize(1000, 400);
        this.setTitle("Voorraad");
        this.drawGUI();
        setLayout(new GridLayout(4,3,5,40));
        this.setVisible(true);
    }
    private void drawGUI() {
        refreshButton = new JButton("refresh");
        add(refreshButton);
        refreshButton.addActionListener(this);
        JLabel labelBlank = new JLabel();
        add(labelBlank);
        returnButton = new JButton("return");
        add(returnButton);
        returnButton.addActionListener(this);

        JLabel Rood = new JLabel(" Rood:");
        Rood2 = new JTextField(""+voorraadRood);
        add(Rood);
        add(Rood2);
        JLabel RedImage = new JLabel();
        RedImage.setIcon(image2);
        add(RedImage);

        JLabel Blauw = new JLabel(" Blauw:");
        Blauw2 = new JTextField(""+voorraadBlauw);
        add(Blauw);
        add(Blauw2);
        JLabel BlueImage = new JLabel();
        BlueImage.setIcon(image1);
        add(BlueImage);

        JLabel Groen = new JLabel(" Groen:");
        Groen2 = new JTextField(""+voorraadGroen);
        add(Groen);
        add(Groen2);
        JLabel GreenImage = new JLabel();
        GreenImage.setIcon(image3);
        add(GreenImage);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==refreshButton) { 
            Rood2.setText(""+voorraadRood);
            Blauw2.setText(""+voorraadBlauw);
            Groen2.setText(""+voorraadGroen);
            setVisible(false);
            setVisible(true);
        } else if(e.getSource()==returnButton) {
            dispose();;
        }
    }
}

