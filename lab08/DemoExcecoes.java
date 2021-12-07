/* Classe que corrige erros em potencial em um programa exemplo */
public class DemoExcecoes {
    /* Método que permite a execução da classe */
    public static void main(String args[]) {
        try {
            // Supomos que quatro argumentos serão passados para o programa, e podemos
            // transformar estes argumentos em valores inteiros.
            int a1 = Integer.parseInt(args[0]);
            int a2 = Integer.parseInt(args[1]);
            int b1 = Integer.parseInt(args[2]);
            int b2 = Integer.parseInt(args[3]);
            // Efetuamos uma operação simples com estes valores.
            int resultado = a1 / a2 + b1 / b2;
            System.out.println("O resultado é " + resultado);
        } // fim do if que verifica se quatro argumentos foram passados
        catch (ArrayIndexOutOfBoundsException e) // se alguma exceção foi jogada, ela será pega por este bloco
        {
            System.out.println("Parametros insuficientes! São necessários no mínimo quatro");
            // e.printStackTrace();
        } catch (NumberFormatException e) // se alguma exceção foi jogada, ela será pega por este bloco
        {
            System.out.println("Os parametros devem ser numeros inteiros.");
            // e.printStackTrace();
        } catch (ArithmeticException e) // se alguma exceção foi jogada, ela será pega por este bloco
        {
            System.out.println("O segundo e quarto parametros devem ser diferentes de zero.");
            // e.printStackTrace();
        } catch (Exception e) // se alguma exceção foi jogada, ela será pega por este bloco
        { // é necessário passar uma instância de uma classe de exceções !
            System.out.println("Erro inesperado: " + e);
            e.printStackTrace();
        }
    } // fim do método main
} // fim da classe DemoExcecoes
