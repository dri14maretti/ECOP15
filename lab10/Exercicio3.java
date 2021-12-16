import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Exercicio3 {
    private static Scanner input, input2;

    public static void abrir() throws IOException {
        try {
            input = new Scanner(Paths.get("texto1.txt"));
            input2 = new Scanner(Paths.get("texto2.txt"));
        }

        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening file.");
            encerra(1);
        }
    }

    public static void comparar() throws IOException {
        String str = "", str2 = "";

        try // read records from file using Scanner object
        {
            while (input.hasNext() || input2.hasNext()) {

                str = input.next();
                str2 = input2.next();

                if (!str.equals(str2)) {
                    JOptionPane.showMessageDialog(null, "Os arquivos sao diferentes!!");
                    JOptionPane.showMessageDialog(null, "Diferença detectada em : [ " + str + " ] e [ " + str2 + " ]");
                    encerra(0);
                }

            }
            JOptionPane.showMessageDialog(null, "Os arquivos sao Iguais!!");
        }

        catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed.");
            JOptionPane.showMessageDialog(null, "Os arquivos sao diferentes!! \n Erro na ultima linha.");
            encerra(1);
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file.");
            encerra(1);
        }

    }

    public static void closeFile() {
        if (input != null) {
            input.close();
        }
        if (input2 != null) {
            input.close();
        }
    }

    public static void encerra(int i) {
        closeFile();
        System.exit(i);
    }

    public static void main(String[] args) throws IOException {
        abrir();
        comparar();
        closeFile();
    }
}
