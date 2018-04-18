public class Principal {

    public static void main(String[] args) {
        System.out.println("Hello!");

        Carro meuCarro;  // meuCarro é do tipo Veiculo (sera instanciado como algo concreto)
        meuCarro = new Carro("Meu carro 1");  // instanciando o Carro

        Transportadora minhaTransportadora;
        minhaTransportadora = new Transportadora(meuCarro);
        minhaTransportadora.transportar(200);

//        System.out.println(meuCarro);  // mesma coisa que System.out.println(meuCarro.toString());
    }
}
