package edu.au.cpsc.module2;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;
//import org.w3c.dom.Text;
import java.io.IOException;


public class SeatReservationApplication extends Application {

    //Instance Variables
    private static SeatReservation seatReservation;

    @Override
    public void start(Stage stage) throws IOException {
        SeatReservation seatReservation = new SeatReservation();



        stage.setTitle("Seat Reservation Application");
        Label fieldLabels = new Label("test");
        Scene scene = new Scene(buildBorder(),480, 400);
        stage.setScene(scene);
        stage.show();

    }

    private Parent buildBorder(){
        BorderPane srBorderPane = new BorderPane();
        srBorderPane.setPadding(new Insets(25,12.5,25,12.5));
        //srBorderPane.setLeft(instVarText());
        //srBorderPane.setRight(instVarFieldFill());
        //srBorderPane.setBottom(createButtonBar());
        srBorderPane.setCenter(groupGrid());
        return srBorderPane;
    }
    private Parent groupGrid(){
        GridPane groupGrid = new GridPane();
        Label label = new Label();
        GridPane.setConstraints(label, 2, 1);
        groupGrid.add(instVarText(), 0, 0 );
        groupGrid.add(instVarFieldFill(), 1, 0);
        groupGrid.add(createButtonBar(), 1, 1);
        return groupGrid;
    }

    private Parent instVarText(){
        //Text of all of the instance variables
        Text flightDesignatorText = new Text("Flight Designator");
        Text flightDateText = new Text("Flight Date");
        Text firstNameText = new Text("First Name");
        Text lastNameText = new Text("Last Name");
        Text travelWithInfantText = new Text("Travel With Infant");
        Text numberOfBaggageText = new Text("Number of Baggage");
        Text numberOfPassengersText = new Text("Number of Passengers");
        VBox iVarTextVBox = new VBox(20, flightDesignatorText, flightDateText, firstNameText, lastNameText, travelWithInfantText, numberOfBaggageText, numberOfPassengersText);
        iVarTextVBox.setPadding(new Insets(25,12.5,25,12.5));
        //Vbox.setAlignment(Pos.Left)
        return iVarTextVBox;
    }

    private Parent instVarFieldFill(){
        //TextFields, DateCheckBox, and Button
        TextField flightDesignatorField = new TextField();
        DatePicker flightDatePicker = new DatePicker();
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        CheckBox travelWithInfantField = new CheckBox();
        TextField numberOfBaggageField = new TextField();

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
        VBox iVarFieldVBox = new VBox(11, flightDesignatorField, flightDatePicker, firstNameField, lastNameField, travelWithInfantField, numberOfBaggageField, numberOfPassengersField);
        iVarFieldVBox.setPadding(new Insets(25,12.5,25,12.5));
        return iVarFieldVBox;
    }
    private Parent createButtonBar(){
        Button cancelButton = new Button("Cancel");
        Button saveButton = new Button("Save");
        HBox buttonBar = new HBox(cancelButton, saveButton);
        AnchorPane anchorPane = new AnchorPane(buttonBar);
        AnchorPane.setRightAnchor(buttonBar, 0.0);
        AnchorPane.setBottomAnchor(buttonBar, 0.0);
        return anchorPane;
    }

    private static void setSeatReservation(SeatReservation seatReservation) {
        seatReservation.setFlightDesignator("null");
        seatReservation.setFlightDate(null);
        seatReservation.setFirstName("null");
        seatReservation.setLastName("null");
        seatReservation.setNumberOfBags(0);
    }
    //private updateUI(){
    //    flightDesignatorField.setText(seatReservation.getFlightDesignator());
    //    return
    //}
    public static void main(String[] args) {
        launch();
    }
}


