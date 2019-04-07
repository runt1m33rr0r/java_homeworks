package com.homework5;

import java.util.ArrayList;

public class Shoes extends Item {

    private boolean canBeTried;

    public Shoes(boolean canBeTried, String address, double deliveryPrice, ArrayList<Element> elements, Box box) {
        super(address, deliveryPrice, elements, box);

        this.canBeTried = canBeTried;
    }

    public boolean canBeTried() {
        return this.canBeTried;
    }

    @Override
    public double shippingPrice() {
        if (this.canBeTried) {
            return super.shippingPrice() + super.shippingPrice() * 3 / 100;
        }

        return super.shippingPrice();
    }

    @Override
    public String toString() {
        return "\n---shoes---\n" + super.toString() + "\ncan be tried: " + this.canBeTried() +
                "\n---shoes---";
    }
}
