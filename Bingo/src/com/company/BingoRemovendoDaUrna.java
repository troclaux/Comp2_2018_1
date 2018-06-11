package com.company;

import java.util.ArrayList;
import java.util.List;

public class BingoRemovendoDaUrna extends Bingo {

    private List<Integer> urna;

    public BingoRemovendoDaUrna(int nBolas) {
        super(nBolas);
        this.urna = new ArrayList<>(nBolas);
        prepararUrna();
    }

    private void prepararUrna() {
        this.urna.clear();
        for (int bola = 1; bola <= this.nBolas; bola++) {
            this.urna.add(bola);
        }
    }

    @Override
    protected int escolherBolaDaUrna() {
        int indice = this.random.nextInt(this.urna.size());
        int bola = this.urna.get(indice);
        this.urna.remove(indice);
        return bola;
    }

    @Override
    public void zerar() {
        super.zerar();
        prepararUrna();
    }
}
