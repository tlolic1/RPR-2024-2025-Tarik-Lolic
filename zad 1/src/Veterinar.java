// Veterinar.java
import java.util.ArrayList;
import java.util.List;

public class Veterinar implements Objekat {
    private String ime;
    private Specijalizacija specijalizacija;
    private List<Ljubimac> pregledi = new ArrayList<>();

    public Veterinar(String ime, Specijalizacija specijalizacija) {
        this.ime = ime;
        this.specijalizacija = specijalizacija;
    }

    public void PregledajLjubimca(Ljubimac ljubimac) throws ValidacijaVrsteException {
        if (specijalizacija == Specijalizacija.Psi && "Pas".equals(ljubimac.getVrsta())) {
            pregledi.add(ljubimac);
        } else {
            throw new ValidacijaVrsteException("Veterinar nije specijalizovan za ovu vrstu ljubimca.");
        }
    }

    public List<Ljubimac> getPregledi() {
        return pregledi;
    }

    @Override
    public String PrikaziInformacije() {
        return "Veterinar: " + ime;
    }
}