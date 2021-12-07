import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.Random;

public class SlideImagePanel extends JPanel {
    private final ImageIcon[] picture = new ImageIcon[5];
    private Random random = new Random();
    private Timer timer;
    private int maxWidth, imgMaxWidth = 0, imgMaxHeight = 0, centroImg, index = 0, rotantionAngle, deslocamento = 0;
    private String[] picturePaths = { "wallpaper.jpeg", "miami.png", "nodejs.png", "java.png", "javascript.png" };

    public SlideImagePanel() {

        this.rotantionAngle = random.nextInt(360);

        for (int i = 0; i < picturePaths.length; i++) {
            picture[i] = new ImageIcon("C:\\Documents\\Unifei\\ECOP05\\P2\\Exercicio8\\img\\" + picturePaths[i]);
            imgMaxWidth = picture[i].getIconWidth() > imgMaxWidth ? picture[i].getIconWidth() : imgMaxWidth;
            imgMaxHeight = picture[i].getIconHeight() > imgMaxHeight ? imgMaxHeight : picture[i].getIconHeight();
            setPreferredSize(new Dimension(imgMaxWidth, imgMaxHeight));
        }

        timer = new Timer(2, e -> {
            deslocamento -= 15;
            repaint();
        });
        timer.start();
    }

    public void kill(boolean encerrar) {
        if (encerrar) {
            timer.stop();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.rotate(rotantionAngle, centroImg, getHeight() / 2);
        g2d.translate(centroImg, getHeight() / 2);
        centroImg = picture[index].getIconWidth() + deslocamento;
        if (centroImg + picture[index].getIconWidth() / 2 <= maxWidth - 200) {
            rotantionAngle = random.nextInt(360);
            deslocamento = imgMaxHeight;
            index++;
            if (index >= picture.length)
                index = 0;
        }

        picture[index].paintIcon(this, g, -picture[index].getIconWidth() / 2, -picture[index].getIconHeight() / 2);

    }

    public void setMaxWidth(int newValue) {
        maxWidth = newValue;
    }

    public static void main(String[] args) {
        SlideImagePanel slideImgPanel = new SlideImagePanel();

        JFrame mainframe = new JFrame("Slide Image Panel");

        mainframe.add(slideImgPanel);
        slideImgPanel.setMaxWidth(0);
        mainframe.pack();
        mainframe.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                slideImgPanel.setMaxWidth(0);
            }
        });
        mainframe.setVisible(true);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}