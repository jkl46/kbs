package arduinoCom;

import data.configuration.Config;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGui extends JFrame implements ActionListener {
    Arduino ard1 = new Arduino(Config.loadConfiguration().getArduino1Port());
    Arduino ard2 = new Arduino(Config.loadConfiguration().getArduino2Port());

    JTextField P1JTmotorSpeed = new JTextField();
    JButton P1JBsetMotorSpeed = new JButton("Set motor");

    JTextField P1rotorSpeed1 = new JTextField();
    JButton P1JBsetRotorSpeed1 = new JButton("set servo1");
    JTextField P1JTRotorSpeed2 = new JTextField();
    JButton P1JBsetRotorSpeed2 = new JButton("set servo2");

    JTextField P2JTmotorSpeed = new JTextField();
    JButton P2JBsetMotorSpeed = new JButton("Set motor");

    JTextField P2JTrotorSpeed = new JTextField();
    JButton P2JBsetRotorSpeed1 = new JButton("set servo1");

    public MainGui (){
        setSize(250,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        jp1.setLayout(new GridLayout(0,2));
        jp2.setLayout(new GridLayout(0,2));
        jp1.setBackground(Color.green);
        jp2.setBackground(Color.yellow);
        jp1.add(new JLabel("Packing arduino"));
        jp1.add(new JLabel(""));
        jp1.add(P1JTmotorSpeed);
        P1JBsetMotorSpeed.addActionListener(this);
        jp1.add(P1JBsetMotorSpeed);

        jp1.add(P1rotorSpeed1);
        P1JBsetRotorSpeed1.addActionListener(this);
        jp1.add(P1JBsetRotorSpeed1);
        jp1.add(P1JTRotorSpeed2);
        P1JBsetRotorSpeed2.addActionListener(this);
        jp1.add(P1JBsetRotorSpeed2);

        jp2.add(new JLabel("Sorting arduino"));
        jp2.add(new JLabel(""));
        jp2.add(P2JTmotorSpeed);
        P2JBsetMotorSpeed.addActionListener(this);
        jp2.add(P2JBsetMotorSpeed);
        jp2.add(P2JTrotorSpeed);
        P2JBsetRotorSpeed1.addActionListener(this);
        jp2.add(P2JBsetRotorSpeed1);
        add(jp1);
        add(jp2);
        ard2.setServoRotor(1, (char) 20);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton s = (JButton) e.getSource();
        if (s.equals(P1JBsetMotorSpeed)){
            char v = (char) Integer.parseInt(P1JTmotorSpeed.getText());
            ard1.setMotorSpeed(1, v);
        }
        else if (s.equals(P1JBsetRotorSpeed1)){
            char v = (char) Integer.parseInt(P1rotorSpeed1.getText());
            ard1.setServoRotor(1, v);
        }
        else if (s.equals(P1JBsetRotorSpeed2)){
            char v = (char) Integer.parseInt(P1JTRotorSpeed2.getText());
            ard1.setServoRotor(2, v);
        }
        else if (s.equals(P2JBsetRotorSpeed1)){
            char v = (char) Integer.parseInt(P2JTrotorSpeed.getText());
            ard2.setServoRotor(1, v);
        }
        else if (s.equals(P2JBsetMotorSpeed)){
            char v = (char) Integer.parseInt(P2JTmotorSpeed.getText());
            ard2.setMotorSpeed(1, v);
        }
//        else if (s.equals(JBgetMotorSpeed)){
//            System.out.println("Motor speed: " + (int)ard.getMotorSpeed());
//        }
    }
}
