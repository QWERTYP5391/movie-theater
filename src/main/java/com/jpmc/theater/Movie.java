package com.jpmc.theater;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Movie {
    private static int MOVIE_CODE_SPECIAL = 1;

    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;
    private int specialCode;

    public Movie(String title, Duration runningTime, double ticketPrice, int specialCode) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }

    public String getTitle() {
        return this.title;
    }

    public Duration getRunningTime() {
        return this.runningTime;
    }

    public double getTicketPrice() {
        return this.ticketPrice;
    }

    public int getSpecialCode() {
        return this.specialCode;
    }

    public double calculateTicketPrice(Showing showing) {
        return ticketPrice - getDiscount(showing);
    }

    public boolean isMovieSpecial() {
        return this.specialCode == MOVIE_CODE_SPECIAL;
    }

    private double getDiscount(Showing showing) {
        int showSequence = showing.getSequenceOfTheDay();
        double timeDiscount = 0;
        double specialDiscount = 0;
        double dateDiscount = 0;
        if (MOVIE_CODE_SPECIAL == specialCode) {
            specialDiscount = ticketPrice * 0.2;  // 20% discount for special movie
        }

        double sequenceDiscount = 0;
        if (showSequence == 1) {
            sequenceDiscount = 3; // $3 discount for 1st show
        } else if (showSequence == 2) {

            sequenceDiscount = 2; // $2 discount for 2nd show
        } else if (showing.getStartTime().isEqual(LocalDate.now().atTime(11, 0)) || (showing.getStartTime().isAfter(LocalDate.now().atTime(11, 0)) &&
                showing.getStartTime().isBefore(LocalDate.now().atTime(16, 0)))) {
            timeDiscount = showing.getMovieFee() * 0.25;
        } else if (showing.getStartTime().getDayOfMonth() == 7) {
            dateDiscount = 1;
        }
//        else {
//            throw new IllegalArgumentException("failed exception");
//        }

        // biggest discount wins
        return Math.max(specialDiscount, Math.max(sequenceDiscount, Math.max(timeDiscount, dateDiscount)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.ticketPrice, ticketPrice) == 0
                && Objects.equals(title, movie.title)
                && Objects.equals(description, movie.description)
                && Objects.equals(runningTime, movie.runningTime)
                && Objects.equals(specialCode, movie.specialCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
    }
}