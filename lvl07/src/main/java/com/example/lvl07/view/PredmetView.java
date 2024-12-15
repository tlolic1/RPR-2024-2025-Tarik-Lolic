// PredmetView.java
package com.example.lvl07.view;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PredmetView {
    private VBox root;
    private Label poruka;

    public PredmetView() {
        root = new VBox();
        poruka = new Label();
        root.getChildren().add(poruka);
    }

    public VBox getRoot() {
        return root;
    }

    public void setPoruka(String poruka) {
        this.poruka.setText(poruka);
    }

    public String getPoruka() {
        return poruka.getText();
    }
}