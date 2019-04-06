package com.homework5;

import java.util.ArrayList;
import java.util.Arrays;

abstract class Item implements IShipment {

    private String address;
    private double deliveryPrice;
    private ArrayList<Element> elements;
    private int elementsCount;
    private Box box;

    Item(String address, double deliveryPrice, int elementsCount, Box box) {
        this.address = address;
        this.deliveryPrice = deliveryPrice;
        this.elementsCount = elementsCount;
        this.box = box;
        this.elements = new ArrayList<>();
    }

    void addElement(Element newElement) {
        this.elements.add(newElement);
        this.elementsCount += 1;
    }

    double getWeight() {
        double result = 0;

        for (Element el : this.elements) {
            result += el.getWeight();
        }

        return result;
    }

    int getElementsCount() {
        return this.elementsCount;
    }

    public double shippingPrice() {
        return this.deliveryPrice * this.getWeight();
    }

    ArrayList<Element> getElements() {
        return this.elements;
    }

    String getAddress() {
        return this.address;
    }

    Box getBox() {
        return this.box;
    }

    @Override
    public String toString() {
        return "address: " + this.getAddress() +
                "\ndelivery price: " + this.deliveryPrice +
                "\nelements count: " + this.getElementsCount() +
                "\nelements: " + this.getElements().toString() +
                "\nbox: " + this.getBox().toString();
    }
}
