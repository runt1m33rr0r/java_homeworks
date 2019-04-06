package com.homework5;

class Furniture extends Item {

    private String brand;

    Furniture(String brand, String address, double deliveryPrice, int elementsCount, Box box) {
        super(address, deliveryPrice, elementsCount, box);

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
