package edu.au.cpsc.module4;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.DayOfWeek;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScheduledFlightTest {

    @Test
    public void testSetFlightDesignatorWithNull() {
        ScheduledFlight flight = new ScheduledFlight();
        assertThrows(IllegalArgumentException.class, () -> flight.setFlightDesignator(null));
    }

    @Test
    public void testSetDepartureAirportIdentWithNull() {
        ScheduledFlight flight = new ScheduledFlight();
        assertThrows(IllegalArgumentException.class, () -> flight.setDepartureAirportIdent(null));
    }

    @Test
    public void testSetDepartureTimeWithNull() {
        ScheduledFlight flight = new ScheduledFlight();
        assertThrows(IllegalArgumentException.class, () -> flight.setDepartureTime(null));
    }

    @Test
    public void testSetArrivalAirportIdentWithNull() {
        ScheduledFlight flight = new ScheduledFlight();
        assertThrows(IllegalArgumentException.class, () -> flight.setArrivalAirportIdent(null));
    }

    @Test
    public void testSetArrivalTimeWithNull() {
        ScheduledFlight flight = new ScheduledFlight();
        assertThrows(IllegalArgumentException.class, () -> flight.setArrivalTime(null));
    }

    @Test
    void testSetDaysOfWeekWithNull() {
        ScheduledFlight flight = new ScheduledFlight();
        assertThrows(IllegalArgumentException.class, () -> {
            flight.setDaysOfWeek(null);
        });
    }
}
