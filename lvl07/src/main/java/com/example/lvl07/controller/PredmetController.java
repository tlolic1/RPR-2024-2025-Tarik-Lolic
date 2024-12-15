// PredmetController.java
package com.example.lvl07.controller;

import com.example.lvl07.model.PredmetModel;
import com.example.lvl07.view.PredmetView;

public class PredmetController {
    private PredmetModel model;
    private PredmetView view;

    public PredmetController(PredmetModel model, PredmetView view) {
        this.model = model;
        this.view = view;
    }

    public void azurirajNaziv(Integer id, String noviNaziv) {
        String poruka = model.azurirajPredmet(id, noviNaziv, null);
        view.setPoruka(poruka);
    }

    public void azurirajEcts(Integer id, Integer noviEcts) {
        String poruka = model.azurirajPredmet(id, null, noviEcts);
        view.setPoruka(poruka);
    }
}