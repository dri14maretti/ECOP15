import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class JGradientePanel extends JPanel {
    Color colorInicial = Color.YELLOW, colorFinal = Color.BLUE;
    private String forma = "Retangulo";
    private int centerX, centerY, degradeX, degradeY;

    public void setColorInicial(Color color) {
        if (color == null) {
            color = Color.YELLOW;
        }
        this.colorInicial = color;
        this.repaint();

    }

    public void setColorFinal(Color color) {
        if (color == null) {
            color = Color.BLUE;
        }
        this.colorFinal = color;
        this.repaint();
    }

    public void setForma(String forma) {
        if (forma == null) {
            forma = "Retangulo";
        }
        this.forma = forma;
        this.repaint();
    }

    public void setCenter(int x, int y) {
        centerX = x - getWidth() / 4 - 7;
        centerY = y - getHeight() / 4 - 51;

        degradeX = centerX + getWidth();
        degradeY = centerY + getHeight();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D g2 = (Graphics2D) graphics;

        g2.setPaint(new GradientPaint(degradeX, degradeY, colorInicial, degradeX, (getHeight() / 2) + degradeY,
                colorFinal, true));

        switch (forma) {
        case "Retangulo":
            g2.fill(new Rectangle2D.Double(centerX, centerY, getWidth() / 2, getHeight() / 2));
            break;

        case "Elipse":
            g2.fill(new Ellipse2D.Double(centerX, centerY, getWidth() / 2, getHeight() / 2));
            break;

        case "Triangulo":
            g2.fill(new Polygon(new int[] { centerX, centerX + getWidth() / 4, centerX + getWidth() / 2 },
                    new int[] { centerY + getHeight() / 2, centerY, centerY + getHeight() / 2 }, 3));
            break;
        }

    }
}
