package com.epam.training.klimov.rentalservice.tools;

import com.epam.training.klimov.rentalservice.entities.RentUnit;
import com.epam.training.klimov.rentalservice.entities.SportEquipment;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * The class helps to print reports.
 *
 * @author Konstantin Klimov
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

    public static boolean showRentedEquipment(RentUnit rentUnit) {
        System.out.println(Messages.LIST_OF_THE_RENTED_EQUIPMENT);
        SportEquipment[] rented = rentUnit.getUnits();
        boolean isEmpty = true;
        for (int i = 0; i < Configuration.MAX_ALLOWED_UNITS_TO_RENT; i++) {
            if (rented[i] != null) {
                isEmpty = false;
                System.out.println(rented[i].toString());
            }
        }
        if (isEmpty) {
            System.out.println(Messages.EMPTY_RENTED_LIST);
        }
        return !isEmpty;
    }
}
