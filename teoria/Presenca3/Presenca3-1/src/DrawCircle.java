import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawCircle extends JPanel {
    int xc, yc;

    final Color VIOLET = new Color(128, 0, 128);

    final Color circleColors[] = { Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.CYAN, Color.MAGENTA, VIOLET,
            Color.GRAY };

    public DrawCircle() {
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int raio = 20;

        xc = getWidth() / 2;
        yc = getHeight() / 2;

        for (int i = circleColors.length - 1; i >= 0; i--) {
            g.setColor(circleColors[i]);
            g.drawArc(xc - i * raio, yc - i * raio, i * raio * 2, i * raio * 2, 0, 360);
        }
    }
}
