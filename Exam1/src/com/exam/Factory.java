package com.exam;

public abstract class Factory {

    private String name;
    private int employeeCount;

    public Factory(String name, int employeeCount) {
        this.name = name;
        this.employeeCount = employeeCount;
    }

    public String getName() {
        return this.name;
    }

    public int getEmployeeCount() {
        return this.employeeCount;
    }

    public abstract double income();

    public abstract double totalCosts();

    public double totalProfit() {
        return this.income() - this.totalCosts();
    }

    public static boolean isMoreProfitable(Factory first, Factory second) {
        return first.totalProfit() > second.totalProfit();
    }
}
