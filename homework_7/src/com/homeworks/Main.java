package com.homeworks;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    Shop waterShop = new Shop("Water shop", 1000, 1.0);
	    waterShop.deliverBottles(10);

	    try {
            waterShop.bottleWater(50, BottleType.GLASS);
        } catch (InsufficientNumberOfBottelsException err) {
	        System.out.println(err.getMessage());
        }

        ArrayList<Bottle> purchase1 = waterShop.buyBottledWater(5, "Customer");
        ArrayList<Bottle> purchase2 = waterShop.buyBottledWater(3, "Customer2");

	    waterShop.printAllInvoices();

	    Bottle.serialize(purchase1.get(0));
	    Bottle deserialized = Bottle.deserialize();
	    System.out.println(deserialized);
    }
}
