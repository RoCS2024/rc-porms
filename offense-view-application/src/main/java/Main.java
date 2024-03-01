import com.offense.view.app.facade.offense.OffenseFacade;
import com.offense.view.app.facade.offense.impl.OffenseFacadeImpl;
import com.offense.view.app.model.offense.Offense;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final OffenseFacade offenseFacade = new OffenseFacadeImpl();

    public static void main(String[] args) {
        char choice;
        do{
            System.out.println("Select your choice");
            System.out.println("1. View Offense table");
            System.out.println("2. View a Certain offense (By Student Id)");
            choice = (char) scanner.nextShort();
            scanner.nextLine();

            switch(choice){
                case 1:
                    viewOffenseTable();
                    break;
                case 2:
                    searchStudentId();

                   // System.out.print("Enter Student Id: ");
                   // String id = scanner.nextLine();

                   // Offense offense = (Offense) offenseFacade.getStudentById(id);
                    //if(null == offense) {
                       // System.out.println("cannot find  " + id);
                       // return;
                   // } else {
                    //    System.out.println("Offense information: ");
                     //   System.out.println(offense.getViolation_id() + " || " +
                      //          offense.getId() + " || " +
                       //         offense.getViolation_id() + " || " +
                       //         offense.getStudent_id() + " || " +
                       //         offense.getOffense_date());
                   // }

                    break;
            }
        } while (choice !=0);
        scanner.close();
    }

    private static void searchStudentId() {
        System.out.print("Enter Student Id: ");
        String id = scanner.nextLine();
        Offense searchStudent = (Offense) offenseFacade.getStudentById(id);
        if(null == searchStudent) {
            System.out.println("cannot find  " + id);
        }else {
            System.out.println("Offense information: ");
            System.out.println(searchStudent.getViolation_id() + " || " +
                    searchStudent.getId() + " || " +
                    searchStudent.getViolation_id() + " || " +
                    searchStudent.getStudent_id() + " || " +
                    searchStudent.getOffense_date());
        }
    }


    private static void viewOffenseTable() {
        try {
            List<Offense> offenses = offenseFacade.getAllOffenses();

            if (offenses.isEmpty()) {
                System.out.println("No records found.");
            } else {
                System.out.println("Offense Table");
                System.out.println(" ID, Violation_Id, Student_Id, Offense_Date ");
                for (Offense offense : offenses) {
                    System.out.println(offense.getViolation_id() + " || " +
                            offense.getId() + " || " +
                            offense.getViolation_id() + " || " +
                            offense.getStudent_id() + " || " +
                            offense.getOffense_date());
                }
            }
        } catch (Exception e) {
            System.out.println("Can't view table, try again.");
            e.printStackTrace();
        }
    }}