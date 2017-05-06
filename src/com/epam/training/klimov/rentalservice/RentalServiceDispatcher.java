package com.epam.training.klimov.rentalservice;

import com.epam.training.klimov.rentalservice.dao.IRentalServiceDAO;
import com.epam.training.klimov.rentalservice.entities.RentUnit;
import com.epam.training.klimov.rentalservice.entities.Shop;
import com.epam.training.klimov.rentalservice.tools.Configuration;
import com.epam.training.klimov.rentalservice.tools.Messages;
import com.epam.training.klimov.rentalservice.tools.UserInputHandler;

/**
 * The class RentalServiceDispatcher contains state of the application and menu methods.
 *
 * @author Konstantin Klimov
 */

class RentalServiceDispatcher {
    private RentUnit rentUnit;
    private Shop shop;
    private IRentalServiceDAO dao;

    RentalServiceDispatcher(IRentalServiceDAO dao) {
        this.dao = dao;
    }

    void initialization() {
        rentUnit = dao.readRentUnit();
        shop = dao.readShop();
    }

    private void saveApplicationState() {
        dao.saveRentUnit(rentUnit);
        dao.saveShop(shop);
    }

    void loginMenu() {
        while (true) {
            Messages.printLoginMenu();
            switch (UserInputHandler.inputNumber()) {
                case Configuration.ADMIN_ACCESS:
                    adminMenu();
                    break;
                case Configuration.USER_ACCESS:
                    userMenu();
                    break;
                case Configuration.EXIT:
                    System.out.println(Messages.EXITING_MESSAGE);
                    saveApplicationState();
                    System.exit(0);
                    break;
                default:
                    System.out.println(Messages.INCORRECT_INPUT);
            }
        }
    }

    private void adminMenu() {
        out:
        while (true) {
            Messages.printAdminMenu();
            switch (UserInputHandler.inputNumber()) {
                case 0 : break out;
                default:
                    System.out.println(Messages.INCORRECT_INPUT);
            }
        }
    }

    private void userMenu() {
        out:
        while (true) {
            Messages.printUserMenu();
            switch (UserInputHandler.inputNumber()) {
                case 0 : break out;
                default:
                    System.out.println(Messages.INCORRECT_INPUT);
            }
        }
    }
}
