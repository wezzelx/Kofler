import java.util.ArrayList;
import java.util.List;

public class Computer extends HMRRessource{

    private String operatinSystem;
    private List<String> InstalledSoftware;

    public Computer(String id, String title,String operatinSystem) {
        super(id, title);
        this.InstalledSoftware = new ArrayList<>();
        this.operatinSystem = operatinSystem;
    }

    public String getOperatinSystem() {
        return operatinSystem;
    }

    public List<String> getInstalledSoftware() {
        return InstalledSoftware;
    }
}
