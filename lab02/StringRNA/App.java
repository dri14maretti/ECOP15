
public class App {
    public static void main(String[] args) throws Exception {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println(" Digite uma cadeia de RNA: ");
        String stringDeEntrada = input.next();
        StringRNA cadeiaRNA = new StringRNA(stringDeEntrada);

        if (cadeiaRNA.equals(""))
            System.out.println("Cadeia de caracteres inválida! ");
        else {
            System.out.println("A cadeia de caracteres digitada foi: " + cadeiaRNA);
            System.out.println("Ela possui : " + cadeiaRNA.quantos('A') + " letras A.");
            System.out.println("Ela possui : " + cadeiaRNA.quantos('C') + " letras C.");
            System.out.println("Ela possui : " + cadeiaRNA.quantos('G') + " letras G.");
            System.out.println("Ela possui : " + cadeiaRNA.quantos('U') + " letras U.");
            System.out.println("O primeiro caractere na cadeia de RNA é: " + cadeiaRNA.charAt(0));

            System.out.println("As bases encontradas foram: " + cadeiaRNA.findBases());
        }

    }
}
