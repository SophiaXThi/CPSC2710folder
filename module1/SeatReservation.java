public class SeatReservation {

    //Private instance variables
    private String flightDesignator;
    private java.time.LocalDate flightDate;
    private String firstName;
    private String lastName;


    //Getters and Setters
    public String getFlightDesignation() {
        return flightDesignation
    }    

    public void setFlightDesignation(String fd) {
        // this.flightDesignator = fd;
        if (flightDesignator == null){
         throw new IllegalArgumentException("flight designator cannot be null");
      }
      this.flightDesignator = fd;
    }

    public java.time.LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(java.time.LocalDate date) {
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

    public String toString() {
        //Will have to add something to deal with null exceptions
        return getFlightDesignation() + getFlightDate() + getFirstName() + getLastName();
    }



        
    public static void main(String[] args){

    }

}