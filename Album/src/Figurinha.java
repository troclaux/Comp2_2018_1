public class Figurinha implements Colecionavel {

    private int numero;
    private float comprimento;
    private float largura;

    private String urlDaImagem;

    public Figurinha(int numero, String urlDaImagem) {
        this.numero = numero;
        this.urlDaImagem = urlDaImagem;
    }

    public int getNumero() {
        return this.numero;
    }

    public float getArea() {
        return this.comprimento * this.largura;
    }

    public void setUrlDaImagem(String url) {
        this.urlDaImagem = url;
    }
}
