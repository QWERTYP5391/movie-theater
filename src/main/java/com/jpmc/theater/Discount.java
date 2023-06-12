package com.jpmc.theater;

public interface Discount {

    public double apply(double movieFee);

    public boolean isEligible(Showing showing);

//    return Math.max(specialDiscount, Math.max(sequenceDiscount, Math.max(timeDiscount, dateDiscount)));
}
