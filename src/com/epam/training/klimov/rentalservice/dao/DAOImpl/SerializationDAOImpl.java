package com.epam.training.klimov.rentalservice.dao.DAOImpl;

import com.epam.training.klimov.rentalservice.dao.IRentalServiceDAO;
import com.epam.training.klimov.rentalservice.entities.RentUnit;
import com.epam.training.klimov.rentalservice.entities.Shop;
import com.epam.training.klimov.rentalservice.entities.SportEquipment;
import com.epam.training.klimov.rentalservice.tools.Configuration;

import java.util.HashMap;
import java.util.Map;
import static com.epam.training.klimov.rentalservice.enums.Category.*;

/**
 * This implementation allows to work with xml files.
 *
 * @author Konstantin Klimov
 */

public class SerializationDAOImpl implements IRentalServiceDAO {

    @Override
    public Shop initShop() {
        //TODO
        Shop shop = new Shop();
        Map<SportEquipment, Integer> goods = new HashMap<>();
        goods.put(new SportEquipment(Gym, "Barbell", 20), 3);
        goods.put(new SportEquipment(Water, "Ball", 5), 2);
        goods.put(new SportEquipment(Leisure, "Pillow", 7), 5);
        goods.put(new SportEquipment(Leisure, "Cards", 5), 10);
        shop.setGoods(goods);
        return shop;
    }

    @Override
    public void saveShop(Shop shop) {

    }

    @Override
    public RentUnit initRentUnit() {
        RentUnit rentUnit = new RentUnit();
        SportEquipment [] units = new SportEquipment[Configuration.MAX_ALLOWED_UNITS_TO_RENT];
        units[1] = new SportEquipment(Gym, "Barbell", 20);
        rentUnit.setUnits(units);
        return rentUnit;
    }

    @Override
    public void saveRentUnit(RentUnit rentUnit) {
    }
}
