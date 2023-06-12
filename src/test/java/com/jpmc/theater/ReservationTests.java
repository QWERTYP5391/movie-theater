package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.jpmc.theater.TestConstants.TICKET_PRICE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationTests {

    public static final String TEST_CUSTOMER_NAME = "John Doe";
    public static final String TEST_CUSTOMER_ID = "unused-id";
    public static final int TEST_AUDIENCE_COUNT = 3;

    @Test
    void totalFee() {
        var customer = new Customer(TEST_CUSTOMER_NAME, TEST_CUSTOMER_ID);
        var showing = new Showing(
                new Movie(TestConstants.MOVIE_TITLE, TestConstants.MOVIE_RUNNING_TIME, TICKET_PRICE, Movie.MOVIE_CODE_SPECIAL),
                1,
                LocalDateTime.now()
        );
//        assertEquals(37.5, new Reservation(customer, showing, 3).totalFee());
    }

    @Test
    void testTotalFeeWithSpecialMovieDiscount() {
        var customer = new Customer(TEST_CUSTOMER_NAME, TEST_CUSTOMER_ID);
        var showing = new Showing(
                new Movie(TestConstants.MOVIE_TITLE, TestConstants.MOVIE_RUNNING_TIME, TICKET_PRICE, Movie.MOVIE_CODE_SPECIAL),
                1,
                LocalDateTime.now()
        );

        assertEquals(30.0D, new Reservation(customer, showing, TEST_AUDIENCE_COUNT, List.of(new SpecialMovieDiscount())).totalFee());
    }

    @Test
    void testTotalFeeWith1stOfTheDayDiscount() {
        var customer = new Customer(TEST_CUSTOMER_NAME, TEST_CUSTOMER_ID);
        var showing = new Showing(
                new Movie(TestConstants.MOVIE_TITLE, TestConstants.MOVIE_RUNNING_TIME, TICKET_PRICE, Movie.MOVIE_CODE_SPECIAL),
                1,
                LocalDateTime.now()
        );

        assertEquals(28.5D, new Reservation(customer, showing, TEST_AUDIENCE_COUNT, List.of(new FirstOfDayDiscount())).totalFee());
    }

    @Test
    void testTotalFeeWith2ndOfTheDayDiscount() {
        var customer = new Customer(TEST_CUSTOMER_NAME, TEST_CUSTOMER_ID);
        var showing = new Showing(
                new Movie(TestConstants.MOVIE_TITLE, TestConstants.MOVIE_RUNNING_TIME, TICKET_PRICE, Movie.MOVIE_CODE_SPECIAL),
                2,
                LocalDateTime.now()
        );

        assertEquals(31.5D, new Reservation(customer, showing, TEST_AUDIENCE_COUNT, List.of(new SecondOfDayDiscount())).totalFee());
    }

    @Test
    void testTotalFeeWithBetween11AMAnd4PMDiscount() {
        var customer = new Customer(TEST_CUSTOMER_NAME, TEST_CUSTOMER_ID);
        var showing = new Showing(
                new Movie(TestConstants.MOVIE_TITLE, TestConstants.MOVIE_RUNNING_TIME, TICKET_PRICE, Movie.MOVIE_CODE_SPECIAL),
                2,
                LocalDate.now().atTime(11, 0)
        );

        assertEquals(28.125D, new Reservation(customer, showing, TEST_AUDIENCE_COUNT, List.of(new TimeOfDayDiscount())).totalFee());
    }

    @Test
    void testTotalFeeWithOn7thDiscount() {
        var customer = new Customer(TEST_CUSTOMER_NAME, TEST_CUSTOMER_ID);
        var showing = new Showing(
                new Movie(TestConstants.MOVIE_TITLE, TestConstants.MOVIE_RUNNING_TIME, TICKET_PRICE, Movie.MOVIE_CODE_SPECIAL),
                2,
                LocalDateTime.of(LocalDate.now().getYear(), LocalDateTime.now().getMonth(), 7, 0, 0));


        assertEquals(34.5, new Reservation(customer, showing, TEST_AUDIENCE_COUNT, List.of(new DayOfMonthDiscount())).totalFee());
    }
}

