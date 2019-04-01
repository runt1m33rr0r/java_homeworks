package com.homework5;

import java.util.ArrayList;

class Furniture extends Item {

    private String brand;

    Furniture(String brand, String address, double deliveryPrice, ArrayList<Element> elements, Box box) {
        super(address, deliveryPrice, elements, box);

        this.brand = brand;
    }

    String getBrand() {
        return this.brand;
    }

    boolean isBreakable() {
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
}
