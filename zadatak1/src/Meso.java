import java.util.List;

class Meso extends Namirnica {
    private String vrsta;

    public Meso(String vrsta, String zemljaPorijekla, List<Integer> nutritivneVrijednosti) {
        super(vrsta, zemljaPorijekla, nutritivneVrijednosti);
        this.vrsta = vrsta;
    }

    @Override
    public int DajBrojKalorija() {
        return (int) (super.DajBrojKalorija() * 1.2);
    }

    @Override
    public boolean Zdravlje(double koeficijentZdravlja) {
        return koeficijentZdravlja > 0.95;
    }
}