package edu.au.cpsc.module2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
//import org.w3c.dom.Text;

import java.io.IOException;

//instance variables that need to be added
//Textbox variables:
//
//
//
//
//
public class SeatReservationApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Group center = new Group();
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        //Label label_left = new Label();
        //Label label_right = new Label();


        //Fields to add data
        TextField flightDesignator = new TextField("Flight Designator");
        DatePicker flightDatePicker = new DatePicker();
        TextField firstName = new TextField("First Name");
        TextField lastName = new TextField("Last Name");
        CheckBox withInfantCheckBox = new CheckBox("Flying with Infant");
        TextField numberOfPassengers = new TextField("Number of Passengers");

        //User HBox for buttons
        Button cancelButton = new Button("Cancel");
        Button saveButton = new Button("Save");
        HBox bottomButtons = new HBox(cancelButton, saveButton);
        borderPane.setBottom(bottomButtons);


        Scene scene = new Scene(borderPane, 800, 720);
        stage.setTitle("Seat Reservation Application");
        stage.setScene(scene);
        stage.show();

    }

    private AnchorPane createButtonBar(){
        Button cancelButton = new Button("Cancel");
        Button saveButton = new Button("Save");
        HBox buttonBar = new HBox(cancelButton, saveButton);
        AnchorPane anchorPane = new AnchorPane(buttonBar);
        AnchorPane.setBottomAnchor(buttonBar, 0.0);
        return anchorPane;
    }

    public static void main(String[] args) {
        launch();
    }
}