// HelloApplication.java
package com.example.lvl07;

import com.example.lvl07.controller.PredmetController;
import com.example.lvl07.model.PredmetModel;
import com.example.lvl07.view.PredmetView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        // Predmet components
        PredmetModel predmetModel = new PredmetModel();
        predmetModel.napuni();

        PredmetView predmetView = new PredmetView();
        PredmetController predmetController = new PredmetController(predmetModel, predmetView);

        // Update a subject's name
        predmetController.azurirajNaziv(1, "Nova Matematika");

        // Print messages to the console
        System.out.println("Predmet view ispisuje: " + predmetView.getPoruka());
        System.out.println("Ažurirani predmet je: " + predmetModel.dajPredmetPoId(1).toString());

        // Set up the scene and show the window
        primaryStage.setTitle("Hello Application");
        primaryStage.setScene(new Scene(predmetView.getRoot(), 300, 200));
        primaryStage.show();
    }
}