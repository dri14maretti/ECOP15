import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        String numeroDigitado = JOptionPane
                .showInputDialog("Digite um numero inteiro para que se calcule seu fatorial");

        int numero = Integer.parseInt(numeroDigitado);

        JOptionPane.showMessageDialog(null, numero + "! = " + fatorial(numero));
    }

    public static int fatorial(int numero) {
        if (numero == 0) {
            return 1;
        } else {
            return numero * fatorial(numero - 1);
        }
    }
}
