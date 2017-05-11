package com.epam.training.klimov.rentalservice.enums;

import com.epam.training.klimov.rentalservice.exceptions.UnknownCommandException;

/**
 * The enum contains main menu commands.
 *
 * @author Konstantin Klimov
 */
public enum MainMenuCommands {
    INITIALIZE_APPLICATION, EXIT, ;

    public static MainMenuCommands stringToCommand(String s) throws UnknownCommandException {

        switch (s) {
            case "1":
                return INITIALIZE_APPLICATION;
            case "0":
                return EXIT;
            default:
                throw new UnknownCommandException();

        }
    }
}
