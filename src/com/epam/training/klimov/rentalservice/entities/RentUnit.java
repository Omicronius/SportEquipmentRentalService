package com.epam.training.klimov.rentalservice.entities;

import java.io.Serializable;

/**
 * The RentUnit class is responsible for storing rented equipment.;
 *
 * @author Konstantin Klimov
 */

public class RentUnit implements Serializable {
    private static final long serialVersionUID = 1L;

    private SportEquipment[] units;

    public RentUnit() {
    }

    public SportEquipment[] getUnits() {
        return units;
    }

    public void setUnits(SportEquipment[] units) {
        this.units = units;
    }
}
