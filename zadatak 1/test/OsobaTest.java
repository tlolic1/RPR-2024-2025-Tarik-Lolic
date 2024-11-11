import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OsobaTest {
    private Osoba osoba;

    @BeforeEach
    void setUp() {
        osoba = new Osoba("Ime", "Prezime", "Adresa", new Date(99, 0, 1)) {};
    }

    @Test
    void testProvjeriMaticniBroj() {
        assertTrue(osoba.ProvjeriMaticniBroj("0101999123456"));
        assertFalse(osoba.ProvjeriMaticniBroj("3112991123456"));
    }

    @Test
    void testDajInformacije() {
        assertEquals("Ime i prezime: Ime Prezime", osoba.DajInformacije());
    }
}