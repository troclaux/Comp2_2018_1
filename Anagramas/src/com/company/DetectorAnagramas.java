package com.company;

public class DetectorAnagramas {

    public static boolean saoAnagramas(String umaString,
                                       String outraString) {
        for (int i = 0; i < umaString.length(); i++) {
            if (outraString.indexOf(umaString.charAt(i)) < 0) {
                return false;
            }
        }
        for (int i = 0; i < outraString.length(); i++) {
            if (umaString.indexOf(outraString.charAt(i)) < 0) {
                return false;
            }
        }

        // ATENÇÃO: o codigo acima está propositalmente ruim, para ilustrar a (falta de) abrangência dos unit tests.

        return true;
    }
}
