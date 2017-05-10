package com.epam.training.klimov.rentalservice.tools;

import com.epam.training.klimov.rentalservice.entities.RentUnit;
import com.epam.training.klimov.rentalservice.entities.Shop;
import com.epam.training.klimov.rentalservice.entities.SportEquipment;

import java.util.*;

/**
 * Created by Администратор on 10.05.2017.
 */
public class Operator {

    public void rentEquipment(Shop shop, RentUnit rentUnit) {
        if (checkAvailableSlots(rentUnit)) {
            System.out.println(Messages.ENTER_TITLE_OF_THE_EQUIPMENT);
            Reporter.showAvailableEquipment(shop.getGoods());
        }
    }

    private boolean checkAvailableSlots(RentUnit rentUnit) {
        SportEquipment[] rented = rentUnit.getUnits();
        for (int i = 0; i < Configuration.MAX_ALLOWED_UNITS_TO_RENT; i++) {
            if (rented[i] == null) {
                return true;
            }
        }
        System.out.println(Messages.NOT_ENOUGH_AVAILABLE_SLOTS);
        return false;
    }

    public void returnRentedEqupment(Shop shop, RentUnit rentUnit) {
    }

    public Map<SportEquipment, Integer> findEquipment(Shop shop) {
        Map <SportEquipment, Integer> foundUnits = new HashMap<>();
        Iterator<SportEquipment> it = shop.getGoods().keySet().iterator();
        String wordForSearch = UserInput.inputString().trim().toLowerCase();
        while (it.hasNext()) {
            SportEquipment equipment = it.next();
            if (equipment.getTitle().toLowerCase().contains(wordForSearch)) {
                foundUnits.put(equipment, shop.getGoods().get(equipment));
            }
        }
        return foundUnits;
    }
}
