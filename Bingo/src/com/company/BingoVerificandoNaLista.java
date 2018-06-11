package com.company;

import java.util.Random;

public class BingoVerificandoNaLista extends Bingo {

    public BingoVerificandoNaLista(int nBolas) {
        super(nBolas);
    }

    @Override
    protected int escolherBolaDaUrna() {
        while (true) {
            int bola = random.nextInt(this.nBolas) + 1;
            if (!this.sorteios.contains(bola)) {
                return bola;
            }
        }
    }
}
