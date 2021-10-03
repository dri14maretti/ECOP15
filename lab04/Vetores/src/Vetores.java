import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Vetores extends JFrame {
    private JTextField lerVetor1;
    private JTextField lerVetor2;
    private JLabel display;
    private JButton calcularBtn;

    private int[] vetor;
    private int[] vetor2;

    public Vetores() {
        super("Vetores");
        setLayout(new FlowLayout());

        add(new JLabel("Ler os vetores na forma a,b,c,...,x,y,z :\n"));
        lerVetor1 = new JTextField(20);
        add(lerVetor1);

        lerVetor2 = new JTextField(20);
        add(lerVetor2);

        calcularBtn = new JButton("Calcular");
        calcularBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processaInformacoesVetor();
            }
        });

        add(calcularBtn);
        display = new JLabel("      ");
        display.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(display);
        setSize(500, 300);
        setVisible(true);
    }

    private void processaInformacoesVetor() {
        String exitText = "";

        String[] vetor1 = lerVetor1.getText().split(",");
        String[] vetor2 = lerVetor2.getText().split(",");

        this.vetor = new int[vetor1.length];
        this.vetor2 = new int[vetor2.length];

        for (int i = 0; i < vetor1.length; i++) {
            this.vetor[i] = Integer.parseInt(vetor1[i]);
        }

        for (int i = 0; i < vetor2.length; i++) {
            this.vetor2[i] = Integer.parseInt(vetor2[i]);

        }

        int produtoEscalar = this.produtoEscalar();

        exitText = "Produto escalar dos vetores vale: " + produtoEscalar + "\n";
        exitText += " e os vetores " + (isOrtogonal() ? "são" : "não são") + " ortogonais.\n";

        display.setText(exitText);
    }

    public int produtoEscalar() {
        int produtoEscalar = 0;

        if (this.vetor.length == this.vetor2.length) {
            for (int i = 0; i < this.vetor.length; i++) {
                produtoEscalar += this.vetor[i] * this.vetor2[i];
            }
            return produtoEscalar;
        }

        return -1;
    }

    public boolean isOrtogonal() {
        return this.produtoEscalar() == 0;
    }

}
