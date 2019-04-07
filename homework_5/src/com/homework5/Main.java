package com.homework5;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Element> funitureElements = new ArrayList<>();
        funitureElements.add(new Element(100, new Material("wood", false)));
        funitureElements.add(new Element(50, new Material("glass", true)));
        Item item1 = new Furniture(
                "IKEA",
                "addr",
                300,
                funitureElements,
                new Box(100, 100, 100));

        ArrayList<Element> shoesElements = new ArrayList<>();
        shoesElements.add(new Element(10, new Material("leather", false)));
        Item item2 = new Shoes(
                true,
                "shoes address",
                10,
                shoesElements,
                new Box(5, 5, 5));
        ArrayList<Item> items = new ArrayList<>();
        items.add(item1);
        CourierCompany company = new CourierCompany(items);
        company.addItem(item2);

        System.out.println(company);
    }
}
