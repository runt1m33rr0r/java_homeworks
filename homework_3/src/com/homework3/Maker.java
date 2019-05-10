package com.homework3;

class Maker {

    private String name;
    private boolean doesExtendWarranty;

    Maker(String name, boolean doesExtendWarranty) {
        this.name = name;
        this.doesExtendWarranty = doesExtendWarranty;
    }

    String getName() {
        return name;
    }

    boolean getDoesExtendWarrany() {
        return this.doesExtendWarranty;
    }

    @Override
    public String toString() {
        return "maker name: " + this.getName() + "\ndoes extend warranty: " + this.getDoesExtendWarrany();
    }
}
