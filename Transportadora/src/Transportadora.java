public class Transportadora {

    private Veiculo meioDeTransporte;

    public Transportadora(Veiculo meioDeTransporte) {
        this.meioDeTransporte = meioDeTransporte;
    }

    public void transportar(int quilos) {
        System.out.println(String.format("Transportando %d quilos usando o veiculo %s",
                quilos, this.meioDeTransporte));
        this.meioDeTransporte.andarPraFrente(60);
        this.meioDeTransporte.parar();
    }
}
