public class Calculadora {
    public static void main(String[] args) throws Exception {
        try {

            float number1 = Float.parseFloat(args[0]);
            String operator = args[1];
            float number2 = Float.parseFloat(args[2]);

            float resultado = realizarOperacao(number1, operator, number2);

            System.out.println("Resultado: de " + number1 + " " + operator + " " + number2 + " = " + resultado);
        } catch (ArrayIndexOutOfBoundsException e) // se alguma exceção foi jogada, ela será pega por este bloco
        {
            System.out.println("Parametros insuficientes! São necessários no mínimo três");
            // e.printStackTrace();
        } catch (NumberFormatException e) // se alguma exceção foi jogada, ela será pega por este bloco
        {
            System.out.println("Os parametros 1 e 3 devem ser números reais");
            // e.printStackTrace();
        } catch (Exception e) // se alguma exceção foi jogada, ela será pega por este bloco
        { // é necessário passar uma instância de uma classe de exceções !
            System.out.println(e);
            e.printStackTrace();
        }
    }

    private Path getFileOrDirectoryPath() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int arquivoLido = fileChooser.showOpenDialog(this);
        if (arquivoLido == JFileChooser.CANCEL_OPTION)
            System.exit(1);
        return fileChooser.getSelectedFile().toPath();
    }

    public static float realizarOperacao(float a, String operador, float b) throws Exception {
        switch (operador) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                try {
                    return a / b;
                } catch (ArithmeticException e) {
                    throw new Exception("Não é possível dividir por 0");
                }

            default:
                throw new Exception("Erro: Operador não reconhecido!");
        }
    }
}
