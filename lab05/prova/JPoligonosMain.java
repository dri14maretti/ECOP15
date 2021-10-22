import java.awt.*;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;

public class JPoligonosMain {
    public static void main(String[] args) {
        int numeroDePoligonos = 0;
        int numeroDeLadosPoligono = 5;

        JFrame frame = new JFrame("Poligonos Regulares");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField(5);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numeroDePoligonos = Integer.parseInt(textField.getText());
                frame.repaint();
            }
        });
        frame.add(textField);

        Timer timer = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.repaint();
            }
        });

        timer.start();

        if (numeroDePoligonos != 0) {
            for (int i = 0; i < numeroDePoligonos; i++) {
                Random random = new Random();

                JPoligonosRegulares poligono = new JPoligonosRegulares(numeroDeLadosPoligono, 50 + random.nextInt(100),
                        new Color(random.nextInt(0, 255)));
                frame.add(poligono);
            }

        }

        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }
}
