package com.epam.training.klimov.rentalservice.entities;

import java.util.Map;

/**
 * The class Shop describes equipment available to rent and their quantity.
 *
 * @author Konstantin Klimov
 */

public class Shop {

    private Map<SportEquipment, Integer> goods;

    public Shop() {
    }

    public Map<SportEquipment, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map<SportEquipment, Integer> goods) {
        this.goods = goods;
    }
}
