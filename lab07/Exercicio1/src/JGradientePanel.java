import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class JGradientePanel extends JPanel {
    Color colorInicial = Color.YELLOW, colorFinal = Color.BLUE;

    public void setColorInicial(Color color) {
        if (color == null) {
            color = Color.YELLOW;
        }
        this.colorInicial = color;
        repaint();

    }

    public void setColorFinal(Color color) {
        if (color == null) {
            color = Color.BLUE;
        }
        this.colorFinal = color;
        repaint();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D g2 = (Graphics2D) graphics;

        g2.setPaint(new GradientPaint(0, 0, colorInicial, 0, getHeight(), colorFinal, true));
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
    }
}
