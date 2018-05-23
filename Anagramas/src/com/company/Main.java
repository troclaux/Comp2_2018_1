package com.company;

public class Main {

    public static void main(String[] args) {
        if (DetectorAnagramas.saoAnagramas("AAB", "ABB")) {
            System.out.println("Sao anagramas!!!");
        } else {
            System.out.println("Nao sao anagramas!!!!!");
        }
    }
}
