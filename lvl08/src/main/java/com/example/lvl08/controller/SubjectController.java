package com.example.lvl08.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.example.lvl08.model.SubjectModel;
import com.example.lvl08.model.Subject;

public class SubjectController {
    @FXML
    private TextField nazivField;
    @FXML
    private TextField opisField;
    @FXML
    private TextField ectsField;
    @FXML
    private Button dodajPredmetButton;
    @FXML
    private Label porukaLabel;

    private SubjectModel model;

    public SubjectController(SubjectModel model) {
        this.model = model;
    }

    @FXML
    public void initialize() {
        dodajPredmetButton.setOnAction(event -> dodajPredmet());
    }

    private void dodajPredmet() {
        String naziv = nazivField.getText();
        String opis = opisField.getText();
        String ects = ectsField.getText();

        if (naziv.isEmpty() || opis.isEmpty() || ects.isEmpty()) {
            porukaLabel.setText("Sva polja moraju biti popunjena!");
            porukaLabel.setVisible(true);
            return;
        }

        try {
            int ectsBodovi = Integer.parseInt(ects);
            Subject subject = new Subject(naziv, opis, ectsBodovi);
            model.dodajPredmet(subject);
            porukaLabel.setText("Predmet uspješno dodan!");
            porukaLabel.setVisible(true);
            nazivField.clear();
            opisField.clear();
            ectsField.clear();
            model.getPredmeti().forEach(System.out::println);
        } catch (NumberFormatException e) {
            porukaLabel.setText("ECTS mora biti broj!");
            porukaLabel.setVisible(true);
        }
    }
}