package com.company;

import java.util.*;

public class Main {

    private static final int N = 160_000;
    private static final int MAX_VALUE = 1_000_000;
    private static final int SOMA_DESEJADA = -1;

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

    /**
     * Enontra dois inteiros na lista dada que somem o valor desejado.
     *
     * @param lista Lista de inteiros
     * @param somaDesejada A soma desejada
     * @return Um dos inteiros encontrados, caso exista um par que some o valor desejado;
     *         null, caso contrario.
     */
    public static Integer encontrarPar(List<Integer> lista, int somaDesejada) {
        for (int i = 0; i < lista.size(); i++) {
            int elemento = lista.get(i);
            
//            for (int j = i+1; j < lista.size(); j++) {
//                int outro = lista.get(j);
//                if (elemento + outro == somaDesejada) {
//                    return elemento;
//                }
//            }
            int complementar = somaDesejada - elemento;
            if (lista.contains(complementar)) {
                return elemento;
            }
        }
        return null;
    }

    public static void main(String[] args) {

	    Random random = new Random();

        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int elemento = random.nextInt(MAX_VALUE);
            lista.add(elemento);
        }

        long inicio = System.currentTimeMillis();
        Integer resultado = encontrarPar(lista, SOMA_DESEJADA);
        long duracao = System.currentTimeMillis() - inicio;
        System.out.println(resultado == null ? "Nao encontrei" :
                String.format("Encontrei um par: %d, %d",
                        resultado, SOMA_DESEJADA - resultado));
        System.out.println("Duracao = " + duracao);

    }
}
