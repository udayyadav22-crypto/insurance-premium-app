package com.insurance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsurancePremiumCalculatorTest {

    @Test
    void shouldGive10PercentDiscountForAge65() {

        InsurancePremiumCalculator calculator =
                new InsurancePremiumCalculator();

        double result = calculator.calculatePremium(65, 10000);

        assertEquals(9000, result);
    }

    @Test
    void shouldGive10PercentDiscountForAge60() {

        InsurancePremiumCalculator calculator =
                new InsurancePremiumCalculator();

        double result = calculator.calculatePremium(60, 10000);

        assertEquals(9000, result);
    }

    @Test
    void shouldNotGiveDiscountForAge59() {

        InsurancePremiumCalculator calculator =
                new InsurancePremiumCalculator();

        double result = calculator.calculatePremium(59, 10000);

        assertEquals(10000, result);
    }

    @Test
    void shouldNotGiveDiscountForAge30() {

        InsurancePremiumCalculator calculator =
                new InsurancePremiumCalculator();

        double result = calculator.calculatePremium(30, 10000);

        assertEquals(10000, result);
    }
}
