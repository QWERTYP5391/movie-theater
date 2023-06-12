package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import static com.jpmc.theater.MovieConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class MovieTests {


    @Test
    void testIsMovieSpecialPositive() {
        assertTrue(new Movie(TEST_MOVIE_TITLE, TEST_MOVIE_RUNNING_TIME, TEST_TICKET_PRICE, Movie.MOVIE_CODE_SPECIAL).isMovieSpecial());
    }

    @Test
    void testIsMovieSpecialNegative() {
        assertFalse(new Movie(TEST_MOVIE_TITLE, TEST_MOVIE_RUNNING_TIME, TEST_TICKET_PRICE, 0).isMovieSpecial());
    }
}
