import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConversorFrame extends JFrame {
    private ConversorBinarioPanel conversorBinarioPanel;
    private JMenuBar menuBar;

    public ConversorFrame() {
        super("Conversor de Binário para Decimal");
        this.setLayout(new BorderLayout());
        conversorBinarioPanel = new ConversorBinarioPanel();

        this.add(conversorBinarioPanel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 200);
        this.configureMenu();
        this.setVisible(true);

    }

    private void configureMenu() {
        menuBar = new JMenuBar();

        JMenu menu = new JMenu("Arquivo");
        menu.setMnemonic('A');

        JMenuItem sobreMenuItem = new JMenuItem("Sobre");
        sobreMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(ConversorFrame.this,
                        "Developer: Adriano Carvalho Maretti\nConversor de Binários para Decimais (P1 - ex2)\nDisciplina ECOP15 - UNIFEI",
                        "Sobre", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        menu.add(sobreMenuItem);
        menu.addSeparator();

        JMenuItem menuSair = new JMenuItem("Sair");
        menuSair.addActionListener(e -> System.exit(0));
        menu.add(menuSair);

        menuBar.add(menu);
        this.setJMenuBar(menuBar);
    }
}
