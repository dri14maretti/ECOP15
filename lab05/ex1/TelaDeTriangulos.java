import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.lang.Math;
import javax.swing.*;
import java.util.Random;

public class TelaDeTriangulos extends JPanel {
    GeneralPath triangulo;

    public TelaDeTriangulos() {
        triangulo = new GeneralPath();

        triangulo.moveTo(0, -100);
        setBackground(Color.BLACK);

        for (int i = 0; i < 3; i++)
            triangulo.lineTo(((int) 100 * Math.cos(2 * Math.PI / 3 * i)), ((int) 100 * Math.sin(2 * Math.PI / 3 * i)));

        triangulo.closePath();

        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });

        timer.start();

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Point point = new Point();
        point.x = getWidth() / 2;
        point.y = getHeight() / 2;

        Random random = new Random();
        g2.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        g2.fill(triangulo);

        for (int i = 0; i < 5; i++) {
            point.x = random.nextInt(getWidth() - 100);
            point.y = random.nextInt(getHeight() - 100);

            g2.translate(point.x, point.y);
            g2.setPaint(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));

            g2.fill(triangulo);
            g2.rotate(-1 * Math.toRadians(point.x));
            g2.translate(-point.x, -point.y);
        }
    }
}