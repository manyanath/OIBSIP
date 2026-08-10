package com.reservation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {

        DatabaseSetup.createTables();

        JFrame frame = new JFrame("Online Reservation System");

        // Title
        JLabel title = new JLabel("Online Reservation System");
        title.setBounds(90, 20, 250, 30);

        // Username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 70, 100, 25);

        JTextField userField = new JTextField();
        userField.setBounds(150, 70, 150, 25);

        // Password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 110, 100, 25);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 110, 150, 25);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 160, 100, 30);

        // Login Button Action
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = userField.getText();
                String password = new String(passField.getPassword());

                if (username.equals("admin") && password.equals("admin123")) {
            
                    JOptionPane.showMessageDialog(frame, "Login Successful!");

                    frame.dispose();

                    new ReservationForm();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Username or Password!");
                }
            }
        });

        // Add Components
        frame.add(title);
        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginButton);

        // Frame Settings
        frame.setSize(400, 280);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
