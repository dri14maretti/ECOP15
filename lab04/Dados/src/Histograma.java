import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Histograma extends JPanel {

    private final ArrayList<Integer> dados = new ArrayList<Integer>();
    private final ArrayList<Integer> freq = new ArrayList<Integer>();

    public Dimension getPreferredSize() {
        return new Dimension(700, 530);
    }

    public void setDados(ArrayList<Integer> array) {
        // limpar vetores internos
        dados.clear();
        freq.clear();
        // criar vet temporario para manipula��es
        int[] copia = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            copia[i] = array.get(i);
        }
        // ordenar dados
        Arrays.sort(copia);
        // encontrar frequencia e preencher dados
        int cont;
        for (int i = 0; i < array.size(); i++) {
            cont = 1;
            for (int j = array.size() - 1; j >= 0; j--)
                if (copia[i] == copia[j] && i != j)
                    cont++;
            if (!dados.contains(copia[i])) {
                dados.add(copia[i]);
                freq.add(cont);
            }
        }
        repaint();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.setBackground(Color.WHITE);

        graphics.setFont(new Font("Serif", Font.BOLD, 14));
        Random random = new Random();

        graphics.drawLine(25, 25, 25, 500);
        graphics.drawString("Frequ�ncia", 30, 20);
        graphics.drawLine(25, 480, 600, 480);
        graphics.drawString("Soma", 610, 482);

        // encontrar maior valor para fazer array escala.
        int aux = 0;
        for (int i = 0; i < freq.size(); i++)
            if (freq.get(i) > aux)
                aux = freq.get(i);

        aux++;

        for (int i = 0; i < dados.size(); i++) {
            graphics.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            graphics.fillRect(35 + 40 * i, 480 - (455 / aux) * freq.get(i), 40, (455 / aux) * freq.get(i));
            graphics.setColor(Color.BLACK);
            graphics.drawLine(20, (480 - 455 / aux * freq.get(i)), 30, (480 - 455 / aux * freq.get(i)));
            graphics.drawLine(55 + 40 * i, 475, 55 + 40 * i, 485);
            graphics.drawString("" + dados.get(i), 55 + 40 * i, 500);
            graphics.drawString("" + freq.get(i), 10, (480 - 455 / aux * freq.get(i)));
        }
    }
}
