package com.insurance;

import java.util.List;

public class NomineeService {

    public boolean isValidAllocation(List<Nominee> nominees) {

        if (nominees == null || nominees.isEmpty()) {
            return false;
        }

        double totalAllocation = nominees.stream()
                .mapToDouble(Nominee::getAllocationPercentage)
                .sum();

        return Double.compare(totalAllocation, 100.0) == 0;
    }
}
