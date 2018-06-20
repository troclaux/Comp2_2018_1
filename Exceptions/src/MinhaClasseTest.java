import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinhaClasseTest {

    private MinhaClasse minhaClasse;

    @Before
    public void setUp() throws Exception {
        minhaClasse = new MinhaClasse(500);
    }

    @Test
    public void testeComputeAlgoParaParametrosBons()
            throws QuocienteAbsurdoException, ParametroInvalidoException {

        int resultadoObtido = minhaClasse.computeAlgo(10, 2);
        assertEquals(495, resultadoObtido);
    }

    @Test
    public void testeComputeAlgoParaSegundoParametroZero() {
        try {
            minhaClasse.computeAlgo(1234, 0);
            fail();
        } catch (ParametroInvalidoException e) {
            // Ok!!!!!
        } catch (QuocienteAbsurdoException e) {
            fail("Deveria ter lançado uma ParametroInvalidoException");
        }

    }

}