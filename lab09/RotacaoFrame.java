import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.awt.image.*;

@SuppressWarnings("serial")
public class RotacaoFrame extends JPanel {
	private static final Random generator = new Random();
	private final Image img;
	private JSlider angulo;
	private final BufferedImage bufferedImage;
	private javax.swing.Timer timer;
	private JButton girarBtn;
	private boolean girando = false;
	private final int raio;

	public RotacaoFrame() {
		img = new ImageIcon("imgs/foto" + generator.nextInt(5) + ".jpg").getImage();
		angulo = new JSlider(SwingConstants.HORIZONTAL, 0, 360, 0);
		add(angulo);
		angulo.addChangeListener(e -> repaint());
		raio = (int) Math.sqrt(Math.pow(img.getWidth(null), 2) + Math.pow(img.getHeight(null), 2)) + 2;
		bufferedImage = new BufferedImage(raio, raio, BufferedImage.TYPE_INT_RGB);
		girarBtn = new JButton("Girar");
		add(girarBtn);
		girarBtn.addActionListener(e -> {
			if (!girando) {
				girarBtn.setText("Parar");
				girando = true;
				timer.start();
			} else {
				girarBtn.setText("Girar");
				girando = false;
				timer.stop();
			}
		});

		timer = new javax.swing.Timer(20, (ActionEvent e) -> {
			if (angulo.getValue() < 359) {
				angulo.setValue(angulo.getValue() + 4);
			} else {
				angulo.setValue(0);
			}
			repaint();
		});
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D gImg = bufferedImage.createGraphics();
		gImg.setColor(Color.WHITE);
		gImg.fillRect(0, 0, raio, raio);
		gImg.translate(raio / 2, raio / 2);
		gImg.rotate(Math.PI * angulo.getValue() / 180.0);
		gImg.translate(-raio / 2, -raio / 2);
		gImg.drawImage(img, raio / 2 - img.getWidth(null) / 2, raio / 2 - img.getHeight(null) / 2, null);

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(bufferedImage, getWidth() / 2 - bufferedImage.getWidth(null) / 2,
				getHeight() / 2 - bufferedImage.getHeight(null) / 2, this);
		repaint();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(img.getWidth(null), img.getHeight(null));
	}
}