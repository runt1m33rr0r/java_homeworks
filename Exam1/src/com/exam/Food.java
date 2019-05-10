package com.exam;

public class Food {

    private String name;
    private double basePrice;
    private FoodType type;

    public Food(String name, double basePrice, FoodType type) {
        this.name = name;
        this.basePrice = basePrice;
        this.type = type;
    }

    public double getBasePrice() {
        return this.basePrice;
    }

    public String getName() {
        return this.name;
    }

    public FoodType getType() {
        return this.type;
    }

    public double totalPrice() {
        return this.basePrice + FoodType.getAdditionalPrice(this.type);
    }

    public boolean isForVegans()
    {
        return this.type == FoodType.VEGAN;
    }

    public static Food chooseMoreExpensive(Food first, Food second)
    {
        if (first.totalPrice() > second.totalPrice())
        {
            return first;
        }

        return second;
    }
}
