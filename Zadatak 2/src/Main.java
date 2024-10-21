import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> brojevi = new ArrayList<>();

        System.out.print("Unesite operaciju ('plus' za sabiranje, 'podijeljeno' za dijeljenje: ");
        String operacija = scanner.nextLine();

        System.out.println("Unesite brojeve (za kraj unesite -400):");
        while (true) {
            double broj = scanner.nextDouble();
            if (broj == -400) {
                break;
            }
            brojevi.add(broj);
        }

        double rezultat = 0;

        if (operacija.equals("plus")) {
            rezultat = saberi(brojevi);
        } else if (operacija.equals("podijeljeno")) {
            try {
                rezultat = podijeli(brojevi);
            } catch (Exception e) {
                System.out.println("Greška: " + e.getMessage());
                return;
            }
        }

        System.out.printf("Konačni rezultat: %.2f%n", rezultat);
    }

    public static double saberi(List<Double> brojevi) {
        double suma = 0;
        for (Double broj : brojevi) {
            suma += broj;
        }
        return suma;
    }

    public static double podijeli(List<Double> brojevi) throws Exception {
        if (brojevi.size() < 2) {
            throw new Exception("Potrebna su barem dva broja za dijeljenje.");
        }
        double rezultat = brojevi.get(0);
        for (int i = 1; i < brojevi.size(); i++) {
            double broj = brojevi.get(i);
            if (broj == 0) {
                throw new Exception("Dijeljenje sa nulom nije dozvoljeno.");
            }
            rezultat /= broj;
        }
        return Math.round(rezultat * 100) / 100.0;
    }
}
