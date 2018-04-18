public class Carro extends Veiculo {

    public Carro(String nome) {
        super(nome, 300);
        System.out.println("Construtor de Carro");
    }

    @Override
    public void acelerar(float velocDesejada, int tempoEmSegundos) {
        System.out.println(String.format("Vou acelerar a %.2f Km/h em %d segundos",
                velocDesejada, tempoEmSegundos));
        setVelocCorrente(velocDesejada);
    }

    public void buzinar() {
        System.out.println("Beep beep!!");
    }
}
