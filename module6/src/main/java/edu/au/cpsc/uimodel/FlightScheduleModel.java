package edu.au.cpsc.uimodel;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;

public class FlightScheduleModel {

    private StringProperty flightDesignatorProperty;
    private StringProperty departureTimeProperty;
    private StringProperty arrivalTimeProperty;
    private BooleanProperty newProperty;
    private BooleanProperty modifiedProperty;

    public FlightScheduleModel() {
        flightDesignatorProperty = new SimpleStringProperty();
        departureTimeProperty = new SimpleStringProperty();
        arrivalTimeProperty = new SimpleStringProperty();
        newProperty = new SimpleBooleanProperty(true);
        modifiedProperty = new SimpleBooleanProperty(true);
        
        //Listeners
        flightDesignatorProperty.addListener((observable, oldValue, newValue) -> setModified(true));
        departureTimeProperty.addListener((observable, oldValue, newValue) -> setModified(true));
        arrivalTimeProperty.addListener((observable, oldValue, newValue) -> setModified(true));
    }

    public String getFlightProperty() {return flightDesignatorProperty.get();}
    public boolean isModified() { return modifiedProperty.get(); }
    public void setModified(boolean m) { modifiedProperty.set(m); }

    // Getter for flight designator property
    public String getFlightDesignator() {
        return flightDesignatorProperty.get();
    }
    public StringProperty flightDesignatorProperty() {
        return flightDesignatorProperty; // Return the property for binding
    }
    public String getDepartureTime() {
        return departureTimeProperty.get();
    }
    public StringProperty departureTimeProperty() {
        return departureTimeProperty;
    }
    public String getArrivalTime() {
        return arrivalTimeProperty.get();
    }
    public StringProperty arrivalTimeProperty() {
        return arrivalTimeProperty;
    }
    public boolean getNewProperty() {
        return newProperty.get();
    }
    public BooleanProperty newProperty() {
        return newProperty;
    }
    public boolean getModifiedProperty() {
        return modifiedProperty.get();
    }
    public BooleanProperty modifiedProperty() {
        return modifiedProperty;
    }

}
