package com.homework5;

import java.util.ArrayList;

class CourierCompany {

    private ArrayList<Item> items;
    private int itemsCount;

    CourierCompany(int itemsCount) {
        this.items = new ArrayList<>();
        this.itemsCount = itemsCount;
    }

    ArrayList<Item> getItems() {
        return this.items;
    }

    double getIncome() {
        double result = 0;

        for (Item item : this.items) {
            result += item.shippingPrice();
        }

        return result;
    }

    double getItemsVolume() {
        double result = 0;

        for (Item item : this.items) {
            result += item.getBox().getVolume();
        }

        return result;
    }

    void addItem(Item item) {
        this.items.add(item);
        this.itemsCount++;
    }
}
