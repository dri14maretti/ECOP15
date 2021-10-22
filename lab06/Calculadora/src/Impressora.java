import javax.swing.*;
import java.awt.*;

public class Impressora extends JPanel {
    private JPanel painelSelecaoTipo;
    private JCheckBox checkBoxes[];
    private String opcoesCheckbox[] = { "Image", "Text", "Code" };

    private JPanel painelRadioButtons;
    private JRadioButton radioButtons[];
    private String selecoesRadioButtons[] = { "Selection", "All", "Applet" };

    private JPanel painelGeralDosBotoes;

    private JPanel painelCentro;

    private JPanel painelSouth;
    private JComboBox<String> selectQualidade;
    private JCheckBox printToFileCheck;
    private String qualidades[] = { "Low", "Medium", "High" };

    private JPanel painelEast;
    private JButton botoesOpcoes[];
    private String opcoesBotoes[] = { "Ok", "Cancel", "Setup...", "Help" };

    public Impressora() {
        this.setLayout(new BorderLayout());

        botoesOpcoes = new JButton[opcoesBotoes.length];
        painelEast = new JPanel();
        painelEast.setLayout(new GridLayout(botoesOpcoes.length, 1));

        for (int i = 0; i < botoesOpcoes.length; i++) {
            botoesOpcoes[i] = new JButton(opcoesBotoes[i]);
            painelEast.add(botoesOpcoes[i]);
        }

        this.add(painelEast, BorderLayout.EAST);

        ButtonGroup grupoRadioButtons = new ButtonGroup();

        painelRadioButtons = new JPanel();
        painelRadioButtons.setLayout(new GridLayout(selecoesRadioButtons.length, 1));
        radioButtons = new JRadioButton[selecoesRadioButtons.length];
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i] = new JRadioButton(selecoesRadioButtons[i]);
            painelRadioButtons.add(radioButtons[i]);
            grupoRadioButtons.add(radioButtons[i]);
        }

        painelSelecaoTipo = new JPanel();
        painelSelecaoTipo.setLayout(new GridLayout(opcoesCheckbox.length, 1));
        checkBoxes = new JCheckBox[opcoesCheckbox.length];
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i] = new JCheckBox(opcoesCheckbox[i]);
            painelSelecaoTipo.add(checkBoxes[i]);
        }

        painelGeralDosBotoes = new JPanel();
        painelGeralDosBotoes.setLayout(new FlowLayout());

        painelGeralDosBotoes.add(painelSelecaoTipo);
        painelGeralDosBotoes.add(painelRadioButtons);

        painelSouth = new JPanel();
        painelSouth.setLayout(new FlowLayout());
        painelSouth.add(new JLabel("Print quality:"));

        selectQualidade = new JComboBox<String>(qualidades);
        painelSouth.add(selectQualidade);
        printToFileCheck = new JCheckBox("Print to file");
        painelSouth.add(printToFileCheck);

        painelCentro = new JPanel();
        painelCentro.setLayout(new BorderLayout());
        painelCentro.add(painelGeralDosBotoes, BorderLayout.CENTER);
        painelCentro.add(painelSouth, BorderLayout.SOUTH);

        this.add(painelCentro, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        JFrame janela = new JFrame("Impressora");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.add(new Impressora());
        janela.setSize(400, 150);
        janela.setLocation(100, 100);
        janela.setVisible(true);
    }
}
