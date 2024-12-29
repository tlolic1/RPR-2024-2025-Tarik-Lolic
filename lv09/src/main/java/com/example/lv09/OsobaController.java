package com.example.lv09;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.application.Platform;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static com.example.lv09.Database.connect;

public class OsobaController {
    @FXML
    private Label ucitavanjeLabel;
    @FXML
    private Label porukaLabel;
    @FXML
    private Button azurirajOsobuButton;
    @FXML
    private ChoiceBox<Uloga> ulogaChoiceBox;
    @FXML
    private ListView<Osoba> osobeListView;
    @FXML
    private TextField imeTextField;
    @FXML
    private TextField prezimeTextField;
    @FXML
    private TextField adresaTextField;
    @FXML
    private TextField datumRodjenjaTextField;
    @FXML
    private TextField maticniBrojTextField;

    private Osoba izabranaOsoba;
    private ObservableList<Osoba> osobeObservableList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        OsobaModel osobaModel = OsobaModel.getInstance();
        osobaModel.kreirajTabeluAkoNePostoji();
        osobaModel.isprazniTabeluOsoba();
        osobaModel.napuniInicijalnimPodacima();
        ucitavanjeLabel.setText("Ucitani podaci");
        ucitavanjeLabel.setStyle("-fx-background-color: green;");

        azurirajOsobuButton.setText("Azuriraj");

        ulogaChoiceBox.getItems().addAll(Uloga.STUDENT, Uloga.NASTAVNO_OSOBLJE);

        ucitajOsobeIzBaze();
        osobeListView.setItems(osobeObservableList);

        // dodavanje listener-a za klik dugmeta
        azurirajOsobuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                azurirajOsobu();
            }
        });

        // dodavanje listener-a za izbor osobe iz listview
        osobeListView.getSelectionModel().selectedItemProperty().addListener((observable, starVrijednost, novaVrijednost) -> {
            if (novaVrijednost != null) {
                izabranaOsoba = novaVrijednost;  // azuriranje varijable koja predstavlja trenutno izabranu osobu
                ispuniPolja(novaVrijednost);  // ispunjavanje polja detaljima izabrane osobe
                porukaLabel.setVisible(false); // sakrij labelu koja sadrzi poruku
            }
        });
    }

    private void ucitajOsobeIzBaze() {
        List<Osoba> osobe = OsobaModel.getInstance().dajSveOsobe();
        osobeObservableList.setAll(osobe);
    }

    private void ispuniPolja(Osoba osoba) {
        imeTextField.setText(osoba.getIme());
        prezimeTextField.setText(osoba.getPrezime());
        adresaTextField.setText(osoba.getAdresa());
        datumRodjenjaTextField.setText(OsobaModel.getDateFormat().format(osoba.getDatumRodjenja()));
        maticniBrojTextField.setText(osoba.getMaticniBroj());
        ulogaChoiceBox.setValue(osoba.getUloga());
    }

    public String obrisiOsobuPoId(Integer id) {
        String deleteSQL = "DELETE FROM Osoba WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                return "Ne postoji osoba sa datim id-em";
            }
            return "Osoba je uspjesno obrisana";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    private void azurirajOsobu() {
        if (izabranaOsoba == null) {
            porukaLabel.setText("Nijedna osoba nije izabrana!");
            porukaLabel.setVisible(true);
            return;
        }

        String novoIme = imeTextField.getText();
        String novoPrezime = prezimeTextField.getText();
        String novaAdresa = adresaTextField.getText();
        Date noviDatumRodjenja = null;
        try {
            noviDatumRodjenja = OsobaModel.getDateFormat().parse(datumRodjenjaTextField.getText());
        } catch (Exception e) {
            porukaLabel.setText("Neispravan format datuma!");
            porukaLabel.setVisible(true);
            return;
        }
        String noviMaticniBroj = maticniBrojTextField.getText();
        Uloga novaUloga = ulogaChoiceBox.getValue();

        // Check if the name length is valid
        if (novoIme.length() < 2 || novoIme.length() > 50) {
            novoIme = null;
        }

        // Check if the maticni broj matches the datum rodjenja
        String datumRodjenjaStr = OsobaModel.getDateFormat().format(noviDatumRodjenja);
        if (!noviMaticniBroj.startsWith(datumRodjenjaStr.replace("-", "").substring(0, 6))) {
            noviMaticniBroj = null;
        }

        String poruka = OsobaModel.getInstance().azurirajOsobu(
                izabranaOsoba.getId(),
                novoIme,
                novoPrezime,
                novaAdresa,
                noviDatumRodjenja,
                noviMaticniBroj,
                novaUloga
        );

        ucitajOsobeIzBaze();
        osobeListView.refresh();

        Platform.runLater(() -> {
            porukaLabel.setVisible(true);
            porukaLabel.setText(poruka);
        });
    }
}