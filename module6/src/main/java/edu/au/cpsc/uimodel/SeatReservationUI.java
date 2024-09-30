package edu.au.cpsc.uimodel;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SeatReservationUI {
    private final SimpleStringProperty flightDesignator = new SimpleStringProperty();
    private final SimpleStringProperty flightDate = new SimpleStringProperty();
    private final SimpleStringProperty firstName = new SimpleStringProperty();
    private final SimpleStringProperty lastName = new SimpleStringProperty();
    private final SimpleStringProperty numberOfBags = new SimpleStringProperty();

    private final SimpleBooleanProperty flightDesignatorValid = new SimpleBooleanProperty(true);
    private final SimpleBooleanProperty flightDateValid = new SimpleBooleanProperty(true);
    private final SimpleBooleanProperty firstNameValid = new SimpleBooleanProperty(true);
    private final SimpleBooleanProperty lastNameValid = new SimpleBooleanProperty(true);
    private final SimpleBooleanProperty numberOfBagsValid = new SimpleBooleanProperty(true);

    public void setFlightDesignator(String value) {
        flightDesignator.set(value);
        flightDesignatorValid.set(!value.isEmpty()); // Basic validation
    }

    public String getFlightDesignator() {
        return flightDesignator.get();
    }

    public boolean isFlightDesignatorValid() {
        return flightDesignatorValid.get();
    }

    public void setFlightDate(String value) {
        flightDate.set(value);
    }
    public String getFlightDate() {
        return flightDate.get();
    }
    public boolean isFlightDateValid() {
        return flightDateValid.get();
    }
    public void setFirstName(String value) {
        firstName.set(value);
    }
    public String getFirstName() {
        return firstName.get();
    }
    public boolean isFirstNameValid() {
        return firstNameValid.get();
    }
    public void setLastName(String value) {
        lastName.set(value);
    }
    public String getLastName() {
        return lastName.get();
    }
    public boolean isLastNameValid() {
        return lastNameValid.get();
    }
    public void setNumberOfBags(String value) {
        numberOfBags.set(value);
    }
    public String getNumberOfBags() {
        return numberOfBags.get();
    }
    public boolean isNumberOfBagsValid() {
        return numberOfBagsValid.get();
    }
    public void setFlightDesignatorValid(boolean value) {
        flightDesignatorValid.set(value);
    }

    public boolean isFormValid() {
        return flightDesignatorValid.get() && flightDateValid.get() && firstNameValid.get()
                && lastNameValid.get() && numberOfBagsValid.get();
    }

}
