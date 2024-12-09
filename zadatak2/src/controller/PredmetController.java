package controller;

import model.Predmet;
import view.PredmetView;

public class PredmetController {
    private Predmet model;
    private PredmetView view;

    public PredmetController(Predmet model, PredmetView view) {
        this.model = model;
        this.view = view;
    }

    public void setNazivPredmeta() {
        String naziv = view.getNaziv();
        model.setNaziv(naziv);
    }

    public void setECTSPredmeta() {
        Double ECTS = view.getECTS();
        model.setECTS(ECTS);
    }

    public void prikaziPredmet() {
        view.prikaziPredmet(model);
    }
}