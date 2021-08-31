import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        String alturaDigitada = JOptionPane.showInputDialog("Digite a altura do retângulo");
        String larguraDigitada = JOptionPane.showInputDialog("Digite a largura do retângulo");

        int altura = Integer.parseInt(alturaDigitada);
        int largura = Integer.parseInt(larguraDigitada);

        for (int i = 0; i < largura; i++) {
            for (int j = 0; j < altura; j++) {
                if (i == 0 || i == largura - 1 || j == 0 || j == altura - 1) {
                    System.out.print("x");
                }

                else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
