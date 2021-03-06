package com.epam.training.klimov.rentalservice;

import com.epam.training.klimov.rentalservice.dao.IRentalServiceDAO;
import com.epam.training.klimov.rentalservice.enums.MainMenuCommands;
import com.epam.training.klimov.rentalservice.enums.UserCommands;
import com.epam.training.klimov.rentalservice.entities.RentUnit;
import com.epam.training.klimov.rentalservice.entities.Shop;
import com.epam.training.klimov.rentalservice.exceptions.UnknownCommandException;
import com.epam.training.klimov.rentalservice.tools.*;

/**
 * The class RentalServiceDispatcher contains state of the application and menu methods.
 *
 * @author Konstantin Klimov
 *
 * @see com.epam.training.klimov.rentalservice.tools.Reporter
 * @see com.epam.training.klimov.rentalservice.tools.Operator
 */

class RentalServiceDispatcher {
    private Shop shop;
    private RentUnit rentUnit;
    private IRentalServiceDAO dao;

    RentalServiceDispatcher(IRentalServiceDAO dao) {
        this.dao = dao;
        this.rentUnit = new RentUnit();
        this.shop = new Shop();
    }

    private void initialization() {
        dao.initialize(shop, rentUnit);
    }

    private void saveConfiguration() {
        dao.saveConfiguration(shop, rentUnit);
    }

    void mainMenu() {
        System.out.println(Messages.MAIN_MENU);
        while (true) {
            try {
                MainMenuCommands mainMenuCommand = MainMenuCommands.stringToCommand(UserInput.inputString());
                switch (mainMenuCommand) {
                    case INITIALIZE_APPLICATION:
                        initialization();
                        userMenu();
                        break;
                    case EXIT:
                        UserInput.close();
                        System.exit(0);
                        break;
                }
            } catch (UnknownCommandException ex) {
                System.out.println(Messages.INCORRECT_INPUT);
            }
        }
    }

    private void userMenu() {
        while (true) {
            System.out.println(Messages.USER_MENU);
            try {
                UserCommands userCommand = UserCommands.stringToCommand(UserInput.inputString());
                switch (userCommand) {
                    case RENT_AN_EQUIPMENT:
                        if (Operator.checkAvailableSlots(rentUnit) && Reporter.showAvailableEquipment(shop.getGoods())) {
                            Operator.rentEquipment(shop, rentUnit);
                        }
                        break;
                    case SHOW_RENTED:
                        Reporter.showRentedEquipment(rentUnit);
                        break;
                    case BRING_BACK:
                        if (Reporter.showRentedEquipment(rentUnit)) {
                            Operator.returnRentedEquipment(shop, rentUnit);
                        }
                        break;
                    case AVAILABLE_EQUIPMENT:
                        Reporter.showAvailableEquipment(shop.getGoods());
                        break;
                    case SEARCH:
                        Reporter.showAvailableEquipment(Operator.findEquipment(shop));
                        break;
                    case EXIT:
                        System.out.println(Messages.SAVING_AND_CLOSING_RESOURCES);
                        saveConfiguration();
                        UserInput.close();
                        System.out.println(Messages.EXITING_MESSAGE);
                        System.exit(0);
                        break;
                }
            } catch (UnknownCommandException ex) {
                System.out.println(Messages.INCORRECT_INPUT);
            }
        }
    }
}
