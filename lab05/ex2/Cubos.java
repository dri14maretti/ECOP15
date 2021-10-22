import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class Cubos extends JPanel {
    GeneralPath cubo;

    int raio = 100;

    public Cubos() {
        cubo = new GeneralPath();
        int x, y, forma = 6;
        cubo.moveTo(0, -raio);
        for (int i = 0; i < forma; i++) {
            x = (int) (raio * Math.cos(-Math.PI / 2 + 2 * Math.PI / forma * i));
            y = (int) (raio * Math.sin(-Math.PI / 2 + 2 * Math.PI / forma * i));
            cubo.lineTo(x, y);

            if (i % 2 == 1) {
                cubo.lineTo(0, 0);
                cubo.lineTo(x, y);
            }

        }
        cubo.closePath();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random random = new Random();
        Point point = new Point();
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < 5; i++) {
            point.x = random.nextInt(getWidth() - raio);
            point.y = random.nextInt(getHeight() - raio);

            g2.translate(point.x, point.y);
            g2.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            g2.draw(cubo);
            g2.translate(-point.x, -point.y);
        }
    }
}
