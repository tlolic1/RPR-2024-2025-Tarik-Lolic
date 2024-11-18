// Macka.java
import java.util.Date;

public class Macka extends Ljubimac {
    private VrstaMacke vrsta;

    public Macka(String ime, Date datumRodjenja, String zdravstvenoStanje, VrstaMacke vrsta) {
        super(ime, datumRodjenja, zdravstvenoStanje);
        this.vrsta = vrsta;
    }

    @Override
    public String getVrsta() {
        return "Mačka";
    }

    @Override
    public String PrikaziInformacije() {
        return "Mačka: " + vrsta;
    }
}