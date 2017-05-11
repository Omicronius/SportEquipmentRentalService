package com.epam.training.klimov.rentalservice.dao;

import com.epam.training.klimov.rentalservice.entities.RentUnit;
import com.epam.training.klimov.rentalservice.entities.Shop;


/**
 * The interface IRentalServiceDAO provides basic operations with data.
 *
 * @author Konstantin Klimov
 */

public interface IRentalServiceDAO {
    void initialize(Shop shop, RentUnit rentUnit);

    void saveConfiguration(Shop shop, RentUnit rentUnit);
}
