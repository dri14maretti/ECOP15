import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

// extends JPanel : herda de JPanel

public class AulaJavaGrafico extends JPanel {

    // repaint() atualiza a tela depois de alguma alteração ter sido feita
    // Classe Color: classe que define cores (valor RGB)

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        g.setColor(new Color(255, 0, 0));
        g.fillRect(10, 10, 100, 100);
        
        g.drawString("Current RGB: " + g.getColor() ,130, 40);
    }

    public static void main(String[] args) throws Exception {

    }
}
