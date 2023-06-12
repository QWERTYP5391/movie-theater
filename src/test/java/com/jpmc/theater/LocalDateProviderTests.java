package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LocalDateProviderTests {

    @Test
    void testSingletonInstance() {
        assertNotNull(LocalDateProvider.singleton());
    }

    @Test
    void testCurrentDate() {
        final LocalDateProvider localDateProvider = LocalDateProvider.singleton();
        final LocalDate localDate = localDateProvider.currentDate();
        assertEquals(localDate, LocalDate.now());
    }
}
