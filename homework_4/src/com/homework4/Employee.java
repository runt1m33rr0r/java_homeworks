package com.homework4;

enum ContractType {
    PERMANENT, PART_TIME, TRAINEE
}

class Employee {

    private String name;
    private int id;
    private int workingHours;
    private double additionalPayment;
    private ContractType contract;

    private static int currentId = 0;

    Employee(String name, int workingHours, ContractType contract, double additionalPayment) {
        this.name = name;
        this.workingHours = workingHours;
        this.additionalPayment = additionalPayment;
        this.id = Employee.generateId();
        this.contract = contract;
    }

    String getName() {
        return this.name;
    }

    ContractType getContract() {
        return this.contract;
    }

    int getId() {
        return this.id;
    }

    int getWorkingHours() {
        return this.workingHours;
    }

    double getMinSalary() {
        switch(contract) {
            case PART_TIME:
                return 1;
            case TRAINEE:
                return 0.5;
            default:
                return 5;
        }
    }

    double getAdditionalPayment() {
        return this.additionalPayment;
    }

    double getSalary() {
        return this.getWorkingHours() * this.getMinSalary() + this.getAdditionalPayment();
    }

    void setAdditionalPayment(double newPayment) {
        this.additionalPayment = newPayment;
    }

    @Override
    public String toString() {
        return "name: " + this.getName() + "\nid: " + this.getId() + "\nhours worked: " + this.getWorkingHours() +
                "\nminimum salary: " + this.getMinSalary() + "\nadditional payment: " + this.getAdditionalPayment() +
                "\nsalary: " + this.getSalary();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            Employee other = (Employee)obj;

            return this.getId() == other.getId();
        }

        return false;
    }

    private static int generateId() {
        int value = Employee.currentId;
        Employee.currentId += 1;

        return value;
    }
}
