import java.util.HashSet;
import java.util.Set;

public class Bestellung {

    private Set<String> produktnamen;
    private String bestellnummer;


    public Bestellung(String bestellnummer){
        this.bestellnummer = bestellnummer;
        this.produktnamen = new HashSet<>();
    }

    public String getBestellnummer() {
        return bestellnummer;
    }

    public Set<String> getProduktname() {
        return produktnamen;
    }

    public void setProduktnamen(Set<String> produktnamen) {
        this.produktnamen = produktnamen;
    }



}

