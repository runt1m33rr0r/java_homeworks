package com.printing;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PrintingHouse printingHouse = new PrintingHouse(
                "Printing house 1",
                1000,
                2000,
                10,
                30,
                3,
                5);

        printingHouse.hireManager("Manager1");
        printingHouse.hireOperator("Operator1");

        Client client1 = new Client("Client1", 9000);

        ArrayList<Issue> issuesToPrint = new ArrayList<>();
        issuesToPrint.add(new Issue("Issue1", 30, PageSize.A5));
        issuesToPrint.add(new Issue("Issue2", 50, PageSize.A4));
        issuesToPrint.add(new Issue("Issue3", 5, PageSize.A5));

        printingHouse.printIssues(client1, issuesToPrint, PaperType.GLOSSY, InkType.COLOR);

        String dataFilePath = "./printing_house.txt";
        FileManager.saveStringToFile(printingHouse.toString(), dataFilePath);
        String printingHouseData = FileManager.readStringFromFile(dataFilePath);
        System.out.println(printingHouseData);
        
        String serializationPath = "./printing_house.serial";
        FileManager.serializePrintingHouse(printingHouse, serializationPath);
        printingHouse = FileManager.deserializePrintingHouse(serializationPath);
        System.out.println(printingHouse);
    }
}
