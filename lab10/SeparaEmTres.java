import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class SeparaEmTres {
    private static Scanner input;
    public static Formatter outputs[];
    private static int contadores[] = new int[3];

    public static void openFile() {
        // Não obrigatória (só aceita valores par)
        while (true) {
            int valorLido = input.nextInt();
            if (valorLido % 2 == 0) {
                break;
            }
            System.out.println("Valor inválido. Digite um valor par.");
            break;
        }

        try {
            input = new Scanner(Paths.get("input.txt"));
            for (int i = 0; i < 3; i++) {
                outputs[i] = new Formatter("output" + (i + 1) + ".txt");
            }
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo");
            closeFile();
            System.exit(1);
        }
    }

    public static void read() {
        while (input.hasNext()) {
            String line = input.nextLine();

            if (line.length() < 6) {
                outputs[0].format("%s %n", line);
            } else if (line.length() > 10) {
                outputs[2].format("%s %n", line);
            } else {
                outputs[1].format("%s %n", line);
            }
        }
    }

    public static void closeFile() {
        if (input != null) {
            input.close();
        }

        for (int i = 0; i < 3; i++) {
            if (outputs[i] != null) {
                outputs[i].close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        openFile();
        read();
        closeFile();
        System.out.println("<6: " + contadores[0]);
        System.out.println(">6 e <10: " + contadores[1]);
        System.out.println(">10: " + contadores[2]);
    }
}