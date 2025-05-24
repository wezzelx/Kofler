import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;

public class ResourceManagement {

    private List<HMRRessource>ressources;

    public ResourceManagement(){
        this.ressources = new ArrayList<>();
    }

    public List<HMRRessource> getRessources() {
        return ressources;
    }

    public void addRessource(HMRRessource hmr){
        ressources.add(hmr);
    }

    public void removeRessource(HMRRessource hmr){
        ressources.remove(hmr);
    }

    public void displayRessourcesByType(){

        for(HMRRessource hmr : ressources){
            if (hmr instanceof Booki){
                System.out.println("Book: "+ hmr.getTitle());
            }
        }

        for(HMRRessource hmr : ressources){
            if (hmr instanceof Computer){
                System.out.println("Computer: "+ hmr.getTitle());
            }
        }

        for(HMRRessource hmr : ressources){
            if (hmr instanceof StaffMember){
                System.out.println("Staff: "+ hmr.getTitle());
            }
        }
    }

    public HMRRessource searchInRessource(String searchFor){
        for (HMRRessource hmr : ressources){
            String titel = hmr.getTitle();
            String id = hmr.getId();
            if (searchFor.equals(titel) || searchFor.equals(id)){
                var klasse = hmr.getClass();
                klasse.getName();
            }
        }
        return null;
    }

    public List<HMRRessource> gerAllRessources(){
        return ressources;
    }
}
