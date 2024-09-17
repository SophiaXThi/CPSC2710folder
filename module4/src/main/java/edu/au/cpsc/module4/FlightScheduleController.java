package edu.au.cpsc.module4;

import edu.au.cpsc.module4.ScheduledFlight;
import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.List;

public class FlightScheduleController {

    @FXML
    private GridPane flightScheduleGridPane;

    @FXML
    private TextField flightDesignatorTextField, departureAirportIdentTextField, arrivalAirportIdentTextField;

    @FXML
    private ToggleButton mondayToggleButton, tuesdayToggleButton, wednesdayToggleButton, thursdayToggleButton, fridayToggleButton, saturdayToggleButton, sundayToggleButton;


    // Methods for the text fields
    public void showFlight(ScheduledFlight scheduledFlight) {
        if (scheduledFlight == null) {
            flightDesignatorTextField.clear();
            departureAirportIdentTextField.clear();
            arrivalAirportIdentTextField.clear();
        return;
        }
        flightDesignatorTextField.setText(scheduledFlight.getFlightDesignator());
        departureAirportIdentTextField.setText(scheduledFlight.getDepartureAirportIdent());
        arrivalAirportIdentTextField.setText(scheduledFlight.getArrivalAirportIdent());
    }

    public void updateFlight(ScheduledFlight scheduledFlight) {
        scheduledFlight.setFlightDesignator(flightDesignatorTextField.getText());
        scheduledFlight.setDepartureAirportIdent(departureAirportIdentTextField.getText());
        scheduledFlight.setArrivalAirportIdent(arrivalAirportIdentTextField.getText());
    }

    // Button stuff

}