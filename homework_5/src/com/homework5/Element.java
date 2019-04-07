package com.homework5;

public class Element {

    private Material material;
    private double weight;

    public Element(double weight, Material material) {
        this.material = material;
        this.weight = weight;
    }

    public boolean isBreakable() {
        return this.material.getBreakable();
    }

    public double getWeight() {
        return this.weight;
    }

    public Material getMaterial() {
        return this.material;
    }

    @Override
    public String toString() {
        return "\n---element---\nweight: " + this.getWeight() + "\n" + this.getMaterial().toString() +
                "\n---element---";
    }
}
