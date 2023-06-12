package com.jpmc.theater;

public class SecondOfDayDiscount implements Discount {
    @Override
    public double apply(double movieFee) {
        return movieFee - 2;
    }

    @Override
    public boolean isEligible(Showing showing) {
        return showing.getSequenceOfTheDay() == 2;
    }
}
