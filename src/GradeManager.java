import java.util.ArrayList;
import java.util.Scanner;

public class GradeManager {
    private ArrayList<User> userList;
    Person mCurrentUser;

    public GradeManager() {
        userList = new ArrayList<>();
        userList.add(new User("aa", "aaa", "20162722"));
        userList.add(new User("bb", "bbb", "20200915"));
        userList.add(new User("cc", "ccc", "20250423"));
    }

    public void run() {
        while (true) {
            boolean endflag = false;
            MenuManager.initMenu();
            int select = MenuManager.selectInitMenu();

            switch (select) {
                case MenuManager.ADMIN_LOGIN:
                    if (this.menuAdminLogin()) {
                        this.gradeProcess();
                    }
                    break;
                case MenuManager.EXIT:
                    endflag = true;
                    break;
            }
            if (endflag) {
                break;
            }
        }
    }

    // 관리자 로그인
    public boolean menuAdminLogin() {
        Scanner s = new Scanner(System.in);
        Admin login = new Admin("admin", "관리자");

        while (true) {
            System.out.print("Name: ");
            String name = s.nextLine();
            System.out.print("Phone: ");
            String phone = s.nextLine();
            System.out.print("ID: ");
            String id = s.nextLine();
            System.out.print("PW: ");
            String pw = s.nextLine();

            if (login.getAdminId().equals(id) && login.getAdminPw().equals(pw)) {
                System.out.println(name + " 관리자님 반갑습니다.");
                this.mCurrentUser = login;
                return true;
            } else {
                System.out.println("관리자 계정이 틀렸습니다.");
            }
        }
    }

    // 성적처리 관리 메뉴
    public void gradeProcess() {
        while (true) {
            boolean endflag = false;
            MenuManager.gradeMenu();
            int select = MenuManager.selectGradeMenu();

            switch (select) {
                case MenuManager.GRADE_INPUT:
                    this.gradeInput();
                    break;
                case MenuManager.GRADE_SEARCH:
                    this.gradeSearch();
                    break;
                case MenuManager.GRADE_SEARCH_ALL:
                    this.gradeSearchAll();
                    break;
                case MenuManager.LOGOUT:
                    endflag = true;
                    this.mCurrentUser = null;
            }
            if (endflag) {
                break;
            }
        }
    }

    // 1. 성적 입력
    public void gradeInput() {
        Scanner s = new Scanner(System.in);
        int count = 0; // 입력 완료된 유저 카운트하기

        for (User u : this.userList) {
            System.out.print("ID: ");
            String id = s.next();
            System.out.print("NAME: ");
            String name = s.next();

            System.out.print("국어: ");
            int korean = s.nextInt();
            System.out.print("영어: ");
            int english = s.nextInt();
            System.out.print("수학: ");
            int math = s.nextInt();

            // 입력한 점수 저장
            u.setId(id);
            u.setUserName(name);
            u.setKorean(korean);
            u.setEnglish(english);
            u.setMath(math);

            count++;

            if (count == this.userList.size()) { // size 사용 -> 리스트 안에 데이터 개수. length랑 비슷하다 생각하면 쉬울 듯
                System.out.println("모든 학생의 입력이 끝났습니다.");
                break;
            }

            System.out.println("계속 입력하시겠습니까? Y | N");
            String yn = s.next();

            if (yn.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    // 2. 성적 검색
    public void gradeSearch() {
        Scanner s = new Scanner(System.in);
        System.out.print("🔍검색할 학생의 학번: ");
        String classNum = s.nextLine();
        System.out.print("ID: ");
        String id = s.nextLine();
        System.out.print("NAME: ");
        String name = s.nextLine();

        for (User u : this.userList) {
            if (u.getClassNum().equals(classNum)) {
                int total = u.getKorean() + u.getEnglish() + u.getMath();
                double avg = total / 3.0;

                System.out.println("국어: " + u.getKorean());
                System.out.println("영어: " + u.getEnglish());
                System.out.println("수학: " + u.getMath());
                System.out.println("총점: " + total);
                System.out.println("평균: " + avg);
            }
        }
    }

    // 3. 전체 성적 출력
    public void gradeSearchAll() {
        for (User u : this.userList) {
            int total = u.getKorean() + u.getEnglish() + u.getMath();
            double avg = total / 3.0;

            System.out.println("ID: " + u.getId());
            System.out.println("NAME: " + u.getUserName());
            System.out.println("국어: " + u.getKorean());
            System.out.println("영어: " + u.getEnglish());
            System.out.println("수학: " + u.getMath());
            System.out.println("총점: " + total);
            System.out.println("평균: " + avg);
            System.out.println();
        }
    }
}
