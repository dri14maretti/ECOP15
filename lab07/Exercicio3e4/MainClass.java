
import javax.swing.*;

public class MainClass {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Exercicio");
        janela.add(new MyColorChooser());
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(600, 600);
        janela.setVisible(true);
    }
}
