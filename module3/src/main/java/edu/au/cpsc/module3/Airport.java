package edu.au.cpsc.module3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private String region;
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

    public String getRegion() {
        return region;
    }

    public String getMunicipality() {
        return municipality;
    }

    //Goes unused
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

    public void setCountry(String isc) {
        this.country = isc;
    }

    public void setRegion(String rn) {
        this.region = rn;
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
        String csvFilePath = "airport-codes.csv";

        // Load the CSV file from the resources folder
        InputStream inputStream = Airport.class.getClassLoader().getResourceAsStream(csvFilePath);
        if (inputStream == null) {
            // In case the file doesn't show up
            throw new FileNotFoundException(csvFilePath);
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
                String line;
                reader.readLine(); // Skip the header line

                while ((line = reader.readLine()) != null) {
                    String[] fields = line.split(",");

                    if (fields.length >= 12) { // Ensure the length is correct
                        Airport airport = new Airport();
                        airport.setIdent(fields[0]);
                        airport.setAircraftType(fields[1]);
                        airport.setAirportName(fields[2]);
                        airport.setElevationFt(fields[3].isEmpty() ? null : Integer.parseInt(fields[3]));
                        airport.setContinent(fields[4]);
                        airport.setCountry(fields[5]);
                        airport.setRegion(fields[6]);
                        airport.setMunicipality(fields[7].isEmpty() ? null : fields[7]);
                        airport.setGpsCode(fields[8].isEmpty() ? null : fields[8]);
                        airport.setIataCode(fields[9].isEmpty() ? null : fields[9]);
                        airport.setLocalCode(fields[10].isEmpty() ? null : fields[10]);

                        // Parse latitude and longitude from the last two columns
                        try {
                            String[] coordinates = fields[11].split(",");
                            if (coordinates.length == 2) {
                                airport.setLatitudeCoordinates(Double.parseDouble(coordinates[0]));
                                airport.setLongitudeCoordinates(Double.parseDouble(coordinates[1]));
                            } else {
                                airport.setLatitudeCoordinates(null);
                                airport.setLongitudeCoordinates(null);
                            }
                        } catch (NumberFormatException e) {
                            airport.setLatitudeCoordinates(null);
                            airport.setLongitudeCoordinates(null);
                        }

                        airports.add(airport);
                    }
                }
            }
            return airports;

        }

    @Override
    public String toString() {
        return "Airport{" + "ident='" + ident + '\'' + ", iataCode='" + iataCode + '\'' + ", localCode='" + localCode + '\'' + ", aircraftType='" + aircraftType + '\'' + ", aircraftName='" + airportName + '\'' + ", elevationFt=" + elevationFt + ", country='" + country + '\'' + ", continent='" + continent + '\'' + ", municipality='" + municipality + '\'' + ", latitude=" + latitudeCoordinates + ", longitude=" + longitudeCoordinates + '}';
    }
}

