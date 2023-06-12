package com.jpmc.theater;

import java.util.List;

public class Reservation {
    private Customer customer;
    private Showing showing;
    private int audienceCount;
    private List<Discount> listOfDiscounts;

    public Reservation(Customer customer, Showing showing, int audienceCount, List<Discount> listOfDiscounts) {
        this.customer = customer;
        this.showing = showing;
        this.audienceCount = audienceCount;
        this.listOfDiscounts = listOfDiscounts;
    }

    public double totalFee() {
        double totalFee = Double.MAX_VALUE;

        for (Discount discount : listOfDiscounts) {
            if (discount.isEligible(showing)) {
                totalFee = Math.min(totalFee, discount.apply(showing.getMovieFee()));
            }
        }

        return Math.min(showing.getMovieFee(), totalFee) * audienceCount;
    }
}