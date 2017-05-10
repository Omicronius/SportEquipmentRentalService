/*
 * For testing the application you can use pre-loaded configuration in the file test.bin
 */

package com.epam.training.klimov.rentalservice;

import com.epam.training.klimov.rentalservice.dao.DAOImpl.SerializationDAOImpl;
import com.epam.training.klimov.rentalservice.dao.IRentalServiceDAO;
import com.epam.training.klimov.rentalservice.tools.Messages;
import com.epam.training.klimov.rentalservice.tools.Operator;

 /* The entrance of the application. Invokes dispatcher, initializes his state and allows to choose access level.
 * @author Konstantin Klimov
 */

public class Runner {

    /**
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(Messages.GREETING_MESSAGE);
        IRentalServiceDAO dao = new SerializationDAOImpl();
        Operator operator = new Operator();
        RentalServiceDispatcher rsd = new RentalServiceDispatcher(operator);
        rsd.initialization(dao);
        rsd.run();
        rsd.saveConfiguration(dao);
        System.out.println(Messages.EXITING_MESSAGE);
    }
}
