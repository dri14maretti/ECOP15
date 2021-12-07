import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;

@SuppressWarnings("serial")
class AnimacaoDireitaFrame extends JPanel {
   private static final Random generator = new Random();
   private Image img;
   public Timer t;
   private int desloc;

   public AnimacaoDireitaFrame() {
      setBackground(Color.BLACK);
      img = new ImageIcon("imgs/foto" + generator.nextInt(5) + ".jpg").getImage();
      desloc = -img.getWidth(null);
      t = new Timer(20, e -> {
         desloc += 4;
         if (desloc >= 0) {
            desloc = -img.getWidth(null);
         }
         repaint();
      });
      t.start();
   }

   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(img, desloc, 0, getWidth(), getHeight(), this);
      g.drawImage(img, desloc + img.getWidth(null), 0, getWidth(), getHeight(), this);
      repaint();
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(img.getWidth(null), img.getHeight(null));
   }
}