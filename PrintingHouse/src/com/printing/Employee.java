package com.printing;

import java.io.Serializable;

public class Employee implements Serializable {
    private double salary;
    private String name;

    public Employee(String name, double salary) {
        this.salary = salary;
        this.name = name;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getName() {
        return this.name;
    }
}
