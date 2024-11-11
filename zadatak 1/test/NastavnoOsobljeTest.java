import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NastavnoOsobljeTest {
    private NastavnoOsoblje nastavnoOsoblje;

    @BeforeEach
    void setUp() {
        nastavnoOsoblje = new NastavnoOsoblje("Ime", "Prezime", "Adresa", new Date(99, 0, 1), 150, 2000, "3-00") {};
    }

    @Test
    void testDajInformacije() {
        assertEquals("Ime i prezime: Ime Prezime", nastavnoOsoblje.DajInformacije());
    }
}