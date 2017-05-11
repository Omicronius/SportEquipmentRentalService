package com.epam.training.klimov.rentalservice.dao.DAOImpl;

import com.epam.training.klimov.rentalservice.dao.IRentalServiceDAO;
import com.epam.training.klimov.rentalservice.entities.RentUnit;
import com.epam.training.klimov.rentalservice.entities.Shop;
import com.epam.training.klimov.rentalservice.tools.Configuration;
import com.epam.training.klimov.rentalservice.tools.Messages;
import java.io.*;


/**
 * This implementation allows to read and write objects using serialization.
 *
 * @author Konstantin Klimov
 */

public class SerializationDAOImpl implements IRentalServiceDAO {
    private String pathToFile = Configuration.pathToFile;

    /**This methods successively write serializable objects to the file.
    *
    */

    public void saveConfiguration(Shop shop, RentUnit rentUnit) {
        try {
            try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(pathToFile))) {
                ous.writeObject(shop);
                ous.writeObject(rentUnit);
            }
        } catch (FileNotFoundException e) {
            System.out.println(Messages.FILE_NOT_FOUND);
        } catch (IOException e) {
            System.out.println(Messages.IO_EXCEPTION);
        }
    }

    /**The method restores serializable objects from the file system.
     *
     * @param shop
     * @param rentUnit
     */

    public void initialize(Shop shop, RentUnit rentUnit) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathToFile))) {
            shop.setGoods(((Shop) ois.readObject()).getGoods());
            rentUnit.setUnits(((RentUnit) ois.readObject()).getUnits());

//            Map<SportEquipment, Integer> map = new HashMap<>();
//            map.put(new SportEquipment(Gym, "Barbell", 15), 1);
//            map.put(new SportEquipment(Gym, "Dumbbells", 15), 2);
//            map.put(new SportEquipment(Water, "Kitesurf kit", 50), 1);
//            map.put(new SportEquipment(Leisure, "Pillow", 15), 7);
//            map.put(new SportEquipment(Leisure, "Cards", 15), 5);
//            shop.setGoods(map);
//            rentUnit.setUnits(new SportEquipment[Configuration.MAX_ALLOWED_UNITS_TO_RENT]);


        } catch (FileNotFoundException e) {
            System.out.println(Messages.FILE_NOT_FOUND);
        } catch (IOException e) {
            System.out.println(Messages.IO_EXCEPTION);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

