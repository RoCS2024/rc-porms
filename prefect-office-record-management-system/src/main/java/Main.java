import com.prefect.office.record.management.app.facade.prefect.offense.OffenseFacade;
import com.prefect.office.record.management.app.facade.prefect.offense.impl.OffenseFacadeImpl;
import com.prefect.office.record.management.app.model.offense.Offense;
import com.prefect.office.record.management.data.dao.prefect.offense.impl.OffenseDaoImpl;

import java.sql.Timestamp;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final OffenseFacade offenseFacade = new OffenseFacadeImpl(new OffenseDaoImpl());

    public static void main(String[] args) {
        try {
            int choice;
            do {
                displayMenu();
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        updateOffense();
                        break;
                    case 0:
                        System.out.println("Exiting the App...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } while (choice != 0);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void displayMenu() {
        System.out.println("User Management Application");
        System.out.println("1. Update User Information");
        System.out.println("0. Exit");
    }

    private static void updateOffense() {
        try {
            int offenseId = 0;
            do {
                System.out.print("Enter Offense-ID: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next();
                    continue;
                }
                offenseId = scanner.nextInt();
                if (offenseId < 0) {
                    System.out.println("Invalid user ID. Please enter a non-negative integer.");
                    continue;
                }

                System.out.print("Enter New Violation-ID: ");
                int violationId = scanner.nextInt();
                violationId = scanner.nextInt();
                if (violationId < 0) {
                    System.out.println("Invalid violation ID. Please enter a non-negative integer.");
                    continue;
                }

                System.out.print("Enter New Student-ID: ");
                String studentId = scanner.next();
                if (studentId.isEmpty()) {
                    System.out.println("Student-ID cannot be empty.");
                    return;
                }

                Offense existingOffense = offenseFacade.getOffenseByID(offenseId);
                if (existingOffense != null) {
                    existingOffense.setViolationId(violationId);
                    existingOffense.setStudentId(studentId);
                    existingOffense.setOffenseDate(new Timestamp(System.currentTimeMillis()));

                    boolean updated = offenseFacade.updateOffense(existingOffense);

                    if (updated) {
                        System.out.println("Offense information updated successfully!");
                    } else {
                        System.out.println("Failed to Offense user information.");
                    }
                } else {
                    System.out.println("Offense with ID " + offenseId + " does not exist.");
                }

            } while (offenseId != 0);

        } catch (Exception e) {
            System.err.println("An error occurred while updating offense information: " + e.getMessage());
        }
    }

}