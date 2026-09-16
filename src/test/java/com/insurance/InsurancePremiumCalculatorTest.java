package com.insurance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InsurancePremiumCalculatorTest {

    @ParameterizedTest
    @CsvSource({
        "65, 10000, 9000",
        "60, 10000, 9000",
        "59, 10000, 10000",
        "30, 10000, 10000"
    })
    void shouldCalculatePremiumCorrectly(int age, double basePremium, double expectedPremium) {

        InsurancePremiumCalculator calculator =
                new InsurancePremiumCalculator();

        double result = calculator.calculatePremium(age, basePremium);

        assertEquals(expectedPremium, result);
    }
}
