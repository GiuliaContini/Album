import java.util.List;

/**
 * Data una collezione di Album. Ogni album ha: un titolo, l’autore, l’anno di pubblicazione, il prezzo e la lista di
 * canzoni. Eseguiamo le seguenti operazioni:
 * I. Ordinare gli album in ordine alfabetico e contare quante canzoni sono presenti in ogni album.
 * II. Trovare il numero totale delle canzoni eliminando i doppioni.
 * III. Trovare il numero totale di canzoni nell'album "The First Album" dell'anno 2001.
 * IV. Supponiamo che un cliente acquisti tutti gli album pubblicati prima dell’anno 1990. Quanto spenderebbe?
 * V. Visualizzare i primi 3 titoli di canzoni diverse che iniziano con la lettera F e fanno parte di album di anni
 * precedenti al 200
 */


public class Album {

    private String titolo;
    private String autore;
    private int annoPubblicazione;
    private double prezzo;

    private List<Canzone> listaCanzoni;


    public Album(String titolo, String autore, int annoPubblicazione, double prezzo, List<Canzone> listaCanzoni) {
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
        this.listaCanzoni = listaCanzoni;
    }

    public String getTitolo() {
        return titolo.toUpperCase();

    }

    public List<Canzone> getListaCanzoni() {
        return listaCanzoni;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return "Album{" +
                "titolo='" + titolo + "\n" +
                ", autore='" + autore + "\n" +
                ", annoPubblicazione=" + annoPubblicazione + "\n" +
                ", prezzo=" + prezzo + "\n" +
                ", listaCanzoni=" + listaCanzoni + "\n" +
                '}';
    }
}
