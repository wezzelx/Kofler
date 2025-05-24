public class StaffMember extends HMRRessource{

    private String role;

    public StaffMember(String id, String title,String role) {
        super(id, title);
        this.role = role;
    }

    public String getRole() {
        return role;
    }


}
