
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pascal extends JFrame {
    private JTextField texto;
    private JTextArea display;

    public Pascal() {
        super("Triângulo de Pascal"); // construtor da classe pai
        setLayout(new FlowLayout());
        add(new JLabel("Número de linhas:"));
        texto = new JTextField(6);

        texto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                geraTrianguloDePascal();
            }
        });

        add(texto);

        display = new JTextArea(20, 70);
        display.setMargin(new Insets(10, 10, 10, 10));
        display.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(display));
        setSize(500, 400);
        setVisible(true);
    }

    private void geraTrianguloDePascal() {
        int linha = Integer.parseInt(texto.getText());

        display.setText(" ");
        int matrizDoTriangulo[][] = new int[linha][];

        for (int i = 0; i < matrizDoTriangulo.length; i++) {
            matrizDoTriangulo[i] = new int[i + 2];
        }

        matrizDoTriangulo[0][0] = 1;
        matrizDoTriangulo[0][1] = 1;

        for (int i = 1; i < matrizDoTriangulo.length; i++) {
            matrizDoTriangulo[i][0] = 1;
            matrizDoTriangulo[i][matrizDoTriangulo[i].length - 1] = 1;

            for (int j = 1; j < matrizDoTriangulo[i].length - 1; j++) {
                matrizDoTriangulo[i][j] = matrizDoTriangulo[i - 1][j - 1] + matrizDoTriangulo[i - 1][j];
            }
        }

        String showTriangulo = "1\n";

        for (int i = 0; i < matrizDoTriangulo.length; i++) {
            for (int j = 0; j < matrizDoTriangulo[i].length; j++) {
                showTriangulo += matrizDoTriangulo[i][j] + " ";
            }
            showTriangulo += "\n";
        }
        display.setText(showTriangulo);

    }
}
