package com.example.lvl08.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OsobaModel {
    private ObservableList<Osoba> osobe = FXCollections.observableArrayList();

    public void napuni() {
        // Add code to populate the list with data
        osobe.add(new Osoba("Tarik", "Lolic", "Bosanska BB", "2003-08-10", "123456789", Uloga.STUDENT));
        osobe.add(new Osoba("Hamza", "Ramic", "Zmaja od Bosne 1", "2003-05-20", "987654321", Uloga.NASTAVNO_OSOBLJE));
    }

    public ObservableList<Osoba> dajSveOsobe() {
        return osobe;
    }

    public void azurirajOsobu(int index, Osoba osoba) {
        osobe.set(index, osoba);
    }

    public ObservableList<Osoba> getOsobe() {
        return osobe;
    }
}