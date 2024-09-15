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
        return daysOfWeek;
    }

    public void setDaysOfWeek(HashSet<DayOfWeek> daysOfWeek) {
        if (daysOfWeek == null) {
            throw new IllegalArgumentException("Day of week cannot be null");
        } else {
            this.daysOfWeek = new HashSet<>(daysOfWeek); // Ensure it's a HashSet
        }
    }
}
