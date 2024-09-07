import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Airport {

    //instance variables
    private String ident;
    private String iataCode;
    private String localCode;

    private String aircraftType;
    private String airportName;
    private Integer elevationFt;
    private String continent;
    private String country;
    private String municipality;
    private String gpsCode;
    private Double latitudeCoordinates;
    private Double longitudeCoordinates;

    //Create getters and setters

    //GETTERS***************************************
    public String getIdent() {
        return ident;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public String getAirportName() {
        return airportName;
    }

    public Integer getElevationFt() {
        return elevationFt;
    }

    public String getContinent() {
        return continent;
    }

    public String getCountry() {
        return country;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getGpsCode() {
        return gpsCode;
    }

    public String getIataCode() {
        return iataCode;
    }

    public String getLocalCode() {
        return localCode;
    }

    public Double getLatitudeCoordinates() {
        return latitudeCoordinates;
    }

    public Double getLongitudeCoordinates() {
        return longitudeCoordinates;
    }

    //Setters**************************************************
    public void setIdent(String si) {
        this.ident = si;
    }

    public void setAircraftType(String at) {
        this.aircraftType = at;
    }

    public void setAirportName(String an) {
        this.airportName = an;
    }

    public void setElevationFt(Integer eft) {
        this.elevationFt = eft;
    }

    public void setContinent(String cn) {
        this.continent = cn;
    }

    public void setIsoCountry(String isc) {
        this.country = isc;
    }

    public void setMunicipality(String mun) {
        this.municipality = mun;
    }

    public void setGpsCode(String gc) {
        this.gpsCode = gc;
    }

    public void setIataCode(String ic) {
        this.iataCode = ic;
    }

    public void setLocalCode(String lcc) {
        this.localCode = lcc;
    }

    public void setLatitudeCoordinates(Double latc) {
        this.latitudeCoordinates = latc;
    }

    public void setLongitudeCoordinates(Double lngc) {
        this.longitudeCoordinates = lngc;
    }


    public static List<Airport> readAll() throws IOException {

        List<Airport> airports = new ArrayList<>();
        BufferedReader reader = null;
        String csvFilePath = "/airport-codes.csv";

        try {
            // Load the CSV file from the resources folder
            InputStream inputStream = Airport.class.getClassLoader().getResourceAsStream(csvFilePath);
            if (inputStream == null) {
                // In case the file doesn't show up
                throw new FileNotFoundException(csvFilePath);
            }

            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            // Ignores the headers
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                // Split on commas as it is a Comma Separated Value file
                String[] fields = line.split(",");

                if (fields.length != 12) {
                    continue;
                }

                Airport airport = new Airport();
                airport.setIdent(fields[0]);
                airport.setAircraftType(fields[1]);
                airport.setAirportName(fields[2]);

                // Because int can not have null but Integers can, check for them per Assignment notes
                try {
                    airport.setElevationFt(fields[3].isEmpty() ? null : Integer.parseInt(fields[3]));
                } catch (NumberFormatException e) {
                    airport.setElevationFt(null);
                }

                airport.setContinent(fields[4]);
                airport.setIsoCountry(fields[5]);

                // Has empty rows
                airport.setMunicipality(fields[6].isEmpty() ? null : fields[6]);
                airport.setGpsCode(fields[7].isEmpty() ? null : fields[7]);
                airport.setIataCode(fields[8].isEmpty() ? null : fields[8]);
                airport.setLocalCode(fields[9].isEmpty() ? null : fields[9]);

                try {
                    airport.setLatitudeCoordinates(fields[10].isEmpty() ? 0.0 : Double.parseDouble(fields[10]));
                    airport.setLongitudeCoordinates(fields[11].isEmpty() ? 0.0 : Double.parseDouble(fields[11]));
                } catch (NumberFormatException e) {
                    // In case there are wonky formats
                    airport.setLatitudeCoordinates(0.0);
                    airport.setLongitudeCoordinates(0.0);
                }

                airports.add(airport);
            }
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
            return airports;
    }
}

