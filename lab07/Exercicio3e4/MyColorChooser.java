import java.awt.*;
import javax.swing.*;

public class MyColorChooser extends JPanel {
    private SliderTextPanel[] panels = new SliderTextPanel[3];

    public MyColorChooser() {
        this.setLayout(new GridLayout(3, 1));

        for (int i = 0; i < 3; i++) {
            panels[i] = new SliderTextPanel();
        }

        for (int i = 0; i < 3; i++) {
            panels[i].setOpaque(false);

            this.add(panels[i]);
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.getColor());
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        this.setBackground(this.getColor());
    }

    public Color getColor() {
        return (new Color(panels[0].getValue(), panels[1].getValue(), panels[2].getValue()));
    }
}