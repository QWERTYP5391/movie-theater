package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import static com.jpmc.theater.CustomerConstants.TEST_CUSTOMER_ID;
import static com.jpmc.theater.CustomerConstants.TEST_CUSTOMER_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheaterTests {

    private Theater theater = new Theater(LocalDateProvider.singleton());

    @Test
    void totalFeeForCustomer() {
        Customer john = new Customer(TEST_CUSTOMER_NAME, TEST_CUSTOMER_ID);
        Reservation reservation = theater.reserve(john, 2, 4);
        assertEquals(37.5D, reservation.totalFee());
    }

    @Test
    void printMovieSchedule() {
        theater.printSchedule();
    }

    @Test
    void printMovieScheduleAsJson() {
        theater.printScheduleAsJson();
    }
}
