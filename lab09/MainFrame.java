import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private JDesktopPane desktop;
    private JMenuBar menuBar;

    public MainFrame() {
        super("Laboratório 9");

        desktop = new JDesktopPane();
        menuBar = new JMenuBar();

        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem menuSobre = new JMenuItem("Exibir");

        JMenu menuExibir = new JMenu("Exibir");

        JMenuItem itemSair = new JMenuItem("Sair");
        itemSair.addActionListener(e -> System.exit(0));

        JMenuItem itemSobre = new JMenuItem("Sobre");
        itemSobre.addActionListener(e -> JOptionPane.showMessageDialog(null,
                "Laboratório 9\n" + "Desenvolvedor: Adriano Maretti\nMatrícula: 2020009562\n"));

        menuArquivo.add(itemSobre);
        menuArquivo.addSeparator();
        menuArquivo.add(itemSair);

        JMenuItem itemCorrosao = new JMenuItem("Corrosão");
        itemCorrosao.addActionListener(e -> {
            CorrosaoFrame corrosao = new CorrosaoFrame();
            desktop.add(corrosao);
            corrosao.setVisible(true);
        });

        JMenuItem itemAnimacaoDireita = new JMenuItem("Animação para a Direira");
        itemAnimacaoDireita.addActionListener(e -> {
            AnimacaoDireitaFrame animacaoDireita = new AnimacaoDireitaFrame();
            desktop.add(animacaoDireita);
            animacaoDireita.setVisible(true);
        });

        JMenuItem itemZoom = new JMenuItem("Zoom");
        itemZoom.addActionListener(e -> {
            ZoomFrame zoom = new ZoomFrame();
            desktop.add(zoom);
            zoom.setVisible(true);
        });

        JMenuItem itemRotacao = new JMenuItem("Rotação");
        itemRotacao.addActionListener(e -> {
            RotacaoFrame rotacao = new RotacaoFrame();
            desktop.add(rotacao);
            rotacao.setVisible(true);
        });

        menuExibir.add(itemCorrosao);
        menuExibir.add(itemAnimacaoDireita);
        menuExibir.add(itemZoom);
        menuExibir.add(itemRotacao);

        menuBar.add(menuArquivo);
        menuBar.add(menuExibir);
        this.setJMenuBar(menuBar);

    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);
        mainFrame.setVisible(true);
    }
}