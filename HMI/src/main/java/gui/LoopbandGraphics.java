package gui;

import gui.screens.Loopband;

import javax.swing.*;
import java.awt.*;

public class LoopbandGraphics extends JPanel {
    Loopband loopband;
    public LoopbandGraphics(Loopband loopband) {
        this.loopband = loopband;
    }

    public static int red = 0;
    public static int green = 0;
    public static int blue = 0;
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 0;

        for (Blokje blokje : this.loopband.blokjes) {

                g.setColor(blokje.getKleur());
                g.drawRect(x, 50, 100, 100);
                g.fillRect(x, 50, 100, 100);
                x += 110;

        }
    }
}
