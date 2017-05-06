package com.epam.training.klimov.rentalservice.entities;

/**
 * The RentUnit class is responsible for storing rented equipment.;
 * @author Konstantin Klimov
 */

public class RentUnit {

    private SportEquipment [] units;

    public RentUnit() {
    }

    public SportEquipment[] getUnits() {
        return units;
    }

    public void setUnits(SportEquipment[] units) {
        this.units = units;
    }
}
