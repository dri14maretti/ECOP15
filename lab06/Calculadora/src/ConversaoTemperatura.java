import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConversaoTemperatura extends JLabel {
    private String opcoesDeTemperatura[] = { "Celsius", "Fahrenheit", "Kelvin" };
    private JRadioButton opcoesDeTemperaturaEntradaBtn[] = new JRadioButton[3];
    private JRadioButton opcoesDeTemperaturaSaidaBtn[] = new JRadioButton[3];
    private double temperatura, temperaturaConvertida;
    private JPanel painelBotoesEntrada;
    private JPanel painelBotoesSaida;
    private JPanel painelDeBotoesGeral;
    private JPanel painelInput;
    private String selecaoDeTemperaturaEntrada = "";
    private String selecaoDeTemperaturaSaida = "";
    private int iterador = 0;

    private JLabel labelResultado;

    public ConversaoTemperatura() {
        this.temperatura = 0.0;
        this.setLayout(new BorderLayout());

        JTextField textField = new JTextField(5);

        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                temperatura = Double.parseDouble(textField.getText());
                temperaturaConvertida = converteTemperatura();
                repaint();
            }
        });

        painelInput = new JPanel();
        painelInput.setLayout(new FlowLayout());
        painelInput.add(textField);

        this.add(painelInput, BorderLayout.NORTH);

        ButtonGroup grupoDeBotoesEntrada = new ButtonGroup();
        ButtonGroup grupoDeBotoesSaida = new ButtonGroup();

        painelBotoesEntrada = new JPanel();
        painelBotoesEntrada.setLayout(new FlowLayout());
        painelBotoesEntrada.add(new Label("Botões de entrada: "));

        painelBotoesSaida = new JPanel();
        painelBotoesSaida.setLayout(new FlowLayout());
        painelBotoesSaida.add(new Label("Botões de saída: "));

        painelDeBotoesGeral = new JPanel();
        painelDeBotoesGeral.setLayout(new GridLayout(2, 1));

        opcoesDeTemperaturaEntradaBtn = new JRadioButton[opcoesDeTemperatura.length];
        opcoesDeTemperaturaSaidaBtn = new JRadioButton[opcoesDeTemperatura.length];

        for (iterador = 0; iterador < opcoesDeTemperatura.length; iterador++) {
            opcoesDeTemperaturaEntradaBtn[iterador] = new JRadioButton(opcoesDeTemperatura[iterador]);
            opcoesDeTemperaturaEntradaBtn[iterador].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    selecaoDeTemperaturaEntrada = e.getSource().toString().split("text=")[1].replace("]", "");
                    temperaturaConvertida = converteTemperatura();
                    labelResultado.setText("Resultado: " + temperaturaConvertida);
                    repaint();
                }
            });
            grupoDeBotoesEntrada.add(opcoesDeTemperaturaEntradaBtn[iterador]);
            painelBotoesEntrada.add(opcoesDeTemperaturaEntradaBtn[iterador]);

            opcoesDeTemperaturaSaidaBtn[iterador] = new JRadioButton(opcoesDeTemperatura[iterador]);
            opcoesDeTemperaturaSaidaBtn[iterador].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    selecaoDeTemperaturaSaida = e.getSource().toString().split("text=")[1].replace("]", "");
                    temperaturaConvertida = converteTemperatura();
                    labelResultado.setText("Resultado: " + temperaturaConvertida);
                    repaint();
                }
            });
            grupoDeBotoesSaida.add(opcoesDeTemperaturaSaidaBtn[iterador]);
            painelBotoesSaida.add(opcoesDeTemperaturaSaidaBtn[iterador]);
        }

        painelDeBotoesGeral.add(painelBotoesEntrada);
        painelDeBotoesGeral.add(painelBotoesSaida);

        labelResultado = new JLabel("Resultado: ");

        this.add(painelDeBotoesGeral, BorderLayout.CENTER);
        this.add(labelResultado, BorderLayout.SOUTH);

    }

    public double converteTemperatura() {
        double resultadoDaConversao = 0.0;

        switch (selecaoDeTemperaturaEntrada) {
        case "Celsius":
            switch (selecaoDeTemperaturaSaida) {
            case "Celsius":
                return temperatura;
            case "Fahrenheit":
                return (temperatura * 1.8) + 32;
            case "Kelvin":
                return temperatura + 273.15;
            }
            break;
        case "Fahrenheit":
            switch (selecaoDeTemperaturaSaida) {
            case "Celsius":
                return (temperatura - 32) / 1.8;
            case "Fahrenheit":
                return temperatura;
            case "Kelvin":
                return (temperatura - 32) / 1.8 + 273.15;
            }
            break;
        case "Kelvin":
            switch (selecaoDeTemperaturaSaida) {
            case "Celsius":
                return temperatura - 273.15;
            case "Fahrenheit":
                return ((temperatura - 273.15) * 1.8) + 32;
            case "Kelvin":
                return temperatura;
            }
            break;
        }

        return resultadoDaConversao;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Conversão de Temperatura");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ConversaoTemperatura());
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
