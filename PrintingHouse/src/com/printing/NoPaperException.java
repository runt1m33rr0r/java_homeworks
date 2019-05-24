package com.printing;

public class NoPaperException extends Exception {
    public NoPaperException(PrintingMachine machine) {
        super("Machine " + machine.getName() + " has no paper in it and can be loaded with maximum " +
                machine.getMaxPaperSheetsCount() + " paper sheets.");
    }
}
