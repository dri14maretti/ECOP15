public class PotenciaNumero {
    int resultado;

    public PotenciaNumero(int base, int expoente) {
        resultado = elevar(base, expoente);
    }

    public int elevar(int base, int expoente) {
        if (expoente == 1)
            return base;

        return base * elevar(base, expoente - 1);
    }

    public int getResultado() {
        return resultado;
    }
}
