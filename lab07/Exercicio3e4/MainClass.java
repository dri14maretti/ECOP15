
import java.util.Scanner;

import javax.swing.*;

public class MainClass {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Exercicio");
        janela.add(new MyColorChooser());
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(600, 600);
        janela.setVisible(true);
    }

    public static void openFile() {
        try {
            output = new Formatter("clientes.txt");
        } catch (SecurityException securityException) {
            System.err.println("Erro de segurança impedindo que a aplicação salve o arquivo no disco");
            System.exit(1);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Erro ao abrir o arquivo de saida");
            System.exit(1);
        }
    }

    public static void addRecords() {
        Scanner input = new Scanner(System.in);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.CANCEL_OPTION) {
            System.exit(0);
        }
        System.out.println("Digite o nome do cliente: ");

        while (input.hasNext()) {
            try {
                output.format("%s\n", input.nextLine());
            } catch (FormatterClosedException formatterClosedException) {
                System.err.println("Erro ao salvar o arquivo");
                System.exit(1);
            }
        }
    }
}
