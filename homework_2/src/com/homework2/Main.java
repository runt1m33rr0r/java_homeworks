package com.homework2;

public class Main {

    public static void main(String[] args) {
        double minPrice = 3;

        Director director1 = new Director("Pesho", 40);
	    MusicCompany company1 = new MusicCompany("Company1", director1,20,5, minPrice);
        company1.setPricePerHour(10);
        company1.decreasePrice(5);

	    Customer customer1 = new Customer(200);
	    company1.getHired(customer1, 3);

	    Director director2 = new Director("Gosho", 45);
	    MusicCompany company2 = new MusicCompany("Company2", director2, 15, 6, minPrice);
	    company2.setPricePerHour(7);
        company2.decreasePrice(6);

	    Customer customer2 = new Customer(300);
	    company2.getHired(customer2, 4);

	    printCompany(company1);
	    printCompany(company2);

	    // -1 for less, 1 for bigger, 0 for equal
	    int res1 = company1.compareByDirector(company2);
	    int res2 = company1.compareByPrice(company2);

        System.out.println("company1 compared to company2 by director: " + res1);
        System.out.println("company1 compared to company2 by price per hour: " + res2);
    }

    private static void printCompany(MusicCompany company)
    {
        System.out.println("company: " + company.getName());
        System.out.println("   director: " + company.getDirector().getName());
        System.out.println("   price per hour: " + company.getPricePerHour());
        System.out.println("   daily income: " + company.getDailyIncome());
        System.out.println("   daily income dollar: " + company.getDailyIncomeDollar());
        System.out.println("   daily income euro: " + company.getDailyIncomeEuro());
    }
}