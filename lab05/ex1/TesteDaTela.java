import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TesteDaTela {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Protetor de tela");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        frame.setSize(d);
        frame.add(new TelaDeTriangulos());
        frame.setUndecorated(true);
        frame.setVisible(true);

        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                System.exit(0);
            }
        });
    }
}