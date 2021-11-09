import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConversorBinarioPanel extends JPanel {

    private JTextField textField;
    private JButton button;
    private JLabel resultado;
    private JPanel painelDeOrganizacao;

    public ConversorBinarioPanel() {
        painelDeOrganizacao = new JPanel();

        painelDeOrganizacao.setLayout(new FlowLayout());

        textField = new JTextField(10);
        painelDeOrganizacao.add(textField);

        button = new JButton("Converter");
        painelDeOrganizacao.add(button);

        resultado = new JLabel();

        this.add(painelDeOrganizacao, BorderLayout.NORTH);
        this.add(resultado, BorderLayout.CENTER);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numeroBinario = textField.getText();
                int numeroDecimal = Integer.parseInt(numeroBinario, 2);

                resultado.setText(numeroBinario + " em decimal é " + numeroDecimal);
                repaint();
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
}
