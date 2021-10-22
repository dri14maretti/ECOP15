
import javax.swing.JOptionPane;

public class MainPotencia {
    public static void main(String[] args) {
        String texto = JOptionPane.showInputDialog("Digite um numero inteiro e o expoente separados por ','");
        String[] numeros;
        if (!texto.isEmpty()) {
            numeros = texto.split(",");
            int base = Integer.parseInt(numeros[0]);
            int expoente = Integer.parseInt(numeros[1]);

            PotenciaNumero resposta = new PotenciaNumero(base, expoente);

            JOptionPane.showMessageDialog(null, "O resultado da potencia é: " + resposta.getResultado());
        }

        JOptionPane.showMessageDialog(null, "Input inválido");
        return;

    }

}
