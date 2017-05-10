package com.epam.training.klimov.rentalservice.enums;

import com.epam.training.klimov.rentalservice.exceptions.UnknownCommandException;

/**
 * Created by Администратор on 10.05.2017.
 */
public enum UserCommands {
    RENT_AN_EQUIPMENT, SHOW_RENTED, BRING_BACK, AVAILABLE_EQUIPMENT, SEARCH, EXIT, ;

    public static UserCommands stringToCommand(String s) throws UnknownCommandException {

        switch (s) {
            case "1":
                return RENT_AN_EQUIPMENT;
            case "2":
                return SHOW_RENTED;
            case "3":
                return BRING_BACK;
            case "4":
                return AVAILABLE_EQUIPMENT;
            case "5":
                return SEARCH;
            case "0":
                return EXIT;
            default:
                throw new UnknownCommandException();

        }
    }
}
