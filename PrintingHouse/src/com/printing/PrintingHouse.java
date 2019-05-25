package com.printing;

import java.io.Serializable;
import java.util.ArrayList;

public class PrintingHouse implements Serializable {
    private ArrayList<Employee> managers;
    private ArrayList<Employee> operators;
    private ArrayList<Issue> printedIssues;
    private PrintingMachine firstMachine;
    private PrintingMachine secondMachine;
    private String name;
    private double baseEmployeeSalary;
    private double salaryBonusThreshold;
    private double salaryBonusPercent;
    private double issueOverchargePercent;
    private double salesIncome;
    private double printCosts;
    private int minIssuesForDiscount;
    private double discountPercent;

    public PrintingHouse(
            String name,
            double baseEmployeeSalary,
            double salaryBonusThreshold,
            double salaryBonusPercent,
            double issueOverchargePercent,
            int minIssuesForDiscount,
            double discountPercent) {
        this.name = name;
        this.baseEmployeeSalary = baseEmployeeSalary;
        this.salaryBonusPercent = salaryBonusPercent;
        this.salaryBonusThreshold = salaryBonusThreshold;
        this.issueOverchargePercent = issueOverchargePercent;
        this.minIssuesForDiscount = minIssuesForDiscount;
        this.discountPercent = discountPercent;
        this.printedIssues = new ArrayList<>();
        this.managers = new ArrayList<>();
        this.operators = new ArrayList<>();
        this.salesIncome = 0;
        this.printCosts = 0;
        this.firstMachine = new PrintingMachine("Machine1", 10, 5, 5);
        this.secondMachine = new PrintingMachine("Machine2", 20, 10, 5);
    }

    public String getName() {
        return this.name;
    }

    private void addIncome(double amount) {
        this.salesIncome += amount;
        this.updateSalaries();
    }

    private void addCosts(double amount) {
        this.printCosts += amount;
        this.updateSalaries();
    }

    private double calculateManagerSalary() {
        double salary = this.baseEmployeeSalary;
        if (this.calculateIncome() > this.salaryBonusThreshold) {
            salary += this.salaryBonusPercent * this.baseEmployeeSalary / 100.0;
        }

        return salary;
    }

    private void updateSalaries() {
        for (Employee manager : this.managers) {
            manager.setSalary(this.calculateManagerSalary());
        }
    }

    private double calculateIssuePaperCost(Issue issue, PaperType paperType) {
        double issuePageSizePrice = PageSize.getPriceBySize(issue.getPageSize());
        double issuePageTypePrice = PaperType.getPriceByPaperType(paperType);
        return (issuePageSizePrice + issuePageTypePrice) * issue.getPagesCount();
    }

    private double calculateIssuePrintingPrice(Issue issue, PaperType paperType, boolean shouldDiscount) {
        double paperCost = this.calculateIssuePaperCost(issue, paperType);
        double addedCost = paperCost * this.issueOverchargePercent / 100.0;
        double discountedCost = paperCost * this.discountPercent / 100.0;

        if (shouldDiscount) {
            return paperCost + addedCost - discountedCost;
        } else {
            return paperCost + addedCost;
        }
    }

    private void printOneIssue(Issue issue, PaperType paperType, InkType inkType) {
        PrintTask task = new PrintTask(this.firstMachine, this, issue, paperType, inkType);

        try {
            task.thread.join();
            this.printedIssues.add(issue);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadMachine(PrintingMachine machine) {
        System.out.println("Loading machine " + machine.getName() + " with paper.");

        int pagesToLoad = machine.getMaxPaperSheetsCount() - machine.getPaperSheetsCount();
        machine.loadPaperSheets(pagesToLoad);
    }

    public void hireManager(String name) {
        double salary = this.calculateManagerSalary();
        this.managers.add(new Employee(name, salary));
    }

    public void hireOperator(String name) {
        this.operators.add(new Employee(name, this.baseEmployeeSalary));
    }

    public double calculateCosts() {
        double salaryCosts = 0;
        for (Employee manager : this.managers) {
            salaryCosts += manager.getSalary();
        }

        for (Employee operator : this.operators) {
            salaryCosts += operator.getSalary();
        }

        return salaryCosts + this.printCosts;
    }

    public double calculateIncome() {
        return this.salesIncome - this.calculateCosts();
    }

    public void printIssues(Client client, ArrayList<Issue> issues, PaperType paperType, InkType inkType) {
        if (issues.size() == 0) {
            return;
        }

        double issuesPrintPrice = 0;
        double issuesPrintCost = 0;
        for (Issue issue : issues) {
            if (issues.size() >= this.minIssuesForDiscount) {
                issuesPrintPrice += this.calculateIssuePrintingPrice(issue, paperType, true);
            } else {
                issuesPrintPrice += this.calculateIssuePrintingPrice(issue, paperType, false);
            }

            issuesPrintCost += this.calculateIssuePaperCost(issue, paperType);
        }

        double moneyTaken = client.takeMoney(issuesPrintPrice);
        if (moneyTaken == 0) {
            return;
        }

        this.addIncome(moneyTaken);
        this.addCosts(issuesPrintCost);

        if (issues.size() >= 2) {
            for (int i = 0; i < issues.size() - 1; i += 2) {
                Issue firstIssue = issues.get(i);
                Issue secondIssue = issues.get(i + 1);
                PrintTask firstTask = new PrintTask(
                        this.firstMachine,
                        this,
                        firstIssue,
                        paperType,
                        inkType);
                PrintTask secondTask = new PrintTask(
                        this.secondMachine,
                        this,
                        secondIssue,
                        paperType,
                        inkType);

                try {
                    firstTask.thread.join();
                    secondTask.thread.join();

                    this.printedIssues.add(firstIssue);
                    this.printedIssues.add(secondIssue);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (issues.size() % 2 != 0) {
                this.printOneIssue(issues.get(issues.size() - 1), paperType, inkType);
            }
        } else if (issues.size() == 1) {
            this.printOneIssue(issues.get(0), paperType, inkType);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Printing house: ").append(this.getName()).append("\n");
        builder.append(" - income: ").append(this.calculateIncome()).append("\n");
        builder.append(" - costs: ").append(this.calculateCosts()).append("\n");
        builder.append(" - printed issues count: ").append(this.printedIssues.size()).append("\n");
        builder.append(" - printed issues list:\n");

        for (Issue issue : this.printedIssues) {
            builder.append("   * ").append(issue).append("\n");
        }

        return builder.toString();
    }
}
