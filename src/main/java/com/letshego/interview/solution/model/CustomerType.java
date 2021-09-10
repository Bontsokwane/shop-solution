package com.letshego.interview.solution.model;

public enum CustomerType {

    AFFILIATE(10),
    EMPLOYEE(30),
    LOYAL_CUSTOMER(5);

    private double discountPercentage;

    CustomerType(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }
}
