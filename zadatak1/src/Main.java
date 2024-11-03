import java.util.List;

public class Main {
    public static void main(String[] args) {
        Voce jabuka = new Voce("Malus domestica", "Bosna i Hercegovina", List.of(10, 20, 5, 2, 1));
        Povrce mrkva = new Povrce("Daucus carota", "Hrvatska", List.of(15, 10, 5, 3, 2));
        Meso piletina = new Meso("Piletina", "Srbija", List.of(50, 30, 20, 10, 5));
        Prodavac prodavac = new Prodavac("Ivan", "Ivic", 1, "1234501");

        System.out.println("Jabuka kalorije: " + jabuka.DajBrojKalorija());
        System.out.println("Jabuka zdravlje: " + jabuka.Zdravlje(0.8));

        System.out.println("Mrkva kalorije: " + mrkva.DajBrojKalorija());
        System.out.println("Mrkva zdravlje: " + mrkva.Zdravlje(0.6));

        System.out.println("Piletina kalorije: " + piletina.DajBrojKalorija());
        System.out.println("Piletina zdravlje: " + piletina.Zdravlje(0.96));

        System.out.println("Prodavac zdravlje: " + prodavac.Zdravlje(0));

        System.out.println("Informacije u vezi namirnica sam generisao pomocu AI-a samo kako bih provjerio ispravnost klasa, s obzirom da se u zadatku trazio testni main.");
    }
}