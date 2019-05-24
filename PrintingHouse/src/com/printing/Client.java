package com.printing;

public class Client {
    private String name;
    private double money;

    public Client(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public double takeMoney(double amount) {
        if (amount > this.money) {
            return 0;
        } else {
            this.money -= amount;
            return amount;
        }
    }
}
