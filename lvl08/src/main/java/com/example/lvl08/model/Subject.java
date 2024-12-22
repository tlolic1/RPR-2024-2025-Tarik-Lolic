package com.example.lvl08.model;

public class Subject {
    private String naziv;
    private String opis;
    private int ects;

    public Subject(String naziv, String opis, int ects) {
        this.naziv = naziv;
        this.opis = opis;
        this.ects = ects;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }

    public int getEcts() {
        return ects;
    }

    @Override
    public String toString() {
        return naziv + ", " + opis + ", " + ects;
    }
}