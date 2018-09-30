package nowka;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(1).addToPlayList("I put the finger on you", playList);
        albums.get(1).addToPlayList(5, playList);
        albums.get(1).addToPlayList("Evil walks", playList);
        albums.get(1).addToPlayList(4, playList);
        albums.get(0).addToPlayList("Stormbringer", playList);
        zaczynamy(playList);
    }

    private static void printMenu() {
        System.out.println("0- Wyjdz\n" +
                "1: Nastepny utwor\n" +
                "2- Poprzedni utwor\n" +
                "3- Powtorz utwor\n" +
                "4- Pokaz utwory\n" +
                "5- Pokaz Menu.");
    }

    private static void showList(LinkedList<Song> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    private static void zaczynamy(LinkedList<Song> lista) {
        ListIterator<Song> list = lista.listIterator();
        boolean wyjdz = false;
        Scanner scanner = new Scanner(System.in);
        if (lista.isEmpty()) {
            System.out.println("Nie ma utworow na liscie");
            return;
        } else {
            System.out.println("Teraz gra " + list.next());
            System.out.println();
            printMenu();
            System.out.println("Wybierz co chcesz zrobic: ");
        }

        while (!wyjdz) {
            int wybor = scanner.nextInt();
            scanner.nextLine();
            switch (wybor) {
                case 0:
                    System.out.println("Koniec sluchania");
                    wyjdz = true;
                    break;
                case 1:
                    if (list.hasNext()) {
                        System.out.println(list.next());
                    } else {
                        System.out.println("Nie ma wiecej utworow");
                    }
                    break;
                case 2:
                    if (list.hasPrevious()) {
                        System.out.println(list.previous());
                    } else {
                        System.out.println("Jestes na poczatku listy");
                    }
                    break;
                case 3:
                    if((!list.hasNext()) && (list.hasPrevious())) {
                        list.previous();
                        System.out.println(list.next());
                    }else if((list.hasNext()) &&(!list.hasPrevious())){
                        list.next();
                        System.out.println(list.previous());
                    }else{
                        list.previous();
                        System.out.println(list.next());
                    }
                break;

                case 4:
                    showList(lista);
                    break;
                case 5:
                    printMenu();
                    break;
                default:
                    System.out.println("Koniec sluchania");
                    wyjdz = true;
                    break;
            }

        }
    }
}
