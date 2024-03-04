import com.add.offense.app.facade.offense.OffenseFacade;
import com.add.offense.app.facade.offense.impl.OffenseFacadeImpl;
import com.add.offense.app.model.offense.Offense;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        OffenseFacade offenseFacade = new OffenseFacadeImpl();

        Offense offense = new Offense();
        offense.setStudentId("CT22-0123");
        offense.setViolationId(123L);
        offenseFacade.saveOffense(offense);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Save Offense");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    saveOffense(offenseFacade, sc);
                    break;
                case 2:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void saveOffense(OffenseFacade offenseFacade, Scanner sc) {
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();

        System.out.print("Enter violation ID: ");
        long violationId = sc.nextLong();
        sc.nextLine();

        Offense offense = new Offense();
        offense.setStudentId(studentId);
        offense.setViolationId(violationId);

        offenseFacade.saveOffense(offense);
        System.out.println("Offense saved successfully!");
    }
}
