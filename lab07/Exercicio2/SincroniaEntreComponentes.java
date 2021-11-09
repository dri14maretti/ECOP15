import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class SincroniaEntreComponentes extends JPanel {
    private JTextField textField;
    private JSlider slider;
    private int[] limites = { 0, 255 };

    public SincroniaEntreComponentes() {
        textField = new JTextField(5);
        slider = new JSlider(JSlider.HORIZONTAL, limites[0], limites[1], 10);

        slider.setMajorTickSpacing(50);
        slider.setPaintTicks(true);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                textField.setText(String.valueOf(slider.getValue()));
                repaint();
            }
        });

        textField.setText(String.valueOf(slider.getValue()));
        textField.addActionListener(new ActionListener() {// register JTextField event listener
            public void actionPerformed(ActionEvent e) {
                int valor = Integer.parseInt(textField.getText());
                slider.setValue(valor);
            }
        });

        this.add(slider);
        this.add(new JLabel("Valor selecionado: "));
        this.add(textField);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}