package com.homework5;

import java.util.ArrayList;

public class Shoes extends Item {

    private boolean canBeTried;

    Shoes(boolean canBeTried, String address, double deliveryPrice, ArrayList<Element> elements, Box box) {
        super(address, deliveryPrice, elements, box);

        this.canBeTried = canBeTried;
    }

    boolean canBeTried() {
        return this.canBeTried;
    }

    @Override
    public double shippingPrice() {
        double result = super.getWeight() * super.shippingPrice();

        if (this.canBeTried) {
            return result + result * 3 / 100;
        }

        return result;
    }
}
