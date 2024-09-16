package edu.au.cpsc.module4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;
class AirlineDatabaseTest {

    private AirlineDatabase database;
    private ScheduledFlight flight1;
    private ScheduledFlight flight2;

    @Test
    void getScheduledFlights() {
        database.addScheduledFlight(flight1);
        database.addScheduledFlight(flight2);
        Set<ScheduledFlight> flights = (Set<ScheduledFlight>) database.getScheduledFlights();
        assertEquals(2, flights.size(), "There should be 2 flights in the database");
        assertTrue(flights.contains(flight1), "Flight 1 should be in the database");
        assertTrue(flights.contains(flight2), "Flight 2 should be in the database");
    }

    @Test
    void addScheduledFlight() {
        database.addScheduledFlight(flight1);
        database.addScheduledFlight(flight2);
        Set<ScheduledFlight> flights = (Set<ScheduledFlight>) database.getScheduledFlights();
        assertTrue(flights.contains(flight1), "Flight 1 should be added to the database");
        assertTrue(flights.contains(flight2), "Flight 2 should be added to the database");
    }

    @Test
    void removeScheduledFlight() {
        database.addScheduledFlight(flight1);
        database.removeScheduledFlight(flight1);
        Set<ScheduledFlight> flights = (Set<ScheduledFlight>) database.getScheduledFlights();
        assertFalse(flights.contains(flight1), "Flight 1 should be removed from the database");
        assertFalse(flights.contains(flight2), "Flight 2 should be removed from the database");
    }

    @Test
    void updateScheduledFlight() {
        database.addScheduledFlight(flight1);

        // Update arrival time
        flight1.setArrivalTime(LocalTime.of(15, 30)); // 3:30 PM
        database.updateScheduledFlight(flight1);

        Set<ScheduledFlight> flights = (Set<ScheduledFlight>) database.getScheduledFlights();
        for (ScheduledFlight flight : flights) {
            if (flight.equals(flight1)) {
                assertEquals(LocalTime.of(15, 30), flight.getArrivalTime(), "Arrival time should be updated");
            }
        }
    }
}