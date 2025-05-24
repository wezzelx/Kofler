public class Song {
    private String title;
    private String artist;

    public Song(String title,String artist){
        this.artist = artist;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
