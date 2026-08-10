package com.reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

public class Reservation {

    public static String bookTicket(
            String passengerName,
            String trainNumber,
            String trainName,
            String classType,
            String journeyDate,
            String source,
            String destination) {

        String pnr = UUID.randomUUID().toString().substring(0,8).toUpperCase();

        try {

            Connection conn = DBconnection.connect();

            String sql = "INSERT INTO reservations VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, pnr);
            ps.setString(2, passengerName);
            ps.setString(3, trainNumber);
            ps.setString(4, trainName);
            ps.setString(5, classType);
            ps.setString(6, journeyDate);
            ps.setString(7, source);
            ps.setString(8, destination);

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch(Exception e){
            e.printStackTrace();
        }

        return pnr;
    }

}
