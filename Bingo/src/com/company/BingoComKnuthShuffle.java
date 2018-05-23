package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BingoComKnuthShuffle extends Bingo {

    private List<Integer> urnaPreOrdenada;

    public BingoComKnuthShuffle(int nBolas) {
        super(nBolas);
    }

    private void prepararUrnaEmbaralhada() {
        this.urnaPreOrdenada = new ArrayList<>(this.nBolas);
        for (int bola = 1; bola <= nBolas; bola++) {
            this.urnaPreOrdenada.add(bola);
        }
        embaralharUrna();
    }

    private void embaralharUrna() {
        Collections.shuffle(this.urnaPreOrdenada);  // Knuth shuffle
    }

    @Override
    protected int escolherBolaDaUrna() {
        if (this.urnaPreOrdenada == null) {
            // lazy instantiation
            prepararUrnaEmbaralhada();
        }
        return this.urnaPreOrdenada.get(this.sorteios.size());
    }

    @Override
    public void zerar() {
        super.zerar();
        embaralharUrna();
    }
}
