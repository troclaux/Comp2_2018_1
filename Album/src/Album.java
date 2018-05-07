public class Album {

    /* Array que armazena, na posicao j, o Colecionavel de numero j */
    private Colecionavel[] itens;

    /* Quantidade de itens distintos a serem colecionados */
    private int tamanho;

    private int quantItensDistintos;
    private int quantRepetidos;
    private int[] repetidos;

    private float precoAlbum;
    private float precoItem;

    public Album(int tamanho) {
        this.tamanho = tamanho;
        this.repetidos = new int[tamanho + 1];   // desprezando a posicao 0
        this.itens = new Colecionavel[tamanho + 1];  // desprezando a posicao 0
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

    public void trocarItem(Colecionavel itemQueEntra, Colecionavel itemQueSai) {
        if (descartarItemRepetido(itemQueSai)) {
            acrescentarItem(itemQueEntra);
        } else {
            System.out.println("Impossivel fazer essa troca!");
        }
    }

    public void esvaziarAlbum() {
        for (int i = 1; i <= this.tamanho; i++) {
            this.itens[i] = null;
            this.repetidos[i] = 0;
        }
        this.quantItensDistintos = 0;
        this.quantRepetidos = 0;
    }

    public void acrescentarItem(Colecionavel colecionavel) {
        int numero = colecionavel.getNumero();
        if (this.itens[numero] == null) {
            // item inedito
            this.quantItensDistintos++;
            this.itens[numero] = colecionavel;
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
    public boolean descartarItemRepetido(Colecionavel item) {
        int numero = item.getNumero();
        if (this.repetidos[numero] >= 1) {
            this.repetidos[numero]--;
            this.quantRepetidos--;
            return true;
        }

        System.out.println("O item nao eh repetido!!");
        return false;
    }

    public Colecionavel getItem(int numero) {
        if (numero > this.tamanho || numero < 1) {
            System.out.println("Numero invalido!");
            return null;
        }
        Colecionavel resultado = this.itens[numero];
        if (resultado == null) {
            System.out.println("Item nao existe no album!");
        }
        return resultado;
    }

    public boolean isCheio() {
        return this.quantItensDistintos == this.tamanho;
    }
}
