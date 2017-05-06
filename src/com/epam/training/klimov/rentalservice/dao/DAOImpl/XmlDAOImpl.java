package com.epam.training.klimov.rentalservice.dao.DAOImpl;

import com.epam.training.klimov.rentalservice.dao.IRentalServiceDAO;
import com.epam.training.klimov.rentalservice.entities.RentUnit;
import com.epam.training.klimov.rentalservice.entities.Shop;
import com.epam.training.klimov.rentalservice.entities.SportEquipment;
import java.util.HashMap;
import java.util.Map;
import static com.epam.training.klimov.rentalservice.enums.Category.Gym;
import static com.epam.training.klimov.rentalservice.enums.Category.Leisure;
import static com.epam.training.klimov.rentalservice.enums.Category.Water;

/**
 * This implementation allows to work with xml files.
 *
 * @author Konstantin Klimov
 */

public class XmlDAOImpl implements IRentalServiceDAO {

    @Override
    public Shop readShop() {
        //TODO
        Shop shop = new Shop();
        Map<SportEquipment, Integer> goods = new HashMap<>();
        goods.put(new SportEquipment(Gym, "Barbell", 20), 3);
        goods.put(new SportEquipment(Water, "Swimming trunks", 5), 2);
        goods.put(new SportEquipment(Leisure, "Pillow", 7), 10);
        shop.setGoods(goods);
        return shop;
    }

    @Override
    public void saveShop(Shop shop) {

    }

    @Override
    public RentUnit readRentUnit() {
        return null;
    }

    @Override
    public void saveRentUnit(RentUnit rentUnit) {
    }
}
