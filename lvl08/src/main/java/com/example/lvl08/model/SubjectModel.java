package com.example.lvl08.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SubjectModel {
    private ObservableList<Subject> predmeti = FXCollections.observableArrayList();

    public void dodajPredmet(Subject subject) {
        predmeti.add(subject);
    }

    public ObservableList<Subject> getPredmeti() {
        return predmeti;
    }
}