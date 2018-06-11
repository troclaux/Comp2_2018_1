package com.company;

public class Comprador<T extends Vendavel> {

    private final Long cpf;
    private String nome;
    private String endereco;
    CarrinhoDeCompras<T> carrinhoDeCompras;

    public Comprador(Long cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        this.carrinhoDeCompras = new CarrinhoDeCompras<>();
    }

    CarrinhoDeCompras<T> getCarrinhoDeCompras() {
        return this.carrinhoDeCompras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
