import java.util.List;

class Povrce extends Namirnica {
    public Povrce(String latinskiNaziv, String zemljaPorijekla, List<Integer> nutritivneVrijednosti) {
        super(latinskiNaziv, zemljaPorijekla, nutritivneVrijednosti);
    }

    @Override
    public boolean Zdravlje(double koeficijentZdravlja) {
        return DajBrojKalorija() < 100 && koeficijentZdravlja >= 0.5 && koeficijentZdravlja <= 0.7;
    }
}