package com.insurance;

public class Nominee {

    private final String name;
    private final double allocationPercentage;

    public Nominee(String name, double allocationPercentage) {
        this.name = name;
        this.allocationPercentage = allocationPercentage;
    }

    public String getName() {
        return name;
    }

    public double getAllocationPercentage() {
        return allocationPercentage;
    }
}
