import java.util.Scanner;

public class MainTest {
    static ManageCrad manageCrad = new ManageCrad();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Thêm card ");
            System.out.println("2. Hiện tất cả");
            System.out.println("3.Hiển thị card theo cardId");
            System.out.println("4. Hiển thị số card có ngày trả sách là ngày cuối tháng");
            System.out.println("0. thoát chương trình");
            System.out.println("Nhập biến choice");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập số lượng bạn muốn thêm card");
                    int amount = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < amount; i++) {
                        addNew();
                    }
                    break;
                case 2:
                    System.out.println(manageCrad.cardMapLists);
                    break;

                case 3:
                    System.out.println("Nhập cardId");
                    String cardId = sc.nextLine();
                    manageCrad.displayById(cardId);
                    break;
                case 4:
                    manageCrad.testReturnDay();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while (choice != 0);
    }
    public static void addNew(){
        Scanner  sc1 = new Scanner(System.in);
        System.out.println("ENTER_NAME_STUDENT");
        String name = sc1.nextLine();
        System.out.println("ENTER_STUDENT_ID");
        String studentId = sc.nextLine();
        System.out.println("ENTER_BIRTH_DAY_STUDENT");
        String birthday = sc1.nextLine();
        System.out.println("ENTER_CLASS_STUDENT");
        String classOfStudent = sc.nextLine();
        System.out.println("ENTER_CARD_ID");
        String cardId = sc1.nextLine();
        System.out.println("ENTER_BEGIN_DAY");
        String beginDay = sc.nextLine();
        String returnDay ="";
        do {
            System.out.println("ENTER_RETURN_DAY FORMAT dd/MM/yyyy");
            returnDay = sc1.nextLine();
        } while (returnDay.length()!=10);
        System.out.println("ENTER_BOOK_CODE");
        String bookCode = sc.nextLine();
        Student student = new Student(name,studentId,birthday,classOfStudent);
        Card card = new Card(student,cardId,beginDay,returnDay,bookCode);
        manageCrad.addNew(cardId,card);
    }
}
