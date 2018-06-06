import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegiaoTest {
    private Regiao regiao;
    private Posicao posicao;
    private Edificacao escola;

    private String nome;

    @Before
    public void setUp() {
        Posicao topLeft = new Posicao(0, 1000);
        Posicao bottomRight = new Posicao(1000, 0);
        this.regiao = new Regiao(topLeft, bottomRight);
        this.posicao = new Posicao(10, 30);
        this.escola = new Edificacao(posicao);
        regiao.incluir(escola);
    }

    @Test
    public void testarLeituraUsandoMesmaInstanciaDePosicao() {
        Posicionavel itemRetornado = regiao.getItem(posicao);
        assertEquals("Deu ruim!!!!", escola, itemRetornado);
    }

    @Test
    public void testarLeituraUsandoOutraInstanciaDaMesmaPosicao() {
        Posicao outraInstanciaDePosicao = new Posicao(10, 30);
        Posicionavel itemRetornado = regiao.getItem(outraInstanciaDePosicao);
        assertEquals("Deu ruim!!!!", escola, itemRetornado);
    }
}