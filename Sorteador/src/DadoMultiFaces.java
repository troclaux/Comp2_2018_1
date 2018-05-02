public class DadoMultiFaces extends Sorteador {

    private int numeroDeFaces;

    public DadoMultiFaces(int numeroDeFaces) {
        this.numeroDeFaces = numeroDeFaces;
    }

    @Override
    int obterResultadoSorteio() {
        // Retorna um inteiro escolhido uniformemente entre 1 e numeroDeFaces (inclusive).
        return this.random.nextInt(this.numeroDeFaces) + 1;
    }
}
