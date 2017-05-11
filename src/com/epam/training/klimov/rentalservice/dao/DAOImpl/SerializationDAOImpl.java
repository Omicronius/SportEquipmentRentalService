package com.epam.training.klimov.rentalservice.dao.DAOImpl;

import com.epam.training.klimov.rentalservice.dao.IRentalServiceDAO;
import com.epam.training.klimov.rentalservice.entities.RentUnit;
import com.epam.training.klimov.rentalservice.entities.Shop;
import com.epam.training.klimov.rentalservice.entities.SportEquipment;
import com.epam.training.klimov.rentalservice.tools.Configuration;
import com.epam.training.klimov.rentalservice.tools.Messages;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.epam.training.klimov.rentalservice.enums.Category.*;

/**
 * This implementation allows to readObject and write objects using serialization.
 *
 * @author Konstantin Klimov
 */

public class SerializationDAOImpl implements IRentalServiceDAO {
    private String pathToFile = Configuration.pathToFile;

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

    public void initialize(Shop shop, RentUnit rentUnit) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathToFile))) {
            shop.setGoods(((Shop) ois.readObject()).getGoods());
            rentUnit.setUnits(((RentUnit) ois.readObject()).getUnits());
        } catch (FileNotFoundException e) {
            System.out.println(Messages.FILE_NOT_FOUND);
        } catch (IOException e) {
            System.out.println(Messages.IO_EXCEPTION);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

