package com.homework5;

public class Shoes extends Item {

    private boolean canBeTried;

    Shoes(boolean canBeTried, String address, double deliveryPrice, int elementsCount, Box box) {
        super(address, deliveryPrice, elementsCount, box);

        this.canBeTried = canBeTried;
    }

    boolean canBeTried() {
        return this.canBeTried;
    }

    @Override
    public double shippingPrice() {
        double result = super.shippingPrice();

        if (this.canBeTried) {
            return result + result * 3 / 100;
        }

        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "\ncan be tried: " + this.canBeTried();
    }
}
