package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DetectorAnagramasTest {

    @Test
    public void saoAnagramasTestParaAnagramas() {
        assertTrue("Falhou para palavras com exatamente os mesmos caracteres (ABCD, CBAD)!",
                DetectorAnagramas.saoAnagramas("ABCD", "CBAD"));
    }

    @Test
    public void saoAnagramasTestParaNaoAnagramasNinguemContidoEmNinguem() {
        assertFalse("Falhou para palavras que não são anagramas!!! (ABCD, EFGH)",
                DetectorAnagramas.saoAnagramas("ABCD","EFGH"));
    }

    @Test
    public void saoAnagramasTestParaNaoAgramasPrimeiraContidaNaSegunda() {
        assertFalse("Falhou para palavras que não são anagramas," +
                        " com os caracteres da primeira String contidos" +
                        " na segunda!!! (ABB, ABC)",
                DetectorAnagramas.saoAnagramas("ABB","ABC"));

    }

    @Test
    public void saoAnagramasTestParaNaoAnagramasComOsMesmosCaracteres() {
        assertFalse("Falhou para palavras que não são anagramas, " +
                        " mas têm os mesmos caracteres!!! (ABB, AAB)",
                DetectorAnagramas.saoAnagramas("AAB","ABB"));
    }
}