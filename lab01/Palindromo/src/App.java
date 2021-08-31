import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        String numeroLido = JOptionPane.showInputDialog("Digite um numero");

        String resultado = isPalindromo(numeroLido) ? "É palindromo" : "Não é palindromo";

        JOptionPane.showMessageDialog(null, resultado);
    }

    public static boolean isPalindromo(String numeroLido) {
        String numeroInvertido = "";
        for (int i = numeroLido.length() - 1; i >= 0; i--) {
            numeroInvertido += numeroLido.charAt(i);
        }
        return numeroInvertido.equals(numeroLido);
    }
}
