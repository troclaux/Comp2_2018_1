package com.company;

/**
 * Loja virtual de livros que aceita apenas bitcoins como meio de pagamento.
 */
public class LivrariaVirtualBitCoin extends LojaVirtual<Livro> {

    public final static float COTACAO_BIT_COIN = 29680.0f;  /* na pratica, leríamos esse valor
                                                               da Internet em tempo de execução,
                                                               ja que ele é dinâmico */

    public LivrariaVirtualBitCoin(Transportadora transportadora) {
        super(transportadora);
    }

    @Override
    protected Recibo efetuarPagamento(Comprador comprador, float preco) {
        float precoEmBitcoins = converterRealParaBitcoin(preco);

        // aqui fica o código para de fato fazer a transferência de bitcoins do comprador para a loja

        Recibo recibo = new Recibo(comprador.getNome(), precoEmBitcoins, "bitcoins");
        return recibo;
    }

    private float converterRealParaBitcoin(float precoEmReal) {
        return precoEmReal / COTACAO_BIT_COIN;
    }
}
