package com.homework5;

import java.util.ArrayList;

class Item implements IShipment {

    private String address;
    private double deliveryPrice;
    private ArrayList<Element> elements;
    private Box box;

    Item(String address, double deliveryPrice, ArrayList<Element> elements, Box box) {
        this.address = address;
        this.deliveryPrice = deliveryPrice;
        this.elements = elements;
        this.box = box;
    }

    void addElement(Element newElement) {
        this.elements.add(newElement);
    }

    double getWeight() {
        double result = 0;

        for (Element el : this.elements) {
            result += el.getWeight();
        }

        return result;
    }

    public double shippingPrice() {
        return this.deliveryPrice;
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
}
