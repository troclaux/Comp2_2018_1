package com.company;

public class Cofre {

    private float valorTotalDepositado;

    /**
     * Armazena um objeto qualquer dentro do cofre.
     * Um objeto, para ser armazenado, deve possuir um `valor`
     * e uma `descricao`.
     *
     * @param objeto O objeto a ser depositado.
     */
    public void depositar(Depositavel objeto) {
        this.valorTotalDepositado += objeto.getValor();
    }

    public float getValorTotalDepositado() {
        return this.valorTotalDepositado;
    }

//    /**
//     * Imprime cada um dos objetos (descrição, valor) depositados.
//     */
//    public void imprimirInventario() {
//
//    }

}
