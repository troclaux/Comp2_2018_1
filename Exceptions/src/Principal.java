import java.util.Random;

public class Principal {

    private static Random random = new Random(1234);

    private static int simule() {
        MinhaClasse minhaClasse = new MinhaClasse(450);

        int contIteracoes = 0;
        while (true) {
            int valorSorteado = random.nextInt(10);
            try {
                int resultado = minhaClasse.computeAlgo(1000, 0);
                System.out.println(
                        String.format("Resultado para o valor sorteado %d é %d",
                                valorSorteado, resultado));

            } catch (QuocienteAbsurdoException e) {
                System.out.println(
                        String.format("Obtive quociente absurdo para o valor sorteado %d!",
                                valorSorteado));
            } catch (ParametroInvalidoException e) {
                System.out.println("O parametro fornecido foi invalido: " +
                        e.getMessage());
                break;
            } finally {
                contIteracoes++;
                System.out.println("Passei pelo finally!!");
            }
        }
        return contIteracoes;
    }

    public static void main(String[] args) {
        int nIteracoes = simule();
        System.out.println("Numero de iteracoes = " + nIteracoes);
    }
}
