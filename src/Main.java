import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Canzone> canzoni1 = new ArrayList<>();
        canzoni1.add(new Canzone("come mai"));
        canzoni1.add(new Canzone("perche"));
        canzoni1.add(new Canzone("chi lo sa"));
        Album album1 = new Album("ciao", "coez", 1980, 37.00, canzoni1);
        List<Canzone> canzoni2 = new ArrayList<>();
        canzoni2.add(new Canzone("volare"));
        canzoni2.add(new Canzone("nel cielo"));
        canzoni2.add(new Canzone("dipinto"));
        canzoni2.add(new Canzone("di blu"));
        Album album2 = new Album("The first Album", "gue", 2001, 40.00, canzoni2);
        List<Canzone> canzoni3 = new ArrayList<>();
        canzoni3.add(new Canzone("la bella vita"));
        canzoni3.add(new Canzone("dipinto"));
        canzoni3.add(new Canzone("felicita"));
        canzoni3.add(new Canzone("nuvole"));
        canzoni3.add(new Canzone("farfalle"));
        Album album3 = new Album("L'ultimo album", "fedez", 1985, 25.00, canzoni3);
        List<Canzone> canzoni4 = new ArrayList<>();
        canzoni4.add(new Canzone("fagiano"));
        canzoni4.add(new Canzone("fisarmonica"));
        canzoni4.add(new Canzone("buio"));
        canzoni4.add(new Canzone("luce"));
        canzoni4.add(new Canzone("mattina"));
        Album album4 = new Album("Felicita", "tananai", 1987, 50.00, canzoni4);
        List<Album> album = Arrays.asList(album1, album2, album3, album4);
        ordinaAlbum(album);
        eliminaDoppioni(album);
        nCanzoniInAlbum(album2, album);
        prezzoTuttiGliAlbumPrimaDel90(album);
        treCanzoniConlaF(album);
    }

    public static void ordinaAlbum(List<Album> album) {
        List<Album> listaOrdineAlf = album.stream()
                .sorted(Comparator.comparing(Album::getTitolo))
                .map(ele -> {
                    System.out.println(ele);
                    System.out.println("numero canzoni= " + ele.getListaCanzoni().size());
                    return ele;
                })
                .collect(Collectors.toList());
    }

    public static void eliminaDoppioni(List<Album> album) {
        long numeroCanzoni = album.stream()
                .flatMap(ele -> ele.getListaCanzoni().stream())
                .map(ele -> ele.getNome())
                .distinct()
                .count();
        System.out.println("il numero delle canzoni " + numeroCanzoni);
    }

    private static void nCanzoniInAlbum(Album album, List<Album> albums) {
        long numeroCanzoni = album.getListaCanzoni().stream().count();
        System.out.println("Il numero di canzoni in questoi album è: " + numeroCanzoni);

        numeroCanzoni = albums.stream()
                .filter(ele -> ele.getTitolo().equalsIgnoreCase("The first Album") && ele.getAnnoPubblicazione() == 2001)
                .flatMap(ele -> ele.getListaCanzoni().stream())
                .count();
        System.out.println("Il numero di canzoni in questoi album è: " + numeroCanzoni);
    }

    private static void prezzoTuttiGliAlbumPrimaDel90(List<Album> albums) {
        double totPrezzo = albums.stream()
                .filter(ele -> ele.getAnnoPubblicazione() < 1990)
                .map(ele -> ele.getPrezzo())
                .reduce(0d, (a, b) -> a + b);
        System.out.println(totPrezzo);
    }

    private static void treCanzoniConlaF(List<Album> albums) {
        List<Canzone> canzoni = albums.stream()
                .filter(ele -> ele.getAnnoPubblicazione() < 2000)
                .flatMap(ele -> ele.getListaCanzoni().stream())
                .filter(ele -> ele.getNome().toUpperCase().charAt(0) == 'F')
                .limit(3)
                .collect(Collectors.toList());

        canzoni.forEach(System.out::println);
    }
}

