
// Fig. 15.7: ShowColors2JFrame.java
// Choosing colors with JColorChooser.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShowColors2JFrame extends JFrame {

    private Color initialColor = Color.LIGHT_GRAY, finalColor = Color.BLACK;

    private JGradientePanel colorJPanel;

    private JMenuBar menuBar;

    public ShowColors2JFrame() {
        super("Using JColorChooser");

        colorJPanel = new JGradientePanel();
        colorJPanel.setColorInicial(initialColor);
        colorJPanel.setColorFinal(finalColor);

        add(colorJPanel, BorderLayout.CENTER);

        this.configureMenuBar();

        this.setSize(600, 600);
        this.setVisible(true);
    }

    private void configureMenuBar() {
        menuBar = new JMenuBar();

        // Declarando menus
        JMenu fileJMenu = new JMenu("Arquivo");
        JMenu configJMenu = new JMenu("Configurações");

        // Itens no menu about
        JMenuItem about = new JMenuItem("Sobre");
        about.setMnemonic('S');
        fileJMenu.add(about);
        fileJMenu.addSeparator();

        JMenuItem exit = new JMenuItem("Sair");
        fileJMenu.add(exit);

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(ShowColors2JFrame.this,
                        "Developer: Adriano Carvalho Maretti\nSolução do Laboratório 7\nDisciplina ECOP15 - UNIFEI",
                        "Sobre", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        // Itens no menu configure
        JMenuItem corInicial = new JMenuItem("Cor Inicial");

        corInicial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                initialColor = JColorChooser.showDialog(ShowColors2JFrame.this, "Escolha a cor Inicial!", initialColor);

                if (initialColor == null) {
                    initialColor = Color.LIGHT_GRAY;
                }

                colorJPanel.setColorInicial(initialColor);
            }
        });
        configJMenu.add(corInicial);
        configJMenu.addSeparator();

        JMenuItem corFinal = new JMenuItem("Cor Final");

        corFinal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                finalColor = JColorChooser.showDialog(ShowColors2JFrame.this, "Escolha a cor final!", finalColor);

                if (finalColor == null) {
                    finalColor = Color.LIGHT_GRAY;
                }

                colorJPanel.setColorFinal(finalColor);
            }
        });
        configJMenu.add(corFinal);

        menuBar.add(fileJMenu);
        menuBar.add(configJMenu);
        this.setJMenuBar(menuBar);
    }
}