package com.epam.training.klimov.rentalservice.tools;

import com.epam.training.klimov.rentalservice.entities.RentUnit;
import com.epam.training.klimov.rentalservice.entities.Shop;
import com.epam.training.klimov.rentalservice.entities.SportEquipment;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Администратор on 10.05.2017.
 */
public class Reporter {

    public static boolean showAvailableEquipment(Map <SportEquipment, Integer> goods) {
        Set<SportEquipment> set = goods.keySet();
        Iterator<SportEquipment> it = set.iterator();
        if (!it.hasNext()) {
            System.out.println(Messages.EMPTY_LIST_OF_AVAILABLE_EQUIPMENT);
            return false;
        }
        System.out.println(Messages.LIST_OF_AVAILABLE_EQUIPMENT);
        while (it.hasNext()) {
            SportEquipment equipment = it.next();
            if (goods.get(equipment) > 0) {
                System.out.println(equipment.toString() + " - " + goods.get(equipment) + " pcs");
            }
        }
        return true;
    }

    public static void showRentedEquipment(RentUnit rentUnit) {
        SportEquipment[] rented = rentUnit.getUnits();
        for (int i = 0; i < Configuration.MAX_ALLOWED_UNITS_TO_RENT; i++) {
            if (rented[i] != null) {
                System.out.println(rented[i].toString());
            }
        }
    }
}