//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MusicLibaryDemo {
    public static void main(String[] args) {
        Song a = new Song("Hello","World");
        Song b = new Song("Abu","sushi");
        Song c = new Song("Thomas","sushi");
        Song d = new Song("wakawaka","shakira");
        Song e = new Song("entchen","sushi");
        Song f = new Song("nomnom","sigmaboy");


        MusicLibary ml = new MusicLibary();
        ml.addSong(a);
        ml.addSong(b);
        ml.addSong(c);
        ml.addSong(d);
        ml.addSong(e);
        ml.addSong(f);

        var x = ml.getSongByArtist("sushi");
        for (Song song : x){
            System.out.println(song.getTitle()+" "+song.getArtist());
        }

    }
}