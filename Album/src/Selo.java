public class Selo implements Colecionavel {


    private String pais;

    private boolean brilhante;

    private float valorPostal;

    private int numero;

    private float area;

    public Selo(int numero, boolean brilhante) {
        this.numero = numero;
        this.brilhante = brilhante;
    }

    public int getNumero() {
        return numero;
    }

    public float getArea() {
        return area;
    }
}
