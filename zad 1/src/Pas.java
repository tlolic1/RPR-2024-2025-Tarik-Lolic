// Pas.java
import java.util.Date;

public class Pas extends Ljubimac {
    private VrstaPsa vrsta;

    public Pas(String ime, Date datumRodjenja, String zdravstvenoStanje, VrstaPsa vrsta) {
        super(ime, datumRodjenja, zdravstvenoStanje);
        this.vrsta = vrsta;
    }

    @Override
    public String getVrsta() {
        return "Pas";
    }

    @Override
    public String PrikaziInformacije() {
        return "Pas: " + vrsta;
    }
}