package edu.au.cpsc.module4;

import edu.au.cpsc.module4.ScheduledFlight;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.time.DayOfWeek;
import java.util.HashSet;

public class FlightScheduleController {

    @FXML
    private TextField flightDesignatorTextField, departureAirportIdentTextField, arrivalAirportIdentTextField;

    @FXML
    private ToggleButton mondayToggleButton, tuesdayToggleButton, wednesdayToggleButton, thursdayToggleButton, fridayToggleButton, saturdayToggleButton, sundayToggleButton;

    @FXML
    private Button addButton, removeButton, updateButton, deleteButton;

    @FXML
    private GridPane flightScheduleGridPane;

    @FXML
    private TableView<ScheduledFlight> flightTableView;

    @FXML
    private TableColumn<ScheduledFlight, String> flightDesignatorCol;

    @FXML
    private TableColumn<ScheduledFlight, String> departureAirportIdentCol;

    @FXML
    private TableColumn<ScheduledFlight, String> arrivalAirportIdentCol;

    @FXML
    private TableColumn<ScheduledFlight, String> daysOfWeekCol;

    private ScheduledFlight scheduledFlight;

    private AirlineDatabase airlineDatabase = new AirlineDatabase();

    @FXML
    public void addScheduledFlight(){
        ScheduledFlight scheduledFlight = new ScheduledFlight();
        scheduledFlight.setFlightDesignator(flightDesignatorTextField.getText());
        scheduledFlight.setDepartureAirportIdent(departureAirportIdentTextField.getText());
        scheduledFlight.setArrivalAirportIdent(arrivalAirportIdentTextField.getText());

        // How do these toggle buttons work???
        HashSet<DayOfWeek> dayOfWeeks = new HashSet<>();
        if(mondayToggleButton.isSelected()){
            dayOfWeeks.add(DayOfWeek.MONDAY);
        }
        else if(tuesdayToggleButton.isSelected()){
            dayOfWeeks.add(DayOfWeek.TUESDAY);
        }
        else if(wednesdayToggleButton.isSelected()){
            dayOfWeeks.add(DayOfWeek.WEDNESDAY);
        }
        else if(thursdayToggleButton.isSelected()){
            dayOfWeeks.add(DayOfWeek.THURSDAY);
        }
        else if(fridayToggleButton.isSelected()){
            dayOfWeeks.add(DayOfWeek.FRIDAY);
        }
        else if(saturdayToggleButton.isSelected()){
            dayOfWeeks.add(DayOfWeek.SATURDAY);
        }
        else if(sundayToggleButton.isSelected()){
            dayOfWeeks.add(DayOfWeek.SUNDAY);
        }

        scheduledFlight.setDaysOfWeek(dayOfWeeks);
        airlineDatabase.addScheduledFlight(scheduledFlight);
    }

    public void removeScheduledFlight(ScheduledFlight scheduledFlight){
        if (scheduledFlight != null) {
            airlineDatabase.removeScheduledFlight(scheduledFlight);
        }
    }
    public void showFlightSchedule(ScheduledFlight scheduledFlight) {
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

    public void updateFlightSchedule(ScheduledFlight scheduledFlight) {
        if (scheduledFlight == null) {
            flightDesignatorTextField.clear();
            departureAirportIdentTextField.clear();
            arrivalAirportIdentTextField.clear();
        } else if (scheduledFlight != null) {
            scheduledFlight.setFlightDesignator(flightDesignatorTextField.getText());
            scheduledFlight.setDepartureAirportIdent(departureAirportIdentTextField.getText());
            scheduledFlight.setArrivalAirportIdent(arrivalAirportIdentTextField.getText());
            scheduledFlight.setDaysOfWeek(scheduledFlight.getDaysOfWeek());
            airlineDatabase.updateScheduledFlight(scheduledFlight);
        }
    }
}