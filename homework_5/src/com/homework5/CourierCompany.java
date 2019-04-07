package com.homework5;

import java.util.ArrayList;

public class CourierCompany {

    private ArrayList<Item> items;
    private int itemsCount;

    public CourierCompany(ArrayList<Item> items) {
        this.items = items;
        this.itemsCount = this.items.size();
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public int getItemsCount() {
        return this.itemsCount;
    }

    public double getIncome() {
        double result = 0;

        for (Item item : this.items) {
            result += item.shippingPrice();
        }

        return result;
    }

    public double getItemsVolume() {
        double result = 0;

        for (Item item : this.items) {
            result += item.getBox().getVolume();
        }

        return result;
    }

    public void addItem(Item item) {
        this.items.add(item);
        this.itemsCount++;
    }

    @Override
    public String toString() {
        return "\n---courier company---\nitems count: " + this.getItemsCount() +
                "\nitems: \n" + this.getItems().toString() +
                "\nincome: " + this.getIncome() +
                "\nitems volume: " + this.getItemsVolume() +
                "\n---courier company---";
    }
}
