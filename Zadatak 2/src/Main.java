import Izuzeci.PremladStudentException;
import Izuzeci.StudentBuducnostException;
import Izuzeci.DijeljenjeSNulomException;
import Klase.Odsjek;
import Klase.Student;

import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

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
                System.out.print("Unesite ocjene studenta: (x,y,...): ");
                String ocjeneInput = scanner.nextLine();
                String[] ocjeneArray = ocjeneInput.split(",");
                List<Integer> ocjeneList = new ArrayList<>();
                for (String ocjena : ocjeneArray) {
                    ocjeneList.add(Integer.parseInt(ocjena.trim()));
                }
                student.setOcjene(ocjeneList);

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
