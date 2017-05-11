package com.epam.training.klimov.rentalservice.tools;

/**
 * This auxiliary class stores the system messages.
 *
 * @author Konstantin Klimov
 */

public class Messages {

    public static final String GREETING_MESSAGE = "*** Welcome to the Sport Equipment Rental Service ***";
    public static final String SAVING_AND_CLOSING_RESOURCES = "Saving configuration and closing resources..";
    public static final String EXITING_MESSAGE = "Exiting the program...";
    public static final String ENTER_TITLE_OF_THE_EQUIPMENT = "Enter the title of the equipment that you'd like to rent: ";
    public static final String EMPTY_RENTED_LIST = "Your list of the rented equipment is empty. Try to rent anything.";
    public static final String EMPTY_LIST_OF_AVAILABLE_EQUIPMENT = "Unfortunately, nothing was found";
    public static final String LIST_OF_AVAILABLE_EQUIPMENT = "The list of available equipment:";
    public static final String INCORRECT_INPUT = "Incorrect input. Try again..";
    public static final String NOT_ENOUGH_AVAILABLE_SLOTS = "Not enough available empty slots! You have to return rented items.";
    public static final String ENTER_THE_TITLE_OF_THE_EQUIPMENT = "Enter the title of the equipment:";
    public static final String ENTER_SEARCH_KEYWORD = "Enter search keyword:";
    public static final String EQUIPMENT = "The sport equipment  ";
    public static final String HAS_BEEN_RENTED = "  has been successfully added to your list.";
    public static final String HAS_BEEN_RETURNED = "  has been returned.";
    public static final String ZERO_LENGTH_INPUT_STRING = "Could you enter longer word?...";
    public static final String LIST_OF_THE_RENTED_EQUIPMENT = "The list of rented equipment:";
    public static final String FILE_NOT_FOUND = "The file has not been found.";
    public static final String IO_EXCEPTION = "The program encountered with an IO exception.";

    public static final String MAIN_MENU =
            "Application menu:" + "\n" +
                    "1. Initialize the application" + "\n" +
                    "0. Back" + "\n";

    public static final String USER_MENU =
            "User menu:" + "\n" +
                    "1. Rent an equipment" + "\n" +
                    "2. Show my rented list" + "\n" +
                    "3. Bring back an equipment" + "\n" +
                    "4. Print available equipment" + "\n" +
                    "5. Search" + "\n" +
                    "0. Back" + "\n";

}
