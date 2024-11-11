import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProfesorTest {
    private Profesor profesor;

    @BeforeEach
    void setUp() {
        profesor = new Profesor("Ime", "Prezime", "Adresa", new Date(99, 0, 1), 150, 2000, "3-00", "red. prof. dr.", 50);
    }

    @Test
    void testDajInformacije() {
        assertEquals("Profesor: red. prof. dr. Ime Prezime", profesor.DajInformacije());
    }
}