package com.homework5;

class Box {

    private double width;
    private double height;
    private double depth;

    Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    double getVolume() {
        return this.width * this.height * this.depth;
    }
}
