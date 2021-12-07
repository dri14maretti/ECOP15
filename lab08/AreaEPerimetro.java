import javax.swing.*;
import java.awt.event.*;

public class AreaEPerimetro extends JPanel {
    public JTextField a, b, c;
    public int x = 0, y = 0, z = 0;
    public JButton botao;
    public JLabel perimetro, area, resp, resa;
    public int p, s;

    public AreaEPerimetro() {
        a = new JTextField(4);
        b = new JTextField(4);
        c = new JTextField(4);
        botao = new JButton("Calcular");
        perimetro = new JLabel("Perimetro: ");
        area = new JLabel("Area: ");
        resp = new JLabel("0");
        resa = new JLabel("0");

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    x = Integer.parseInt(a.getText());
                    y = Integer.parseInt(b.getText());
                    z = Integer.parseInt(c.getText());

                    if (x >= z + y || y >= z + x || z >= x + y) {
                        throw new ArithmeticException();
                    }

                    s = (int) Math.sqrt((p / 2) * (p / 2 - x) * (p / 2 - y) * (p / 2 - z));
                    p = x + y + z;

                    resp.setText("" + p);
                    resa.setText("" + s);

                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(AreaEPerimetro.this, "Apenas numeros inteiros!");
                    a.setText("");
                    b.setText("");
                    c.setText("");
                } catch (ArithmeticException error) {
                    JOptionPane.showMessageDialog(AreaEPerimetro.this, "Triangulo invalido!");
                    a.setText("");
                    b.setText("");
                    c.setText("");
                }
            }
        });

        resp.setText("" + p);
        resa.setText("" + s);

        add(a);
        add(b);
        add(c);
        add(botao);

        add(area);
        add(resa);
        add(perimetro);
        add(resp);
    }

    public static void main(String[] args) {
        JFrame janela = new JFrame("Lab8-Letra c)");

        JMenuBar bar = new JMenuBar();
        janela.setJMenuBar(bar);

        JMenu arquivo = new JMenu("Aquivo");
        JMenuItem sair = new JMenuItem("Sair");
        arquivo.add(sair);
        bar.add(arquivo);

        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.add(new AreaEPerimetro());
        janela.setSize(280, 200);
        janela.setVisible(true);
    }
}
