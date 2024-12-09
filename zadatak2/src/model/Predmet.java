package model;

public class Predmet {
    private String naziv;
    private Double ECTS;

    public Predmet(String naziv, Double ECTS) {
        setNaziv(naziv);
        setECTS(ECTS);
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if (naziv == null || naziv.length() < 5 || naziv.length() > 100) {
            throw new IllegalArgumentException("Naziv mora imati između 5 i 100 znakova.");
        }
        this.naziv = naziv;
    }

    public Double getECTS() {
        return ECTS;
    }

    public void setECTS(Double ECTS) {
        if (ECTS == null || ECTS < 5.0 || ECTS > 20.0 || (ECTS * 10) % 5 != 0) {
            throw new IllegalArgumentException("ECTS mora biti između 5.0 i 20.0 i može imati samo 0 ili 5 kao vrijednost prve decimale.");
        }
        this.ECTS = ECTS;
    }

    @Override
    public String toString() {
        return "Predmet{" +
                "naziv='" + naziv + '\'' +
                ", ECTS=" + ECTS +
                '}';
    }
}