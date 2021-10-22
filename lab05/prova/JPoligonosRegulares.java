import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
import javax.swing.*;

public class JPoligonosRegulares extends JPanel {
    private int numeroDeLados;
    private int raio;
    private Color cor;
    private GeneralPath poligono;

    public JPoligonosRegulares(int numeroDeLadosRecebido, int raioRecebido, Color corRecebida) {
        this.poligono = new GeneralPath();
        this.cor = corRecebida;
        this.numeroDeLados = numeroDeLadosRecebido;
        this.raio = raioRecebido;

        int x, y;

        this.poligono.moveTo(0, -this.raio);

        for (int i = 1; i < this.numeroDeLados; i++) {
            x = (int) (this.raio * Math.cos(-Math.PI / 2 + 2 * Math.PI / this.numeroDeLados * i));
            y = (int) (this.raio * Math.sin(-Math.PI / 2 + 2 * Math.PI / this.numeroDeLados * i));

            this.poligono.lineTo(x, y);
        }

        this.poligono.closePath();
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(this.cor);
        g2d.draw(this.poligono);
    }

    public void fill(Graphics2D g2d) {
        g2d.setPaint(new GradientPaint(0, 0, this.cor, 0, this.raio, Color.WHITE));
        g2d.fill(this.poligono);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Point point = new Point(0, 0);
        Random random = new Random();

        point.x = random.nextInt(this.getWidth() - this.raio);
        point.y = random.nextInt(this.getHeight() - this.raio);

        g2d.translate(point.x, point.y);

        this.draw(g2d);
        this.fill(g2d);

        g2d.translate(-point.x, -point.y);
    }
}
