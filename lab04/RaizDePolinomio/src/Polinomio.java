
public class Polinomio {
    public double polinomio[];

    public Polinomio(int n) {
        polinomio = new double[n];
    }

    public Polinomio(double polinomio[]) {
        this.polinomio = new double[polinomio.length];

        for (int i = 0; i < polinomio.length; i++) {
            this.polinomio[i] = polinomio[polinomio.length - 1 - i];
        }
    }

    public Polinomio derivada() {
        Polinomio derivada = new Polinomio(polinomio.length - 1);

        for (int i = 0; i < derivada.polinomio.length; i++) {
            derivada.polinomio[i] = polinomio[i + 1] * (i + 1);
        }

        return derivada;
    }

    public double valorEm(double x) {
        double valor = 0;

        for (int i = 0; i < polinomio.length; i++) {
            valor += polinomio[i] * Math.pow(x, i);
        }

        return valor;
    }

    public double raiz(double x) {
        double raiz = 0;
        double epsilon = 0.000001;

        for (int i = 0; i < 100; i++) {
            raiz = x - this.valorEm(x) / this.derivada().valorEm(x);

            if (Math.abs(raiz - x) < epsilon) { // |xn+1 - xn| < epsilon
                break;
            }

            x = raiz;
        }

        return Math.round(raiz);
    }
}
