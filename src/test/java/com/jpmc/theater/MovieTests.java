package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import static com.jpmc.theater.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class MovieTests {



    @Test
    void testIsMovieSpecialPositive() {
        assertTrue(new Movie(MOVIE_TITLE, MOVIE_RUNNING_TIME, TICKET_PRICE, Movie.MOVIE_CODE_SPECIAL).isMovieSpecial());
    }

    @Test
    void testIsMovieSpecialNegative() {
        assertFalse(new Movie(MOVIE_TITLE, MOVIE_RUNNING_TIME, TICKET_PRICE, 0).isMovieSpecial());
    }
}
