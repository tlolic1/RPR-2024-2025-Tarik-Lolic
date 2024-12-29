package com.example.lv09;

public class Predmet {
    private int id;
    private String naziv;
    private int ects;

    // Constructors, getters, and setters
    public Predmet(int id, String naziv, int ects) {
        this.id = id;
        this.naziv = naziv;
        this.ects = ects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }
}