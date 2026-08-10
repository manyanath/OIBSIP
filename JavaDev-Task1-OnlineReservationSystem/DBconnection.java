package com.reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    private static final String URL = "jdbc:sqlite:reservation.db";

    public static Connection connect() {
        try {
            Connection conn = DriverManager.getConnection(URL);
            System.out.println("Database Connected!");
            return conn;
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return null;
        }
    }
}
