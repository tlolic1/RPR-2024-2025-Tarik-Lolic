class ProstiBrojevi {
    public static void main(String[] args) {
        for (int broj = 2; broj <= 100; broj++) {
            if (jeProst(broj)) {
                System.out.println(broj);
            }
        }
    }

    public static boolean jeProst(int broj) {
        if (broj <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(broj); i++) {
            if (broj % i == 0) {
                return false;
            }
        }
        return true;
    }
}
