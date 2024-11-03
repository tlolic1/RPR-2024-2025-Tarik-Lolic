class Prodavac implements NutritivnaVrijednost {
    private String ime;
    private String prezime;
    private int brojStanda;
    private String idBrojLicence;

    public Prodavac(String ime, String prezime, int brojStanda, String idBrojLicence) {
        this.ime = ime;
        this.prezime = prezime;
        this.brojStanda = brojStanda;
        this.idBrojLicence = idBrojLicence;
    }

    @Override
    public int DajBrojKalorija() {
        return 0; // Prodavac nema nutritivne vrijednosti
    }

    @Override
    public boolean Zdravlje(double koeficijentZdravlja) {
        return idBrojLicence.endsWith("01");
    }
}