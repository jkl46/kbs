package gui.screens;

import gui.Blokje;
import gui.LoopbandGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Loopband extends JDialog implements ActionListener {
    public JButton rood = new JButton("rood");
    public JButton blauw = new JButton("blauw");
    public JButton groen = new JButton("groen");
    public JPanel loopendebandGraphics;

    public List<Blokje> blokjes = new ArrayList<>();
    public Loopband(JFrame frame, boolean modal) {
        super(frame, modal);
        setSize(600, 300);
        setTitle("Loopband");

        loopendebandGraphics = new LoopbandGraphics(this);
        loopendebandGraphics.setPreferredSize(new Dimension(600, 200));
        loopendebandGraphics.setBackground(new Color(0, 0, 0));

        JLabel label = new JLabel();
        label.setText("Visualisatie van de loopband:");

        rood.setText("rood");
        rood.addActionListener(this);
        add(rood);


        blauw.setText("blauw");
        blauw.addActionListener(this);
        add(blauw);


        groen.setText("groen");
        groen.addActionListener(this);
        add(groen);

        setLayout(new FlowLayout());
        add(label);
        add(loopendebandGraphics);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        loopendebandGraphics.repaint();
        if (e.getSource() == rood) {
            System.out.println("rood");
            Blokje blokje = new Blokje();
            blokje.setKleur(Color.RED);
            blokjes.add(blokje);
        }else if (e.getSource()== blauw){
            Blokje blokje = new Blokje();
            blokje.setKleur(Color.BLUE);
            blokjes.add(blokje);
        }else if (e.getSource()== groen){
            Blokje blokje = new Blokje();
            blokje.setKleur(Color.GREEN);
            blokjes.add(blokje);
        }
    }
}
