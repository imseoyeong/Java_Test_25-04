public class User {
    private String id;
    private String userName;
    private String classNum;

    public User(String id, String userName, String classNum) {
        this.id = id;
        this.userName = userName;
        this.classNum = classNum;
    }

    // getter
    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getClassNum() {
        return classNum;
    }
}

