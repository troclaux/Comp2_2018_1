import java.util.ArrayList;

public class AlbumGenerico<T extends Colecionavel> {

    /* ArrayList que armazena, na posicao j, o Colecionavel de numero j */
    private ArrayList<T> itens;

    /* Quantidade de itens distintos a serem colecionados */
    private int tamanho;

    private int quantItensDistintos;
    private int quantRepetidos;
    private int[] repetidos;

    private float precoAlbum;
    private float precoItem;

    public AlbumGenerico(int tamanho) {
        this.tamanho = tamanho;
        this.repetidos = new int[tamanho + 1];   // desprezando a posicao 0
        this.itens = new ArrayList<>(tamanho + 1);  // desprezando a posicao 0
        esvaziarAlbum();
    }

    public float getPrecoAlbum() {
        return precoAlbum;
    }

    public void setPrecoAlbum(float precoAlbum) {
        if (precoAlbum >= 0) {
            this.precoAlbum = precoAlbum;
        } else {
            System.out.println("Valor invalido!!!");
        }
    }

    public float getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(float precoItem) {
        this.precoItem = precoItem;
    }

    public int getQuantRepetidos() {
        return this.quantRepetidos;
    }

    public void trocarItem(T itemQueEntra, T itemQueSai) {
        if (descartarItemRepetido(itemQueSai)) {
            acrescentarItem(itemQueEntra);
        } else {
            System.out.println("Impossivel fazer essa troca!");
        }
    }

    public void esvaziarAlbum() {
        for (int i = 0; i <= this.tamanho; i++) {
            this.repetidos[i] = 0;
            if (i < this.itens.size()) {
                this.itens.set(i, null);
            } else {
                this.itens.add(null);
            }
        }
        this.quantItensDistintos = 0;
        this.quantRepetidos = 0;
    }

    public void acrescentarItem(T colecionavel) {
        int numero = colecionavel.getNumero();
        if (this.itens.get(numero) == null) {
            // item inedito
            this.quantItensDistintos++;
            this.itens.set(numero, colecionavel);
        } else {
            // item repetido
            this.quantRepetidos++;
            this.repetidos[numero]++;
        }
    }

    /**
     * Descarta um item repetido daquele album.
     *
     * @param item O numero do item que eu quero descartar
     * @return true, se o item foi descartada com sucesso;
     *         false, caso contrario (se o item nao era repetida)
     */
    public boolean descartarItemRepetido(T item) {
        int numero = item.getNumero();
        if (this.repetidos[numero] >= 1) {
            this.repetidos[numero]--;
            this.quantRepetidos--;
            return true;
        }

        System.out.println("O item nao eh repetido!!");
        return false;
    }

    public T getItem(int numero) {
        if (numero > this.tamanho || numero < 1) {
            System.out.println("Numero invalido!");
            return null;
        }
        T resultado = this.itens.get(numero);
        if (resultado == null) {
            System.out.println("Item nao existe no album!");
        }
        return resultado;
    }

    public boolean isCheio() {
        return this.quantItensDistintos == this.tamanho;
    }
}
