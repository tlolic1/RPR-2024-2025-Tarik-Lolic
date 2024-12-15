package com.example.lvl07.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class Osoba {
    private IntegerProperty id;
    private StringProperty ime;
    private StringProperty prezime;
    private StringProperty adresa;
    private ObjectProperty<Date> datumRodjenja;
    private StringProperty maticniBroj;
    private ObjectProperty<Uloga> uloga;

    public Osoba(Integer id, String ime, String prezime, String adresa, Date datumRodjenja, String maticniBroj, Uloga uloga) {
        // inicijalizacija polja
        this.id = new SimpleIntegerProperty(id);
        this.ime = new SimpleStringProperty();
        this.prezime = new SimpleStringProperty(prezime);
        this.adresa = new SimpleStringProperty(adresa);
        this.datumRodjenja = new SimpleObjectProperty<>(datumRodjenja);
        this.maticniBroj = new SimpleStringProperty();
        this.uloga = new SimpleObjectProperty<>(uloga);

        // validacija polja
        setIme(ime);
        setMaticniBroj(maticniBroj);
    }

    // id
    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    // ime
    public String getIme() {
        return ime.get();
    }

    public StringProperty imeProperty() {
        return ime;
    }

    public void setIme(String ime) {
        if (ime == null || ime.length() < 2 || ime.length() > 50) {
            throw new IllegalArgumentException("Ime mora imati izmedju 2 i 50 znakova.");
        }
        this.ime.set(ime);
    }

    // prezime
    public String getPrezime() {
        return prezime.get();
    }

    public StringProperty prezimeProperty() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    // adresa
    public String getAdresa() {
        return adresa.get();
    }

    public StringProperty adresaProperty() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa.set(adresa);
    }

    // datumRodjenja
    public Date getDatumRodjenja() {
        return datumRodjenja.get();
    }

    public ObjectProperty<Date> datumRodjenjaProperty() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja.set(datumRodjenja);
    }

    // maticniBroj
    public String getMaticniBroj() {
        return maticniBroj.get();
    }

    public StringProperty maticniBrojProperty() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        if (maticniBroj == null || maticniBroj.trim().isEmpty() || maticniBroj.length() != 13) {
            throw new IllegalArgumentException("Maticni broj mora imati tacno 13 karaktera");
        } else if (!ProvjeriMaticniBroj(maticniBroj)) {
            throw new IllegalArgumentException("Maticni broj se ne poklapa sa datumom rodjenja!");
        }
        this.maticniBroj.set(maticniBroj);
    }

    // uloga
    public Uloga getUloga() {
        return uloga.get();
    }

    public ObjectProperty<Uloga> ulogaProperty() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga.set(uloga);
    }

    // Dummy method for maticniBroj validation
    private boolean ProvjeriMaticniBroj(String maticniBroj) {
        // Implement validation logic here
        return true;
    }
}