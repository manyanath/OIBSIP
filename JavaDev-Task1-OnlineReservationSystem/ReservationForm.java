package com.reservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ReservationForm extends JFrame {

    JTextField passengerField;
    JTextField trainNumberField;
    JTextField trainNameField;
    JTextField journeyDateField;
    JTextField sourceField;
    JTextField destinationField;

    JComboBox<String> classBox;

    JButton bookButton;

    public ReservationForm() {

        setTitle("Reservation Form");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Train Reservation Form");
        title.setBounds(150, 20, 200, 30);
        add(title);

        JLabel p1 = new JLabel("Passenger Name");
        p1.setBounds(40, 70, 120, 25);
        add(p1);

        passengerField = new JTextField();
        passengerField.setBounds(180,70,200,25);
        add(passengerField);

        JLabel p2 = new JLabel("Train Number");
        p2.setBounds(40,110,120,25);
        add(p2);

        trainNumberField = new JTextField();
        trainNumberField.setBounds(180,110,200,25);
        add(trainNumberField);

        JLabel p3 = new JLabel("Train Name");
        p3.setBounds(40,150,120,25);
        add(p3);

        trainNameField = new JTextField();
        trainNameField.setBounds(180,150,200,25);
        add(trainNameField);
        trainNumberField.addActionListener(e -> {

    String trainNo = trainNumberField.getText();

    switch(trainNo){

        case "12345":
            trainNameField.setText("Rajdhani Express");
            break;

        case "12627":
            trainNameField.setText("Karnataka Express");
            break;

        case "12951":
            trainNameField.setText("Mumbai Rajdhani");
            break;

        case "12001":
            trainNameField.setText("Shatabdi Express");
            break;

        default:
            trainNameField.setText("Unknown Train");
    }

});

        JLabel p4 = new JLabel("Class");
        p4.setBounds(40,190,120,25);
        add(p4);

        classBox = new JComboBox<>();
        classBox.addItem("Sleeper");
        classBox.addItem("AC");
        classBox.addItem("First Class");
        classBox.setBounds(180,190,200,25);
        add(classBox);

        JLabel p5 = new JLabel("Journey Date");
        p5.setBounds(40,230,120,25);
        add(p5);

        journeyDateField = new JTextField();
        journeyDateField.setBounds(180,230,200,25);
        add(journeyDateField);

        JLabel p6 = new JLabel("Source");
        p6.setBounds(40,270,120,25);
        add(p6);

        sourceField = new JTextField();
        sourceField.setBounds(180,270,200,25);
        add(sourceField);

        JLabel p7 = new JLabel("Destination");
        p7.setBounds(40,310,120,25);
        add(p7);

        destinationField = new JTextField();
        destinationField.setBounds(180,310,200,25);
        add(destinationField);

        bookButton = new JButton("Book Ticket");
        bookButton.setBounds(170,370,140,35);
        add(bookButton);
        bookButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        String passenger = passengerField.getText().trim();
            String trainNo = trainNumberField.getText().trim();
            String trainName = trainNameField.getText().trim();
            String journeyDate = journeyDateField.getText().trim();
            String source = sourceField.getText().trim();
            String destination = destinationField.getText().trim();

if (passenger.isEmpty() || trainNo.isEmpty() || trainName.isEmpty()
        || journeyDate.isEmpty() || source.isEmpty() || destination.isEmpty()) {

    JOptionPane.showMessageDialog(null, "Please fill all fields!");
    return;
}

if (!trainNo.matches("\\d+")) {
    JOptionPane.showMessageDialog(null, "Train Number should contain only digits!");
    return;
}

if (source.equalsIgnoreCase(destination)) {
    JOptionPane.showMessageDialog(null, "Source and Destination cannot be the same!");
    return;
}

if (!journeyDate.matches("\\d{2}-\\d{2}-\\d{4}")) {
    JOptionPane.showMessageDialog(null, "Enter Journey Date in DD-MM-YYYY format!");
    return;
}

        String pnr = Reservation.bookTicket(
            
                passengerField.getText(),
                trainNumberField.getText(),
                trainNameField.getText(),
                classBox.getSelectedItem().toString(),
                journeyDateField.getText(),
                sourceField.getText(),
                destinationField.getText());

               JOptionPane.showMessageDialog(
                null,
                "Reservation Successful!\n\n" +
                "Passenger : " + passenger + "\n" +
                "Train Number : " + trainNo + "\n" +
                "Train Name : " + trainName + "\n" +
                "Class : " + classBox.getSelectedItem().toString() + "\n" +
                "Journey Date : " + journeyDate + "\n" +
                "Source : " + source + "\n" +
                "Destination : " + destination + "\n\n" +
                "PNR Number : " + pnr
        );

    }
});

JButton cancelFormButton = new JButton("Cancel Ticket");
cancelFormButton.setBounds(170, 420, 140, 35);
add(cancelFormButton);

cancelFormButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        new CancellationForm();
    }
});

setVisible(true);

}   // End of constructor

}   // End of class
