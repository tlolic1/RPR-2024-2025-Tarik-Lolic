package com.example.lv09;

import java.sql.*;

public class Database {
    private static final String DB_URL = "jdbc:sqlite:baza";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Povezano s bazom podataka!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS korisnici ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "ime TEXT NOT NULL, "
                + "godine INTEGER NOT NULL"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Tabela 'korisnici' je kreirana.");
        } catch (SQLException e) {
            System.out.println("SQL Greška: " + e.getMessage());
        }
    }

    public static void executeQuery(String parametar1, int parametar2) {
        String SQL_QUERY = "SELECT * FROM korisnici WHERE ime = ? AND godine > ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY)) {

            // (1) Postavljanje parametara u PreparedStatement
            pstmt.setString(1, parametar1);
            pstmt.setInt(2, parametar2);

            // (2) Izvršavanje upita
            ResultSet rs = pstmt.executeQuery(); // Koristi se za SELECT upite

            // (3) Obrada rezultata (samo za SELECT upite)
            while (rs.next()) {
                String ime = rs.getString("ime");
                int godine = rs.getInt("godine");
                // Rad s dobijenim podacima
                System.out.println("Ime: " + ime + ", Godine: " + godine);
            }

        } catch (SQLException e) {
            // Obrada greške
            System.out.println("SQL Greška: " + e.getMessage());
        }
    }
}