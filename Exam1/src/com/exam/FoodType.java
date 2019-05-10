package com.exam;

public enum FoodType {
    MEAT, VEGETARIAN, VEGAN;

    public static double getAdditionalPrice(FoodType type) {
        if (type == FoodType.VEGAN) {
            return 10;
        } else if (type == FoodType.MEAT) {
            return 20;
        }

        return 30;
    }
}