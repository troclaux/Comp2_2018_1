import java.util.Random;

/**
 * Classe base abstrata para sorteadores de inteiros (pseudo-)aleatórios,
 * que permite a qualquer instante se obter a média de todos os sorteios feitos.
 */
public abstract class Sorteador {

    /* Gerador de números aleatórios */
    protected Random random;
    /* Contador de sorteios */
    private int contSorteios;
    /* Acumulador para a soma de todos os inteiros sorteados na vida do sorteador */
    private long totalSorteadoAcumulado;

    public Sorteador() {
        this.random = new Random();
        this.contSorteios = 0;
        this.totalSorteadoAcumulado = 0;
    }

    /**
     * Sorteia um inteiro e atualiza os contadores internos de forma a permitir o cálculo da média.
     *
     * @return o inteiro sorteado
     */
    public int sortear() {
        this.contSorteios++;
        int resultado = obterResultadoSorteio();
        this.totalSorteadoAcumulado += resultado;
        return resultado;
    }

    /**
     * Subclasses concretas devem implementar esse método de forma a produzir um número inteiro escolhido
     * aleatoriamente de um intervalo qualquer e segundo qualquer distribuição de probabilidades,
     * dependendo da intenção da classe em questão.
     *
     * @return o inteiro sorteado
     */
    abstract int obterResultadoSorteio();

    /**
     * @return a média dos resultados obtidos em todos os sorteios
     */
    public float getMediaSorteios() {
        return this.totalSorteadoAcumulado / (float) this.contSorteios;
    }
}
