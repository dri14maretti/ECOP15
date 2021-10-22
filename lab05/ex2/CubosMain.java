import javax.swing.*;

public class CubosMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cubos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new Cubos());

        frame.setSize(1280, 720);
        frame.setVisible(true);
    }
}
