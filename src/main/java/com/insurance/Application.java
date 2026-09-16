package com.insurance;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        InsurancePremiumCalculator calculator =
                new InsurancePremiumCalculator();

        double premium = calculator.calculatePremium(65, 10000);

        List<Nominee> nominees = List.of(
                new Nominee("Nominee A", 50),
                new Nominee("Nominee B", 50)
        );

        NomineeService nomineeService = new NomineeService();

        System.out.println("Insurance Premium Application Started");
        System.out.println("Premium: " + premium);
        System.out.println("Nominee Allocation Valid: "
                + nomineeService.isValidAllocation(nominees));
    }
}
