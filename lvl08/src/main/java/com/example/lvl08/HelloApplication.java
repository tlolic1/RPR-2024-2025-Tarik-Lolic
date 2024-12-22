package com.example.lvl08;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.lvl08.model.OsobaModel;
import com.example.lvl08.controller.OsobaController;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException
    {
        OsobaModel osobaModel = new OsobaModel();


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setController(new OsobaController(osobaModel));


        Scene scene = new Scene(fxmlLoader.load(), 300, 700);
        stage.setTitle("Dodaj osobu!");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}