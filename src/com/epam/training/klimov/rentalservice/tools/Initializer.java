package com.epam.training.klimov.rentalservice.tools;

import com.epam.training.klimov.rentalservice.entities.RentUnit;
import com.epam.training.klimov.rentalservice.entities.Shop;
import com.epam.training.klimov.rentalservice.entities.SportEquipment;

import java.util.HashMap;
import java.util.Map;

import static com.epam.training.klimov.rentalservice.enums.Category.*;

/**
 * Created by Администратор on 06.05.2017.
 */

public class Initializer {

    public static final Shop initialize(Shop shop) {
        Map<SportEquipment, Integer> goods = new HashMap<>();
        goods.put(new SportEquipment(Gym, "Barbell", 20), 3);
        goods.put(new SportEquipment(Water, "Swimming trunks", 5), 2);
        goods.put(new SportEquipment(Leisure, "Pillow", 7), 10);
        shop.setGoods(goods);
        return shop;
    }

    public static final RentUnit initialize(RentUnit rentUnit) {
        return rentUnit;
    }
}
