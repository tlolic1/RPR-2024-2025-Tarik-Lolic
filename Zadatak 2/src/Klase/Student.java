package Klase;

import Izuzeci.PremladStudentException;
import Izuzeci.StudentBuducnostException;
import Izuzeci.DijeljenjeSNulomException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
    String ime, prezime, brojIndeksa;
    Odsjek odsjek;
    Date datumRodjenja;
    Integer godinaStudija;
    List<Integer> ocjene;

    public Student(String ime, String prezime, Date datumRodjenja, String brojIndeksa,
                   Odsjek odsjek, Integer godinaStudija) throws Exception {
        setIme(ime);
        setPrezime(prezime);
        setDatumRodjenja(datumRodjenja);
        setBrojIndeksa(brojIndeksa);
        setOdsjek(odsjek);
        setGodinaStudija(godinaStudija);
        setOcjene(new ArrayList<>());
    }

    private void setOdsjek(Odsjek odsjek) {
        this.odsjek = odsjek;
    }

    private void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    private void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Double Prosjek() throws DijeljenjeSNulomException {
        if (ocjene.isEmpty()) {
            throw new DijeljenjeSNulomException("Student nema nijednu unesenu ocjenu! Nije moguće ispisati podatke.");
        }
        Double prosjek = 0.0;
        for (Integer ocjena : ocjene) {
            prosjek += ocjena;
        }
        return prosjek / ocjene.size();
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public Integer getGodinaStudija() {
        return godinaStudija;
    }

    public List<Integer> getOcjene() {
        return ocjene;
    }

    public void setOcjene(List<Integer> ocjene) {
        this.ocjene = ocjene;
    }

    public void setDatumRodjenja(Date datumRodjenja) throws StudentBuducnostException, PremladStudentException {
        Date today = new Date();
        if (datumRodjenja.compareTo(today) >= 0) {
            throw new StudentBuducnostException("Datum rođenja ne može biti u budućnosti!");
        } else if (today.getYear() - datumRodjenja.getYear() < 16) {
            throw new PremladStudentException("Student ne može biti mlađi od 16 godina!");
        }
        this.datumRodjenja = datumRodjenja;
    }

    public void setGodinaStudija(Integer godinaStudija) {
        if (godinaStudija > 0 && godinaStudija < 6) {
            this.godinaStudija = godinaStudija;
        }
    }

    @Override
    public String toString() {
        try {
            Double prosjek = Prosjek();
            return String.format("Student: %s %s, broj indeksa: %s, Prosjek: %f", ime, prezime, brojIndeksa, prosjek);
        } catch (DijeljenjeSNulomException e) {
            System.out.println(e.getMessage());
            return "";
        }
    }
}
