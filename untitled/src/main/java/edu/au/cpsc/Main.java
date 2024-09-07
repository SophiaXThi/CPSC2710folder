package edu.au.cpsc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Adjust the path to your CSV file
        String CSV_FILE_PATH = "/airport-codes.csv";

        List<Airport> airports = new ArrayList<>();
        String line;
        String csvSplitBy = ","; // Adjust the delimiter if necessary

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            // Skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                // Split the line into columns
                String[] values = line.split(csvSplitBy);

                // Create a new Airport object and add it to the list
                if (values.length >= 3) { // Ensure there are enough columns
                    Airport airport = new Airport(values[0], values[1], values[2]);
                    airports.add(airport);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return airports;
    }

        public static void main(String[] args) {
            try {
                List<Airport> airports = readAll();
                for (Airport airport : airports) {
                    System.out.println(airport);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
public class Airport {
    private String id;
    private String name;
    private String city;

    // Constructor
    public Airport(String id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Airport{id='" + id + "', name='" + name + "', city='" + city + "'}";
    }
}

    public class AirportReader {

        // Adjust the path to your CSV file
        private static final String CSV_FILE_PATH = "path/to/your/airports.csv";

       try {
            // Load the CSV file from the resources folder
            InputStream inputStream = Airport.class.getClassLoader().getResourceAsStream(csvFilePath);
            if (inputStream == null) {
                throw new FileNotFoundException("Resource not found: " + csvFilePath);
            }

            // Initialize the BufferedReader
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            // Skip the header line if there is one
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length != 12) {
                    // Handle error: wrong number of fields
                    continue;
                }

                Airport airport = new Airport();
                airport.setIdent(fields[0]);
                airport.setIataCode(fields[1]);
                airport.setLocalCode(fields[2]);
                airport.setAircraftType(fields[3]);
                airport.setAirportName(fields[4]);

                try {
                    airport.setElevationFt(fields[5].isEmpty() ? null : Integer.parseInt(fields[5]));
                } catch (NumberFormatException e) {
                    // Handle error: invalid elevation format
                    airport.setElevationFt(null);
                }

                airport.setContinent(fields[6]);
                airport.setCountry(fields[7]);
                airport.setMunicipality(fields[8]);
                airport.setGpsCode(fields[9]);

                try {
                    airport.setLatitudeCoordinates(Double.parseDouble(fields[10]));
                    airport.setLongitudeCoordinates(Double.parseDouble(fields[11]));
                } catch (NumberFormatException e) {
                    // Handle error: invalid latitude or longitude format
                    airport.setLatitudeCoordinates(0);
                    airport.setLongitudeCoordinates(0);
                }

                airports.add(airport);
            }
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // Handle potential IOException when closing the reader
                    e.printStackTrace();
                }
            }
        }

        return airports;
    }
    }