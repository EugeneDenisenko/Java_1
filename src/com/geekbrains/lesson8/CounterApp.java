package com.geekbrains.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp extends JFrame {
    private int value;

    public CounterApp() {
        setTitle("Счетчик");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 200, 300, 200);

        Font font32 = new Font("Arial", Font.BOLD, 32);
        Font font15 = new Font("Arial", Font.BOLD, 10);

        setLayout(null);

        JLabel jLabel = new JLabel();
        jLabel.setFont(font32);
        jLabel.setBounds(30, 20, 225, 120);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(jLabel);

        value = 0;
        jLabel.setText(String.valueOf(value));

        JButton reset = new JButton("Reset");
        reset.setFont(font15);
        reset.setBounds(0, 0, 284, 30);
        add(reset);

        JButton decButton = new JButton("<");
        decButton.setFont(font32);
        decButton.setBounds(0, 30, 60, 100);
        add(decButton);

        JButton incButton = new JButton(">");
        incButton.setFont(font32);
        incButton.setBounds(224, 30, 60, 100);
        add(incButton);

        JButton decButtonTen = new JButton("-10");
        decButtonTen.setFont(font15);
        decButtonTen.setBounds(0, 130, 142, 30);
        add(decButtonTen);

        JButton incButtonTen = new JButton("+10");
        incButtonTen.setFont(font15);
        incButtonTen.setBounds(142, 130, 142, 30);
        add(incButtonTen);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == reset) {
                    value = 0;
                } else if (e.getSource() == decButton) {
                    value--;
                } else if (e.getSource() == incButton) {
                    value++;
                } else if (e.getSource() == decButtonTen) {
                    value -= 10;
                } else if (e.getSource() == incButtonTen) {
                    value += 10;
                }
                refreshValue(jLabel);
            }
        };

        reset.addActionListener(actionListener);
        decButton.addActionListener(actionListener);
        incButton.addActionListener(actionListener);
        decButtonTen.addActionListener(actionListener);
        incButtonTen.addActionListener(actionListener);

        setVisible(true);
    }

    private void refreshValue(JLabel jLabel) {
        jLabel.setText(String.valueOf(value));
    }

    public static void main(String[] args) {
        new CounterApp();
    }
}
