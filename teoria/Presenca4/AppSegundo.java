import java.util.Arrays;

public class AppSegundo {
    public static float produtoDosTermosPassados(int ...termos) {
        int produto = 1;
        for (int termo : termos) {
            produto *= termo;
        }
        return produto;
    }
    public static void main(String[] args) throws Exception {
        int[] f = new int[10];
        System.out.println("Posição 6 do f = " + f[5]);

        int[] g = new int[5];

        Arrays.fill(g, 8);

        for (int termo : g) 
            System.out.println("Posição do g = " + termo);

        float[] c = new float[100];

        for (int i = 0; i < c.length; i++) {
            c[i] = i + 1;
        }

        float soma = 0;
        for (float termo : c) {
            soma += termo;
        }
        System.out.println("A soma foi de = " + soma);

        int[] a = new int[11];
        int[] b = new int[34];

        for(int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }

        float[] w = new float[99];

        for (int i = 0; i < w.length; i++) {
            w[i] = (float) (Math.random() * 100);
        }

        Arrays.sort(w);
       
        System.out.println("Menor valor: " + w[0]);
        System.out.println("Maior valor: " + w[w.length - 1]);

        int[] arrayTeste = new int[10];

        for(int i = 0; i < arrayTeste.length; i++) {
            arrayTeste[i] = (int)(Math.random() * 10 + 1);
            System.out.println(arrayTeste[i]);
        }

        System.out.println("O produto dos termos do array é = " + produtoDosTermosPassados(arrayTeste));
    }
}
