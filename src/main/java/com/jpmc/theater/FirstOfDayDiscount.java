package com.jpmc.theater;

public class FirstOfDayDiscount implements Discount {
    @Override
    public double apply(double movieFee) {
        return movieFee - 3;
    }

    @Override
    public boolean isEligible(Showing showing) {
        return showing.getSequenceOfTheDay() == 1;
    }
}
