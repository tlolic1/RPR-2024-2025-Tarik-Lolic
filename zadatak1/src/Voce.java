import java.util.List;

class Voce extends Namirnica {
    public Voce(String latinskiNaziv, String zemljaPorijekla, List<Integer> nutritivneVrijednosti) {
        super(latinskiNaziv, zemljaPorijekla, nutritivneVrijednosti);
    }

    @Override
    public boolean Zdravlje(double koeficijentZdravlja) {
        return DajBrojKalorija() < 50 && koeficijentZdravlja > 0.75;
    }
}
