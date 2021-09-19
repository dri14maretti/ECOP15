import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        DrawCircle circle = new DrawCircle();
        JFrame janela = new JFrame();
        
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.add(circle);
        janela.setSize(230, 250);
        janela.setVisible(true);
    }
}
