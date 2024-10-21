import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;

        while (true) {
            System.out.printf("Unesite broj n: ");
            n = in.nextInt();

            if (n > 500) {
                System.out.println("Uneseni broj je prevelik!");
            } else if (n < 2) {
                System.out.println("Nije moguće izvršiti izračunavanje prostih brojeva.");
                return;
            } else {
                break;
            }
        }

        System.out.println("Prosti brojevi između 2 i " + (2 * n) + ":");
        for (int i = 2; i <= 2 * n; i++) {
            if (DaLiJeProst(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean DaLiJeProst(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // Nije prost
            }
        }
        return true; // Jest prost
    }
}
