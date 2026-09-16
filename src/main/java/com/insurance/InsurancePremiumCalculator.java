package com.insurance;

public class InsurancePremiumCalculator {

    public double calculatePremium(int age, double basePremium) {

        if (age >= 60) {
            return basePremium * 0.90;
        }

        return basePremium;
    }
}
