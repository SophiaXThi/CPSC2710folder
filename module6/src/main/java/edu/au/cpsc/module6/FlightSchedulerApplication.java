package edu.au.cpsc.module6;

import edu.au.cpsc.model.SeatReservation;
import edu.au.cpsc.uimodel.SeatReservationUI;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class FlightSchedulerApplication extends Application {

    private SeatReservationUI seatReservationUI;
    private SeatReservation seatReservation;
    private TextField flightDesignatorField;
    private DatePicker flightDatePicker;
    private TextField firstNameField;
    private TextField lastNameField;
    private CheckBox travelWithInfantField;
    private TextField numberOfBaggageField;
    private Button saveButton;

    // Boolean properties for validation
    private final SimpleBooleanProperty isFlightDesignatorValid = new SimpleBooleanProperty(true);
    private final SimpleBooleanProperty isFlightDateValid = new SimpleBooleanProperty(true);
    private final SimpleBooleanProperty isFirstNameValid = new SimpleBooleanProperty(true);
    private final SimpleBooleanProperty isLastNameValid = new SimpleBooleanProperty(true);
    private final SimpleBooleanProperty isNumberOfBaggageValid = new SimpleBooleanProperty(true);

    @Override
    public void start(Stage stage) throws IOException {
        seatReservation = new SeatReservation();
        seatReservationUI = new SeatReservationUI();
        seatReservation.setFlightDesignator("null");
        seatReservation.setFlightDate(LocalDate.now());
        seatReservation.setFirstName("null");
        seatReservation.setLastName("null");
        seatReservation.setNumberOfBags(0);
        seatReservation.makeNotFlyingWithInfant();

        stage.setTitle("Seat Reservation Application");
        BorderPane srBorderPane = buildBorder();
        Scene scene = new Scene(srBorderPane, 480, 400);
        stage.setScene(scene);

        createButtonBar();
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

        validateInputs();
        updateButtonState();
        updateInputStyles();
    }

    private void updateInputStyles() {
        updateTextBackgroundStyle(flightDesignatorField, seatReservationUI.flightDesignatorValidProperty().get());
        updateDateBackgroundStyle(flightDatePicker, seatReservationUI.flightDateValidProperty().get());
    }

    private BorderPane buildBorder() {
        BorderPane srBorderPane = new BorderPane();
        srBorderPane.setPadding(new Insets(25, 12.5, 25, 12.5));
        srBorderPane.setCenter(groupGrid());
        return srBorderPane;
    }

    private GridPane groupGrid() {
        GridPane groupGrid = new GridPane();
        flightDesignatorField = new TextField();
        flightDatePicker = new DatePicker();
        firstNameField = new TextField();
        lastNameField = new TextField();
        travelWithInfantField = new CheckBox();
        numberOfBaggageField = new TextField();

        groupGrid.add(instVarLabel(), 0, 0);
        groupGrid.add(instVarFieldFillVBox(), 1, 0);
        groupGrid.add(createButtonBar(), 1, 1);

        setListeners();
        return groupGrid;
    }

    private void setListeners() {
        flightDesignatorField.textProperty().addListener((obs, oldText, newText) -> {
            seatReservation.setFlightDesignator(newText);
            isFlightDesignatorValid.set(!newText.isEmpty());
            updateTextBackgroundStyle(flightDesignatorField, isFlightDesignatorValid.get());
        });

        flightDatePicker.valueProperty().addListener((obs, oldDate, newDate) -> {
            seatReservation.setFlightDate(newDate);
            isFlightDateValid.set(newDate != null);
            updateDateBackgroundStyle(flightDatePicker, isFlightDateValid.get());
        });

        firstNameField.textProperty().addListener((obs, oldText, newText) -> {
            seatReservation.setFirstName(newText);
            isFirstNameValid.set(!newText.isEmpty());
            updateTextBackgroundStyle(firstNameField, isFirstNameValid.get());
        });

        lastNameField.textProperty().addListener((obs, oldText, newText) -> {
            seatReservation.setLastName(newText);
            isLastNameValid.set(!newText.isEmpty());
            updateTextBackgroundStyle(lastNameField, isLastNameValid.get());
        });

        travelWithInfantField.selectedProperty().addListener((obs, oldValue, newValue) -> {
            seatReservation.makeFlyingWithInfant(newValue);
        });

        numberOfBaggageField.textProperty().addListener((obs, oldText, newText) -> {
            if (!newText.matches("\\d*")) {
                numberOfBaggageField.setText(newText.replaceAll("\\D", ""));
            } else {
                seatReservation.setNumberOfBags(newText.isEmpty() ? 0 : Integer.parseInt(newText));
                isNumberOfBaggageValid.set(!newText.isEmpty());
                updateTextBackgroundStyle(numberOfBaggageField, isNumberOfBaggageValid.get());
            }
        });
    }

    public VBox instVarLabel() {
        Label flightDesignatorText = new Label("Flight Designator");
        Label flightDateText = new Label("Flight Date");
        Label firstNameText = new Label("First Name");
        Label lastNameText = new Label("Last Name");
        Label travelWithInfantText = new Label("Travel With Infant");
        Label numberOfBaggageText = new Label("Number of Baggage");
        VBox iVarTextLabels = new VBox(20);
        iVarTextLabels.getChildren().addAll(flightDesignatorText, flightDateText, firstNameText, lastNameText, travelWithInfantText, numberOfBaggageText);
        iVarTextLabels.setPadding(new Insets(25, 12.5, 25, 12.5));
        return iVarTextLabels;
    }

    public VBox instVarFieldFillVBox() {
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
        return iVarFieldVBox;
    }

    private AnchorPane createButtonBar() {
        Button cancelButton = new Button("Cancel");
        saveButton = new Button("Save");

        cancelButton.setOnAction(event -> cancelButton());
        saveButton.setOnAction(event -> saveButton());

        HBox buttonBar = new HBox(cancelButton, saveButton);
        AnchorPane anchorPane = new AnchorPane(buttonBar);
        AnchorPane.setRightAnchor(buttonBar, 0.0);
        AnchorPane.setBottomAnchor(buttonBar, 0.0);
        return anchorPane;
    }

    private void updateTextBackgroundStyle(TextField field, boolean isValid) {
        if (isValid) {
            field.setStyle("");
        } else {
            field.setStyle("-fx-background-color: red");
        }
    }

    private void updateDateBackgroundStyle(DatePicker field, boolean isValid) {
        if (isValid) {
            field.setStyle("");
        } else {
            field.setStyle("-fx-background-color: red");
        }
    }

    private void validateInputs() {
        isFlightDesignatorValid.set(!flightDesignatorField.getText().isEmpty());
        isFlightDateValid.set(flightDatePicker.getValue() != null);
        isFirstNameValid.set(!firstNameField.getText().isEmpty());
        isLastNameValid.set(!lastNameField.getText().isEmpty());
        isNumberOfBaggageValid.set(!numberOfBaggageField.getText().isEmpty());
    }

    public void updateButtonState() {
        saveButton.disableProperty().bind(Bindings.createBooleanBinding(
                () -> !isFlightDesignatorValid.get() ||
                        !isFlightDateValid.get() ||
                        !isFirstNameValid.get() ||
                        !isLastNameValid.get() ||
                        !isNumberOfBaggageValid.get(),
                isFlightDesignatorValid,
                isFlightDateValid,
                isFirstNameValid,
                isLastNameValid,
                isNumberOfBaggageValid
        ));
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


