package com.homework3;

import java.util.ArrayList;
import java.util.Arrays;

public class Store {

    private Device[] devices;

    Store() {
        this.devices = new Device[3];

        Maker maker = new Maker("Pesho",true);
        this.devices[0] = new WashingMachine(maker, 20, 12, 90, true);
        this.devices[1] = new Device(maker, 30, 10);
        this.devices[2] = new ElectricOven(maker, 40, 16);
    }

    ArrayList<String> getCatalogue() {
        ArrayList<String> deviceCatalogue = new ArrayList<>();
        for (Device device : this.devices) {
            deviceCatalogue.add(device.toString());
        }

        return deviceCatalogue;
    }

    Device buyDevice(int deviceID, Customer cust) {
        Device dev = this.devices[deviceID];

        if (cust.takeMoney(dev.getPrice()) > 0) {
            return dev;
        }

        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.devices);
    }
}
