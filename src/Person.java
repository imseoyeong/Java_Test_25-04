public class Person {
    private String id;
    private String userName;
    private String classNum;

    private int korean;
    private int english;
    private int math;

    // 생성자
    public Person(String id, String userName, String classNum) {
        this.id = id;
        this.userName = userName;
        this.classNum = classNum;
    }

    public Person(String id, String userName) {
        this.id = id;
        this.userName = userName;
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

    public int getKorean() {
        return korean;
    }

    public int getEnglish() {
        return english;
    }

    public int getMath() {
        return math;
    }

    // setter
    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public void setMath(int math) {
        this.math = math;
    }
}
