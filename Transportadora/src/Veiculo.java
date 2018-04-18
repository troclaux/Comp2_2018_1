public abstract class Veiculo {

    private String nome;
    private float velocCorrente;
    private float velocMaxima;
    private int maxPassageiros;

    public Veiculo(String nome, float velocMaxima) {
        this.nome = nome;
        this.velocMaxima = velocMaxima;
        System.out.println("Construtor de Veiculo");
    }

    public void parar() {
        this.velocCorrente = 0;
        System.out.println("Parei!");
    }

    public void andarPraFrente(float velocidade) {
        if (this.velocCorrente == 0) {
            acelerar(velocidade, 10);
        } else {
            acelerar(velocidade, 3);
        }
        System.out.println(
                String.format("Comecei a andar pra frente com velocidade %.2f Km/h", velocidade));
    }

    /**
     * Faz com que o veiculo modifique sua velocidade corrente ate a velocidade desejada
     * durante o intervalo de tempo passado como parâmetro.
     *
     * @param velocDesejada a velocidade final a ser atingida
     * @param tempoEmSegundos o tempo durante o qual a velocidade irá variar
     */
    public abstract void acelerar(float velocDesejada, int tempoEmSegundos);

    public float getVelocCorrente() {
        return this.velocCorrente;
    }

    public void setVelocCorrente(float velocCorrente) {
        if (velocCorrente >= 0 && velocCorrente <= this.velocMaxima) {
            this.velocCorrente = velocCorrente;
            System.out.println("Alterei a veloc corrente via setVelocCorrente");
        } else {
            System.out.println(String.format("Velocidade invalida: %.2f", velocCorrente));
        }
    }

    @Override
    public String toString() {
        return String.format("%s -- velocidade: %.2f", this.nome, this.velocCorrente);
    }
}
