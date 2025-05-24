import java.util.*;

public class MusicLibary {

    private Set<Song> songs;
    private Map<String,Set<Song>>songsByArtist;

    public MusicLibary(){
        this.songs = new HashSet<>();
        this.songsByArtist = new HashMap<>();
    }

    public void addSong(Song song){
        songs.add(song);
        // key = der artiste + value = das set von dem artist
        //wenn der artist besteht
        if (songsByArtist.containsKey(song.getArtist())) {
            songsByArtist.get(song.getArtist()).add(song);
        }
        else {
            //wenn es den Artist nicht gibt lege ich einen neuen an mit eigenem Set
            Set<Song> neu = new HashSet<>();
            neu.add(song);
            songsByArtist.putIfAbsent(song.getArtist(), neu);
        }
    }

    public Set<Song> getSongByArtist(String artist){
        if (songsByArtist.containsKey(artist)){
            return songsByArtist.get(artist);
        }
        else {
            System.out.println("Artist nicht gefunden");
            return Collections.emptySet();
        }
    }

    public boolean removeSong(Song song){
        if (songs.contains(song) && songsByArtist.containsKey(song.getArtist())){
            songs.remove(song);
            songsByArtist.get(song.getArtist()).remove(song);

            //wenn artist leer soll er gelöscht werden
            if (songsByArtist.get(song.getArtist()).isEmpty()){
                songsByArtist.remove(song.getArtist());
            }
            return true;
        }
        return false;
    }

    public void printSongsbyArtist(){

        List<String>bereitsVerwendeteArtists = new ArrayList<>();

        for (Song song: songs){
            if (!bereitsVerwendeteArtists.contains(song.getArtist())) {
                bereitsVerwendeteArtists.add(song.getArtist());
                var artistSongSet = songsByArtist.get(song.getArtist());
                for (Song artistsong : artistSongSet) {
                    System.out.println("Artist: " + song.getArtist() + " Titel: " + artistsong.getTitle());
                }
            }
        }

    }

}
