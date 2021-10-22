import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.lang.Math;
import javax.swing.*;
import java.util.Random;

public class Hexagonos extends JPanel {
    GeneralPath hexagono;

    public Hexagonos() {
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });

        timer.start();

        setBackground(Color.BLACK);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random random = new Random();
        Point point = new Point();
        int raio, forma = 6;

        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < 10; i++) {
            raio = 30 + random.nextInt(80);
            GeneralPath hexagono = montaHexagono(raio, forma);

            point.x = random.nextInt(getWidth() - 100);
            point.y = random.nextInt(getHeight() - 100);

            Color color1 = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            Color color2 = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

            g2.translate(point.x, point.y);
            g2.rotate(-Math.PI / 2);
            g2.setPaint(new GradientPaint(0, raio / 2, color1, raio, raio / 2, color2));

            g2.fill(hexagono);
            g2.rotate(-Math.PI / 2);
            g2.translate(-point.x, -point.y);
        }

    }

    public GeneralPath montaHexagono(int raio, int forma) {
        int x, y;
        GeneralPath hexagono = new GeneralPath();

        hexagono.moveTo(0, -raio);

        for (int i = 1; i < forma; i++) {
            x = (int) (raio * Math.cos(-Math.PI / 2 + 2 * Math.PI / forma * i));
            y = (int) (raio * Math.sin(-Math.PI / 2 + 2 * Math.PI / forma * i));

            hexagono.lineTo(x, y);

            if (i % 2 == 1) {
                hexagono.lineTo(0, 0);
                hexagono.lineTo(x, y);
            }
        }

        hexagono.closePath();

        return hexagono;
    }
}