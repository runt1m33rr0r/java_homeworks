package com.homework2;

class Customer {
    private double money;

    Customer(double money) {
        this.money = money;
    }

    double takeMoney(double amount) {
        if (this.money - amount >= 0) {
            this.money -= amount;
        }

        return amount;
    }
}
