import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Dados extends JFrame {
    private JLabel vetor1;
    private JLabel vetor2;
    private JLabel display;
    private JButton btnCalcular;

    private Histograma histograma;

    public Dados() {
        super("Dados");
        setLayout(new FlowLayout());
        add(new JLabel("Média da soma de dois números: \n"));

        Random gerador = new Random();
        ArrayList<Integer> vetor = new ArrayList<Integer>();
        histograma = new Histograma();
        btnCalcular = new JButton("Calcular");

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vetor1.setText("" + (gerador.nextInt(6) + 1));
                vetor2.setText("" + (gerador.nextInt(6) + 1));
                vetor.add(Integer.parseInt(vetor1.getText()) + Integer.parseInt(vetor2.getText()));
                histograma.setDados(vetor);
                display.setText("Media acumulada: " + media(vetor) + ".");
            }
        });

        add(btnCalcular);

        add(new JLabel("Número 1: "));
        vetor1 = new JLabel("");
        add(vetor1);

        add(new JLabel("Número 2: "));
        vetor2 = new JLabel("");
        add(vetor2);

        add(histograma);

        display = new JLabel("  ");

        add(display);
        setSize(800, 600);

        setVisible(true);

    }

    public float media(ArrayList<Integer> vetor) {
        float media = 0;
        for (int i = 0; i < vetor.size(); i++) {
            media += vetor.get(i);
        }
        return media / vetor.size();
    }
}