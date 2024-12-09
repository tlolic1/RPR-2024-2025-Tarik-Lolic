package main;

import controller.PredmetController;
import loader.PredmetLoader;
import model.Predmet;
import view.PredmetView;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Matematika, 10.0");
        System.out.println("Fizika, 7.5");
        System.out.println("Hemija, 5.0");

        PredmetLoader loader = new PredmetLoader();
        try {
            Path filePath = Paths.get(
                    Main.class.getClassLoader().getResource("data/predmeti.txt").toURI()
            );

            System.out.println("File path: " + filePath.toString());

            List<Predmet> predmeti = loader.ucitajPredmeteIzTekstualneDatoteke(filePath.toString());
            for (Predmet predmet : predmeti) {
                PredmetView view = new PredmetView();
                PredmetController controller = new PredmetController(predmet, view);
                controller.prikaziPredmet();
                controller.setNazivPredmeta();
                controller.setECTSPredmeta();
                controller.prikaziPredmet();
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}