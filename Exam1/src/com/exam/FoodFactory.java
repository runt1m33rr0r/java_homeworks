package com.exam;

import java.util.ArrayList;

public class FoodFactory extends Factory {

    private double employeeCosts;
    private double rentCost;
    private ArrayList<Food> soldProducts;

    public FoodFactory(String name, int employeeCount, double employeeCosts, double rentCost) {
        super(name, employeeCount);

        this.employeeCosts = employeeCosts;
        this.rentCost = rentCost;
        this.soldProducts = new ArrayList<>();
    }

    @Override
    public double income() {
        double result = 0;

        for (Food product : this.soldProducts) {
            result += product.totalPrice();
        }

        return result;
    }

    @Override
    public double totalCosts() {
        return this.employeeCosts + this.rentCost;
    }

    public void addSoldProduct(Food product) {
        this.soldProducts.add(product);
    }

    public double getProfitByFoodType(FoodType type) {
        double result = 0;

        for (Food product : this.soldProducts) {
            if (product.getType() == type) {
                result += product.totalPrice();
            }
        }

        return result;
    }
}
