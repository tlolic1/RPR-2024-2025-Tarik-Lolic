package com.example.lvl07.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class OsobaModel {
    private ObservableList<Osoba> osobe;

    public OsobaModel() {
        this.osobe = FXCollections.observableArrayList();
    }

    public String dodajOsobu(Integer id, String ime, String prezime, String adresa, Date datumRodjenja, String maticniBroj, Uloga uloga) {
        try {
            Osoba newOsoba = new Osoba(id, ime, prezime, adresa, datumRodjenja, maticniBroj, uloga);
            osobe.add(newOsoba);
            return "Osoba je uspjesno dodana!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public ObservableList<Osoba> dajSveOsobe() {
        return osobe;
    }

    public Osoba dajOsobuPoId(Integer id) {
        for (Osoba osoba : osobe) {
            if (osoba.getId() == id) {
                return osoba;
            }
        }
        return null;
    }

    public String azurirajOsobu(Integer id, String novoIme, String novoPrezime, String novaAdresa, Date noviDatumRodjenja, String noviMaticniBroj, Uloga novaUloga) {
        Osoba trazenaOsoba = dajOsobuPoId(id);
        if (trazenaOsoba != null) {
            try {
                if (novoIme != null) trazenaOsoba.setIme(novoIme);
                if (novoPrezime != null) trazenaOsoba.setPrezime(novoPrezime);
                if (novaAdresa != null) trazenaOsoba.setAdresa(novaAdresa);
                if (noviDatumRodjenja != null) trazenaOsoba.setDatumRodjenja(noviDatumRodjenja);
                if (noviMaticniBroj != null) trazenaOsoba.setMaticniBroj(noviMaticniBroj);
                if (novaUloga != null) trazenaOsoba.setUloga(novaUloga);
                return "Osoba je uspjesno azurirana!";
            } catch (IllegalArgumentException e) {
                return e.getMessage();
            }
        }
        return "Osoba nije pronadjena!";
    }

    public String obrisiOsobu(Integer id) {
        boolean removed = osobe.removeIf(osoba -> osoba.getId() == id);
        if (removed) {
            return "Osoba je uspjesno obrisana!";
        } else {
            return "Osoba nije pronadjena!";
        }
    }

    public void napuni() {
        osobe.add(new Osoba(1, "Neko", "Nekic", "Neka adresa", new Date(97, 8, 25), "2509997123456", new Uloga("STUDENT")));
        osobe.add(new Osoba(2, "Neko 2", "Nekic 2", "Neka adresa 2", new Date(97, 8, 25), "2509997123457", new Uloga("NASTAVNO_OSOBLJE")));
    }

    public void ucitajOsobeIzTxtDatoteke(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    Integer id = Integer.parseInt(data[0]);
                    String ime = data[1];
                    String prezime = data[2];
                    String adresa = data[3];
                    Date datumRodjenja = new Date(data[4]);
                    String maticniBroj = data[5];
                    Uloga uloga = new Uloga(data[6]);
                    dodajOsobu(id, ime, prezime, adresa, datumRodjenja, maticniBroj, uloga);
                }
            }
        }
    }

    //dodaj getosobe
    public ObservableList<Osoba> getOsobe() {
        return osobe;
    }
}
