
public class StringRNA {
    private String cadeiaRNA;

    private String bases[][] = { { "Alanine", "A", "GCU", "GCC", "GCA", "GCG" },
            { "Arginine", "R", "CGU", "CGC", "CGA", "CGG", "AGA", "AGG" }, { "Aspartic Acid", "D", "GAU", "GAC" },
            { "Arparginine", "N", "AAU", "AAC" }, { "Cysteine", "C", "UGU", "UGC" },
            { "Glutamic acid", "E", "GAA", "GAG" }, { "Glutamine", "Q", "CAA", "CAG" },
            { "Glycine", "G", "GGU", "GGC", "GGA", "GGG" }, { "Histine", "H", "CAU", "CAC" },
            { "Isoleucine", "I", "AUU", "AUC", "AUA" }, { "Leucine", "L", "UUA", "UUG", "CUU", "CUC", "CUA", "CUG" },
            { "Lysine", "K", "AAA", "AAG" }, { "Methionine", "M", "AUG" }, { "Phenylalanine", "F", "UUU", "UUC" },
            { "Proline", "P", "CCU", "CCC", "CCA", "CCG" }, { "Serine", "S", "AGU", "AGC", "UCU", "UCC", "UCA", "UCG" },
            { "Threonine", "T", "ACU", "ACC", "ACA", "ACG" }, { "Tryptophan", "W", "UGG" },
            { "Tyrosine", "X", "UAU", "UAC" }, { "Valine", "V", "GUU", "GUC", "GUA", "GUG" },
            { "Sinais de término", ".", "UAA", "UAG", "UGA" } };

    public char charAt(int index) {
        return this.cadeiaRNA.charAt(index);
    }

    public boolean confereRNA(String baseRecebida) {
        for (int i = 0; i < baseRecebida.length(); i++) {
            if (baseRecebida.charAt(i) != 'A' && baseRecebida.charAt(i) != 'U' && baseRecebida.charAt(i) != 'G'
                    && baseRecebida.charAt(i) != 'C') {
                return false;
            }
        }
        return true;
    }

    public StringRNA(String stringPassada) {
        stringPassada = stringPassada.toUpperCase();

        if (confereRNA(stringPassada)) {
            this.cadeiaRNA = stringPassada;
            return;
        }

        this.cadeiaRNA = "";
    }

    public String toString() {
        return this.cadeiaRNA;
    }

    public int length() {
        return this.cadeiaRNA.length();
    }

    public boolean equals(String comparada) {
        return this.cadeiaRNA.equals(comparada);
    }

    public int quantos(char base) {
        int contador = 0;
        for (int i = 0; i < this.cadeiaRNA.length(); i++) {
            if (this.cadeiaRNA.charAt(i) == base) {
                contador++;
            }
        }
        return contador;
    }

    public String findBases() {
        String basesEncontrada = "";
        int contadora = 0;
        while (contadora + 2 < this.cadeiaRNA.length()) {
            String temp = this.cadeiaRNA.substring(contadora, contadora + 3);
            for (int i = 0; i < 21; i++) {
                for (int j = 2; j < this.bases[i].length; j++) {
                    if (temp.equals(this.bases[i][j])) {
                        basesEncontrada += this.bases[i][1];
                        ;
                    }
                }
            }
            contadora += 3;
        }

        return basesEncontrada != "" ? basesEncontrada : "Nenhuma base encontrada";
    }
}
