package com.reservation;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {

    public static void createTables() {

        try {
            Connection conn = DBconnection.connect();
            Statement stmt = conn.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS reservations (" +
                    "pnr TEXT PRIMARY KEY," +
                    "passengerName TEXT," +
                    "trainNumber TEXT," +
                    "trainName TEXT," +
                    "classType TEXT," +
                    "journeyDate TEXT," +
                    "source TEXT," +
                    "destination TEXT" +
                    ");";

            stmt.execute(sql);

            System.out.println("Table Created Successfully!");

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
