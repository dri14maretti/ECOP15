import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Formatter;

public class Exercicio2 {

    private static Scanner input;
    public static Formatter output;
    private static int chave;
    private static String nome;

    public static void openFile() {
        try {
            input = new Scanner(Paths.get(nome + ".txt"));
            output = new Formatter("saida.txt");
        } catch (IOException ex) {
            System.out.println("Não foi possível abrir o arquivo!\n" + ex);
            closeFile();
            System.exit(0);
        }
    }

    public static void read() {
        while (input.hasNext()) {
            String text;
            text = input.nextLine();

            for (char i : text.toCharArray()) {
                if ((i >= 'a') && (i <= 'z')) {
                    if ((char) (i + chave) > 'z')
                        output.format("%s", (char) (i + chave - 26));
                    else
                        output.format("%s", (char) (i + chave));
                } else if ((i >= 'A') && (i <= 'Z')) {
                    if ((char) (i + chave) > 'Z')
                        output.format("%s", (char) (i + chave - 26));
                    else
                        output.format("%s", (char) (i + chave));
                } else
                    output.format("%c", i);
            }
            output.format("%n");
        }
    }

    public static void closeFile() {
        if (input != null)
            input.close();
        if (output != null)
            output.close();

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite a chave: ");
        chave = input.nextInt();
        chave = 1 + chave % 25;

        System.out.println("Digite o nome do arquivo: ");
        nome = input.next();

        openFile();
        read();
        closeFile();
    }
}
