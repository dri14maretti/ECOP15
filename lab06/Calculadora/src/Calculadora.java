import javax.swing.*;
import java.awt.*;

public class Calculadora extends JPanel {
    private JPanel teclado;
    private JButton buttons[];
    private String teclas[] = { "7", "8", "9", "X", "4", "5", "6", "/", "1", "2", "3", "-", "0", ".", "=", "+" };

    public Calculadora() {
        setLayout(new BorderLayout());
        teclado = new JPanel();
        teclado.setLayout(new GridLayout(4, 4));
        buttons = new JButton[teclas.length];
        for (int i = 0; i < teclas.length; i++) {
            buttons[i] = new JButton(teclas[i]);
            teclado.add(buttons[i]);
        }
        add(teclado, BorderLayout.CENTER);
        add(new JTextField(), BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Calculadora());
        frame.setSize(300, 400);
        frame.setVisible(true);
    }
}
