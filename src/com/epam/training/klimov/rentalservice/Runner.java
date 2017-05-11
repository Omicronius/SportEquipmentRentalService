/*
 * For testing the application you can use pre-loaded configuration in the file test.bin
 */

package com.epam.training.klimov.rentalservice;

import com.epam.training.klimov.rentalservice.dao.DAOImpl.SerializationDAOImpl;
import com.epam.training.klimov.rentalservice.dao.IRentalServiceDAO;
import com.epam.training.klimov.rentalservice.tools.Messages;
import com.epam.training.klimov.rentalservice.tools.Operator;

 /** "SportEquipmentRent" program is a console application, where user can rent or return rented an sport equipment
  * via computer console. Invokes dispatcher, initializes his state and allows.
 *
 * @author Konstantin Klimov
 * @version 1.0
 */

public class Runner {

    /**
     * The entry point of the program.
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(Messages.GREETING_MESSAGE);
        IRentalServiceDAO dao = new SerializationDAOImpl();
        RentalServiceDispatcher rsd = new RentalServiceDispatcher(dao);
        rsd.initialization();
        rsd.run();
        System.out.println(Messages.EXITING_MESSAGE);
    }
}
