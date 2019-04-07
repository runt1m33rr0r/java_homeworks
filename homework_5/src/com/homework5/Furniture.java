package com.homework5;

import java.util.ArrayList;

public class Furniture extends Item {

    private String brand;

    public Furniture(String brand, String address, double deliveryPrice, ArrayList<Element> elements, Box box) {
        super(address, deliveryPrice, elements, box);

        this.brand = brand;
    }

    public String getBrand() {
        return this.brand;
    }

    public boolean isBreakable() {
        for (Element el : this.getElements()) {
            if (el.isBreakable()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public double shippingPrice() {
        if (this.isBreakable()) {
            return super.shippingPrice() * 1.5 / 100 + super.shippingPrice();
        }

        return super.shippingPrice();
    }

    @Override
    public String toString() {
        return "\n---furniture---\n" + super.toString() +
                "\nbrand: " + this.getBrand() +
                "\n---furniture---";
    }
}
