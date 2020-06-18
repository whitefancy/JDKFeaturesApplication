package javacore.awtswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hang extends JFrame {
    private static final long serialVersionUID = 5321579168274373687L;

    private Hang() {
        JButton b1 = new JButton("Sleep");
        JButton b2 = new JButton("Hello");
        b1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Thread.currentThread().sleep(5000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
        );
        b2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Hello World");
                    }
                }
        );
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(b1);
        getContentPane().add(b2);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Hang();
    }
}
