package org.vistula.basket;

import java.util.List;

public class BasketItem {

    String name;
    private float price;
    boolean ageRestrictedItem;


    public BasketItem(String name, float price, boolean ageRestrictedItem) {
        this.name = name;
        this.price = price;
        this.ageRestrictedItem = ageRestrictedItem;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public BasketItem() {
    }

    public float getPrice() {
        return price;
    }

    public boolean isAgeRestrictedItem() {
        return ageRestrictedItem;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setAgeRestrictedItem(boolean ageRestrictedItem) {
        this.ageRestrictedItem = ageRestrictedItem;
    }








}
