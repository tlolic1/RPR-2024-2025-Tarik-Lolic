package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class OsobaReader {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static List<Osoba> ucitajOsobeIzTxtDatoteke(String putanjaDoDatoteke) throws IOException {
        List<Osoba> osobe = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(putanjaDoDatoteke));
        String linija;
        try {
            while ((linija = reader.readLine()) != null) {
                String[] polja = linija.split(",");
                if (polja.length == 7) {
                    Integer id = Integer.parseInt(polja[0]);
                    String ime = polja[1];
                    String prezime = polja[2];
                    String adresa = polja[3];
                    Date datumRodjenja = dateFormat.parse(polja[4]);
                    String maticniBroj = polja[5];
                    Uloga uloga = Uloga.valueOf(polja[6].toUpperCase());

                    Osoba osoba = new Osoba(id, ime, prezime, adresa, datumRodjenja, maticniBroj, uloga);
                    osobe.add(osoba);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
        return osobe;
    }

    public static List<Osoba> ucitajOsobeIzXmlDatoteke(String putanjaDoDatoteke) throws Exception {
        List<Osoba> osobe = new ArrayList<>();
        File xmlDatoteka = new File(putanjaDoDatoteke);

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(xmlDatoteka);

        doc.getDocumentElement().normalize();

        NodeList listaCvorova = doc.getElementsByTagName("osoba");

        for (int i = 0; i < listaCvorova.getLength(); i++) {
            Node cvor = listaCvorova.item(i);

            if (cvor.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) cvor;

                Integer id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
                String ime = element.getElementsByTagName("ime").item(0).getTextContent();
                String prezime = element.getElementsByTagName("prezime").item(0).getTextContent();
                String adresa = element.getElementsByTagName("adresa").item(0).getTextContent();
                Date datumRodjenja = dateFormat.parse(element.getElementsByTagName("datumRodjenja").item(0).getTextContent());
                String maticniBroj = element.getElementsByTagName("maticniBroj").item(0).getTextContent();
                Uloga uloga = Uloga.valueOf(element.getElementsByTagName("uloga").item(0).getTextContent().toUpperCase());

                Osoba osoba = new Osoba(id, ime, prezime, adresa, datumRodjenja, maticniBroj, uloga);
                osobe.add(osoba);
            }
        }
        return osobe;
    }
}