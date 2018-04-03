package br.ufrj;

public class Palindromo {

    public static boolean ehPalindromo(String texto) {
        int tamanho = texto.length();
        for (int i = 0; i < tamanho; i++) {
            if (texto.charAt(i) != texto.charAt(tamanho - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
	    String[] palavras = new String[] {"arara", "goiaba", "socorrammesubinoonibusemmarrocos"};

        for (String palavraTeste : palavras) {
            System.out.println(String.format("%s %s um palindromo.", palavraTeste,
                    ehPalindromo(palavraTeste) ? "eh" : "nao eh"));
        }
    }
}
