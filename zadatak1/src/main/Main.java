package main;

import controller.OsobaController;
import model.Osoba;
import model.Uloga;
import view.OsobaView;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            Osoba osoba = new Osoba(1, "Neko", "Nekic", "Neka adresa", new Date(97, 8, 25), "2509971234567", Uloga.STUDENT);

            System.out.println("Osoba ima pravo na stipendiju: " + osoba.imaPravoNaStipendiju());

            OsobaView osobaView = new OsobaView();

            osobaView.setUlazniTekst("Novo ime");

            OsobaController osobaController = new OsobaController(osoba, osobaView);

            osobaController.azurirajIme();

            System.out.println("1) View ispisuje: " + osobaView.getPoruka());

            try {
                osobaController.dajOsobeIzTxtDatoteke("zadatak1/src/data/osobe.txt");
                System.out.println("2) View ispisuje: " + osobaView.getPoruka());
            } catch (Exception e) {
                System.out.println("2) Greska: " + e.getMessage());
            }

            try {
                osobaController.dajOsobeIzXmlDatoteke("zadatak1/src/data/osobe.xml");
                System.out.println("3) View ispisuje: " + osobaView.getPoruka());
            } catch (Exception e) {
                System.out.println("3) Greska: " + e.getMessage());
            }
        } catch (Exception ex) {
            System.out.println("Greska u aplikaciji: " + ex.getMessage());
        }
    }
}
