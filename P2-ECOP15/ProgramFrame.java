import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class ProgramFrame extends JFrame {

	private JDesktopPane theDesktop;

	public ProgramFrame() {
		super("ECOP15 - Prova 02");

		JMenuBar bar = new JMenuBar();

		JMenu file = new JMenu("Arquivo");
		JMenuItem exit = new JMenuItem("Sair");
		JMenuItem about = new JMenuItem("Sobre...");

		file.add(about);
		file.addSeparator();
		file.add(exit);
		exit.addActionListener(e -> System.exit(0));
		about.addActionListener(e -> JOptionPane.showMessageDialog(null,
				"Sobre o software:",
				"Lab de Programação Aplicada - ECOP15\nAdriano Carvalho Maretti - 2020009562\nData: 16/12/2021",
				JOptionPane.INFORMATION_MESSAGE));

		bar.add(file);

		JMenu show = new JMenu("Exibir");
		JMenuItem transition = new JMenuItem("Fazer transição");

		show.add(transition);
		transition.addActionListener(e -> {
			JInternalFrame frame = new JInternalFrame("Transicao", true, true, false, true);
			Transition panel = new Transition();
			frame.add(panel, BorderLayout.CENTER);
			frame.pack();
			theDesktop.add(frame);
			frame.setVisible(true);
		});
		bar.add(show);

		this.setJMenuBar(bar);

		theDesktop = new JDesktopPane();
		this.add(theDesktop);
	}
}

class Transition extends JPanel {

	private Image programmer, watch, shownImg;
	private static int width, height, x = 0;
	private int[] pixels, result;
	private PixelGrabber grabber1, grabber2;
	private Timer timer, timer2;
	private double seconds, minutes, hours;

	public Transition() {
		programmer = new ImageIcon(getClass().getResource("img/programming.jpg")).getImage();
		watch = new ImageIcon(getClass().getResource("img/relogio.jpg")).getImage();

		// inicio relogio
		timer2 = new Timer(1000, e -> {
			seconds -= 6;
			if (seconds <= -360) {
				seconds = 0;
			}
			minutes -= 360.0 / (60 * 60);
			if (minutes <= -360) {
				minutes = 0;
			}
			hours -= 360.0 / (60 * 60 * 12);
			if (hours <= -360) {
				hours = 0;
			}
			repaint();
		});
		timer2.start();

		Calendar calendar = Calendar.getInstance();
		seconds = (-6) * calendar.get(Calendar.SECOND);
		minutes = (-6) * (calendar.get(Calendar.MINUTE) - seconds / 360);
		hours = (-30) * (calendar.get(Calendar.HOUR) - minutes / 360);

		height = watch.getHeight(this);
		width = watch.getWidth(this);

		pixels = new int[width * height];
		grabber1 = new PixelGrabber(programmer, 0, 0, width, height, pixels, 0, width);

		result = new int[(width + 1) * height];
		grabber2 = new PixelGrabber(watch, 0, 0, width, height, result, 0, width);

		try {
			grabber1.grabPixels();
			grabber2.grabPixels();
		} catch (InterruptedException ex) {
			System.out.println("Erro!");
		}

		timer = new Timer(50, event -> {
			repaint();
			x++;
		});
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < width; i++) {
			if (x * width + i < width * height)
				result[width * x + i] = pixels[width * x + i];
			else {
				try {
					grabber2 = new PixelGrabber(watch, 0, 0, width, height, result, 0, width);
					grabber2.grabPixels();
				} catch (InterruptedException ex) {
					System.out.println("Erro!");
				}
				x = 0;
			}

		}

		shownImg = createImage(new MemoryImageSource(width, height, result, 0, width));
		g.drawImage(shownImg, 0, 0, this);

		int x = 0, y = 0;
		int larg = getWidth() / 2;
		int alt = getHeight() / 2;
		g.translate(getWidth() / 2, getHeight() / 2);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(3.0f));

		x = (int) (larg * .8 * Math.sin(Math.toRadians(seconds) - Math.PI));
		y = (int) (alt * .8 * Math.cos(Math.toRadians(seconds) - Math.PI));
		g.setColor(Color.BLUE);
		g.drawLine(0, 0, x, y);

		x = (int) (larg * .65 * Math.sin(Math.toRadians(minutes) - Math.PI));
		y = (int) (alt * .65 * Math.cos(Math.toRadians(minutes) - Math.PI));
		g.setColor(Color.GREEN);
		g2d.setStroke(new BasicStroke(5.0f));
		g.drawLine(0, 0, x, y);

		x = (int) (larg * .55 * Math.sin(Math.toRadians(hours) - Math.PI));
		y = (int) (alt * .55 * Math.cos(Math.toRadians(hours) - Math.PI));
		g.setColor(Color.ORANGE);
		g2d.setStroke(new BasicStroke(8.0f));
		g.drawLine(0, 0, x, y);

	}

	public Dimension getPreferredSize() {
		return new Dimension(watch.getWidth(null),
				watch.getHeight(null));
	}
}
