import javax.swing.*;
import java.awt.*;
import java.util.*;

@SuppressWarnings("serial")
class ZoomFrame extends JPanel {
	private static final Random generator = new Random();
	private final Image img;
	private final JSlider zoom;

	public ZoomFrame() {
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		img = new ImageIcon("imgs/foto" + generator.nextInt(5) + ".jpg").getImage();
		zoom = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 0);
		add(zoom, BorderLayout.SOUTH);
		zoom.addChangeListener(e -> repaint());
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		double z = 1.0 + ((float) 9.0 * zoom.getValue()) / 100.0;
		double x = getWidth() * (1 - z) / 2;
		double y = getHeight() * (1 - z) / 2;
		double w = img.getWidth(null) * z;
		double h = img.getHeight(null) * z;
		g.drawImage(img, (int) x, (int) y, (int) w, (int) h, this);
		repaint();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(img.getWidth(null),
				img.getHeight(null));
	}
}