package com.example.lvl07.controller;

import com.example.lvl07.model.Osoba;
import com.example.lvl07.model.OsobaModel;
import com.example.lvl07.view.OsobaView;
import java.util.Date;
import com.example.lvl07.model.Uloga;

public class OsobaController {
    private OsobaModel model;
    private OsobaView view;

    public OsobaController(OsobaModel model, OsobaView view) {
        this.model = model;
        this.view = view;
    }

    public void dodajOsobu(Integer id, String ime, String prezime, String adresa, String datumRodjenja, String maticniBroj, String ulogaNaziv) {
        try {
            String rezultat = model.dodajOsobu(id, ime, prezime, adresa, new Date(datumRodjenja), maticniBroj, new Uloga(ulogaNaziv));
            view.setPoruka(rezultat);
        } catch (Exception e) {
            view.setPoruka("Greska pri dodavanju: " + e.getMessage());
        }
    }

    public Osoba dajOsobuPoId(Integer id) {
        Osoba osoba = model.dajOsobuPoId(id);
        if (osoba == null) {
            view.setPoruka("Osoba nije pronadjena!");
        } else {
            view.setPoruka(osoba.toString());
        }
        return osoba;
    }

    public void azurirajIme(Integer id, String novoIme) {
        try {
            String rezultat = model.azurirajOsobu(id, novoIme, null, null, null, null, null);
            view.setPoruka(rezultat);
        } catch (Exception e) {
            view.setPoruka("Greska: " + e.getMessage());
        }
    }

    public void obrisiOsobu(Integer id) {
        model.obrisiOsobu(id);
        view.setPoruka("Osoba sa ID " + id + " je obrisana.");
    }

    public void napuniPodatke() {
        model.napuni();
        view.setPoruka("Podaci su uspjesno napunjeni.");
    }

    public void dajOsobeIzTxtDatoteke(String filePath) {
        try {
            model.ucitajOsobeIzTxtDatoteke(filePath);
            view.setPoruka("Osobe uspješno učitane iz TXT datoteke.");
        } catch (Exception e) {
            view.setPoruka("Greška pri učitavanju iz TXT datoteke: " + e.getMessage());
        }
    }
}