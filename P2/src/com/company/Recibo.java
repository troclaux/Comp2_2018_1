package com.company;

public class Recibo implements Transportavel {

    private String texto;

    public Recibo(String nomeComprador, float valor, String moeda) {
        this.texto = String.format("Recibo de %f %s em nome de %s",
                valor, moeda,nomeComprador);
    }

    @Override
    public float getVolume() {
        return 0.01f;
    }

    @Override
    public float getPeso() {
        return 50;
    }

    @Override
    public String toString() {
        return this.texto;
    }
}
