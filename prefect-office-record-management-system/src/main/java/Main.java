import com.prefect.office.record.management.app.facade.prefect.communityservice.CommunityServiceFacade;
import com.prefect.office.record.management.app.facade.prefect.communityservice.impl.CommunityServiceFacadeImpl;
import com.prefect.office.record.management.app.facade.prefect.offense.OffenseFacade;
import com.prefect.office.record.management.app.facade.prefect.offense.impl.OffenseFacadeImpl;
import com.prefect.office.record.management.app.facade.prefect.violation.ViolationFacade;
import com.prefect.office.record.management.app.facade.prefect.violation.impl.ViolationFacadeImpl;
import com.prefect.office.record.management.app.model.communityservice.CommunityService;
import com.prefect.office.record.management.app.model.offense.Offense;
import com.prefect.office.record.management.data.dao.prefect.communityservice.impl.CommunityServiceDaoImpl;
import com.prefect.office.record.management.data.dao.prefect.offense.impl.OffenseDaoImpl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final OffenseFacade offenseFacade = new OffenseFacadeImpl(new OffenseDaoImpl());
    private static final CommunityServiceFacade communityServiceFacade = new CommunityServiceFacadeImpl(new CommunityServiceDaoImpl());
    private static final ViolationFacade violationFacade = new ViolationFacadeImpl();

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
                        viewCsHistory();
                        break;
                    case 3:
                        renderCs();
                        break;
                    case 4:
                        addViolation();
                        break;
                    case 5:
                        addOffense();
                        break;
                    case 6:
                        viewAllOffense();
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
        System.out.println("2. View Community Service History");
        System.out.println("3. Render Community Service");
        System.out.println("4. Add Violation");
        System.out.println("5. Add Offense");
        System.out.println("6. View Offense");
        System.out.println("0. Exit");
    }

    private static void viewAllOffense() {
        List<Offense> offenseRecords = offenseFacade.getAllOffenses();

        if (offenseRecords != null && !offenseRecords.isEmpty()) {
            System.out.println("Offense Records");
            for (Offense offenseRecord : offenseRecords) {
                System.out.println("Offense ID: " + offenseRecord.getId());
                System.out.println("Violation ID: " + offenseRecord.getViolationId());
                System.out.println("Student ID: " + offenseRecord.getStudentId());
                System.out.println("Offense Date: " + offenseRecord.getOffenseDate());
                System.out.println("-----------------------------------");
            }
        } else {
            System.out.println("No offense records found.");
        }
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

    private static void addOffense() {
        System.out.println("\nAdding an Offense:");

        System.out.print("Enter Violation ID: ");
        int violationId = scanner.nextInt();

        System.out.print("Enter Student ID: ");
        String studentId = scanner.next();


        Offense newOffense = new Offense();
        newOffense.setViolationId(violationId);
        newOffense.setStudentId(studentId);
        newOffense.setOffenseDate(new Timestamp(System.currentTimeMillis()));

        boolean added = offenseFacade.addOffense(newOffense);

        if (added) {
            System.out.println("Offense added successfully!");
        } else {
            System.out.println("Failed to add offense.");
        }
    }

    private static void viewCsHistory() {
        List<CommunityService> csRecords = communityServiceFacade.getAllCs();

        if (csRecords != null && !csRecords.isEmpty()) {
            System.out.println("Community Service Records");
            for (CommunityService csRecord : csRecords) {
                System.out.println("Community Service ID: " + csRecord.getId());
                System.out.println("Student ID: " + csRecord.getStudent_id());
                System.out.println("Date Rendered: " + csRecord.getDate_rendered());
                System.out.println("Hours Rendered: " + csRecord.getHours_rendered());
                System.out.println("-----------------------------------");
            }
        } else {
            System.out.println("No Community Service found.");
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

    private static void addViolation() {
        System.out.println("\nAdding a Violation:");

        System.out.print("Enter Violation Description: ");
        scanner.nextLine();
        String description = scanner.nextLine();

        System.out.print("Enter Violation Type: ");
        String type = scanner.nextLine();

        System.out.print("Enter Community Service Hours: ");
        int commServHours = scanner.nextInt();
        scanner.nextLine();


        violationFacade.addViolation(description, type, commServHours);
        System.out.println("Violation added successfully!");
    }
}
