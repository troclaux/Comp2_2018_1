package com.company;

import java.util.HashMap;

public class CarrinhoDeCompras<T extends Vendavel> extends HashMap<T, Integer> {

    public Integer get(T key) {
        return getOrDefault(key, 0);
    }

    public float getPrecoTotal() {
        float total = 0;
        for (T item : this.keySet()) {
            float precoUnitario = item.getPreco();
            int quantidade = this.get(item);
            total += precoUnitario * quantidade;
        }
        return total;
    }
}
