package com.epam.training.klimov.rentalservice.tools;

/**
 * Created by Администратор on 06.05.2017.
 */

public class Messages {

    public static final String GREETING_MESSAGE = "*** Welcome to the Sport Equipment Rental Service ***";
    public static final String EXITING_MESSAGE = "Exiting the program...";

    public static final String INCORRECT_INPUT = "Incorrect input. Try again..";
    public static final String INCORRECT_NUMERIC_INPUT = "Incorrect input. Please, enter positive value..";

    public static void printLoginMenu() {
        System.out.println("Enter a role:");
        System.out.println("1. Admin");
        System.out.println("2. User");
        System.out.println("0. Exit.");
    }

    public static void printAdminMenu() {
        System.out.println("Admin menu:");
        System.out.println("1. Make a report ");
        System.out.println("0. Back.");
    }

    public static void printUserMenu() {
        System.out.println("User menu:");
        System.out.println("1. Show my rented list");
        System.out.println("2. Bring back equipment");
        System.out.println("3. Show available to rent");
        System.out.println("0. Back.");
    }
}
