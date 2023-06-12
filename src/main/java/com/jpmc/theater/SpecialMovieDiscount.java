package com.jpmc.theater;

public class SpecialMovieDiscount implements Discount {
    @Override
    public double apply(double movieFee) {
        return movieFee * 0.8;
    }

    @Override
    public boolean isEligible(Showing showing) {
        return showing.getMovie().isMovieSpecial();
    }
}
