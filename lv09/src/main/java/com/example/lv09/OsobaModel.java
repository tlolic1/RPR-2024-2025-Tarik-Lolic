package com.example.lv09;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OsobaModel {
    private static final String DATABASE_URL = "jdbc:sqlite:baza.db";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static OsobaModel instance = null;

    private OsobaModel() {
        // Private constructor to prevent instantiation
    }

    public static OsobaModel getInstance() {
        if (instance == null) {
            instance = new OsobaModel();
        }
        return instance;
    }

    public static void removeInstance() {
        instance = null;
    }

    public static SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }

    public void kreirajTabeluAkoNePostoji() {
        String kreirajOsobaTabeluSql = """
            CREATE TABLE IF NOT EXISTS Osoba (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                ime TEXT,
                prezime TEXT,
                adresa TEXT,
                datumRodjenja TEXT,
                maticniBroj TEXT,
                uloga TEXT
            );
        """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(kreirajOsobaTabeluSql);
            System.out.println("Tabela je kreirana ili vec postoji!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void napuniInicijalnimPodacima() {
        String insertSQL = """
            INSERT INTO Osoba (ime, prezime, adresa, datumRodjenja, maticniBroj, uloga)
            VALUES (?, ?, ?, ?, ?, ?);
        """;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setString(1, "John");
            pstmt.setString(2, "Doe");
            pstmt.setString(3, "Some Address");
            pstmt.setString(4, "1995-01-15");
            pstmt.setString(5, "1501995123456");
            pstmt.setString(6, "STUDENT");
            pstmt.executeUpdate();

            pstmt.setString(1, "Alice");
            pstmt.setString(2, "Alister");
            pstmt.setString(3, "Another Address");
            pstmt.setString(4, "1980-05-20");
            pstmt.setString(5, "2005980444444");
            pstmt.setString(6, "NASTAVNO_OSOBLJE");
            pstmt.executeUpdate();

            System.out.println("Ubaceni pocetni podaci!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void isprazniTabeluOsoba() {
        String deleteSQL = "DELETE FROM Osoba";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            int brojObrisanihRedova = stmt.executeUpdate(deleteSQL);
            System.out.println("Obrisani redovi tabele. Broj obrisanih redova: " + brojObrisanihRedova);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Osoba> dajSveOsobe() {
        List<Osoba> osobe = new ArrayList<>();
        String upit = "SELECT * FROM Osoba";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(upit)) {

            while (rs.next()) {
                Osoba osoba = new Osoba(
                        rs.getInt("id"),
                        rs.getString("ime"),
                        rs.getString("prezime"),
                        rs.getString("adresa"),
                        dateFormat.parse(rs.getString("datumRodjenja")),
                        rs.getString("maticniBroj"),
                        Uloga.valueOf(rs.getString("uloga"))
                );
                osobe.add(osoba);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return osobe;
    }

    public Osoba dajOsobuPoId(Integer id) {
        Osoba osoba = null;
        String upit = "SELECT * FROM Osoba WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(upit)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                osoba = new Osoba(
                        rs.getInt("id"),
                        rs.getString("ime"),
                        rs.getString("prezime"),
                        rs.getString("adresa"),
                        dateFormat.parse(rs.getString("datumRodjenja")),
                        rs.getString("maticniBroj"),
                        Uloga.valueOf(rs.getString("uloga"))
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return osoba;
    }

    public String azurirajOsobu(Integer id, String novoIme, String novoPrezime, String novaAdresa, Date noviDatumRodjenja, String noviMaticniBroj, Uloga novaUloga) {
        StringBuilder upit = new StringBuilder("UPDATE Osoba SET ");
        boolean imaPromjene = false;

        // lista koja cuva parametre
        List<Object> parametri = new ArrayList<>();

        // provjera vrijednosti pojedinih polja (da li su prazna ili ne)
        if (novoIme != null && !novoIme.isEmpty()) {
            upit.append("ime = ?, ");
            parametri.add(novoIme);
            imaPromjene = true;
        }
        if (novoPrezime != null && !novoPrezime.isEmpty()) {
            upit.append("prezime = ?, ");
            parametri.add(novoPrezime);
            imaPromjene = true;
        }
        if (novaAdresa != null && !novaAdresa.isEmpty()) {
            upit.append("adresa = ?, ");
            parametri.add(novaAdresa);
            imaPromjene = true;
        }
        if (noviDatumRodjenja != null) {
            upit.append("datumRodjenja = ?, ");
            parametri.add(dateFormat.format(noviDatumRodjenja));  // Format the date
            imaPromjene = true;
        }
        if (noviMaticniBroj != null && !noviMaticniBroj.isEmpty()) {
            upit.append("maticniBroj = ?, ");
            parametri.add(noviMaticniBroj);
            imaPromjene = true;
        }
        if (novaUloga != null) {
            upit.append("uloga = ?, ");
            parametri.add(novaUloga.name());
            imaPromjene = true;
        }

        // izadji ranije ako nema polja za azuriranje
        if (!imaPromjene) {
            return "Sva polja su ista kao i prije!";
        }

        // uklanjanje zareza na kraju upita i razmaka iz SQL upita
        upit.delete(upit.length() - 2, upit.length());
        upit.append(" WHERE id = ?");

        // dodaj id kao parametar
        parametri.add(id);

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(upit.toString())) {

            // dodavanje parameatara u PreparedStatement
            for (int i = 0; i < parametri.size(); i++) {
                pstmt.setObject(i + 1, parametri.get(i));
            }

            int promijenjeniRedovi = pstmt.executeUpdate();
            if (promijenjeniRedovi > 0) {
                return "Osoba je uspjesno azurirana";
            } else {
                return "Ne postoji osoba sa datim id-em";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public String obrisiOsobuPoId(Integer id) {
        String deleteSQL = "DELETE FROM Osoba WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                return "Ne postoji osoba sa datim id-em";
            }
            return "Osoba je uspjesno obrisana";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}