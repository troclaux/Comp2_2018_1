public interface Colecionavel {

    /**
     * Expoe o numero do item colecionavel. Este numero é, em geral,
     * a posicao do item dentro de sua coleção.
     *
     * @return O numero do item
     */
    int getNumero();

    /**
     * A area do item colecionavel.
     *
     * @return Um float, indicando a área do item em centimetros quadrados.
     */
    float getArea();

}
