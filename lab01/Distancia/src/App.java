import javax.swing.JOptionPane;
import java.lang.Math;

public class App {
    public static void main(String[] args) throws Exception {
        String velocidadeDigitada = JOptionPane.showInputDialog("Qual a velocidade inicial?");
        String anguloDigitado = JOptionPane.showInputDialog("Qual o angulo de lançamento?");

        double velocidade = Double.parseDouble(velocidadeDigitada);
        double angulo = Double.parseDouble(anguloDigitado);

        double distancia = ((velocidade * velocidade) * Math.sin(2 * angulo * Math.PI / 180) / 9.8);

        JOptionPane.showMessageDialog(null, "A distancia é: " + distancia + " metros");
    }
}
