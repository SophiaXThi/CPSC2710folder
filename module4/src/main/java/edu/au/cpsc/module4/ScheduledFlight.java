package edu.au.cpsc.module4;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class ScheduledFlight {

    // Instance Variables
    private String flightDesignator;
    private String departureAirportIdent;
    private LocalTime departureTime;
    private String arrivalAirportIdent;
    private LocalTime arrivalTime;
    private HashSet<DayOfWeek> daysOfWeek;

    public ScheduledFlight(String s, String s1, Object o, String s2, Object o1, HashSet<String> daysOfWeek) {
    }


    //Getters and Setters
    public String getFlightDesignator() {
        return flightDesignator;
    }

    public void setFlightDesignator(String flightDesignator) {

        // This String can NOT be null or empty
        if (flightDesignator == null) {
            throw new IllegalArgumentException("Flight designator cannot be null or empty");
        } else {
            this.flightDesignator = flightDesignator;
        }
    }

    public String getDepartureAirportIdent() {
        return departureAirportIdent;
    }

    public void setDepartureAirportIdent(String departureAirportIdent) {
        if (departureAirportIdent == null) {
            throw new IllegalArgumentException("Departure airport ident cannot be null");
        } else {
            this.departureAirportIdent = departureAirportIdent;
        }
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        if (departureTime == null) {
            throw new IllegalArgumentException("Departure time cannot be null");
        } else {
            this.departureTime = departureTime;
        }
    }

    public String getArrivalAirportIdent() {
        return arrivalAirportIdent;
    }

    public void setArrivalAirportIdent(String arrivalAirportIdent) {
        if (arrivalAirportIdent == null) {
            throw new IllegalArgumentException("Arrival airport ident cannot be null");
        } else {
            this.arrivalAirportIdent = arrivalAirportIdent;
        }
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        if (arrivalTime == null) {
            throw new IllegalArgumentException("Arrival time cannot be null");
        } else {
            this.arrivalTime = arrivalTime;
        }
    }

    public HashSet<DayOfWeek> getDaysOfWeek() {
        // Days of the week don't change
        return new HashSet<>(daysOfWeek);
    }


    public void setDaysOfWeek(HashSet<DayOfWeek> daysOfWeek) {
        if (daysOfWeek == null) {
            throw new IllegalArgumentException("Day of week cannot be null");
        } else {
            this.daysOfWeek = new HashSet<>(daysOfWeek); // Ensure it's a HashSet
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ScheduledFlight scheduledFlight)) {
            return false;
        }
        if (!Objects.equals(flightDesignator, scheduledFlight.flightDesignator)) {
            return false;
        }
        if (!Objects.equals(departureAirportIdent, scheduledFlight.departureAirportIdent)) {
            return false;
        }
        if (!Objects.equals(arrivalAirportIdent, scheduledFlight.arrivalAirportIdent)) {
            return false;
        }
        return Objects.equals(daysOfWeek, scheduledFlight.daysOfWeek);
    }

    @Override
    public int hashCode() {
        int result = flightDesignator != null ? flightDesignator.hashCode() : 0;
        result = 31 * result + (departureAirportIdent != null ? departureAirportIdent.hashCode() : 0);
        result = 31 * result + (arrivalAirportIdent != null ? arrivalAirportIdent.hashCode() : 0);
        return result;
    }
}
