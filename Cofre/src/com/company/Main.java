package com.company;

public class Main {

    public static void main(String[] args) {
	    Cofre cofre = new Cofre();

	    Ouro barraDeOuro = new Ouro();

	    Pessoa fulano = new Pessoa("Fulano", 1234);
	    TituloRendaFixa meuTitulo = new TituloRendaFixa(fulano);

	    cofre.depositar(meuTitulo);
	    cofre.depositar(barraDeOuro);


    }
}
