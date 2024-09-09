package edu.au.cpsc.module3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static edu.au.cpsc.module3.Airport.searchAirport;


public class AirportController implements Initializable {

    // Don't forget to call in the Airport Class
    public List<Airport> airports;

    // Do I need to pull in the labels?
    @FXML
    private BorderPane root;

    @FXML
    private VBox airportBox;

    @FXML
    private GridPane airportGrid;

    @FXML
    private Label identLabel;

    // Editable textfields
    @FXML
    private TextField identField;

    @FXML
    private Label iataLabel;

    @FXML
    private TextField iataCodeField;

    @FXML
    private TextField localCodeField;

    @FXML
    private Label localCodeLabel;

    // Uneditable fields
    @FXML
    private TextField aircraftTypeField;

    @FXML
    private Label aircraftTypeLabel;

    @FXML
    private TextField airportNameField;

    @FXML
    private Label airportNameLabel;

    @FXML
    private TextField elevationTextField;

    @FXML
    private Label elevationLabel;

    @FXML
    private TextField continentField;

    @FXML
    private Label regionLabel;

    @FXML
    private TextField countryField;

    @FXML
    private Label countryLabel;

    @FXML
    private TextField regionField;

    @FXML
    private TextField municipalityField;

    @FXML
    private Label municipalityLabel;

    @FXML
    private ButtonBar buttonBar;

    @FXML
    private Button searchButton;

    @FXML
    private WebView mapViewer;

    public void initialize(URL location, ResourceBundle resources){

        // Read the CSV file
        try {
            airports = Airport.readAll();
            System.out.println("Total airports loaded: " + airports.size());

            // Sanity Check
            //airports.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Create the frame with the parts that work
        identField.setOnAction(event -> handleSearch());
        iataCodeField.setOnAction(event -> handleSearch());
        localCodeField.setOnAction(event -> handleSearch());
        searchButton.setOnAction(event -> handlesSearchButtonAct());

        WebEngine webEngine = mapViewer.getEngine();
        webEngine.load("https://www.windy.com/");
    }

    public void handleSearch() {
        // Searches bases on the first empty field
        String ident = identField.getText();
        String iataCode = iataCodeField.getText();
        String localCode = localCodeField.getText();
        Airport findAirport = null;
        // Rule is it goes by the first EMPTY field
        for (Airport airport : airports) {
            if (!ident.isEmpty() && airport.getIdent().equalsIgnoreCase(ident)) {
                updateFields(airport);
                break;
        }
            else if (!iataCode.isEmpty() && airport.getIataCode().equalsIgnoreCase(iataCode)){
                updateFields(airport);
                System.out.println("TroubleHere 2");
                break;
            }
            else if (!localCode.isEmpty()&& airport.getLocalCode().equalsIgnoreCase(localCode)){
                updateFields(airport);
                System.out.println("TroubleHere 3");
                break;
            }
            // Update the fields and map. Make sure to check the lat and long to ensure it is correct
            System.out.println("No airport found");
        }
    }



    public void handlesSearchButtonAct(){
        handleSearch();
        System.out.println("Search button pressed");
    }

    public void updateFields(Airport airport) {

        //Looking through the CSV there are many rows
        identField.setText(airport.getIdent() != null ? airport.getIdent() : "");
        iataCodeField.setText(airport.getIataCode() != null ? airport.getIataCode() : "");
        localCodeField.setText(airport.getLocalCode() != null ? airport.getLocalCode() : "");


        //Returns the non-editable
        aircraftTypeField.setText(airport.getAircraftType() != null ? airport.getAircraftType() : "");
        airportNameField.setText(airport.getAirportName() != null ? airport.getAirportName() : "");
        elevationTextField.setText(String.valueOf(airport.getElevationFt() != null ? airport.getElevationFt() : ""));
        //continentField.setText(airport.getContinent() != null ? airport.getContinent() : "");
        countryField.setText(airport.getCountry() != null ? airport.getCountry() : "");
        regionField.setText(airport.getRegion() != null ? airport.getRegion() : "");
        municipalityField.setText(airport.getMunicipality() != null ? airport.getMunicipality() : "");
    }
    public void updateMapView(Airport airport) {
        WebEngine webEngine = mapViewer.getEngine();
        String latitudeCoordinates = String.valueOf(airport.getLatitudeCoordinates());
        String longitudeCoordinates = String.valueOf(airport.getLongitudeCoordinates());
        String webURL = "https://www.windy.com/";
        webEngine.load(webURL);

    }
}