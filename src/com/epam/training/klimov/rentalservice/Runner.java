/*
 * For testing the application you can use pre-loaded configuration in the file test.bin
 */

package com.epam.training.klimov.rentalservice;

import com.epam.training.klimov.rentalservice.tools.Messages;

 /* The entrance of the application. Invokes dispatcher, initializes his state and allows to choose access level.
 * @author Konstantin Klimov
 */

public class Runner {

    /**
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(Messages.GREETING_MESSAGE);
        RentalServiceDispatcher rsd = new RentalServiceDispatcher();
        rsd.initialization();
        rsd.loginMenu();
        System.out.println(Messages.EXITING_MESSAGE);
    }
}
