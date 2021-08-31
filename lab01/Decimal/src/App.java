import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        String numeroBinario = JOptionPane.showInputDialog("Digite o número binário");

        int numeroDecimal = Integer.parseInt(numeroBinario, 2);

        JOptionPane.showMessageDialog(null, "O número binário " + numeroBinario + " é equivalente a " + numeroDecimal);
    }
}
