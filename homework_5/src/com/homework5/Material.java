package com.homework5;

class Material {

    private String name;
    private boolean isBreakable;

    Material(String name, boolean isBreakable) {
        this.name = name;
        this.isBreakable = isBreakable;
    }

    String getName() {
        return this.name;
    }

    boolean getBreakable() {
        return this.isBreakable;
    }
}
