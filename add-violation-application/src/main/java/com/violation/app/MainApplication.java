package com.violation.app;

import com.violation.app.facade.violation.impl.ViolationFacade;
import com.violation.app.facade.violation.impl.ViolationFacadeImpl;
import com.violation.app.model.item.Violation;

import java.util.List;
import java.util.Scanner;

public class MainApplication {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ViolationFacade violationFacade = new ViolationFacadeImpl();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Violation");
            System.out.println("2. Exit");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addViolation();
                    break;
                case 2:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.out.print("Enter your choice: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void addViolation() {
        System.out.println("\nAdding a Violation:");

        System.out.print("Enter Violation Description: ");
        String description = scanner.next();

        System.out.print("Enter Violation Type: ");
        String type = scanner.next();

        System.out.print("Enter Community Service Hours: ");
        int commServHours = scanner.nextInt();

        violationFacade.addViolation(description, type, commServHours);
        System.out.println("Violation added successfully!");
    }
}