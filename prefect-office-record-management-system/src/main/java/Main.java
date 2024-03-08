import com.prefect.office.record.management.app.facade.prefect.communityservice.CommunityServiceFacade;
import com.prefect.office.record.management.app.facade.prefect.communityservice.impl.CommunityServiceFacadeImpl;
import com.prefect.office.record.management.app.facade.prefect.offense.OffenseFacade;
import com.prefect.office.record.management.app.facade.prefect.offense.impl.OffenseFacadeImpl;
import com.prefect.office.record.management.app.model.communityservice.CommunityService;
import com.prefect.office.record.management.app.model.offense.Offense;
import com.prefect.office.record.management.data.dao.prefect.communityservice.impl.CommunityServiceDaoImpl;
import com.prefect.office.record.management.data.dao.prefect.offense.impl.OffenseDaoImpl;

import java.sql.Timestamp;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final OffenseFacade offenseFacade = new OffenseFacadeImpl(new OffenseDaoImpl());
    private static final CommunityServiceFacade communityServiceFacade = new CommunityServiceFacadeImpl(new CommunityServiceDaoImpl());

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
                    case 2:
                        renderCs();
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
        System.out.println("Prefect System");
        System.out.println("1. Update Offense");
        System.out.println("2. Render Community Service");
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
                        System.out.println("Failed to update Offense information.");
                    }
                } else {
                    System.out.println("Offense with ID " + offenseId + " does not exist.");
                }

            } while (offenseId != 0);

        } catch (Exception e) {
            System.err.println("An error occurred while updating Offense information: " + e.getMessage());
        }
    }
    private static void renderCs() {
        try {
            int csId = 0;
            do {
                System.out.print("Enter Community Service-ID: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next();
                    continue;
                }
                csId = scanner.nextInt();
                if (csId < 0) {
                    System.out.println("Invalid Community Service ID. Please enter a non-negative integer.");
                    continue;
                }

                System.out.print("Enter Student-ID: ");
                String student_id = scanner.next();
                if (student_id.isEmpty()) {
                    System.out.println("Student-ID cannot be empty.");
                    return;
                }

                System.out.print("Enter Hours Rendered: ");
                int hoursRender = scanner.nextInt();
                if (hoursRender < 0) {
                    System.out.println("Please enter a non-negative integer.");
                    continue;
                }

                CommunityService existingCs = communityServiceFacade.getCsById(csId);
                if (existingCs != null) {
                    existingCs.setStudent_id(student_id);
                    existingCs.setHours_rendered(hoursRender);
                    existingCs.setDate_rendered(new Timestamp(System.currentTimeMillis()));

                    boolean render = communityServiceFacade.renderCs(existingCs);

                    if (render) {
                        System.out.println("Community Service Rendered successfully!");
                    } else {
                        System.out.println("Failed to Render Community Service.");
                    }
                } else {
                    System.out.println("Community Service with ID " + csId + " does not exist.");
                }

            } while (csId != 0);

        } catch (Exception e) {
            System.err.println("An error occurred while updating Community Service: " + e.getMessage());
        }
    }
}