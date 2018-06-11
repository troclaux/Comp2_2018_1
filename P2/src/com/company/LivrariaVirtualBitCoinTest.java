package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LivrariaVirtualBitCoinTest {

    private LivrariaVirtualBitCoin livraria;
    private Livro livro;
    private Livro livro2;
    private final long cpfDoComprador = 1234L;
    private final String nomeDoComprador = "Fulano";

    @Before
    public void setUp() {
        Transportadora transportadora = new Transportadora();
        livraria = new LivrariaVirtualBitCoin(transportadora);
        livro = new Livro("Livro 1", "Autor do livro 1");
        livro.setPreco(40);
        livraria.atualizarItemNoEstoque(livro, 10);
        livraria.atualizarItemNoEstoque(livro2, 10);
        livraria.cadastrarComprador(cpfDoComprador, nomeDoComprador, "Casa do Fulano");

    }

    @Test
    public void testeCompraBemSucedida() {
        assertTrue(livraria.adicionarAoCarrinho(cpfDoComprador, livro, 2));
        Recibo recibo = livraria.finalizarCompra(cpfDoComprador);
        assertEquals(8, (int) livraria.estoque.get(livro));
        Recibo reciboEsperado = new Recibo(nomeDoComprador, 40 / LivrariaVirtualBitCoin.COTACAO_BIT_COIN, "bitcoins");
        assertEquals(reciboEsperado, recibo);
    }

    @Test
    public void testeCompraOutraInstanciaDoMesmoLivro() {
        Livro livroDesejado = new Livro("Livro 1", "Autor do livro 1");
        assertTrue(livraria.adicionarAoCarrinho(cpfDoComprador, livroDesejado, 1));
    }

    @Test
    public void testeEstoqueInsuficiente() {
        assertFalse(livraria.adicionarAoCarrinho(cpfDoComprador, livro, 11));
    }

    @Test
    public void testeCompradorDesconhecido() {
        assertFalse(livraria.adicionarAoCarrinho(9999L, livro, 1));
    }
}