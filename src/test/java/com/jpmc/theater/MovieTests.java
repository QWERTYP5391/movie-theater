package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTests {
//    @Test
//    void specialMovieWith50PercentDiscount() {
//        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
//        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
//        assertEquals(10, spiderMan.calculateTicketPrice(showing));
//
//        System.out.println(Duration.ofMinutes(90));
//    }

    @Test
    void testCalculateTicketPriceWithSpecialMovieDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        assertEquals(10, spiderMan.calculateTicketPrice(showing));
    }


    @Test
    void testCalculateTicketPriceWith1stOfTheDayDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        assertEquals(9.5, spiderMan.calculateTicketPrice(showing));

    }

    @Test
    void testCalculateTicketPriceWith2ndOfTheDayDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        assertEquals(10.5, spiderMan.calculateTicketPrice(showing));
    }


    @Test
    void testCalculateTicketPriceWithBetween11AMAnd4pmDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12, 0);
        Showing showing = new Showing(spiderMan, 3, LocalDate.now().atTime(11, 1));
        assertEquals(9, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void testCalculateTicketPriceWithOn7thDiscount() {

        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12, 0);
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.now().getYear(), LocalDateTime.now().getMonth(), 7, 0, 0));
        assertEquals(11, spiderMan.calculateTicketPrice(showing));

    }
}
