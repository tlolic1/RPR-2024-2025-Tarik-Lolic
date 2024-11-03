import java.util.List;

abstract class Namirnica implements NutritivnaVrijednost {
    protected String latinskiNaziv;
    protected String zemljaPorijekla;
    protected List<Integer> nutritivneVrijednosti;

    public Namirnica(String latinskiNaziv, String zemljaPorijekla, List<Integer> nutritivneVrijednosti) {
        this.latinskiNaziv = latinskiNaziv;
        this.zemljaPorijekla = zemljaPorijekla;
        this.nutritivneVrijednosti = nutritivneVrijednosti;
    }

    @Override
    public int DajBrojKalorija() {
        int sum = 0;
        for (int value : nutritivneVrijednosti) {
            sum += value;
        }
        return sum;
    }
}