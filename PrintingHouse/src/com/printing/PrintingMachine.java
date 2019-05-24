package com.printing;

import java.io.Serializable;

public class PrintingMachine implements Serializable {
    private String name;
    private int maxPaperSheetsCount;
    private int paperSheetsCount;
    private int pagesPerMinute;

    public PrintingMachine(
            String name,
            int maxPaperSheetsCount,
            int paperSheetsCount,
            int pagesPerMinute) {
        this.name = name;
        this.maxPaperSheetsCount = maxPaperSheetsCount;
        this.paperSheetsCount = paperSheetsCount;
        this.pagesPerMinute = pagesPerMinute;
    }

    public String getName() {
        return this.name;
    }
    
    public int getMaxPaperSheetsCount() {
        return this.maxPaperSheetsCount;
    }

    public int getPaperSheetsCount() {
        return this.paperSheetsCount;
    }

    public int getPagesPerMinute() {
        return this.pagesPerMinute;
    }

    public void loadPaperSheets(int sheetsCount) {
        if (this.paperSheetsCount + sheetsCount <= this.maxPaperSheetsCount) {
            this.paperSheetsCount += sheetsCount;
        }
    }

    public void printPages(int pagesCount, PaperType paperType, InkType inkType) throws NoPaperException {
        if (pagesCount > this.paperSheetsCount || this.paperSheetsCount == 0) {
            throw new NoPaperException(this);
        }

        int timeForOnePage = 1000 / this.pagesPerMinute;
        try {
            for (int i = 1; i <= pagesCount; i++) {
                System.out.println("Machine " + this.name + " is printing page " + i + " out of " +
                        pagesCount + " with " + inkType + " ink and " + paperType + " paper.");

                this.paperSheetsCount--;
                Thread.sleep(timeForOnePage);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
