package loader;

import model.Predmet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PredmetLoader {
    public List<Predmet> ucitajPredmeteIzTekstualneDatoteke(String filePath) throws IOException {
        List<Predmet> predmeti = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String naziv = parts[0].trim();
                Double ECTS = Double.parseDouble(parts[1].trim());
                predmeti.add(new Predmet(naziv, ECTS));
            }
        }
        return predmeti;
    }
}