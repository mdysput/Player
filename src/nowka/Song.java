package nowka;

public class Song {
    private String nazwaUtworu;
    private double dlugoscUtworu;

    public Song(String nazwaUtworu, double dlugoscUtworu) {
        this.nazwaUtworu = nazwaUtworu;
        this.dlugoscUtworu = dlugoscUtworu;
    }

    public String getNazwaUtworu() {
        return nazwaUtworu;
    }

    @Override
    public String toString() {
        return this.nazwaUtworu+": "+this.dlugoscUtworu;
    }
}
