package com.printing;

import java.io.*;

public class FileManager {
    public static void saveStringToFile(String input, String filePath) {
        File outFile = new File(filePath);

        try {
            outFile.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (PrintWriter writer = new PrintWriter(outFile)) {
            writer.println(input);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String readStringFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder builder = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                builder.append(line);
                builder.append(System.lineSeparator());
                line = reader.readLine();
            }

            return builder.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return "";
    }

    public static void serializePrintingHouse(PrintingHouse printingHouse, String filePath) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filePath))) {
            output.writeObject(printingHouse);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static PrintingHouse deserializePrintingHouse(String filePath) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return (PrintingHouse)inputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }
}
