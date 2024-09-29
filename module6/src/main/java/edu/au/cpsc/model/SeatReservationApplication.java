package edu.au.cpsc.model;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

import javafx.scene.Group;


public class SeatReservationApplication extends Application {

    //Instance Variables
    public SeatReservation seatReservation;
    private TextField flightDesignatorField;
    private DatePicker flightDatePicker;
    private TextField firstNameField;
    private TextField lastNameField;
    private CheckBox travelWithInfantField;
    private TextField numberOfBaggageField;
    private TextField numberOfPassengersField;

    @Override
    public void start(Stage stage) throws IOException {

        //Create Instance Variable with info
        seatReservation = new SeatReservation(); // Use the instance variable

        // Initialize with valid values
        try {
            seatReservation.setFlightDesignator("null"); // Provide a valid flight designator
            seatReservation.setFlightDate(LocalDate.now()); // Set a valid date
            seatReservation.setFirstName("null"); // Example first name
            seatReservation.setLastName("null"); // Example last name
            seatReservation.setNumberOfBags(0); // Initial number of bags
            seatReservation.makeNotFlyingWithInfant(); // Assuming no infant traveling
        } catch (IllegalArgumentException e) {
            System.out.println("Error initializing SeatReservation: " + e.getMessage());
            return; // Exit the start method to prevent further errors
        }
        stage.setTitle("Seat Reservation Application");
        Group centerPane = new Group(groupGrid());
        Scene scene = new Scene(buildBorder(), 480, 400);
        stage.setScene(scene);

        updateUI();
        stage.show();
    }

    private void updateUI() {
        flightDesignatorField.setText(seatReservation.getFlightDesignator());
        flightDatePicker.setValue(seatReservation.getFlightDate());
        firstNameField.setText(seatReservation.getFirstName());
        lastNameField.setText(seatReservation.getLastName());
        travelWithInfantField.setSelected(seatReservation.isFlyingWithInfant());
        numberOfBaggageField.setText(Integer.toString(seatReservation.getNumberOfBags()));
    }


    private BorderPane buildBorder() {
        BorderPane srBorderPane = new BorderPane();
        srBorderPane.setPadding(new Insets(25, 12.5, 25, 12.5));
        srBorderPane.setCenter(groupGrid());
        return srBorderPane;
    }

    private GridPane groupGrid() {
        GridPane groupGrid = new GridPane();
        Label label = new Label();
        GridPane.setConstraints(label, 2, 1);
        groupGrid.add(instVarLabel(), 0, 0);
        groupGrid.add(instVarFieldFillVBox(), 1, 0);
        groupGrid.add(createButtonBar(), 1, 1);
        return groupGrid;
    }

    public VBox instVarLabel() {
        //Label of all the instance variables
        Label flightDesignatorText = new Label("Flight Designator");
        Label flightDateText = new Label("Flight Date");
        Label firstNameText = new Label("First Name");
        Label lastNameText = new Label("Last Name");
        Label travelWithInfantText = new Label("Travel With Infant");
        Label numberOfBaggageText = new Label("Number of Baggage");
        Label numberOfPassengersText = new Label("Number of Passengers");
        VBox iVarTextLabels = new VBox(20);
        iVarTextLabels.getChildren().addAll(flightDesignatorText, flightDateText, firstNameText, lastNameText, travelWithInfantText, numberOfBaggageText, numberOfPassengersText);
        iVarTextLabels.setPadding(new Insets(25, 12.5, 25, 12.5));
        return iVarTextLabels;
    }

    public VBox instVarFieldFillVBox() {
        // Initialize instance variables
        flightDesignatorField = new TextField();
        flightDatePicker = new DatePicker();
        firstNameField = new TextField();
        lastNameField = new TextField();
        travelWithInfantField = new CheckBox();
        numberOfBaggageField = new TextField();


        // Ensure that only numeric input is allowed in the baggage field
        numberOfBaggageField.textProperty().addListener((obs, oldText, newText) -> {
            // Allow only digits in the baggage field
            if (!newText.matches("\\d*")) {
                numberOfBaggageField.setText(newText.replaceAll("\\D", ""));
            }
        });

        // Set up input bindings to the SeatReservation model
        flightDesignatorField.textProperty().addListener((obs, oldText, newText) -> {
            try {
                seatReservation.setFlightDesignator(newText);
            } catch (IllegalArgumentException e) {
                // Handle invalid input, e.g., show an error message
                System.out.println("Invalid flight designator: " + e.getMessage());
            }
        });

        flightDatePicker.valueProperty().addListener((obs, oldDate, newDate) -> {
            seatReservation.setFlightDate(newDate);
        });

        firstNameField.textProperty().addListener((obs, oldText, newText) -> {
            seatReservation.setFirstName(newText);
        });

        lastNameField.textProperty().addListener((obs, oldText, newText) -> {
            seatReservation.setLastName(newText);
        });

        travelWithInfantField.selectedProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                seatReservation.makeFlyingWithInfant(travelWithInfantField.isSelected());
            } else {
                seatReservation.makeNotFlyingWithInfant();
            }
        });

        // Create the VBox to hold the fields
        VBox iVarFieldVBox = new VBox(11);
        iVarFieldVBox.getChildren().addAll(
                flightDesignatorField,
                flightDatePicker,
                firstNameField,
                lastNameField,
                travelWithInfantField,
                numberOfBaggageField
        );
        iVarFieldVBox.setPadding(new Insets(25, 12.5, 25, 12.5));

        // Populate fields with current values from the model
        updateUI();

        return iVarFieldVBox;
    }


    private AnchorPane createButtonBar() {
        Button cancelButton = new Button("Cancel");
        Button saveButton = new Button("Save");

        cancelButton.setOnAction(event -> cancelButton());
        saveButton.setOnAction(event -> saveButton());

        HBox buttonBar = new HBox(cancelButton, saveButton);
        AnchorPane anchorPane = new AnchorPane(buttonBar);
        AnchorPane.setRightAnchor(buttonBar, 0.0);
        AnchorPane.setBottomAnchor(buttonBar, 0.0);
        return anchorPane;
    }


    public void saveButton() {
        try {
            seatReservation.setFlightDesignator(flightDesignatorField.getText());
            seatReservation.setFlightDate(flightDatePicker.getValue());
            seatReservation.setFirstName(firstNameField.getText());
            seatReservation.setLastName(lastNameField.getText());

            seatReservation.setNumberOfBags(Integer.parseInt(numberOfBaggageField.getText()));
            seatReservation.makeFlyingWithInfant(travelWithInfantField.isSelected());
            System.out.println("Saved successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void cancelButton() {
        Platform.exit();
        System.out.println("Cancel clicked");
    }

    public static void main(String[] args) {

        launch();
    }
}



