package edu.au.cpsc.module4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ScheduledFlightTest {

    private AirlineDatabase database;
    private ScheduledFlight flight1;
    private ScheduledFlight flight2;

    @BeforeEach
    void setUp() {
        database = new AirlineDatabase();

        // Setup flight1
        flight1 = new ScheduledFlight();
        flight1.setFlightDesignator("DL1331");
        flight1.setDepartureAirportIdent("KPIT");
        flight1.setDepartureTime(LocalTime.of(13, 30)); // 1:30 PM
        flight1.setArrivalAirportIdent("KATL");
        flight1.setArrivalTime(LocalTime.of(15, 0)); // 3:00 PM
        HashSet<DayOfWeek> days1 = new HashSet<>();
        days1.add(DayOfWeek.MONDAY);
        days1.add(DayOfWeek.FRIDAY);
        flight1.setDaysOfWeek(days1);

        // Setup flight2
        flight2 = new ScheduledFlight();
        flight2.setFlightDesignator("DL2002");
        flight2.setDepartureAirportIdent("KLAX");
        flight2.setDepartureTime(LocalTime.of(14, 0)); // 2:00 PM
        flight2.setArrivalAirportIdent("KJFK");
        flight2.setArrivalTime(LocalTime.of(22, 0)); // 10:00 PM
        HashSet<DayOfWeek> days2 = new HashSet<>();
        days2.add(DayOfWeek.WEDNESDAY);
        days2.add(DayOfWeek.SUNDAY);
        flight2.setDaysOfWeek(days2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getFlightDesignator() {
        ScheduledFlight flight = new ScheduledFlight();
    }

    @Test
    void setFlightDesignator() {
        ScheduledFlight flight = new ScheduledFlight();
        assertThrows(IllegalArgumentException.class, () -> flight.setFlightDesignator(null));
    }

    @Test
    void getDepartureAirportIdent() {
        ScheduledFlight flight = new ScheduledFlight();
    }

    @Test
    void setDepartureAirportIdent() {
        ScheduledFlight flight = new ScheduledFlight();
        assertThrows(IllegalArgumentException.class, () -> flight.setDepartureAirportIdent(null));
    }

    @Test
    void getDepartureTime() {
        ScheduledFlight flight = new ScheduledFlight();
    }

    @Test
    void setDepartureTime() {
        ScheduledFlight flight = new ScheduledFlight();
        assertThrows(IllegalArgumentException.class, () -> flight.setDepartureTime(null));
    }

    @Test
    void getArrivalAirportIdent() {
        ScheduledFlight flight = new ScheduledFlight();
    }

    @Test
    void setArrivalAirportIdent() {
        ScheduledFlight flight = new ScheduledFlight();
        assertThrows(IllegalArgumentException.class, () -> flight.setArrivalAirportIdent(null));
    }

    @Test
    void getArrivalTime() {
        ScheduledFlight flight = new ScheduledFlight();
    }

    @Test
    void setArrivalTime() {
        ScheduledFlight flight = new ScheduledFlight();
        assertThrows(IllegalArgumentException.class, () -> flight.setArrivalTime(null));
    }

    @Test
    void getDaysOfWeek() {
        assertThrows(IllegalArgumentException.class, () -> flight1.setDaysOfWeek(null), "Setting daysOfWeek to null should throw IllegalArgumentException");
    }

    @Test
    void setDaysOfWeek() {
        HashSet<DayOfWeek> days = new HashSet<>();
        days.add(DayOfWeek.TUESDAY);
        flight1.setDaysOfWeek(days);
        assertEquals(days, flight1.getDaysOfWeek(), "DaysOfWeek should be set correctly to a valid HashSet");
    }

    @Test
    void getDayOfWeek() {
        flight1.setDaysOfWeek(null);
    }
}