package view;

import model.Predmet;

import java.util.Scanner;

public class PredmetView {
    private Scanner scanner = new Scanner(System.in);

    public String getNaziv() {
        System.out.print("Unesite naziv predmeta: ");
        return scanner.nextLine();
    }

    public Double getECTS() {
        System.out.print("Unesite ECTS vrijednost: ");
        return scanner.nextDouble();
    }

    public void prikaziPredmet(Predmet predmet) {
        System.out.println(predmet);
    }
}
