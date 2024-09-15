package edu.au.cpsc.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AirlineDatabaseTest {

    private AirlineDatabase database;
    private ScheduledFlight flight1;
    private ScheduledFlight flight2;

    @BeforeEach
    public void setUp() {
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

    @Test
    public void testAddScheduledFlight() {
        database.addScheduledFlight(flight1);
        Set<ScheduledFlight> flights = (Set<ScheduledFlight>) database.getScheduledFlights();
        assertTrue(flights.contains(flight1), "Flight 1 should be added to the database");
    }

    @Test
    public void testRemoveScheduledFlight() {
        database.addScheduledFlight(flight1);
        database.removeScheduledFlight(flight1);
        Set<ScheduledFlight> flights = (Set<ScheduledFlight>) database.getScheduledFlights();
        assertFalse(flights.contains(flight1), "Flight 1 should be removed from the database");
    }

    @Test
    public void testUpdateScheduledFlight() {
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

    @Test
    public void testGetScheduledFlights() {
        database.addScheduledFlight(flight1);
        database.addScheduledFlight(flight2);
        Set<ScheduledFlight> flights = (Set<ScheduledFlight>) database.getScheduledFlights();
        assertEquals(2, flights.size(), "There should be 2 flights in the database");
        assertTrue(flights.contains(flight1), "Flight 1 should be in the database");
        assertTrue(flights.contains(flight2), "Flight 2 should be in the database");
    }

    @Test
    public void testAddNullScheduledFlightThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> database.addScheduledFlight(null), "Adding a null flight should throw IllegalArgumentException");
    }

    @Test
    public void testRemoveNonexistentFlightDoesNothing() {
        database.addScheduledFlight(flight1);
        database.removeScheduledFlight(flight2); // Flight 2 was never added
        Set<ScheduledFlight> flights = (Set<ScheduledFlight>) database.getScheduledFlights();
        assertEquals(1, flights.size(), "Only flight 1 should be in the database");
    }

    @Test
    public void testSetDaysOfWeekWithEmptyHashSet() {
        HashSet<DayOfWeek> emptyDays = new HashSet<>();
        flight1.setDaysOfWeek(emptyDays);

        assertTrue(flight1.getDaysOfWeek().isEmpty(), "The daysOfWeek should be empty after setting an empty HashSet");
    }

    @Test
    public void testSetDaysOfWeekWithNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> flight1.setDaysOfWeek(null), "Setting daysOfWeek to null should throw IllegalArgumentException");
    }

    @Test
    public void testSetValidDaysOfWeek() {
        HashSet<DayOfWeek> days = new HashSet<>();
        days.add(DayOfWeek.TUESDAY);
        flight1.setDaysOfWeek(days);

        assertEquals(days, flight1.getDaysOfWeek(), "DaysOfWeek should be set correctly to a valid HashSet");
    }
}
