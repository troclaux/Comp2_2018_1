package com.company;

public class Metal extends ElementoQuimico {

    private int nivelBrilho;
    private int condutividadeEletrica;
    private float calorEspecifico;
    protected float densidade;

    public Metal(int numeroAtomico, float densidade) {
        super(numeroAtomico);
        this.densidade = densidade;
    }
}
