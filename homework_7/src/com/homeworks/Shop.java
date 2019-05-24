package com.homeworks;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Shop {
    private int bottlesCount;
    private ArrayList<Bottle> bottledWater;
    private double pricePerBottle;
    private String shopName;

    private static int invoiceCounter = 0;
    private static String invoicesDir = "./invoices/";

    public Shop(String shopName, int bottlesCount, double pricePerBottle) {
        this.bottlesCount = bottlesCount;
        this.bottledWater = new ArrayList<>();
        this.pricePerBottle = pricePerBottle;
        this.shopName = shopName;
    }

    private static String getNextInvoiceName() {
        Shop.invoiceCounter += 1;

        return "invoice_" + Shop.invoiceCounter + ".txt";
    }

    private void saveInvoice(int itemsCount, String buyer) {
        String fileName = Shop.getNextInvoiceName();
        String invoicesDir = "./invoices/";
        new File(invoicesDir).mkdirs();
        File outFile = new File(invoicesDir + fileName);

        try (PrintWriter out = new PrintWriter(outFile)) {
            out.println("invoice number: " + Shop.invoiceCounter);
            out.println("provider: " + this.shopName);
            out.println("buyer: " + buyer);
            out.println("date: " + new Date());
            out.println("number of sold bottles: " + itemsCount);
            out.println("price per item: " + this.pricePerBottle);
            out.println("purchase price: " + this.pricePerBottle * itemsCount);
        } catch (FileNotFoundException e) {
            System.out.println("Can not write to file!");
        }
    }

    public void printAllInvoices() {
        File folder = new File(Shop.invoicesDir);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            try {
                List<String> lines = Files.readAllLines(Path.of(file.getPath()));

                for (String line : lines) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Could not read invoice!");
            }

            System.out.println();
        }
    }

    public void deliverBottles(int count) {
        this.bottlesCount += count;
    }

    public void bottleWater(int count, BottleType bottleType) throws InsufficientNumberOfBottelsException {
        if (count <= this.bottlesCount) {
            for (int i = 0; i < count; i++) {
                this.bottledWater.add(new Bottle(
                        bottleType,
                        BottleContent.WATER,
                        0.5,
                        this.pricePerBottle));
            }

            this.bottlesCount -= count;
        } else {
            throw new InsufficientNumberOfBottelsException("The shop does not have enough bottles!");
        }
    }

    public ArrayList<Bottle> buyBottledWater(int count, String buyerName) {
        ArrayList<Bottle> result = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            result.add(this.bottledWater.get(this.bottledWater.size() - 1));
            this.bottledWater.remove(this.bottledWater.size() - 1);
        }

        this.saveInvoice(count, buyerName);

        return result;
    }
}
