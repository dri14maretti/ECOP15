import java.awt.Graphics;

import javax.swing.JRadioButton;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class EscolheFormas extends JPanel {
    private int forma = 1;

    private JRadioButton escolheCirculo;
    private JRadioButton escolheQuadrado;
    private JRadioButton escolheTriangulo;
    private ButtonGroup grupoDeFormas;

    public EscolheFormas() {
        escolheCirculo = new JRadioButton("Circulo", true);
        escolheTriangulo = new JRadioButton("Triangulo", false);
        escolheQuadrado = new JRadioButton("Quadrado", false);
        add(escolheCirculo);
        add(escolheTriangulo);
        add(escolheQuadrado);

        grupoDeFormas = new ButtonGroup();
        grupoDeFormas.add(escolheCirculo);
        grupoDeFormas.add(escolheTriangulo);
        grupoDeFormas.add(escolheQuadrado);

        escolheCirculo.addItemListener(new TrataEvento(1));
        escolheTriangulo.addItemListener(new TrataEvento(2));
        escolheQuadrado.addItemListener(new TrataEvento(3));

        escolheCirculo.setSelected(true);
    }

    private class TrataEvento implements ItemListener {
        private int var;

        public TrataEvento(int i) {
            var = i;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            forma = var;
            repaint();
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random random = new Random();

        g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        switch (forma) {
            case 1:
                g.fillOval(90, 90, 100, 100);
                break;
            case 2:
                int[] x = { 90, 190, 140 };
                int[] y = { 190, 190, 90 };

                g.fillPolygon(x, y, 3);
                break;
            case 3:
                g.fillRect(90, 90, 100, 100);
                break;
        }
    }

}
