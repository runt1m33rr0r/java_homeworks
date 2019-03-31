package com.homework3;

class GasOven extends Oven {

    GasOven(Maker maker, double price, int minWarranty) {
        super(maker, price, minWarranty);
    }

    @Override
    int guaranteePeriod() {
        return super.guaranteePeriod() + 12;
    }
}
