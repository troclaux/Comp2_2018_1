package com.company;

import java.util.List;

public class Main {

    private static int N = 1000;

    public static void simularJogo(Bingo bingo) {
        long inicio = System.currentTimeMillis();
        for (int i = 1; i <= N; i++) {
            int bola = bingo.sortearProxima();
        }
        long duracao = System.currentTimeMillis() - inicio;

//        System.out.println(bingo.listarTodosOsSorteios());
        System.out.println(String.format(
                "duracao = %d mili-segundos (%s)", duracao, bingo.getClass().getName()));
    }

    public static void main(String[] args) {
	    Bingo bingoVerificandoNaLista = new BingoVerificandoNaLista(N);
        Bingo bingoRemovendoDaUrna = new BingoRemovendoDaUrna(N);
        Bingo bingoVerificandoNoSet = new BingoVerificandoNoSet(N);
        Bingo bingoComKnuthShuffle = new BingoComKnuthShuffle(N);

        simularJogo(bingoVerificandoNaLista);
        simularJogo(bingoRemovendoDaUrna);
        simularJogo(bingoVerificandoNoSet);
        simularJogo(bingoComKnuthShuffle);
    }
}
