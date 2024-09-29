package edu.au.cpsc.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class SeatReservation {

    //Private instance variables
    private String flightDesignator;
    private java.time.LocalDate flightDate;
    private String firstName;
    private String lastName;
    private int numberOfBags;
    private boolean flyingWithInfant;

    // Validation stuff
    private BooleanProperty flightDesignatorValid = new SimpleBooleanProperty(true);
    private BooleanProperty flightDateValid = new SimpleBooleanProperty(true);
    private BooleanProperty firstNameValid = new SimpleBooleanProperty(true);
    private BooleanProperty lastNameValid = new SimpleBooleanProperty(true);
    private BooleanProperty numberOfBagsValid = new SimpleBooleanProperty(true);

    //Getters for the validation stuff
    public BooleanProperty flightDesignatorValidProperty() {
        return flightDesignatorValid;
    }
    public BooleanProperty flightDateValidProperty() {
        return flightDateValid;
    }
    public BooleanProperty firstNameValidProperty() {
        return firstNameValid;
    }
    public BooleanProperty lastNameValidProperty() {
        return lastNameValid;
    }
    public BooleanProperty numberOfBagsValidProperty() {
        return numberOfBagsValid;
    }
    public void validateFlightDesignator(String flightDesignator) {
        if (flightDesignator == null || flightDesignator.isEmpty()) {
            flightDesignatorValid.set(false);
        }else {
            flightDesignatorValid.set(true);
        }
    }
    public void validateFlightDate(String flightDate) {
        if (flightDate == null || flightDate.isEmpty()) {
            flightDateValid.set(false);
        }
        else {
            flightDateValid.set(true);
        }
    }
    public void validateFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            firstNameValid.set(false);
        }
        else {
            firstNameValid.set(true);
        }
    }
    public void validateLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            lastNameValid.set(false);
        }else {
            lastNameValid.set(true);
        }
    }

    //Getters and Setters
    public String getFlightDesignator() {
        return flightDesignator;
    }    

    public void setFlightDesignator(String sr) {
        System.out.println("Setting flight designator: " + sr);
        if (flightDesignator == null){
            this.flightDesignator = sr;
        }
        //We need to count the length of the string
        int count = sr.replace(" ", "").length();

        //Strings less than 4 or greater than 6 are not allowed
        if (count < 4 || count > 6) {
            throw new IllegalArgumentException("Invalid flight designation");
        } else {
            this.flightDesignator = sr;
        }
    }

    public java.time.LocalDate getFlightDate() {

        return flightDate;
    }

    public void setFlightDate(java.time.LocalDate date) {
        if (date != null && date.isBefore(java.time.LocalDate.now())) {
            throw new IllegalArgumentException("Flight date cannot be in the past");
        }
        this.flightDate = date;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String fn) {

        this.firstName = fn;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String ln) {

        this.lastName = ln;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(int nb) {
        if (nb < 0) {
            throw new IllegalArgumentException("Number of bags cannot be less than 0");
        }
        else{
            this.numberOfBags = nb;
        }
    }

    public boolean isFlyingWithInfant() {
        return flyingWithInfant;
    }

    public void makeFlyingWithInfant(boolean selected) {
        this.flyingWithInfant = true;
    }

    public void makeNotFlyingWithInfant() {
        this.flyingWithInfant = false;
    }

    //*****************************************************************************************
    public String toString() {
        //Will have to add something to deal with null exceptions
        if(flightDesignator == null) {
            flightDesignator = "null";
        }
        if(firstName == null) {
            firstName = "null";
        }
        if (lastName == null) {
            lastName = "null";
        }

        return "SeatReservation{flightDesignator=" + flightDesignator + "," +
                "flightDate=" + flightDate + "," + "firstName=" + firstName + "," +
                "lastName=" + lastName + "," + "numberOfBags=" + numberOfBags + "," +
                "flyingWithInfant=" + flyingWithInfant + "}";
    }
        
    public static void main(String[] args){

    }
}