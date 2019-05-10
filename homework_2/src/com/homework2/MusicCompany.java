package com.homework2;

class MusicCompany {
    private String name;
    private Director director;
    private double capacity;
    private double pricePerHour;
    private double hiredHours;
    private double minPrice;

    MusicCompany(
            String name,
            Director director,
            double capacity,
            double pricePerHour,
            double minPrice) {
        this.name = name;
        this.director = director;
        this.capacity = capacity;
        this.hiredHours = 0;
        this.minPrice = minPrice;

        this.setPricePerHour(pricePerHour);
    }

    String getName() {
        return this.name;
    }

    Director getDirector() {
        return this.director;
    }

    void setPricePerHour(double price) {
        if (price >= this.minPrice) {
            this.pricePerHour = price;
        }
    }

    double getPricePerHour() {
        return this.pricePerHour;
    }

    // income in leva
    double getDailyIncome() {
        return this.pricePerHour * this.hiredHours;
    }

    double getDailyIncomeEuro() {
        return this.getDailyIncome() * 0.51;
    }

    double getDailyIncomeDollar() {
        return this.getDailyIncomeEuro() * 0.58;
    }

    void decreasePrice(int percentage) {
        double decreaseBy = (this.pricePerHour * percentage) / 100.0;

        if (this.pricePerHour - decreaseBy >= minPrice) {
            this.pricePerHour -= decreaseBy;
        }
    }

    void getHired(Customer cust, double time) {
        if (this.hiredHours + time <= this.capacity) {
            this.hiredHours += time;
            double money = cust.takeMoney(time * this.pricePerHour);
        }
    }

    int compareByDirector(MusicCompany other) {
        if (this.getDirector().getAge() < other.getDirector().getAge()) {
            return -1;
        } else if (this.getDirector().getAge() > other.getDirector().getAge()) {
            return 1;
        } else {
            return 0;
        }
    }

    int compareByPrice(MusicCompany other) {
        if (this.getPricePerHour() < other.getPricePerHour()) {
            return -1;
        } else if (this.getPricePerHour() > other.getPricePerHour()) {
            return 1;
        } else {
            return 0;
        }
    }
}
