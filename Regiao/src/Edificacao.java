public class Edificacao implements Posicionavel {

    public Posicao posicao = new Posicao(0, 0);

    public Edificacao(Posicao posicao) {
        this.posicao = posicao;
    }

    @Override
    public Posicao getPosicao() {
        return this.posicao;
    }
}
