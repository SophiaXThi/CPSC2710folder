package edu.au.cpsc.module2;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.w3c.dom.Text;
import java.io.IOException;

import javafx.scene.Group;


public class SeatReservationApplication extends Application {

    //Instance Variables
    private static SeatReservation seatReservation;

    @Override
    public void start(Stage stage) throws IOException {

        //Create Instance Variable with info
        SeatReservation seatReservation = new SeatReservation();


        stage.setTitle("Seat Reservation Application");
        Label fieldLabels = new Label("test");
        Group centerPane = new Group(groupGrid());
        Scene scene = new Scene(buildBorder(),480, 400);
        stage.setScene(scene);

        //updateUI();
        stage.show();
    }

    public static SeatReservation getSeatReservation() {
        seatReservation.setFlightDesignator("null");
        seatReservation.setFlightDate(null);
        seatReservation.setFirstName("null");
        seatReservation.setLastName("null");
        seatReservation.setNumberOfBags(0);
        return seatReservation;
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
        //Vbox.setAlignment(Pos.Left)
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

        //Actions
        flightDesignatorField.setOnAction(event -> {
            String text = flightDesignatorField.getText();
        });
        

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

//    //Events
//    public void flightDesignatorFieldParse(){
//        flightDesignatorField.getText();
//    }
//
//    public void checkedBox(){
//        if (travelWithInfantField.isSelected()) {
//            seatReservation.makeFlyingWithInfant();
//        }
//        else{
//            seatReservation.makeNotFlyingWithInfant();
//        }
//    }
    public void saveButton(){
        System.out.println("Okay");
//        seatReservation.setFlightDesignator(flightDesignatorField.getText());
//        seatReservation.setFlightDate();
//        seatReservation.setFirstName();
//        seatReservation.setLastName();
//        seatReservation.setNumberOfBags();
//        seatReservation.isFlyingWithInfant();
  }
    public void cancelButton(){
        Platform.exit();
    }
    public static void main(String[] args) {
        launch();
    }
}


