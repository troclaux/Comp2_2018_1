package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BingoComKnuthShuffle extends Bingo {

    private List<Integer> urnaPreOrdenada;

    public BingoComKnuthShuffle(int nBolas) {
        super(nBolas);
        this.urnaPreOrdenada = new ArrayList<>(nBolas);
        for (int bola = 1; bola <= nBolas; bola++) {
            this.urnaPreOrdenada.add(bola);
        }
        Collections.shuffle(this.urnaPreOrdenada);  // Knuth shuffle
    }

    @Override
    protected int escolherBolaDaUrna() {
        return this.urnaPreOrdenada.get(this.sorteios.size());
    }
}
