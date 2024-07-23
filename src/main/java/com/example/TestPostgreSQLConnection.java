package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestPostgreSQLConnection {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/ordermanagament";
        String jdbcUsername = "postgres";
        String jdbcPassword = "1234";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            if (connection != null) {
                System.out.println("Veritabanına başarılı bir şekilde bağlandı!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
