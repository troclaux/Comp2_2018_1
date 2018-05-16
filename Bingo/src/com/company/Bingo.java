package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Bingo {

    protected List<Integer> sorteios;
    protected int nBolas;
    protected Random random;

    public Bingo(int nBolas) {
        this.nBolas = nBolas;
        this.random = new Random();
        this.sorteios = new ArrayList<>(nBolas);
    }

    public int sortearProxima() {
        int bola = escolherBolaDaUrna();
        this.sorteios.add(bola);
        return bola;
    }

    public List<Integer> listarTodosOsSorteios() {
        return this.sorteios;
    }

    public void zerar() {
        this.sorteios.clear();
    }

    /**
     * @return um int, representando uima bola da urna, sem reposição,
     *         ou seja, não permitirá sorteios repetidos.
     */
    protected abstract int escolherBolaDaUrna();
}
