package model;

import java.util.Date;
import java.util.Calendar;

public class Osoba {
    private Integer id;
    private String ime, prezime, adresa;
    private Date datumRodjenja;
    private String maticniBroj;
    private Uloga uloga;

    public Osoba(Integer id, String ime, String prezime, String adresa, Date datumRodjenja, String maticniBroj, Uloga uloga) {
        setId(id);
        setIme(ime);
        setPrezime(prezime);
        setAdresa(adresa);
        setDatumRodjenja(datumRodjenja);
        setMaticniBroj(maticniBroj);
        setUloga(uloga);
    }

    private void setId(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID mora biti pozitivan broj.");
        }
        this.id = id;
    }

    public void setIme(String ime) {
        if (ime == null || ime.length() < 2 || ime.length() > 50) {
            throw new IllegalArgumentException("Ime mora imati izmedju 2 i 50 znakova.");
        }
        this.ime = ime;
    }

    private void setPrezime(String prezime) {
        if (prezime == null || prezime.length() < 2 || prezime.length() > 50) {
            throw new IllegalArgumentException("Prezime mora imati izmedju 2 i 50 znakova.");
        }
        this.prezime = prezime;
    }

    public void setAdresa(String adresa) {
        if (adresa == null || adresa.length() < 5 || adresa.length() > 100) {
            throw new IllegalArgumentException("Adresa mora imati izmedju 5 i 100 znakova.");
        }
        this.adresa = adresa;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        if (datumRodjenja == null) {
            throw new IllegalArgumentException("Datum rodjenja ne smije biti null.");
        }
        this.datumRodjenja = datumRodjenja;
    }

    public void setMaticniBroj(String maticniBroj) {
        if (maticniBroj == null || maticniBroj.trim().isEmpty() || maticniBroj.length() != 13) {
            throw new IllegalArgumentException("Maticni broj mora imati tacno 13 karaktera!");
        }
        if (!maticniBrojMatchesDatumRodjenja(maticniBroj, datumRodjenja)) {
            throw new IllegalArgumentException("Maticni broj se ne poklapa sa datumom rodjenja!");
        }
        this.maticniBroj = maticniBroj;
    }

    private boolean maticniBrojMatchesDatumRodjenja(String maticniBroj, Date datumRodjenja) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(datumRodjenja);
        String day = String.format("%02d", cal.get(Calendar.DAY_OF_MONTH));
        String month = String.format("%02d", cal.get(Calendar.MONTH) + 1);
        String year = String.valueOf(cal.get(Calendar.YEAR)).substring(2);

        String datePart = day + month + year;
        return maticniBroj.startsWith(datePart);
    }

    public void setUloga(Uloga uloga) {
        if (uloga == null) {
            throw new IllegalArgumentException("Uloga ne smije biti null.");
        }
        this.uloga = uloga;
    }

    public int getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public boolean imaPravoNaStipendiju() {
        return this.uloga == Uloga.STUDENT;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", adresa='" + adresa + '\'' +
                ", datumRodjenja=" + datumRodjenja +
                ", maticniBroj='" + maticniBroj + '\'' +
                ", uloga=" + uloga +
                '}';
    }
}
