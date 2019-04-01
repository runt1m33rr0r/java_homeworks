package com.homework5;

class Element {

    private Material material;
    private double weight;

    Element(double weight, Material material) {
        this.material = material;
        this.weight = weight;
    }

    boolean isBreakable() {
        return this.material.getBreakable();
    }

    double getWeight() {
        return this.weight;
    }

    Material getMaterial() {
        return this.material;
    }
}
