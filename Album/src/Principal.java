import java.util.ArrayList;
import java.util.Random;

public class Principal {

    public static void simularPreenchimentoDoAlbum() {
        Random random = new Random();

        int tamanho = 690;
        int nExperimentos = 10000;

        AlbumGenerico album = new AlbumGenerico(tamanho);

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

    public static void imprimirLista(ArrayList<Figurinha> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(String.format("lista[%d] = %s", i, lista.get(i)));
        }
    }

    public static void main(String[] args)
    {
//        ArrayList<Figurinha> minhaLista = new ArrayList<>(30);
//        for (int i = 0; i < 30; i++) {
//            minhaLista.add(null);
//        }
//
//        System.out.println("minhaLista.size() = " + minhaLista.size());
//
//        for (int i = 1; i <= 10; i++) {
//            minhaLista.set(i - 1, new Figurinha(i, "http://fig" + i + ".jpg"));
//        }
//        System.out.println("minhaLista.size() = " + minhaLista.size());
//
//        imprimirLista(minhaLista);
//
//        System.out.println("\n\nVamos modificar a lista...");
//
//        minhaLista.set(18, new Figurinha(18, null));
//
//        imprimirLista(minhaLista);


//        simularPreenchimentoDoAlbum();

        Album album = new Album(30);
        AlbumGenerico<Figurinha> albumGenerico = new AlbumGenerico<>(30);

        albumGenerico.acrescentarItem(new Figurinha(10, null));
//        albumGenerico.acrescentarItem(new Selo(15, false));
        Figurinha umaFigurinha = albumGenerico.getItem(10);
        System.out.println("Figurinha --> "+ umaFigurinha);

    }

}
