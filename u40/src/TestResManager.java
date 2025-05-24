//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestResManager {
    public static void main(String[] args) {

        StaffMember staff = new StaffMember("1","Manu","Bauer");
        Booki book = new Booki("2","Gupta","Shakur");
        Booki book2 = new Booki("4","G4pta","kur");
        Booki book3 = new Booki("6","Gc","ur");
        Computer comp = new Computer("3","HH","Windows");

        ResourceManagement rm = new ResourceManagement();

        rm.addRessource(staff);
        rm.addRessource(book);
        rm.addRessource(book2);
        rm.addRessource(book3);
        rm.addRessource(comp);


        var x = rm.searchInRessource("HH");
        System.out.println("Title"+ x.getTitle()+ "ID: "+ x.getId());

    }
}