import com.view.history.app.facade.student.StudentFacade;
import com.view.history.app.facade.student.impl.StudentFacadeImpl;
import com.view.history.app.model.Student;
import com.view.history.data.student.dao.StudentDao;
import com.view.history.data.student.dao.impl.StudentDaoImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    private static final StudentFacade studentFacade = new StudentFacadeImpl(new Student());
    private static Student[] Students;


    public static void main(String[] args) {
        int choice;
        do {
            displayMenu ();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewStudentTable();
                    break;
                case 0:
                    System.out.println("Exiting Infirmary System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Student Prefect System Menu");
        System.out.println("1. View Student Table");
        System.out.println("0. Exit");
    }
    private static void viewStudentTable() {
        List<Student> employ = studentFacade.getStudentById();

        if (employ.isEmpty()) {
            System.out.println("No records found in student table.");
        } else {
            for (Student student : Students) {
                System.out.printf("%-10s %-15s %-15s %-15s %-25s %-20s %-32s %-15s %-15s %-15s %-15s %-10s %-10s %-20s %-16s %-16s %-16s %-16s%n",
                        student.getLastName(), student.getFirstName(), student.getMiddleName(),
                        student.getBirthday(), student.getSex(), student.getReligion(), student.getEmail(),
                        student.getAddress(), student.getContactNumber());

            }
        }
    }

}