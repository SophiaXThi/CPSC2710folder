package edu.au.cpsc.module2;
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
import javafx.util.StringConverter;

import java.io.IOException;

import javafx.scene.Group;


public class SeatReservationApplication extends Application {

    //Instance Variables
    public SeatReservation seatReservation;
    private TextField flightDesignatorField;
    private DatePicker flightDatePicker;
    private TextField firstNameField;
    private TextField lastNameField ;
    private CheckBox travelWithInfantField;
    private TextField numberOfBaggageField;
    private TextField numberOfPassengersField;
    @Override
    public void start(Stage stage) throws IOException {

        //Create Instance Variable with info
        SeatReservation srObj = new SeatReservation();
        srObj.setFlightDesignator("null");
        srObj.setFlightDate(null);
        srObj.setFirstName("null");
        srObj.setLastName("null");
        srObj.setNumberOfBags(0);
        srObj.makeNotFlyingWithInfant(false);

        stage.setTitle("Seat Reservation Application");
        Group centerPane = new Group(groupGrid());
        Scene scene = new Scene(buildBorder(),480, 400);
        stage.setScene(scene);

        updateUI();
        stage.show();
    }

   private void updateUI(){
//        Label flightDesignatorField = new Label();
//        Label flightDatePicker = new Label();
//        Label firstNameLabel = new Label();
//        Label lastNameLabel = new Label();
//        Label travelWithInfantLabel = new Label();
//        Label numberOfBaggageLabel = new Label();
        flightDesignatorField.setText(seatReservation.getFlightDesignator());
        flightDatePicker.setValue(seatReservation.getFlightDate());
        firstNameField.setText(seatReservation.getFirstName());
        lastNameField.setText(seatReservation.getLastName());
        travelWithInfantField.setSelected(seatReservation.isFlyingWithInfant());
        numberOfBaggageField.setText(Integer.toString(seatReservation.getNumberOfBags()));
   }


    private BorderPane buildBorder(){
        BorderPane srBorderPane = new BorderPane();
        srBorderPane.setPadding(new Insets(25,12.5,25,12.5));
        srBorderPane.setCenter(groupGrid());
        return srBorderPane;
    }
    private GridPane groupGrid(){
        GridPane groupGrid = new GridPane();
        Label label = new Label();
        GridPane.setConstraints(label, 2, 1);
        groupGrid.add(instVarLabel(), 0, 0 );
        groupGrid.add(instVarFieldFillVBox(), 1, 0);
        groupGrid.add(createButtonBar(), 1, 1);
        return groupGrid;
    }

    public VBox instVarLabel(){
        //Label of all the instance variables
        Label flightDesignatorText = new Label("Flight Designator");
        Label flightDateText = new Label("Flight Date");
        Label firstNameText =new Label("First Name");
        Label lastNameText = new Label("Last Name");
        Label travelWithInfantText = new Label("Travel With Infant");
        Label numberOfBaggageText = new Label("Number of Baggage");
        Label numberOfPassengersText = new Label("Number of Passengers");
        VBox iVarTextLabels = new VBox(20 );
        iVarTextLabels.getChildren().addAll(flightDesignatorText, flightDateText, firstNameText, lastNameText, travelWithInfantText, numberOfBaggageText, numberOfPassengersText);
        iVarTextLabels.setPadding(new Insets(25,12.5,25,12.5));
        return iVarTextLabels;
    }

    public VBox instVarFieldFillVBox(){
        //TextFields, DateCheckBox, and Button
        TextField flightDesignatorField = new TextField();
        DatePicker flightDatePicker = new DatePicker();
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        CheckBox travelWithInfantField = new CheckBox();
        TextField numberOfBaggageField = new TextField();

        //

        //travelWithInfantField.isSelected(true);


        //This field can not be edited and should only return value
        TextField numberOfPassengersField = new TextField();
        numberOfPassengersField.setEditable(false);
        numberOfPassengersField.setTextFormatter(new TextFormatter<>(new StringConverter<Integer>() {
            @Override
            public String toString(Integer object) {
                return "1";
            }

            @Override
            public Integer fromString(String string) {
                return 1;
            }
        }));

        boolean isSelected = travelWithInfantField.isSelected();

        //Create the VBox
        VBox iVarFieldVBox = new VBox(11);
        iVarFieldVBox.getChildren().addAll(flightDesignatorField, flightDatePicker, firstNameField, lastNameField, travelWithInfantField, numberOfBaggageField, numberOfPassengersField);
        iVarFieldVBox.setPadding(new Insets(25,12.5,25,12.5));
        return iVarFieldVBox;
    }



    private AnchorPane createButtonBar(){
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



    public void saveButton(){
        System.out.println("Okay");
        //Add SeatReservation Setters
//        srObj.setFlightDesignator("null");
//        srObj.setFlightDate(null);
//        srObj.setFirstName("null");
//        srObj.setLastName("null");
//        srObj.setNumberOfBags(0);
//        srObj.isFlyingWithInfant();


    }
    public void cancelButton(){
        Platform.exit();
        System.out.println("Cancel clicked");
    }
    public static void main(String[] args) {
        launch();
    }
}


