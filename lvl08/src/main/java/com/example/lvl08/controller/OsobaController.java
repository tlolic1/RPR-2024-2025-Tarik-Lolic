package com.example.lvl08.controller;

import com.example.lvl08.model.Uloga;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.example.lvl08.model.Osoba;
import com.example.lvl08.model.OsobaModel;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class OsobaController {
    @FXML
    private Label ucitavanjeLabel;
    @FXML
    private ListView<Osoba> osobeListView;
    @FXML
    private TextField imeField;
    @FXML
    private TextField prezimeField;
    @FXML
    private TextField adresaField;
    @FXML
    private DatePicker datumRodjenjaPicker;
    @FXML
    private TextField maticniBrojField;
    @FXML
    private ChoiceBox<Uloga> ulogaChoiceBox;
    @FXML
    private Button azurirajOsobuButton;
    @FXML
    private Label porukaLabel;

    private OsobaModel model;
    private ObservableList<Osoba> osobeObservableList = FXCollections.observableArrayList();
    private Osoba izabranaOsoba;

    public OsobaController(OsobaModel model) {
        this.model = model;
    }

    @FXML
    public void initialize() {
        // Load data into the model
        model.napuni();

        // Set the label text and style
        ucitavanjeLabel.setText("Ucitani podaci");
        ucitavanjeLabel.setStyle("-fx-background-color: green;");

        // Set the button text
        azurirajOsobuButton.setText("Azuriraj");

        // Add items to the ChoiceBox
        ulogaChoiceBox.getItems().addAll(Uloga.STUDENT, Uloga.NASTAVNO_OSOBLJE);

        // Populate the ListView with data from the model
        osobeObservableList.addAll(model.dajSveOsobe());
        osobeListView.setItems(osobeObservableList);

        // Add a listener to the ListView to handle selection changes
        osobeListView.getSelectionModel().selectedItemProperty().addListener((observable, staraVrijednost, novaVrijednost) -> {
            if (novaVrijednost != null) {
                // Update the variable representing the currently selected person
                izabranaOsoba = novaVrijednost;
                // Fill the fields with the details of the selected person
                ispuniPolja(novaVrijednost);
                // Hide the label containing the message
                porukaLabel.setVisible(false);
            }
        });

        // Set the action for the update button
        azurirajOsobuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                azurirajOsobu();
            }
        });
    }

    private void azurirajOsobu() {
        if (izabranaOsoba != null) {
            // Read the input field values
            String ime = imeField.getText();
            String prezime = prezimeField.getText();
            String adresa = adresaField.getText();
            LocalDate datumRodjenjaLocal = datumRodjenjaPicker.getValue();
            String maticniBroj = maticniBrojField.getText();
            Uloga uloga = ulogaChoiceBox.getValue();

            // Validate form fields
            if (ime.isEmpty() || prezime.isEmpty() || adresa.isEmpty() || maticniBroj.isEmpty() || datumRodjenjaLocal == null || uloga == null) {
                porukaLabel.setVisible(true);
                porukaLabel.setText("Sva polja moraju biti popunjena!");
                return;
            }

            // Update the selected person
            izabranaOsoba.setIme(ime);
            izabranaOsoba.setPrezime(prezime);
            izabranaOsoba.setAdresa(adresa);
            izabranaOsoba.setDatumRodjenja(datumRodjenjaLocal.toString());
            izabranaOsoba.setMaticniBroj(maticniBroj);
            izabranaOsoba.setUloga(uloga);

            model.azurirajOsobu(osobeListView.getSelectionModel().getSelectedIndex(), izabranaOsoba);
            porukaLabel.setVisible(true);
            porukaLabel.setText("Osoba ažurirana!");
            osobeListView.refresh();
        }
    }

    private void ispuniPolja(Osoba osoba) {
        imeField.setText(osoba.getIme());
        prezimeField.setText(osoba.getPrezime());
        adresaField.setText(osoba.getAdresa());
        datumRodjenjaPicker.setValue(LocalDate.parse(osoba.getDatumRodjenja()));
        maticniBrojField.setText(osoba.getMaticniBroj());
        ulogaChoiceBox.setValue(osoba.getUloga());
    }
}