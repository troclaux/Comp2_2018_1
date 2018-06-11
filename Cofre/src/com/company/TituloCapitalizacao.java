package com.company;

public class TituloCapitalizacao implements Depositavel {
    private Pessoa titular;

    private int quantidadeCotas;

    private float valorDaCota;

    public TituloCapitalizacao(Pessoa titular, int quantidadeDeCotas) {
        this.titular = titular;
        this.quantidadeCotas = quantidadeDeCotas;
    }

    public float getValor() {
        return quantidadeCotas * valorDaCota;
    }

    public String getDescricao() {
        return String.format("Titulo do %s", titular.getNome());
    }
}
