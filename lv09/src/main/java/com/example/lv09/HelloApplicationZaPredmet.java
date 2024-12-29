package com.example.lv09;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplicationZaPredmet extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("predmet.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Predmet Management");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        PredmetModel predmetModel = PredmetModel.getInstance();
        predmetModel.kreirajTabeluAkoNePostoji();
        launch();
    }
}