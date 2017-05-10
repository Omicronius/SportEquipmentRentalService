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
        System.out.print(Messages.ENTER_TITLE_OF_THE_EQUIPMENT);
        String keyword = UserInput.inputString().trim().toLowerCase();
        Iterator <SportEquipment> it = shop.getGoods().keySet().iterator();
        while (it.hasNext()) {
            SportEquipment equipment = it.next();
            if (equipment.getTitle().toLowerCase().contains(keyword) && shop.getGoods().get(equipment) > 0) {
                shop.getGoods().put(equipment, shop.getGoods().get(equipment) - 1);
                SportEquipment [] rentedUnits = rentUnit.getUnits();
                for (int i = 0; i < Configuration.MAX_ALLOWED_UNITS_TO_RENT; i++) {
                    if (rentedUnits[i] == null) {
                        rentedUnits[i] = equipment;
                        System.out.println(Messages.EQUIPMENT_HAS_BEEN_RENTED);
                        return;
                    }
                }
            }
        }
    }

    public void returnRentedEquipment(Shop shop, RentUnit rentUnit) {
        System.out.print(Messages.ENTER_THE_TITLE_OF_THE_EQUIPMENT);
        String keyword = UserInput.inputString().trim().toLowerCase();
        SportEquipment[] rentedUnits = rentUnit.getUnits();
        boolean itemReturned = false;
        for (int i = 0; i < rentedUnits.length; i++) {
            if (!itemReturned && rentedUnits[i] != null && rentedUnits[i].getTitle().toLowerCase().contains(keyword)) {
                shop.getGoods().put(rentedUnits[i], shop.getGoods().get(rentedUnits[i]) + 1);
                itemReturned = true;
                System.out.println(Messages.ITEM_HAS_BEEN_RETURNED);
                rentedUnits[i] = null;
            }
        }
    }

    public Map<SportEquipment, Integer> findEquipment(Shop shop) {
        Map<SportEquipment, Integer> foundUnits = new HashMap<>();
        System.out.print(Messages.ENTER_SEARCH_KEYWORD);
        String keyword = UserInput.inputString().trim().toLowerCase();
        for (Map.Entry<SportEquipment, Integer> entry : shop.getGoods().entrySet()) {
            if (entry.getKey().getTitle().toLowerCase().contains(keyword)) {
                foundUnits.put(entry.getKey(), entry.getValue());
            }
        }
        return foundUnits;
    }

    public boolean checkAvailableSlots(RentUnit rentUnit) {
        SportEquipment[] rented = rentUnit.getUnits();
        for (int i = 0; i < Configuration.MAX_ALLOWED_UNITS_TO_RENT; i++) {
            if (rented[i] == null) {
                return true;
            }
        }
        System.out.println(Messages.NOT_ENOUGH_AVAILABLE_SLOTS);
        return false;
    }
}
