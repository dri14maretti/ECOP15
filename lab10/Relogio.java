import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;

public class Relogio extends JPanel {
    private ImageIcon imagem;
    private Timer t;
    private double angSeg, angMin, angHor;

    public Relogio() {
        imagem = new ImageIcon(getClass().getResource("relogio.jpg"));
        t = new Timer(1000, e -> {
            angSeg -= 6;
            if (angSeg <= -360) {
                angSeg = 0;
            }
            angMin -= 360.0 / (60 * 60);
            if (angMin <= -360) {
                angMin = 0;
            }
            angHor -= 360.0 / (60 * 60 * 12);
            if (angHor <= -360) {
                angHor = 0;
            }
            repaint();
        });
        t.start();
        Calendar c = Calendar.getInstance();
        angSeg = -6 * c.get(Calendar.SECOND);
        angMin = -6 * (c.get(Calendar.MINUTE) - angSeg / 360);
        angHor = -30 * (c.get(Calendar.HOUR) - angMin / 360);
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 0, y = 0;
        int larg = getWidth() / 2;
        int alt = getHeight() / 2;
        g.translate(getWidth() / 2, getHeight() / 2);
        g.drawImage(imagem.getImage(), -getWidth() / 2, -getHeight() / 2, getWidth(), getHeight(), null);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3.0f));

        x = (int) (larg * .8 * Math.sin(Math.toRadians(angSeg) - Math.PI));
        y = (int) (alt * .8 * Math.cos(Math.toRadians(angSeg) - Math.PI));
        g.drawLine(0, 0, x, y);

        x = (int) (larg * .65 * Math.sin(Math.toRadians(angMin) - Math.PI));
        y = (int) (alt * .65 * Math.cos(Math.toRadians(angMin) - Math.PI));
        g.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(5.0f));
        g.drawLine(0, 0, x, y);

        // desenha o ponteiro das horas
        x = (int) (larg * .55 * Math.sin(Math.toRadians(angHor) - Math.PI));
        y = (int) (alt * .55 * Math.cos(Math.toRadians(angHor) - Math.PI));
        g.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(8.0f));
        g.drawLine(0, 0, x, y);
    }

    public static void main(String[] args) {
        JFrame janela = new JFrame("Rel�gio");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(800, 600);
        janela.add(new Relogio());
        janela.setVisible(true);
    }
}
