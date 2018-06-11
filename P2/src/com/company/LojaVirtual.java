package com.company;

import java.util.HashMap;
import java.util.Map;

public abstract class LojaVirtual<T extends Vendavel> {

    /** Mapa de compradores por cpf */
    private Map<Long, Comprador<T>> compradorByCpf;

    /** Mapa { item --> quantidade em estoque } representando o estoque da loja */
    protected Map<T, Integer> estoque;

    protected Transportadora transportadora;

    public LojaVirtual(Transportadora transportadora) {
        this.transportadora = transportadora;
        this.compradorByCpf = new HashMap<>();
        this.estoque = new HashMap<>();
    }

    /**
     * Atualiza a quantidade do item informado no estoque da loja.
     * Note que a quantidade informada *não* será somada à quantidade existente,
     * mas sim sobrescrita à quantidade existente.
     *
     * @param item O item em estoque
     * @param quantidadeCorrente A quantidade do item que passará a valer
     */
    public void atualizarItemNoEstoque(T item, int quantidadeCorrente) {
        this.estoque.put(item, quantidadeCorrente);
    }

    /**
     * Cadastra um novo comprador, caso ainda não exista um com o cpf informado;
     * caso já exista, atualiza o nome e o endereço.
     *
     * @param cpf O cpf do comprador
     * @param nome O nome do comprador
     * @param endereco O endereço do comprador
     */
    public void cadastrarComprador(Long cpf, String nome, String endereco) {
        Comprador<T> comprador = this.compradorByCpf.get(cpf);
        if (comprador == null) {
            comprador = new Comprador<>(cpf, nome);
            this.compradorByCpf.put(cpf, comprador);
        }
        comprador.setNome(nome);
        comprador.setEndereco(endereco);
    }

    /**
     * Adiciona a quantidade desejada do item informado ao carrinho de compras
     * do comprador identificado pelo cpf dado.
     *
     * @param cpf O cpf do comprador
     * @param item O item a ser adicionado ao carrinho
     * @param quantidade A quantidade desejada do item
     * @return true, se a operação foi bem sucedida; false, caso contrário
     */
    public boolean adicionarAoCarrinho(Long cpf, T item, int quantidade) {
        Comprador<T> comprador = this.compradorByCpf.get(cpf);
        if (comprador == null) {
            System.out.println("CPF não cadastrado");
            return false;
        }
        Integer quantidadeEmEstoque = this.estoque.get(item);
        if (quantidadeEmEstoque == null || quantidadeEmEstoque < quantidade) {
            System.out.println("Estoque insuficiente");
            return false;
        }
        CarrinhoDeCompras<T> carrinho = comprador.getCarrinhoDeCompras();
        Integer quantidadeDoItemNoCarrinho = carrinho.get(item);
        carrinho.put(item, quantidadeDoItemNoCarrinho + quantidade);

        atualizarItemNoEstoque(item, quantidadeEmEstoque - quantidade);
        return true;
    }









    /**
     * Finaliza a compra, efetuando o pagamento e despachando os itens para a transportadora.
     *
     * @param cpf O cpf do comprador que quer finalizar sua compra
     * @return o Recibo da compra
     */
    public Recibo finalizarCompra(Long cpf) {
        Comprador<T> comprador = this.compradorByCpf.get(cpf);
        if (comprador == null) {
            System.out.println("CPF não cadastrado");
            return null;
        }
        CarrinhoDeCompras<T> carrinho = comprador.getCarrinhoDeCompras();
        Recibo recibo = efetuarPagamento(comprador, carrinho.getPrecoTotal());

        for (T item : carrinho.keySet()) {
            int quantidade = carrinho.get(item);
            for (int i = 0; i < quantidade; i++) {
                this.transportadora.entregarItem(item, comprador.getEndereco());
            }
        }

        transportadora.entregarItem(recibo, comprador.getEndereco());

        return recibo;
    }

    /**
     * Efetua o pagamento usando algum método concreto (cartão, PayPal, boleto bancário, etc.)
     *
     * @param comprador O comprador
     * @param preco O preço final
     * @return o Recibo do pagamento realizado
     */
    protected abstract Recibo efetuarPagamento(Comprador comprador, float preco);
}
