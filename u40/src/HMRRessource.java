public abstract class HMRRessource {

    private String id;
    private String title;

    public HMRRessource(String id,String title){
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
