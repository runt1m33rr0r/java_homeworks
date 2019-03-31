package com.homework3;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();
        Customer cust = new Customer(900);
        Device boughtDevice = store.buyDevice(0, cust);

        // toString() uses guaranteePeriod()
        System.out.println(boughtDevice);
        System.out.println();

        boughtDevice = store.buyDevice(1, cust);
        System.out.println(boughtDevice);
        System.out.println();

        boughtDevice = store.buyDevice(2, cust);
        System.out.println(boughtDevice);
        System.out.println();
    }
}
