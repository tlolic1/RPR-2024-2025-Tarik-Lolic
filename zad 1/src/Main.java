import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ljubimac> ljubimci = new ArrayList<>();
        ljubimci.add(new Pas("Rex", new Date(118, 4, 20), "Zdrav", VrstaPsa.ZlatniRetreiver));
        ljubimci.add(new Macka("Mici", new Date(120, 10, 1), "Zdrava", VrstaMacke.Sijamska));

        Veterinar veterinar = new Veterinar("Dr. Vet", Specijalizacija.Psi);

        try {
            veterinar.PregledajLjubimca(ljubimci.get(0));
            System.out.println("Pregled uspješan: " + veterinar.getPregledi().size() + " pregleda.");
        } catch (ValidacijaVrsteException e) {
            System.out.println(e.getMessage());
        }

        try {
            veterinar.PregledajLjubimca(ljubimci.get(1));
        } catch (ValidacijaVrsteException e) {
            System.out.println(e.getMessage());
        }

        List<Objekat> objekti = new ArrayList<>();
        objekti.add(ljubimci.get(0));
        objekti.add(ljubimci.get(1));
        objekti.add(veterinar);

        for (Objekat o : objekti) {
            System.out.println(o.PrikaziInformacije());
        }
    }
}