public class Jogo {

    private Sorteador sorteador;

    public Jogo(Sorteador sorteador) {
        this.sorteador = sorteador;
    }

    public void jogar(int numeroDeRodadas) {
        int pontosJogadorA = 0;
        int pontosJogadorB = 0;
        int empates = 0;

        for (int i = 1; i<= numeroDeRodadas; i++) {
            int resultadoJogadorA = sorteador.sortear();
            int resultadoJogadorB = sorteador.sortear();



        }

        System.out.println(String.format("\nPontos Jogador A: %d\nPontos Jogador B: %d\nEmpates: %d",
                pontosJogadorA, pontosJogadorB, empates));
    }
}
