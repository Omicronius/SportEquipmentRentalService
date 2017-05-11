package com.epam.training.klimov.rentalservice;

import com.epam.training.klimov.rentalservice.dao.IRentalServiceDAO;
import com.epam.training.klimov.rentalservice.enums.UserCommands;
import com.epam.training.klimov.rentalservice.entities.RentUnit;
import com.epam.training.klimov.rentalservice.entities.Shop;
import com.epam.training.klimov.rentalservice.exceptions.UnknownCommandException;
import com.epam.training.klimov.rentalservice.tools.Messages;
import com.epam.training.klimov.rentalservice.tools.Operator;
import com.epam.training.klimov.rentalservice.tools.Reporter;
import com.epam.training.klimov.rentalservice.tools.UserInput;

/**
 * The class RentalServiceDispatcher contains state of the application and menu methods.
 *
 * @author Konstantin Klimov
 */

class RentalServiceDispatcher {
    private RentUnit rentUnit;
    private Shop shop;

    void initialization(IRentalServiceDAO dao) {
        rentUnit = dao.initRentUnit();
        shop = dao.initShop();
    }

    void saveConfiguration(IRentalServiceDAO dao) {
        dao.saveRentUnit(rentUnit);
        dao.saveShop(shop);
    }

    void run() {
        boolean inUserMenu = true;
        while (inUserMenu) {
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
                        inUserMenu = false;
                        break;
                }
            } catch (UnknownCommandException ex) {
                System.out.println(Messages.INCORRECT_INPUT);
            }
        }
    }
}
