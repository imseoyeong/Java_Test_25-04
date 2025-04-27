import java.util.Scanner;

public class MenuManager {
    public final static int ADMIN_LOGIN = 1;
    public final static int EXIT = 2;

    public final static int GRADE_INPUT = 1;
    public final static int GRADE_SEARCH = 2;
    public final static int GRADE_SEARCH_ALL = 3;
    public final static int LOGOUT = 4;

    public static void initMenu() {
        System.out.println("[📝성적처리]");
        System.out.println("1. 관리자 로그인");
        System.out.println("2. 종료");
    }

    public static void gradeMenu() {
        System.out.println("[📝성적처리]");
        System.out.println("1. 성적 입력");
        System.out.println("2. 성적 검색");
        System.out.println("3. 전체 성적 출력");
        System.out.println("4. 로그아웃");
    }

    public static int selectInitMenu() {
        Scanner s = new Scanner(System.in);
        int select;

        while (true) {
            select = s.nextInt();
            s.nextLine();

            if (select < ADMIN_LOGIN || select > EXIT) {
                System.out.println("❌잘못입력했습니다.");
                continue;
            }
            break;
        }
        return select;
    }

    public static int selectGradeMenu() {
        Scanner s = new Scanner(System.in);
        int select;

        while (true) {
            select = s.nextInt();
            s.nextLine();

            if (select < GRADE_INPUT || select > LOGOUT) {
                System.out.println("❌잘못입력했습니다.");
                continue;
            }
            break;
        }
        return select;
    }
}
