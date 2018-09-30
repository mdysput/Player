package nowka;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String nazwaWykonawcy;
    private String nazwaPlyty;
    private ListaUtworow listaUtworow;

    public Album(String nazwaWykonawcy, String nazwaPlyty) {
        this.nazwaWykonawcy = nazwaWykonawcy;
        this.nazwaPlyty = nazwaPlyty;
        this.listaUtworow = new ListaUtworow();
    }

    public boolean addSong(String nazwa, double dlugosc) {
        return this.listaUtworow.add(new Song(nazwa, dlugosc));
    }

    public boolean addToPlayList(String nazwa, LinkedList<Song> linkedList) {
        Song utwor = listaUtworow.znajdzUtwor(nazwa);
        if (utwor != null) {
            linkedList.add(utwor);
            return true;
        }
        System.out.println("Nie mozna dodac utworu "+nazwa);
        return false;
    }

    public boolean addToPlayList(int nr, LinkedList<Song> linkedList){
        Song utwor= listaUtworow.znajdzUtwor(nr);
        if(utwor != null){
            linkedList.add(utwor);
            return true;
        }
        System.out.println("Nie mozna dodac utworu o nr "+nr);
        return false;
    }


    public class ListaUtworow {
        private ArrayList<Song> songs;

        public ListaUtworow() {
            this.songs = new ArrayList<Song>();
        }

        public boolean add(Song song) {
            if (songs.contains(song)) {
                return false;
            } else
                this.songs.add(song);
            return true;
        }

        public Song znajdzUtwor(String nazwa) {
            for (Song znalezionyUtwor : songs) {
                if (znalezionyUtwor.getNazwaUtworu().equals(nazwa)) {
                    return znalezionyUtwor;
                }
            }
            return null;
        }

        public Song znajdzUtwor(int nr) {
            int numer = nr - 1;
            if (numer >= 0 && numer < songs.size()) {
                return songs.get(numer);
            } else
                return null;
        }
    }
}
