package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HelloController {
    @FXML
    private ListView<Integer> listaBrojeva;

    private List<Integer> brojevi = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @FXML
    public void inicijalizacija() {
        listaBrojeva.getItems().addAll(brojevi);
    }

    @FXML
    protected void naKlikDugmetaParni() {
        List<Integer> parniBrojevi = brojevi.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        listaBrojeva.getItems().setAll(parniBrojevi);
    }

    @FXML
    protected void naKlikDugmetaNeparni() {
        List<Integer> neparniBrojevi = brojevi.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
        listaBrojeva.getItems().setAll(neparniBrojevi);
    }

    @FXML
    protected void naKlikDugmetaSvi() {
        listaBrojeva.getItems().setAll(brojevi);
    }
}