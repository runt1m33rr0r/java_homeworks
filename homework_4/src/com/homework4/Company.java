package com.homework4;

import java.util.ArrayList;

class Company {

    private ArrayList<Employee> employees;
    private String name;
    private int maxEmployeesCount;

    Company(String name, int maxEmployeesCount) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.maxEmployeesCount = maxEmployeesCount;
    }

    private Employee findEmployeeById(int id) {
        Employee result = null;

        for (Employee em : this.employees) {
            if (em.getId() == id) {
                result = em;
            }
        }

        return result;
    }

    String getName() {
        return this.name;
    }

    int getMaxEmployeesCount() {
        return this.maxEmployeesCount;
    }

    void hireEmployee(Employee someone) {
        if (this.employees.size() < this.maxEmployeesCount) {
            this.employees.add(someone);
        }
    }

    void fireEmployee(int employeeId) {
        Employee em = this.findEmployeeById(employeeId);

        if (em != null) {
            this.employees.remove(em);
        }
    }

    String showEmployeeList() {
        return this.employees.toString();
    }

    double getSalariesSum() {
        double result = 0;

        for (Employee someone : this.employees) {
            result += someone.getSalary();
        }

        return result;
    }

    double getAverageSalary() {
        return this.getSalariesSum() / this.employees.size();
    }

    void increaseEmployeePayment(int employeeId, double percentage) {
        Employee em = this.findEmployeeById(employeeId);

        if (em != null) {
            double increase = em.getAdditionalPayment() * percentage / 100;
            em.setAdditionalPayment(em.getAdditionalPayment() + increase);
        }
    }

    void increaseAllEmployeesPayment(double percentage) {
        for (Employee em : this.employees) {
            double increase = em.getAdditionalPayment() * percentage / 100;
            em.setAdditionalPayment(em.getAdditionalPayment() + increase);
        }
    }

    double getAverageSalaryByContract(ContractType contract) {
        int count = 0;
        double result = 0;

        for (Employee em : this.employees) {
            if (em.getContract() == contract) {
                count += 1;
                result += em.getSalary();
            }
        }

        return result / count;
    }

    void printCompanyData() {
        System.out.println(
                "name: " + this.getName() +
                "\nmax number of employees: " + this.getMaxEmployeesCount() +
                "\nnumber of hired employees: " + this.employees.size());
    }
}
