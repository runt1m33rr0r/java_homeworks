package com.homework3;

class Device {

    private Maker maker;
    private double price;
    private int minWarranty;

    Device(Maker maker, double price, int minWarranty) {
        this.maker = maker;
        this.price = price;
        this.minWarranty = minWarranty;
    }

    Maker getMaker() {
        return this.maker;
    }

    double getPrice() {
        return this.price;
    }

    int getMinWarranty() {
        return this.minWarranty;
    }

    int guaranteePeriod() {
        if (this.getMaker().getDoesExtendWarrany()) {
            return this.getMinWarranty() + 12;
        }

        return this.getMinWarranty();
    }

    @Override
    public String toString() {
        return this.getMaker().toString() + "\nprice: " + this.getPrice() + "\nwarranty: " + this.guaranteePeriod();
    }
}
