package com.company;

import java.util.*;

public class Main {

    private static final int N = 20000;
    private static final int MAX_VALUE = 1_000_000;

    private static void rodarTeste(Collection<Integer> lista, String nomeColecao) {
        long inicio = System.currentTimeMillis();
        int contImpares = 0;
        for (int i = 1; i <= MAX_VALUE; i += 2) {
            if (lista.contains(i)) {
                contImpares++;
            }
        }
        long duracao = System.currentTimeMillis() - inicio;

        System.out.println(String.format(
                "%s contem %d impares (tempo: %d mili-segundos)",
                nomeColecao, contImpares, duracao));
    }


    public static void main(String[] args) {

	    Random random = new Random();

        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int elemento = random.nextInt(MAX_VALUE);
            lista.add(elemento);
        }

        Set<Integer> conjunto = new HashSet<>();
        while (conjunto.size() < N) {
            int elemento = random.nextInt(MAX_VALUE);
            conjunto.add(elemento);
        }

        rodarTeste(lista, "Lista");
        rodarTeste(conjunto, "Conjunto");
    }
}
