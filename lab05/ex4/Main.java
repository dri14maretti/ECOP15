import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercício 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new EscolheFormas());
        frame.setSize(300, 300);
        frame.setVisible(true);

    }
}
