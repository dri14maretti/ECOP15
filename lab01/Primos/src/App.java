import java.lang.Math;

public class App {
    public static void main(String[] args) throws Exception {
        int numeroDePrimosMostrados = 20;

        mostraNprimos(numeroDePrimosMostrados);
    }

    public static boolean verificaPrimo(int numero) {
        if (numero == 2)
            return true;

        if (numero % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(numero) + 1; i++) {
            if (numero % i == 0)
                return false;
        }

        return true;
    }

    public static void mostraNprimos(int n) {
        int contador = 0;
        int i = 2;

        while (contador < n) {
            if (verificaPrimo(i)) {
                System.out.print(i + ", ");
                contador++;
            }
            i++;
        }
        System.out.print("\b\b ");

    }
}
