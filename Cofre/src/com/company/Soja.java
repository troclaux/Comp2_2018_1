package com.company;

public class Soja extends ProducaoAgricola {

    private float quilos;

    private float valorPorQuilo;

    public void setQuilos(int quilos) {
        this.quilos = quilos;
    }

    public float getValor() {
        return quilos * valorPorQuilo;
    }
}
