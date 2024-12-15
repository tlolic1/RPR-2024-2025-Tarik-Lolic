// OsobaModelTest.java
package com.example.lvl07.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OsobaModelTest {
    private OsobaModel osobaModel;

    @BeforeEach
    public void setUp() {
        osobaModel = new OsobaModel();
    }

    @Test
    public void testNapuni() {
        osobaModel.napuni();
        assertFalse(osobaModel.getOsobe().isEmpty(), "Lista osoba ne bi trebala biti prazna nakon poziva metode napuni()");
    }

    @Test
    public void testAzurirajOsobuPostojeciId() {
        osobaModel.napuni();
        String rezultat = osobaModel.azurirajOsobu(1, "Novo ime", null, null, null, null, null);
        assertEquals("Osoba je uspjesno azurirana!", rezultat, "Poruka bi trebala biti 'Osoba uspješno ažurirana'");
        assertEquals("Novo ime", osobaModel.dajOsobuPoId(1).getIme(), "Ime osobe sa ID 1 bi trebalo biti ažurirano");
    }

    @Test
    public void testAzurirajOsobuNepostojeciId() {
        osobaModel.napuni();
        String rezultat = osobaModel.azurirajOsobu(999, "Novo ime", null, null, null, null, null);
        assertEquals("Osoba nije pronadjena!", rezultat, "Poruka bi trebala biti 'Osoba nije pronađena'");
    }

    @Test
    public void testAzurirajOsobuSamoNekaPolja() {
        osobaModel.napuni();
        osobaModel.azurirajOsobu(1, "Novo ime", null, "Nova adresa", null, null, null);
        Osoba osoba = osobaModel.dajOsobuPoId(1);
        assertEquals("Novo ime", osoba.getIme(), "Ime osobe sa ID 1 bi trebalo biti ažurirano");
        assertEquals("Nova adresa", osoba.getAdresa(), "Adresa osobe sa ID 1 bi trebala biti ažurirana");
    }
}