import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;

class CorrosaoFrame extends JPanel
   {
       private static final Random generator = new Random();
    private static final long serialVersionUID = 1L;
       private Image img;
	   public Timer t;
	   int nImagem = generator.nextInt(5);

       public CorrosaoFrame()
       {
		  setBackground(Color.BLACK);
          img = new ImageIcon( "imgs/foto" + nImagem + ".jpg" ).getImage();
		  t = new Timer(100, e -> {
				BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
				Graphics2D gImg = bi.createGraphics();
				gImg.setColor(Color.BLACK);
				gImg.drawImage(img, 0,0,getWidth(), getHeight(),null);
				int i;
				boolean fim=false;
				int quant=0;
				for (i=0;i<500;i++) {
					quant++;
					if (quant==100000) {
						fim = true;
						break;
					}
					int x = generator.nextInt(getWidth());
					int y = generator.nextInt(getHeight());
					if ((bi.getRGB(x,y) & 0xFFFFFF)==0) {
						i--;
						continue;
					}
					gImg.fillRect(x,y,2,2);
					
				}
				if (fim) {
					img = new ImageIcon("imgs/foto" + nImagem + ".jpg").getImage();
					gImg.drawImage(img, 0,0,getWidth(), getHeight(),null);
				}
				img = bi;
				repaint();
			
		});
		t.start();
                repaint();
		
       }

       @Override
       public void paintComponent( Graphics g )
       {
          super.paintComponent( g );
		  g.drawImage(img, 0,0,getWidth(), getHeight(),this);
                  repaint();
       }


       @Override
       public Dimension getPreferredSize()
       {
          return new Dimension( img.getWidth(null),
             img.getHeight(null) );                
       }
    }