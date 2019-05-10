package com.homework5;

public class Material {

    private String name;
    private boolean isBreakable;

    public Material(String name, boolean isBreakable) {
        this.name = name;
        this.isBreakable = isBreakable;
    }

    public String getName() {
        return this.name;
    }

    public boolean getBreakable() {
        return this.isBreakable;
    }

    @Override
    public String toString() {
        return "---material---\nname: " + this.getName() + "\nis breakable: " + this.isBreakable +
                "\n---material---";
    }
}
