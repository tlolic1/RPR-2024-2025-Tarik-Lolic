package com.example.lv09;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PredmetModel {
    private static final String DATABASE_URL = "jdbc:sqlite:baza.db";
    private static PredmetModel instance = null;

    private PredmetModel() {
        // Private constructor to prevent instantiation
    }

    public static PredmetModel getInstance() {
        if (instance == null) {
            instance = new PredmetModel();
        }
        return instance;
    }

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }

    public void kreirajTabeluAkoNePostoji() {
        String kreirajPredmetTabeluSql = """
            CREATE TABLE IF NOT EXISTS Predmet (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                naziv TEXT,
                ects INTEGER
            );
        """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(kreirajPredmetTabeluSql);
            System.out.println("Tabela Predmet je kreirana ili vec postoji!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Predmet> dajSvePredmete() {
        List<Predmet> predmeti = new ArrayList<>();
        String selectSQL = "SELECT * FROM Predmet";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            while (rs.next()) {
                Predmet predmet = new Predmet(
                        rs.getInt("id"),
                        rs.getString("naziv"),
                        rs.getInt("ects")
                );
                predmeti.add(predmet);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return predmeti;
    }

    public Predmet dajPredmetPoId(int id) {
        String selectSQL = "SELECT * FROM Predmet WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Predmet(
                        rs.getInt("id"),
                        rs.getString("naziv"),
                        rs.getInt("ects")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String azurirajPredmet(int id, String naziv, int ects) {
        String updateSQL = "UPDATE Predmet SET naziv = ?, ects = ? WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            pstmt.setString(1, naziv);
            pstmt.setInt(2, ects);
            pstmt.setInt(3, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                return "Ne postoji predmet sa datim id-em";
            }
            return "Predmet je uspjesno azuriran";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public String obrisiPredmetPoId(int id) {
        String deleteSQL = "DELETE FROM Predmet WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                return "Ne postoji predmet sa datim id-em";
            }
            return "Predmet je uspjesno obrisan";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}