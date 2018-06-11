package com.company;

public interface Depositavel {

    float getValor();

    default String getDescricao() {
        return "DEPOSITAVEL: " + toString();
    }
}
