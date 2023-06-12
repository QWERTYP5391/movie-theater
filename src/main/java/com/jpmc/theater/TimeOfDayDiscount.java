package com.jpmc.theater;

import java.time.LocalDate;

public class TimeOfDayDiscount implements Discount {
    @Override
    public double apply(double movieFee) {
        return movieFee * 0.75;
    }

    @Override
    public boolean isEligible(Showing showing) {
        return showing.getStartTime().isEqual(LocalDate.now().atTime(11, 0)) || (showing.getStartTime().isAfter(LocalDate.now().atTime(11, 0)) &&
                showing.getStartTime().isBefore(LocalDate.now().atTime(16, 0)));
    }
}
