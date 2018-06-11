package com.company;

public class Pessoa {

    private String nome;
    private long cpf;

    public Pessoa(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }
}
