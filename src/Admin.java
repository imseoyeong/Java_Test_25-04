public class Admin extends Person {
    private String adminId = "admin";
    private String adminPw = "1111";

    public Admin(String id, String userName) {
        super(id, userName);
    }

    public String getAdminId() {
        return adminId;
    }

    public String getAdminPw() {
        return adminPw;
    }
}
