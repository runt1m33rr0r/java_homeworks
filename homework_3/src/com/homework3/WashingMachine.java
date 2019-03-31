package com.homework3;

class WashingMachine extends Device {

    private double maxRPM;
    private boolean canDryClothes;

    WashingMachine(Maker maker, double price, int minWarranty, double maxRPM, boolean canDryClothes) {
        super(maker, price, minWarranty);

        this.maxRPM = maxRPM;
        this.canDryClothes = canDryClothes;
    }

    double getMaxRPM() {
        return this.maxRPM;
    }

    boolean getCanDryCothers() {
        return this.canDryClothes;
    }

    @Override
    int guaranteePeriod() {
        if (this.getCanDryCothers()) {
            return super.guaranteePeriod() + this.getMinWarranty() * 50 / 100;
        }

        return super.guaranteePeriod();
    }

    @Override
    public String toString() {
        return super.toString() + "\nmax rpm: " + this.getMaxRPM() + "\ncan dry clothes: " + this.getCanDryCothers();
    }
}
