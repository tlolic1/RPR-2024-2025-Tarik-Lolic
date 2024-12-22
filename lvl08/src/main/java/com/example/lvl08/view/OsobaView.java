package com.example.lvl08.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.example.lvl08.model.OsobaModel;
import com.example.lvl08.model.Osoba;
import com.example.lvl08.model.Uloga;

public class OsobaView {
    private final OsobaModel osobaModel;

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

    public OsobaView(OsobaModel osobaModel) {
        this.osobaModel = osobaModel;
    }

    @FXML
    public void initialize() {
        osobeListView.setItems(osobaModel.getOsobe());
        azurirajOsobuButton.setOnAction(event -> azurirajOsobu());
    }

    private void azurirajOsobu() {
        int selectedIndex = osobeListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Osoba osoba = new Osoba(
                    imeField.getText(),
                    prezimeField.getText(),
                    adresaField.getText(),
                    datumRodjenjaPicker.getValue().toString(),
                    maticniBrojField.getText(),
                    ulogaChoiceBox.getValue()
            );

            osobaModel.azurirajOsobu(selectedIndex, osoba);
            porukaLabel.setText("Osoba ažurirana!");
            porukaLabel.setVisible(true);
        }
    }
}