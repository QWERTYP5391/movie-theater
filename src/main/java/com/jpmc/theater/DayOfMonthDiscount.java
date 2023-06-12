package com.jpmc.theater;

public class DayOfMonthDiscount implements Discount {

    private static final int DAY_OF_THE_MONTH = 7;

    @Override
    public double apply(double movieFee) {
        return movieFee - 1;
    }

    @Override
    public boolean isEligible(Showing showing) {
        return showing.getStartTime().getDayOfMonth() == DAY_OF_THE_MONTH;
    }
}
