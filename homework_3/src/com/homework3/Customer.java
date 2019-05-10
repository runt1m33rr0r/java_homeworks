package com.homework3;

class Customer {

    private double budget;

    Customer(double budget) {
        this.budget = budget;
    }

    double takeMoney(double amount) {
        if (this.budget - amount >= 0) {
            this.budget -= amount;

            return amount;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "budget: " + this.budget;
    }
}
