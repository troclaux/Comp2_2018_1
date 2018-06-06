import java.util.HashMap;
import java.util.Map;

public class Regiao {

    private Map<Posicao, Posicionavel> itemByPosicao;

    private final Posicao topLeft;
    private final Posicao bottomRight;

    public Regiao(Posicao topLeft, Posicao bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.itemByPosicao = new HashMap<>();
    }

    public void incluir(Posicionavel posicionavel) {
        this.itemByPosicao.put(posicionavel.getPosicao(), posicionavel);
    }

    public Posicionavel getItem(Posicao pos) {
        return this.itemByPosicao.get(pos);
    }
}

