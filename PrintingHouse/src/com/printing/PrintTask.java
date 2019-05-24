package com.printing;

public class PrintTask implements Runnable {
    private PrintingMachine machine;
    private InkType inkType;
    private PaperType paperType;
    private PrintingHouse printingHouse;
    private Issue issue;

    public Thread thread;

    public PrintTask(
            PrintingMachine machine,
            PrintingHouse printingHouse,
            Issue issue,
            PaperType paperType,
            InkType inkType) {
        this.machine = machine;
        this.issue = issue;
        this.inkType = inkType;
        this.paperType = paperType;
        this.printingHouse = printingHouse;
        this.thread = new Thread(this);

        this.thread.start();
    }

    @Override
    public void run() {
        System.out.println("Machine " + this.machine.getName() + " is printing " + this.issue.getTitle() + ".");

        int remainingPages = this.issue.getPagesCount();
        while (remainingPages > 0) {
            // load the machine if empty
            if (this.machine.getPaperSheetsCount() == 0) {
                this.printingHouse.loadMachine(this.machine);
            }

            // decide how big should be the pages batch
            int pagesToPrint = this.machine.getPaperSheetsCount();
            if (this.machine.getPaperSheetsCount() > remainingPages) {
                pagesToPrint = remainingPages;
            }

            try {
                this.machine.printPages(pagesToPrint, this.paperType, this.inkType);
                remainingPages -= pagesToPrint;
            } catch (NoPaperException e) {
                this.printingHouse.loadMachine(this.machine);
            }
        }

        System.out.println("Machine " + this.machine.getName() + " has finished printing " + this.issue.getTitle() + ".");
    }
}
