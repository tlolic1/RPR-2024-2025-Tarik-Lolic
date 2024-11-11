import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentTest {
    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student("Ime", "Prezime", "Adresa", new Date(99, 0, 1), "IB12345", 3, 8.5);
    }

    @Test
    void testDajInformacije() {
        assertEquals("Student: Ime Prezime, broj indeksa: IB12345", student.DajInformacije());
    }
}