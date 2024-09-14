package edu.au.cpsc.module4;

import java.time.LocalTime;
import java.util.HashSet;

public class ScheduledFlight {

    // Instance Variables
    private String flightDesignator;
    private String departureAirportIdent;
    private LocalTime departureTime;
    private String arrivalAirportIdent;
    private LocalTime arrivalTime;
    private HashSet daysOfWeek;

    //Getters and Setters
    public String getFlightDesignator() {
        return flightDesignator;
    }

    public void setFlightDesignator(String flightDesignator) {

        // This String can NOT be null or empty
        if(flightDesignator == null||flightDesignator.isEmpty()) {
            throw new IllegalArgumentException("Flight designator cannot be null or empty");
        }
        this.flightDesignator = flightDesignator;
    }

    public String getDepartureAirportIdent() {
        return departureAirportIdent;
    }

    public void setDepartureAirportIdent(String departureAirportIdent) {
        if(departureAirportIdent == null||departureAirportIdent.isEmpty()) {
            throw new IllegalArgumentException("Departure airport ident cannot be null or empty");
        }
        this.departureAirportIdent = departureAirportIdent;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        if(departureTime == null) {
            throw new IllegalArgumentException("Departure time cannot be null");
        }
        this.departureTime = departureTime;
    }

    public String getArrivalAirportIdent() {
        return arrivalAirportIdent;
    }

    public void setArrivalAirportIdent(String arrivalAirportIdent) {
        if(arrivalAirportIdent == null||arrivalAirportIdent.isEmpty()) {
            throw new IllegalArgumentException("Arrival airport ident cannot be null or empty");
        }
        this.arrivalAirportIdent = arrivalAirportIdent;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        if(arrivalTime == null) {
            throw new IllegalArgumentException("Arrival time cannot be null");
        }
        this.arrivalTime = arrivalTime;
    }

    public HashSet getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(HashSet daysOfWeek) {
        if(daysOfWeek == null||daysOfWeek.isEmpty()) {
            throw new IllegalArgumentException("Day of week cannot be null");
        }
        this.daysOfWeek = daysOfWeek;
    }

    @Override
    public String toString() {
        return "ScheduledFlight{" +
                "flightDesignator='" + flightDesignator + '\'' +
                ", departureAirportIdent='" + departureAirportIdent + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalAirportIdent='" + arrivalAirportIdent + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", daysOfWeek=" + daysOfWeek +
                '}';
    }
}
