package com.homework4;

public class Main {

    public static void main(String[] args) {
	    Employee em1 = new Employee("Pesho", 20, ContractType.PERMANENT, 10);
        Employee em2 = new Employee("Gosho", 60, ContractType.PART_TIME, 1);
        Company company = new Company("Vivacom", 30);

	    company.hireEmployee(em1);
	    company.hireEmployee(em2);

        System.out.println();
	    company.printCompanyData();

        System.out.println();
        System.out.println(company.showEmployeeList());
        company.increaseAllEmployeesPayment(100);
        company.increaseEmployeePayment(0, 100);
        System.out.println();
        System.out.println(company.showEmployeeList());

        company.fireEmployee(1);
        System.out.println();
        System.out.println(company.showEmployeeList());
    }
}
