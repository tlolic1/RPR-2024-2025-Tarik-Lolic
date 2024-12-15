// Predmet.java
package com.example.lvl07.model;

public class Predmet {
    private Integer id;
    private String naziv;
    private Integer ects;

    public Predmet(Integer id, String naziv, Integer ects) {
        this.id = id;
        this.naziv = naziv;
        this.ects = ects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getEcts() {
        return ects;
    }

    public void setEcts(Integer ects) {
        this.ects = ects;
    }

    @Override
    public String toString() {
        return id + "," + naziv + "," + ects;
    }
}