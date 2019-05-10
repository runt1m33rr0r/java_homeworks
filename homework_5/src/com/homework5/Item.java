package com.homework5;

import java.util.ArrayList;

public abstract class Item implements IShipment {

    private String address;
    private double deliveryPrice;
    private ArrayList<Element> elements;
    private int elementsCount;
    private Box box;

    public Item(String address, double deliveryPrice, ArrayList<Element> elements, Box box) {
        this.address = address;
        this.deliveryPrice = deliveryPrice;
        this.box = box;
        this.elements = elements;
        this.elementsCount = this.elements.size();
    }

    public void addElement(Element newElement) {
        this.elements.add(newElement);
        this.elementsCount += 1;
    }

    public double getWeight() {
        double result = 0;

        for (Element el : this.elements) {
            result += el.getWeight();
        }

        return result;
    }

    public int getElementsCount() {
        return this.elementsCount;
    }

    public double shippingPrice() {
        return this.deliveryPrice * this.getWeight();
    }

    public double getDeliveryPricePerKg() {
        return this.deliveryPrice;
    }

    public ArrayList<Element> getElements() {
        return this.elements;
    }

    public String getAddress() {
        return this.address;
    }

    public Box getBox() {
        return this.box;
    }

    @Override
    public String toString() {
        return "address: " + this.getAddress() +
                "\ndelivery price per kg: " + this.getDeliveryPricePerKg() +
                "\nshipping price: " + this.shippingPrice() +
                "\nelements count: " + this.getElementsCount() +
                "\n" + this.getElements().toString() +
                "\n" + this.getBox().toString();
    }
}
