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
    }
}
