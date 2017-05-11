package com.epam.training.klimov.rentalservice;

import com.epam.training.klimov.rentalservice.dao.DAOImpl.SerializationDAOImpl;
import com.epam.training.klimov.rentalservice.dao.IRentalServiceDAO;
import com.epam.training.klimov.rentalservice.tools.Messages;


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
     * @param args Unused.
     *
     * @see com.epam.training.klimov.rentalservice.RentalServiceDispatcher
     */

    public static void main(String[] args) {
        System.out.println(Messages.GREETING_MESSAGE);
        IRentalServiceDAO dao = new SerializationDAOImpl();
        RentalServiceDispatcher rsd = new RentalServiceDispatcher(dao);
        rsd.mainMenu();
    }
}
