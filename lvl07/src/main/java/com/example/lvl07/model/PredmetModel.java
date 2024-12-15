// PredmetModel.java
package com.example.lvl07.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PredmetModel {
    private ObservableList<Predmet> predmeti;

    public PredmetModel() {
        this.predmeti = FXCollections.observableArrayList();
    }

    public void napuni() {
        predmeti.add(new Predmet(1, "Matematika", 6));
        predmeti.add(new Predmet(2, "Fizika", 5));
    }

    public ObservableList<Predmet> getPredmeti() {
        return predmeti;
    }

    public Predmet dajPredmetPoId(Integer id) {
        for (Predmet predmet : predmeti) {
            if (predmet.getId().equals(id)) {
                return predmet;
            }
        }
        return null;
    }

    public String azurirajPredmet(Integer id, String noviNaziv, Integer noviEcts) {
        Predmet predmet = dajPredmetPoId(id);
        if (predmet != null) {
            if (noviNaziv != null) predmet.setNaziv(noviNaziv);
            if (noviEcts != null) predmet.setEcts(noviEcts);
            return "Predmet je uspjesno azuriran!";
        }
        return "Predmet nije pronadjen!";
    }
}