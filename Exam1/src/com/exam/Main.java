package com.exam;

public class Main {

    public static void main(String[] args) {
	    FoodFactory factory = new FoodFactory("Bai Dancho", 100, 1000, 5000);

	    Food product1 = new Food("Sirene", 10, FoodType.VEGETARIAN);
	    Food product2 = new Food("Kashkaval", 15, FoodType.VEGETARIAN);
        Food product3 = new Food("Kebabche", 5, FoodType.MEAT);

        System.out.println(product1.getName() + " base price: " + product1.getBasePrice());
        System.out.println(product1.getName() + " type: " + product1.getType());
        System.out.println(product1.getName() + " total price: " + product1.totalPrice());
        System.out.println(product1.getName() + " is for vegans: " + product1.isForVegans());
        System.out.println(
                "the more expensive between " +
                product1.getName() + " and " + product2.getName() + " is " +
                Food.chooseMoreExpensive(product1, product2).getName());

        factory.addSoldProduct(product1);
        factory.addSoldProduct(product2);
        factory.addSoldProduct(product3);

        System.out.println("factory name: " + factory.getName());
        System.out.println("factory employees count: " + factory.getEmployeeCount());
        System.out.println("factory income: " + factory.income());
        System.out.println("factory total costs: " + factory.totalCosts());
        System.out.println("factory total profit: " + factory.totalProfit());
        System.out.println("factory profit by vegetarian food: " + factory.getProfitByFoodType(FoodType.VEGETARIAN));
        System.out.println("factory profit by vegan food: " + factory.getProfitByFoodType(FoodType.VEGAN));
        System.out.println("factory profit by meat food: " + factory.getProfitByFoodType(FoodType.MEAT));

        FoodFactory factory2 = new FoodFactory("Milka", 20, 10000, 1000);
        System.out.println(
                factory.getName() + " is more profitable than " + factory2.getName() + ": " +
                Factory.isMoreProfitable(factory, factory2));
    }
}
