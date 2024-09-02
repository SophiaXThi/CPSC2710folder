package edu.au.cpsc.module2;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//import org.w3c.dom.Text;
import java.io.IOException;

import static javafx.scene.layout.AnchorPane.setBottomAnchor;

public class SeatReservationApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
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

        //This field can not be edited
        TextField numberOfPassengersField = new TextField();
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

    public static void main(String[] args) {
        launch();
    }
}