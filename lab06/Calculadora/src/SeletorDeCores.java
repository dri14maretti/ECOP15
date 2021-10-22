import javax.swing.*;
import java.awt.*;

public class SeletorDeCores extends JPanel {
    private JPanel parteDoMeio, parteInferior;
    private String colors[] = { "RED", "GREEN", "BLUE" };

    public SeletorDeCores() {
        JComboBox<String> comboBox = new JComboBox<String>(colors);

        this.setLayout(new BorderLayout());
        parteDoMeio = new JPanel();
        parteInferior = new JPanel();

        parteDoMeio.setLayout(new FlowLayout());
        parteInferior.setLayout(new FlowLayout());

        parteDoMeio.add(new JCheckBox("background"));
        parteDoMeio.add(new JCheckBox("foreground"));

        parteInferior.add(new JButton("OK"));
        parteInferior.add(new JButton("Cancel"));

        add(comboBox, BorderLayout.NORTH);
        add(parteDoMeio, BorderLayout.CENTER);
        add(parteInferior, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        JFrame janela = new JFrame("Seletor de cores");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(400, 200);
        janela.setContentPane(new SeletorDeCores());
        janela.setVisible(true);
    }
}
