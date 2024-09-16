package edu.au.cpsc.module4;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class AirlineDatabase implements Serializable {

    public List<ScheduledFlight> scheduledFlights;
    // Methods

    public AirlineDatabase() {
        scheduledFlights = new ArrayList<>();
    }

    public List<ScheduledFlight> getScheduledFlights(){
        return scheduledFlights;
    }

    public void addScheduledFlight(ScheduledFlight sf) {
        scheduledFlights.add(sf);
    }

    public void removeScheduledFlight(ScheduledFlight sf){
        scheduledFlights.remove(sf);
    }

    public void updateScheduledFlight(ScheduledFlight sf) {
        if (sf == null) {
            throw new IllegalArgumentException("Scheduled flight cannot be null");
        }
        // Check if flight exists before updating
        if (scheduledFlights.contains(sf)) {
            throw new IllegalArgumentException("Scheduled flight already exist");
        }
        // Remove the old flight and add the updated one
        for (int i = 0; i < scheduledFlights.size(); i++) {
            if (Objects.equals(scheduledFlights.get(i).getFlightDesignator(), sf.getFlightDesignator())) {
                scheduledFlights.set(i, sf);  // Update the existing flight
                return;
            }
        }
        throw new IllegalArgumentException("Scheduled flight does not exist");
    }
}
