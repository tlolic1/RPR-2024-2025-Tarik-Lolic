package com.example.lvl08.model;

public class Osoba {
    private String ime;
    private String prezime;
    private String adresa;
    private String datumRodjenja;
    private String maticniBroj;
    private Uloga uloga;

    public Osoba(String ime, String prezime, String adresa, String datumRodjenja, String maticniBroj, Uloga uloga) {
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.datumRodjenja = datumRodjenja;
        this.maticniBroj = maticniBroj;
        this.uloga = uloga;
    }

    // Getters and setters for each field
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(String datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }


    @Override
    public String toString() {
        return ime + ", " + prezime + ", " + adresa + ", " + datumRodjenja + ", " + maticniBroj + ", " + uloga;
    }
}