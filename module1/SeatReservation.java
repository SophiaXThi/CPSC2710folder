public class SeatReservation {

    //Private instance variables
    private String flightDesignator;
    private java.time.LocalDate flightDate;
    private String firstName;
    private String lastName;


    //Getters and Setters
    public String getFlightDesignator() {
        return flightDesignator;
    }    

    public void setFlightDesignator(String sr) {

        //We need to count the length of the string
        int count = 0;
        if (sr != null) {
            for (int i = 0; i < sr.length(); i++) {
                if (sr.charAt(i) != ' ') {
                    count++;
                }
            }
        }

        //Strings less than 4 or greater than 6 are not allowed
        if (count < 4 || count > 6) {
            throw new IllegalArgumentException("Invalid flight designation");
        } else {
            this.flightDesignator = sr;
        }
        // this.flightDesignator = fd;


        if (flightDesignator == null){
         throw new IllegalArgumentException("flight designator cannot be null");
      }

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
                "lastName=" + lastName + "}";
    }

        
    public static void main(String[] args){

    }

}