import com.prefect.office.record.management.appl.facade.prefect.communityservice.CommunityServiceFacade;
import com.prefect.office.record.management.appl.facade.prefect.communityservice.impl.CommunityServiceFacadeImpl;
import com.prefect.office.record.management.appl.facade.prefect.offense.OffenseFacade;
import com.prefect.office.record.management.appl.facade.prefect.offense.impl.OffenseFacadeImpl;
import com.prefect.office.record.management.appl.facade.prefect.violation.ViolationFacade;
import com.prefect.office.record.management.appl.facade.prefect.violation.impl.ViolationFacadeImpl;
import com.prefect.office.record.management.appl.model.communityservice.CommunityService;
import com.prefect.office.record.management.appl.model.offense.Offense;
import com.prefect.office.record.management.appl.model.violation.Violation;
import com.prefect.office.record.management.data.dao.prefect.communityservice.impl.CommunityServiceDaoImpl;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;
import com.prefect.office.record.management.data.dao.prefect.offense.impl.OffenseDaoImpl;
import com.student.information.management.appl.facade.student.StudentFacade;
import com.student.information.management.appl.facade.student.impl.StudentFacadeImpl;
import com.student.information.management.appl.model.student.Student;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CommunityServiceFacade communityServiceFacade = new CommunityServiceFacadeImpl(new CommunityServiceDaoImpl());
    private static final ViolationFacade violationFacade = new ViolationFacadeImpl();
    private static OffenseFacade offenseFacade;

    public static void main(String[] args) {

        OffenseDao offenseDao = new OffenseDaoImpl();
        offenseFacade = new OffenseFacadeImpl(offenseDao);

        try {
            int choice;
            do {
                displayMenu();
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        viewAllOffense();
                        break;
                    case 2:
                        addOffense();
                        break;
                    case 3:
                        updateOffense();
                        break;
                    case 4:
                        addViolation();
                        break;
                    case 5:
                        updateViolation();
                        break;
                    case 6:
                        viewAllViolation();
                        break;
                    case 7:
                        renderCs();
                        break;
                    case 8:
                        viewCsHistory();
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
        System.out.println("1. View List of Offense");
        System.out.println("2. Add Offense");
        System.out.println("3. Update Offense");
        System.out.println("4. Add Violation");
        System.out.println("5. Update Violation");
        System.out.println("6. View List of Violation");
        System.out.println("7. Render Community Service");
        System.out.println("8. View Community Service History");
        System.out.println("0. Exit");
    }

    private static void viewAllOffense() {
        try {
            List<Offense> offenseRecords = offenseFacade.getAllOffenses();

            if (offenseRecords != null && !offenseRecords.isEmpty()) {
                System.out.println("Offense Records");
                for (Offense offenseRecord : offenseRecords) {
                    System.out.println("Offense ID: " + offenseRecord.getId());
                    System.out.println("Violation ID: " + offenseRecord.getViolation().getViolation());
                    System.out.println("Student Last Name: " + offenseRecord.getStudent().getLastName());
                    System.out.println("Student First Name: " + offenseRecord.getStudent().getFirstName());
                    System.out.println("Student Middle Name: " + offenseRecord.getStudent().getMiddleName());
                    System.out.println("Offense Date: " + offenseRecord.getOffenseDate());
                    System.out.println("-----------------------------------");
                }
            } else {
                System.out.println("No offense records found.");
            }
        } catch (Exception e) {
            System.err.println("An error occurred while viewing all offenses: " + e.getMessage());
        }
    }


    private static void addOffense() {
        try {
            System.out.println("\nAdding an Offense:");

            System.out.print("Enter Violation ID: ");
            int violationId = scanner.nextInt();
            if (violationId < 0) {
                System.out.println("Invalid Violation ID. Please enter a non-negative integer.");
                return;
            }

            System.out.print("Enter Student ID: ");
            String studentId = scanner.next();

            System.out.print("Enter Offense Date (YYYY-MM-DD): ");
            String dateStr = scanner.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(dateStr);
            Timestamp offenseDate = new Timestamp(parsedDate.getTime());

            Violation violation = violationFacade.getViolationByID(violationId);

            StudentFacade studentFacade = new StudentFacadeImpl();
            Student student = studentFacade.getStudentById(studentId);

            Offense newOffense = new Offense();
            newOffense.setViolation(violation);
            newOffense.setStudent(student);
            newOffense.setOffenseDate(offenseDate);

            boolean added = offenseFacade.addOffense(newOffense);

            if (added) {
                System.out.println("Offense added successfully!");
            } else {
                System.out.println("Failed to add offense.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid IDs.");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
        } catch (Exception e) {
            System.err.println("An error occurred while adding an offense: " + e.getMessage());
        }
    }


    private static void updateOffense() {
        try {
            System.out.print("Enter Offense ID: ");
            int offenseId = scanner.nextInt();

            System.out.print("Enter New Violation ID: ");
            int newViolationId = scanner.nextInt();

            System.out.print("Enter New Student ID: ");
            String newStudentId = scanner.next();

            Violation newViolation = violationFacade.getViolationByID(newViolationId);

            StudentFacade studentFacade = new StudentFacadeImpl();
            Student newStudent = studentFacade.getStudentById(newStudentId);

            Offense updatedOffense = new Offense();
            updatedOffense.setId(offenseId);
            updatedOffense.setViolation(newViolation);
            updatedOffense.setStudent(newStudent);
            updatedOffense.setOffenseDate(new Timestamp(System.currentTimeMillis()));

            boolean updated = offenseFacade.updateOffense(updatedOffense);

            if (updated) {
                System.out.println("Offense information updated successfully!");
            } else {
                System.out.println("Failed to update Offense information.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid IDs.");
        } catch (Exception e) {
            System.err.println("An error occurred while updating Offense information: " + e.getMessage());
        }
    }

    private static void addViolation() {
        try {
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
        } catch (Exception e) {
            System.err.println("An error occurred while adding a violation: " + e.getMessage());
        }
    }

    private static void updateViolation() {
        try {
            System.out.print("Enter Violation ID: ");
            int violationId = scanner.nextInt();

            System.out.print("Enter New Violation ID: ");
            int newViolationId = scanner.nextInt();
            System.out.print("Enter New Violation Name: ");
            String newViolation = scanner.next();
            System.out.print("Enter New Violation Type: ");
            String newViolationType = scanner.next();
            System.out.print("Enter New Community Service Hours: ");
            int newCsHours = scanner.nextInt();

            Violation updatedViolation = new Violation();
            updatedViolation.setId(violationId);
            updatedViolation.setViolation(newViolation);
            updatedViolation.setType(newViolationType);
            updatedViolation.setCommServHours(newCsHours);

            boolean updated = violationFacade.updateViolation(updatedViolation);

            if (updated) {
                System.out.println("Violation information updated successfully!");
            } else {
                System.out.println("Failed to update Violation information.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid IDs.");
        } catch (Exception e) {
            System.err.println("An error occurred while updating Violation information: " + e.getMessage());
        }
    }

    private static void viewAllViolation() {
        System.out.println("Showing all Violations ...");
        List<Violation> violationList =violationFacade.getAllViolation();
        for (Violation violation : violationList) {
            System.out.println("-------------------------------------");
            System.out.println("Violation ID: " + violation.getId());
            System.out.println("Violation: " + violation.getViolation());
            System.out.println("Violation Type: " + violation.getType());
            System.out.println("Community Service Hours: " + violation.getCommServHours());
        }
    }

    private static void renderCs() {
        try {
                int offenseId;
                do {
                    System.out.print("Enter Offense-ID (0 to exit): ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter an integer.");
                        scanner.next();
                        continue;
                    }
                    offenseId = scanner.nextInt();
                    if (offenseId < 0) {
                        System.out.println("Invalid Offense ID. Please enter a non-negative integer.");
                        continue;
                    }
                    if (offenseId == 0) {
                        System.out.println("Exiting...");
                        return;
                    }

                    System.out.print("Enter Student-ID: ");
                    String studentId = scanner.next().trim();
                    if (studentId.isEmpty()) {
                        System.out.println("Student-ID cannot be empty.");
                        continue;
                    }

                    System.out.print("Enter Hours Rendered: ");
                    int hoursRendered;
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter an integer.");
                        scanner.next();
                        continue;
                    }
                    hoursRendered = scanner.nextInt();
                    if (hoursRendered < 0) {
                        System.out.println("Invalid input. Please enter a non-negative integer.");
                        continue;
                    }

                    Offense existingOffense = offenseFacade.getOffenseByID(offenseId);
                    if (existingOffense != null) {
                        CommunityService newCs = new CommunityService();
                        newCs.setStudent_id(studentId);
                        newCs.setHours_rendered(hoursRendered);
                        newCs.setDate_rendered(new Timestamp(System.currentTimeMillis()));

                        boolean render = communityServiceFacade.renderCs(newCs);

                        if (render) {
                            System.out.println("Community Service Rendered successfully!");
                        } else {
                            System.out.println("Failed to Render Community Service.");
                        }
                    } else {
                        System.out.println("Offense with ID " + offenseId + " does not exist.");
                    }
                } while (true);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid value.");
            scanner.next();
        } catch (Exception e) {
            System.err.println("An error occurred while rendering Community Service: " + e.getMessage());
        }
    }

    private static void viewCsHistory() {
        try {
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
        } catch (Exception e) {
            System.err.println("An error occurred while viewing community service history: " + e.getMessage());
        }
    }
}
