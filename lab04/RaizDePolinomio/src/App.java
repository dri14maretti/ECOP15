import java.util.Scanner;
import java.util.StringTokenizer;

public class App {

    public static Polinomio lerPolinomio() {
        String polinomio;
        Scanner scanner = new Scanner(System.in);
        System.out
                .println("Entre com os coeficientes do polinomio separados por espaços, em ordem decrescente de grau");

        polinomio = scanner.nextLine();
        StringTokenizer tokenizer = new StringTokenizer(polinomio); // Separa uma string em um vetor de strings
                                                                    // separadas por espaços

        double[] coeficientes = new double[tokenizer.countTokens()];
        int i = 0;

        while (tokenizer.hasMoreTokens()) {
            coeficientes[i] = Double.parseDouble(tokenizer.nextToken());
            i++;
        }

        return new Polinomio(coeficientes);
    }

    public static void main(String[] args) throws Exception {
        Polinomio polinomio = lerPolinomio();

        System.out.println("Raiz do polinomio: " + polinomio.raiz(200));
    }
}
