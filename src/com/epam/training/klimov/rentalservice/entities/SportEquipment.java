package com.epam.training.klimov.rentalservice.entities;

import com.epam.training.klimov.rentalservice.enums.Category;

/**
 * Instances of the class Class SportEquipment represent common base element which can be rented.
 *
 * @author Konstantin Klimov
 */

public class SportEquipment {

    private Category category;
    private String title;
    private int price;

    public SportEquipment() {
    }

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
}
