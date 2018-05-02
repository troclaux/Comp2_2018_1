package com.company;

public class Ouro extends Metal implements TransportavelEDepositavel {

    private int gramas;
    private float precoPorGrama;

    public Ouro() {
        super(56, 150);  // chutado!
    }

    public float getValor() {
        return this.gramas * this.precoPorGrama;
    }

    public String getDescricao() {
        return "Barras de ouro!";
    }

    public int getPeso() {
        return this.gramas;
    }

    public int getVolume() {
        return (int) (this.gramas / this.densidade);
    }
}
