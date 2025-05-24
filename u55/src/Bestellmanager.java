import java.util.*;

public class Bestellmanager {


    private Map<Kunde, List<Bestellung>> bestellungenNachKunde;
    private List<Kunde> kundenListe;

    public Bestellmanager(){
        this.bestellungenNachKunde = new HashMap<>();
        this.kundenListe = new ArrayList<>();
    }

    public void addBestellung(Kunde k,Bestellung b){
        //wenn Kunde existiert neue Bestellung
        if (bestellungenNachKunde.containsKey(k)){
            bestellungenNachKunde.get(k).add(b);
        }
        //wenn nicht neuen Kunden anlegen
        else{
            List<Bestellung> neu = new ArrayList<>();
            neu.add(b);
            kundenListe.add(k);
            bestellungenNachKunde.put(k,neu);
        }
    }

    public Kunde getKundebyMail(String email){
        //jeden kunden durchgehen
            for (Kunde k : kundenListe){
                //email nehmen
                if(k.getEmail().equals(email)){
                    return k;
                }
            }
            System.out.println("kein kunde mit dieser Mail");
            return null;
    }


    public void addProduktNachtraeglich(Kunde k, String p){

        //besteht Kunde?
        if(bestellungenNachKunde.containsKey(k)){
            //letzte bestellungen des Kunden
            List<Bestellung> letztekaufe = bestellungenNachKunde.get(k);
            //wenn bestellungen bestehen
            if (!letztekaufe.isEmpty()) {
                //letzte bestellung nehmen
                Bestellung letzteBestellung = letztekaufe.getLast();
                //produkte aus der letzten bestellung aktualisieren
                var produkte = letzteBestellung.getProduktname();
                produkte.add(p);
                letzteBestellung.setProduktnamen(produkte);
                System.out.println("Produkt der Letzten bestellung mit der ID: "+ letzteBestellung.getBestellnummer()+" hinzugefügt");
            }
            //wenn keine bestellung für den kunden besteht
            else{
                //neue anlegen mit neuer ID
                Random r = new Random(10000);
                int id = 0;
                for (Kunde kunde : kundenListe){
                    id = r.nextInt();
                    var bestellungen = bestellungenNachKunde.get(kunde);
                    for (Bestellung b : bestellungen){
                        if (b.getBestellnummer().equals(Integer.toString(id))){
                           break;
                        }
                    }
                }
                //neue Bestellung
                Bestellung neu = new Bestellung(Integer.toString(id)+"-2025");
                //neue Produktnamen für bestellung
                Set<String>produktnamenNeu = new HashSet<>();
                produktnamenNeu.add(p);
                //Bestellung neues Produkt übergeben
                neu.setProduktnamen(produktnamenNeu);
                //neue liste für kunden anlegen
                List<Bestellung>neueBestellungsliste = new ArrayList<>();
                //kunde neue Bestellung hinzufügen
                bestellungenNachKunde.put(k,neueBestellungsliste);
            }
        }

    }

    public void deleteKunde(Kunde k){
        //Liste löschen
        bestellungenNachKunde.get(k).clear();
        //Key entfernen
        bestellungenNachKunde.clear();
        //kundenliste aktualisieren
        kundenListe.remove(k);
    }

    //häufigkeit der Produkte
    public Map<String,Integer> produktbeliebtheit(){
        //neue Map
        Map<String,Integer> rückgabe = new HashMap<>();
        //jeden Kunden durchgehen
        for (Kunde k : kundenListe){
            //Liste der Bestellungen pro Kunde
            List<Bestellung> kundenSpezifischeBest = bestellungenNachKunde.get(k);
            //Bestellungen durchgehen
            for (Bestellung b : kundenSpezifischeBest){
                //Set der Produktnamen pro Bestellung
                Set<String> produktname  = b.getProduktname();
                //Set der Namen durchgehen
                for (String name : produktname){
                    //wenn produktname schon in der Map dann wert der häufigkeit um 1 erhöhen
                    if (rückgabe.containsKey(name)){
                        int aktuellrcount = rückgabe.get(name);
                        rückgabe.put(name,aktuellrcount+1);
                    }
                    //wenn nicht neu anlegen
                    else rückgabe.put(name,1);
                }
            }
        }
        //map wieder auspucken
        return rückgabe;

    }


    public Set<Kunde> mehrfachkaefer (){

        Set<Kunde> rueckgabe = new HashSet<>();
        //jeden kunden durchgehen
        for (Kunde k : kundenListe){
            //bestellungsliste cheken ob mehr als 1
            List<Bestellung> kudnenbestellung = bestellungenNachKunde.get(k);
            if (kudnenbestellung.size()>1){
                rueckgabe.add(k);
            }
        }
        return rueckgabe;
    }


    public Map<String,Set<Kunde>> produktZuKunde(){
        Map<String,Set<Kunde>>ausgabe = new HashMap<>();

        for (Kunde k : kundenListe){
            for (Bestellung b :bestellungenNachKunde.get(k)){
                for (String produktName : b.getProduktname()){
                    //wenn es schon ein produkt gibt wird nur der Kunde neu angelegt
                    if (ausgabe.containsKey(produktName)) {
                        ausgabe.get(produktName).add(k);
                    }
                    //wenn produkt noch nicht in der Map
                    else {
                        Set<Kunde> neuesSetKunde = new HashSet<>();
                        neuesSetKunde.add(k);
                        ausgabe.put(produktName,neuesSetKunde);
                    }
                }
            };

        }
        return ausgabe;


    }

}
