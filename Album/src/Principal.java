import java.util.Random;

public class Principal {

    public static void simularPreenchimentoDoAlbum() {
        Random random = new Random();

        int tamanho = 690;
        int nExperimentos = 10000;

        Album album = new Album(tamanho);

        long totalItensComprados = 0;

        for (int i = 0; i < nExperimentos; i++) {
            while(!album.isCheio()) {
                int numeroNovoItem = random.nextInt(tamanho) + 1;
                Colecionavel novoItem;
                novoItem = new Selo(numeroNovoItem, false);
                album.acrescentarItem(novoItem);
            }
            totalItensComprados += tamanho + album.getQuantRepetidos();
            album.esvaziarAlbum();
        }

        float mediaItensComprados = totalItensComprados / (float) nExperimentos;
        System.out.println(String.format(
                "Foram comprados %.2f itens em media.",
                mediaItensComprados));

    }

    public static void main(String[] args) {
        simularPreenchimentoDoAlbum();
    }


}
