package com.epam.training.klimov.rentalservice.tools;

import com.epam.training.klimov.rentalservice.entities.RentUnit;
import com.epam.training.klimov.rentalservice.entities.Shop;
import com.epam.training.klimov.rentalservice.entities.SportEquipment;

import java.util.*;
/**
 * The Class contains main methods for searching, rent and returning rented equipment.
 *
 * @author Konstantin Klimov
 */
public class Operator {

    /**
     * The method transfers the unit from the shop store to the user's rented list if unit's title matches the keyword.
     * @param shop
     * @param rentUnit
     */
    public static void rentEquipment(Shop shop, RentUnit rentUnit) {
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
                        System.out.println(Messages.EQUIPMENT + equipment.toString() + Messages.HAS_BEEN_RENTED);
                        return;
                    }
                }
            }
        }
    }

    /**
     *  The method returns the rented unit from the rented list to the shop store.
     * @param shop
     * @param rentUnit
     */
    public static void returnRentedEquipment(Shop shop, RentUnit rentUnit) {
        System.out.print(Messages.ENTER_THE_TITLE_OF_THE_EQUIPMENT);
        String keyword = UserInput.inputString().trim().toLowerCase();
        SportEquipment[] rentedUnits = rentUnit.getUnits();
        boolean itemReturned = false;
        for (int i = 0; i < rentedUnits.length; i++) {
            if (!itemReturned && rentedUnits[i] != null && rentedUnits[i].getTitle().toLowerCase().contains(keyword)) {
                shop.getGoods().put(rentedUnits[i], shop.getGoods().get(rentedUnits[i]) + 1);
                itemReturned = true;
                System.out.println(Messages.EQUIPMENT + rentedUnits[i].toString() + Messages.HAS_BEEN_RETURNED);
                rentedUnits[i] = null;
            }
        }
    }

    /**
     *  The method moves through the map and selects equipment which matches to the keyword.
     * @param shop
     * @return The map of the found equipment.
     */
    public static Map<SportEquipment, Integer> findEquipment(Shop shop) {
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

    /**
     * Helpful methods check user's ability to rent additional units.
     * @param rentUnit
     * @return
     */
    public static boolean checkAvailableSlots(RentUnit rentUnit) {
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
