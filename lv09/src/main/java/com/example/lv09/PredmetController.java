package com.example.lv09;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class PredmetController {
    @FXML
    private Label porukaLabel;
    @FXML
    private Button azurirajPredmetButton;
    @FXML
    private ChoiceBox<Integer> predmetIdChoiceBox;
    @FXML
    private ListView<Predmet> predmetiListView;
    @FXML
    private TextField nazivTextField;
    @FXML
    private TextField ectsTextField;

    private Predmet izabraniPredmet;
    private ObservableList<Predmet> predmetiObservableList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        PredmetModel predmetModel = PredmetModel.getInstance();
        ucitajPredmeteIzBaze();
        predmetiListView.setItems(predmetiObservableList);

        azurirajPredmetButton.setOnAction(event -> azurirajPredmet());

        predmetiListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                izabraniPredmet = newValue;
                ispuniPolja(newValue);
                porukaLabel.setVisible(false);
            }
        });
    }

    private void ucitajPredmeteIzBaze() {
        List<Predmet> predmeti = PredmetModel.getInstance().dajSvePredmete();
        predmetiObservableList.setAll(predmeti);
    }

    private void ispuniPolja(Predmet predmet) {
        nazivTextField.setText(predmet.getNaziv());
        ectsTextField.setText(String.valueOf(predmet.getEcts()));
    }

    private void azurirajPredmet() {
        if (izabraniPredmet == null) {
            porukaLabel.setText("Nijedan predmet nije izabran!");
            porukaLabel.setVisible(true);
            return;
        }

        String noviNaziv = nazivTextField.getText();
        int noviEcts;
        try {
            noviEcts = Integer.parseInt(ectsTextField.getText());
        } catch (NumberFormatException e) {
            porukaLabel.setText("Neispravan format ECTS bodova!");
            porukaLabel.setVisible(true);
            return;
        }

        String poruka = PredmetModel.getInstance().azurirajPredmet(
                izabraniPredmet.getId(),
                noviNaziv,
                noviEcts
        );

        ucitajPredmeteIzBaze();
        predmetiListView.refresh();

        porukaLabel.setVisible(true);
        porukaLabel.setText(poruka);
    }
}