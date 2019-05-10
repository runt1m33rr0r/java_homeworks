package com.homework5;

public class Box {

    private double width;
    private double height;
    private double depth;

    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public double getVolume() {
        return this.width * this.height * this.depth;
    }

    @Override
    public String toString() {
        return "---box---\nwidth: " + this.width + "\nheight: " + this.height + "\ndepth: " + this.depth +
                "\nvolume: " + this.getVolume() + "\n---box---";
    }
}
