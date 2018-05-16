package com.company;

import java.util.HashSet;
import java.util.Set;

public class BingoVerificandoNoSet extends Bingo {

    private Set<Integer> conjuntoDeBolasSorteadas;

    public BingoVerificandoNoSet(int nBolas) {
        super(nBolas);
        this.conjuntoDeBolasSorteadas = new HashSet<>();
    }

    @Override
    protected int escolherBolaDaUrna() {
        while (true) {
            int bola = random.nextInt(this.nBolas) + 1;
            if (!this.conjuntoDeBolasSorteadas.contains(bola)) {
                this.conjuntoDeBolasSorteadas.add(bola);
                return bola;
            }
        }
    }
}
