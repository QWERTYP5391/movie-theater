package com.jpmc.theater;

public interface Discount {

    double apply(double movieFee);

    boolean isEligible(Showing showing);

}
