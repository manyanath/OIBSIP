package com.reservation;

import javax.swing.*;
import java.sql.*;

public class CancellationForm extends JFrame {

    JTextField pnrField;
    JTextArea detailsArea;
    JButton fetchButton;
    JButton cancelButton;

    public CancellationForm() {

        setTitle("Cancellation Form");
        setSize(500, 450);
        setLayout(null);

        JLabel pnrLabel = new JLabel("Enter PNR:");
        pnrLabel.setBounds(40, 30, 100, 25);
        add(pnrLabel);

        pnrField = new JTextField();
        pnrField.setBounds(150, 30, 200, 25);
        add(pnrField);

        fetchButton = new JButton("Fetch");
        fetchButton.setBounds(170, 70, 100, 30);
        add(fetchButton);

        detailsArea = new JTextArea();
        detailsArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(detailsArea);
        scroll.setBounds(40, 120, 400, 180);
        add(scroll);

        cancelButton = new JButton("Cancel Reservation");
        cancelButton.setBounds(140, 330, 180, 35);
        add(cancelButton);

        // Fetch Booking
        fetchButton.addActionListener(e -> fetchReservation());

        // Cancel Booking
        cancelButton.addActionListener(e -> cancelReservation());

        setVisible(true);
    }

    private void fetchReservation() {

        try {

            Connection conn = DBconnection.connect();

            String sql = "SELECT * FROM reservations WHERE pnr=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, pnrField.getText());

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                detailsArea.setText(
                        "Passenger : " + rs.getString("passengerName") +
                        "\nTrain No : " + rs.getString("trainNumber") +
                        "\nTrain Name : " + rs.getString("trainName") +
                        "\nClass : " + rs.getString("classType") +
                        "\nJourney : " + rs.getString("journeyDate") +
                        "\nSource : " + rs.getString("source") +
                        "\nDestination : " + rs.getString("destination")
                );

            }else{

                JOptionPane.showMessageDialog(this,"PNR Not Found");

            }

            conn.close();

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    private void cancelReservation(){

        int choice = JOptionPane.showConfirmDialog(
                this,
                "Do you want to cancel this reservation?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION);

        if(choice==JOptionPane.YES_OPTION){

            try{

                Connection conn = DBconnection.connect();

                String sql="DELETE FROM reservations WHERE pnr=?";

                PreparedStatement ps=conn.prepareStatement(sql);

                ps.setString(1,pnrField.getText());

                int rows=ps.executeUpdate();

                if(rows>0){

                    JOptionPane.showMessageDialog(this,"Reservation Cancelled");

                    detailsArea.setText("");

                    pnrField.setText("");

                }else{

                    JOptionPane.showMessageDialog(this,"PNR Not Found");

                }

                conn.close();

            }catch(Exception ex){

                ex.printStackTrace();

            }

        }

    }

}
