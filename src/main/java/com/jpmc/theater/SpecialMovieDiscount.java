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

//### Current Features
//        * Customer can make a reservation for the movie
//        * And, system can calculate the ticket fee for customer's reservation
//        * Theater have a following discount rules
//        * 20% discount for the special movie
//        * $3 discount for the movie showing 1st of the day
//        * $2 discount for the movie showing 2nd of the day
//        * System can display movie schedule with simple text format
//
//        ## New Requirements
//        * New discount rules; In addition to current rules
//        * Any movies showing starting between 11AM ~ 4pm, you'll get 25% discount
//        * Any movies showing on 7th, you'll get 1$ discount
//        * The discount amount applied only one if met multiple rules; biggest amount one
//        * We want to print the movie schedule with simple text & json format
