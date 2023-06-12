package com.jpmc.theater;

public class DayOfMonthDiscount implements Discount {
    @Override
    public double apply(double movieFee) {
        return movieFee - 1;
    }

    @Override
    public boolean isEligible(Showing showing) {
        return showing.getStartTime().getDayOfMonth() == 7;
    }
}
