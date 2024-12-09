package model;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OsobaTest {

    @Test
    void testOsobaIspravnoKreirana() {
        Calendar cal = Calendar.getInstance();
        cal.set(1990, Calendar.MARCH, 15);
        Date datumRodjenja = cal.getTime();
        Osoba osoba = new Osoba(1, "Marko", "Markovic", "Neka Adresa 123", datumRodjenja, "1503901234567", Uloga.STUDENT);
        assertNotNull(osoba);
        assertEquals(1, osoba.getId());
        assertEquals("Marko", osoba.getIme());
        assertEquals("Markovic", osoba.getPrezime());
        assertEquals("Neka Adresa 123", osoba.getAdresa());
        assertEquals(datumRodjenja, osoba.getDatumRodjenja());
        assertEquals("1503901234567", osoba.getMaticniBroj());
        assertEquals(Uloga.STUDENT, osoba.getUloga());
    }

    @Test
    void testImeNeispravno() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Osoba(1, "M", "Markovic", "Neka Adresa 123", new Date(), "1503901234567", Uloga.STUDENT);
        });
        assertEquals("Ime mora imati izmedju 2 i 50 znakova.", exception.getMessage());
    }

    @Test
    void testMaticniBrojNeispravnaDuzina() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Osoba(1, "Marko", "Markovic", "Neka Adresa 123", new Date(), "123", Uloga.STUDENT);
        });
        assertEquals("Maticni broj mora imati tacno 13 karaktera!", exception.getMessage());
    }

    @Test
    void testMaticniBrojNepodudaranjeSaDatumomRodjenja() {
        Calendar cal = Calendar.getInstance();
        cal.set(1990, Calendar.MARCH, 15);
        Date datumRodjenja = cal.getTime();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Osoba(1, "Marko", "Markovic", "Neka Adresa 123", datumRodjenja, "1234567890123", Uloga.STUDENT);
        });
        assertEquals("Maticni broj se ne poklapa sa datumom rodjenja!", exception.getMessage());
    }
}
