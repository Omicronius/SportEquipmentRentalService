package com.epam.training.klimov.rentalservice.dao.DAOImpl;

import com.epam.training.klimov.rentalservice.dao.IRentalServiceDAO;
import com.epam.training.klimov.rentalservice.entities.RentUnit;
import com.epam.training.klimov.rentalservice.entities.Shop;
import com.epam.training.klimov.rentalservice.entities.SportEquipment;
import com.epam.training.klimov.rentalservice.tools.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static com.epam.training.klimov.rentalservice.enums.Category.*;

/**
 * This implementation allows to work with xml files.
 *
 * @author Konstantin Klimov
 */

public class SerializationDAOImpl implements IRentalServiceDAO {
    private ArrayList<SportEquipment> list;

    public SerializationDAOImpl() {
        ArrayList<SportEquipment> initList = new ArrayList<>();
        initList.add(new SportEquipment(Gym, "Barbell", 20));
        initList.add(new SportEquipment(Gym, "Dumbbells", 12));
        initList.add(new SportEquipment(Water, "Kitesurf kit", 50));
        initList.add(new SportEquipment(Leisure, "Pillow", 7));
        initList.add(new SportEquipment(Leisure, "Cards", 5));
        this.list = initList;
    }

    @Override
    public Shop initShop() {
        //TODO
        Shop shop = new Shop();
        Map<SportEquipment, Integer> goods = new HashMap<>();
        goods.put(list.get(0), 1);
        goods.put(list.get(1), 4);
        goods.put(list.get(2), 2);
        goods.put(list.get(3), 5);
        goods.put(list.get(4), 10);
        shop.setGoods(goods);
        return shop;
    }

    @Override
    public void saveShop(Shop shop) {

    }

    @Override
    public RentUnit initRentUnit() {
        RentUnit rentUnit = new RentUnit();
        SportEquipment [] rentedUnits = new SportEquipment[Configuration.MAX_ALLOWED_UNITS_TO_RENT];
        rentUnit.setUnits(rentedUnits);
        return rentUnit;
    }

    @Override
    public void saveRentUnit(RentUnit rentUnit) {
    }
}
