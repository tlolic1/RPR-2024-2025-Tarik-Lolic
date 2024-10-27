import Izuzeci.PremladStudentException;
import Klase.Odsjek;
import Klase.Student;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean uspjesanUnos = false;
        Student student = null;
        while (!uspjesanUnos) {
            try {
                System.out.printf("Datum rođenja (dd/mm/yyyy):");
                String datumString = scanner.nextLine();
                int godina = Integer.parseInt(datumString.substring(6)) - 1900;
                int mjesec = Integer.parseInt(datumString.substring(3, 5)) - 1;
                int dan = Integer.parseInt(datumString.substring(0, 2));
                Date datumDate = new Date(godina, mjesec, dan);
                student = new Student("Ime", "Prezime", datumDate, "12345", Odsjek.RI, 2);
                uspjesanUnos = true;
            } catch (PremladStudentException e) {
                System.out.println(e.getMessage());
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Molimo ponovite unos datuma rođenja!");
            }
        }
        System.out.println("Unos studenta uspješan! " + student);
    }
}
