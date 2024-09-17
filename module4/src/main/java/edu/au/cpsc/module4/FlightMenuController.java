package edu.au.cpsc.module4;


import edu.au.cpsc.module4.ScheduledFlight;
import edu.au.cpsc.module4.FlightTableController;
import edu.au.cpsc.module4.AirlineDatabase;
import edu.au.cpsc.module4.Database;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import edu.au.cpsc.module4.FlightTableController.FlightTableEvent;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;


public class FlightMenuController {

    // Call in my crappy controllers
    @FXML FlightTableController flightTableController;

    @FXML FlightScheduleController flightScheduleController;

    @FXML
    private MenuItem flightMenu;

    @FXML
    private Button addButton, removeButton, updateButton, quitButton;

    private ScheduledFlight flightBeingEdited;

    private boolean flightBeingEditedIsNew;

    @FXML
    public void initialize() throws FileNotFoundException {
        flightTableController.onFlightSectionChanged(this::handleFlightSelection);
        flightTableController.showFlights(Database.getDatabase().getScheduledFlights());
        flightTableController.onFlightSectionChanged(event -> showFlight(event.getSelectedFlight()));
        showFlight(null);
    }

    public void handleFlightSelection(FlightTableEvent event) {
        ScheduledFlight selectedFlight = event.getSelectedFlight();
    }
    public void showFlight(ScheduledFlight flight) {
        flightScheduleController.showFlight(flight);
        HashSet<String> daysOfWeek = new HashSet<>();
        flightBeingEdited = flight == null ? new ScheduledFlight("", "", null, "", null, daysOfWeek) : flight;

    flightBeingEditedIsNew = flight == null;
    String changedButtonLabel = flightBeingEditedIsNew ? "Add" : "Updated";
    updateButton.setText(changedButtonLabel);
    flightMenu.setText(changedButtonLabel);
    }

    @FXML
    public void updateButtonAction() throws FileNotFoundException {
        flightTableController.updateFlight(flightBeingEdited);
        if (flightBeingEditedIsNew) {
            Database.getDatabase().addScheduledFlight(flightBeingEdited);
        }
        else {
            Database.getDatabase().updateScheduledFlight(flightBeingEdited);
        }
        Database.saveDatabase();
        flightTableController.showFlights(Database.getDatabase().getScheduledFlights());
        flightTableController.select(flightBeingEdited);
    }

    @FXML
    public void addButtonAction() throws FileNotFoundException {
        flightTableController.select(null);
    }

    @FXML
    public void removeButtonAction() throws FileNotFoundException {
        if (flightBeingEditedIsNew) {
            flightTableController.select(null);
        }
        else {
            Database.getDatabase().removeScheduledFlight(flightBeingEdited);
            Database.saveDatabase();
            flightTableController.showFlights(Database.getDatabase().getScheduledFlights());
        }
    }

    @FXML
    public void quitButtonAction() {
        Platform.exit();
    }

}
