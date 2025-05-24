public class Booki extends HMRRessource{

    private String author;

    public Booki(String id, String title, String author) {
        super(id, title);
        this.author=author;
    }

    public String getAuthor() {
        return author;
    }
}
