import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AsistentTest {
    private Asistent asistent;

    @BeforeEach
    void setUp() {
        asistent = new Asistent("Ime", "Prezime", "Adresa", new Date(99, 0, 1), 150, 2000, "3-00", "Lab", "Termin");
    }

    @Test
    void testDajInformacije() {
        assertEquals("Ime i prezime: Ime Prezime", asistent.DajInformacije());
    }
}