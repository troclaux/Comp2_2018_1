package com.company;

import java.util.Random;

public class Album {

    /* Array que indica, na posicao j, quantas figurinhas j eu tenho */
    private int[] figurinhas;

    /* Quantidade de figurinhas distintas que existem */
    private int tamanho;

    private int quantFigurinhas;
    private int quantRepetidas;

    private float precoAlbum;
    private float precoFigurinha;

    public Album(int tamanho) {
        this.tamanho = tamanho;
        this.figurinhas = new int[tamanho + 1];  // desprezando a posicao 0
        esvaziarAlbum();
    }

    public float getPrecoAlbum() {
        return precoAlbum;
    }

    public void setPrecoAlbum(float precoAlbum) {
        if (precoAlbum >= 0) {
            this.precoAlbum = precoAlbum;
        } else {
            System.out.println("Valor invalido!!!");
        }
    }

    public float getPrecoFigurinha() {
        return precoFigurinha;
    }

    public void setPrecoFigurinha(float precoFigurinha) {
        this.precoFigurinha = precoFigurinha;
    }

    public int getQuantRepetidas() {
        return this.quantRepetidas;
    }

    public void trocarFigurinha(int figurinhaQueEntra, int repetidaQueSai) {
        if (descartarFigurinhaRepetida(repetidaQueSai)) {
            acrescentarFigurinha(figurinhaQueEntra);
        } else {
            System.out.println("Impossivel fazer essa troca!");
        }
    }

    public void esvaziarAlbum() {
        for (int i = 1; i <= this.tamanho; i++) {
            this.figurinhas[i] = 0;
        }
        this.quantFigurinhas = 0;
        this.quantRepetidas = 0;
    }

    public void acrescentarFigurinha(int figurinha) {
        if (this.figurinhas[figurinha] == 0) {
            // figurinha inedita
            this.quantFigurinhas++;
        } else {
            // figurinha repetida
            this.quantRepetidas++;
        }
        this.figurinhas[figurinha]++;
    }

    /**
     * Descarta um figurinha repetida daquele album.
     *
     * @param figurinha O numero da figurinha que eu quero descartar
     * @return true, se a figurinha foi descartada com sucesso;
     *         false, caso contrario (se a figurinha nao era repetida)
     */
    public boolean descartarFigurinhaRepetida(int figurinha) {
        if (this.figurinhas[figurinha] > 1) {
            this.figurinhas[figurinha]--;
            this.quantRepetidas--;
            return true;
        }

        System.out.println("A figurinha nao eh repetida!!");
        return false;
    }

    private boolean isCheio() {
        return this.quantFigurinhas == this.tamanho;
    }

    public static void simularPreenchimentoDoAlbum() {
        Random random = new Random();

        int tamanho = 690;
        int nExperimentos = 10000;

        Album albumDaCopa = new Album(tamanho);

        long totalFigurinhasCompradas = 0;

        for (int i = 0; i < nExperimentos; i++) {
            while(!albumDaCopa.isCheio()) {
                int novaFigurinha = random.nextInt(tamanho) + 1;
                albumDaCopa.acrescentarFigurinha(novaFigurinha);
            }
            totalFigurinhasCompradas += tamanho + albumDaCopa.getQuantRepetidas();
            albumDaCopa.esvaziarAlbum();
        }

        float mediaFigurinhasCompradas = totalFigurinhasCompradas / (float) nExperimentos;
        System.out.println(String.format(
                "Foram compradas %.2f figurinhas em media.",
                mediaFigurinhasCompradas));

    }

    public static void main(String[] args) {
        simularPreenchimentoDoAlbum();
    }
}

