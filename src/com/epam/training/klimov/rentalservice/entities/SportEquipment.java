package com.epam.training.klimov.rentalservice.entities;

import com.epam.training.klimov.rentalservice.enums.Category;

import java.io.Serializable;

/**
 * Instances of the class Class SportEquipment represent common base element which can be rented.
 *
 * @author Konstantin Klimov
 */

public class SportEquipment implements Serializable {
    private static final long serialVersionUID = 1L;
    private Category category;
    private String title;
    private int price;

    public SportEquipment() {
    }

    /**
     * Constructor.
     *
     * @param category
     *            - a category of a sport equipment
     * @param title
     *            - a title of a sport equipment
     * @param price
     *            - a price for rent per day
     */
    public SportEquipment(Category category, String title, int price) {
        this.category = category;
        this.title = title;
        this.price = price;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SportEquipment equipment = (SportEquipment) o;

        if (price != equipment.price) return false;
        if (category != equipment.category) return false;
        return title != null ? title.equals(equipment.title) : equipment.title == null;
    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return title +
                " (Category:" + category +
                ", Price:" + price + ")";
    }
}
