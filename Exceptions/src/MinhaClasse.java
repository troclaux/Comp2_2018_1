public class MinhaClasse {

    private final int limite;

    public MinhaClasse(int limite) {
        this.limite = limite;
    }

    /**
     * @param x O primero inteiro do cálculo que será feito
     * @param y O segundo parâmetro
     * @return O resultado, sempre positivo, de uma conta maluca
     *
     * @throws QuocienteAbsurdoException Se o quociente for maior do que o limite
     * @throws ParametroInvalidoException Se o parametro y for zero
     */
    public int computeAlgo(int x, int y)
            throws QuocienteAbsurdoException, ParametroInvalidoException {

        if (y == 0) {
            y = 1;
//            throw new ParametroInvalidoException("O parametro y nao pode ser zero!");
        }
        int z = x / y;
        if (z > this.limite) {
            throw new QuocienteAbsurdoException();
        }

        return limite - z;
    }
}
