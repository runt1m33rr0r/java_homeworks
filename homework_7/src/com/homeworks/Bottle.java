package com.homeworks;

import java.io.*;

public class Bottle implements Serializable {
    private BottleType type;
    private BottleContent content;
    private double volume;
    private double price;

    private static String serializationPath = "./bottle.serial";

    public Bottle(BottleType type, BottleContent content, double volume, double price) {
        this.type = type;
        this.volume = volume;
        this.content = content;
        this.price = price;
    }

    public BottleType getType() {
        return this.type;
    }

    public BottleContent getContent() {
        return this.content;
    }

    public double getVolume() {
        return this.volume;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Bottle\ntype: " + this.type + "\n" + "content: " + this.content + "\n" +
                "volume: " + this.volume + "\n" + "price: " + this.price;
    }

    public static void serialize(Bottle bottle) {
        try (FileOutputStream fos = new FileOutputStream(Bottle.serializationPath);
             ObjectOutputStream outputStream = new ObjectOutputStream(fos)) {
            outputStream.writeObject(bottle);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public static Bottle deserialize() {
        try (FileInputStream fis = new FileInputStream(Bottle.serializationPath);
             ObjectInputStream inputStream = new ObjectInputStream(fis)) {
            Bottle bottle = (Bottle)inputStream.readObject();

            return bottle;
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found: " + ex);
        } catch (IOException ex) {
            System.err.println("IO error: " + ex);
        }

        return null;
    }
}
