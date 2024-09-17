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
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.List;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;


public class FlightTableController {

    @FXML
    private TableView<ScheduledFlight> flightTableView;

    @FXML
    private TableColumn<ScheduledFlight, String> flightDesignatorCol, departureAirportIdentCol, arrivalAirportIdentCol, daysOfWeekCol;

    private final List<String> daysOrder = Arrays.asList("M", "T", "W", "R", "F", "S", "U");

    public void initialize() {
        //Table view stuff
        flightDesignatorCol.setCellValueFactory(new PropertyValueFactory<>("flightDesignator"));
        departureAirportIdentCol.setCellValueFactory(new PropertyValueFactory<>("departureAirportIdent"));
        arrivalAirportIdentCol.setCellValueFactory(new PropertyValueFactory<>("arrivalAirportIdent"));
        daysOfWeekCol.setCellValueFactory(cellInfo -> {
            ScheduledFlight flight = cellInfo.getValue();
            String sortedDays = flight.getDaysOfWeek().stream().map(Enum::toString).collect(Collectors.joining(", "));
            return new SimpleStringProperty(sortedDays);
        });
        flightTableView.getSelectionModel().selectedItemProperty().addListener(c -> tableSelectionChanged());
    }

    // Show the flights available
    public void showFlights(List<ScheduledFlight> flights) {
        SortedList<ScheduledFlight> sortedList = new SortedList<>(FXCollections.observableList(flights));
        flightTableView.setItems(sortedList);
        sortedList.comparatorProperty().bind(flightTableView.comparatorProperty());
        flightTableView.refresh();
    }

    public void onFlightSectionChanged(EventHandler<FlightTableEvent> handler) {
        flightTableView.addEventHandler(FlightTableEvent.FLIGHT_SELECTED, handler);
    }

    private void tableSelectionChanged() {
        ScheduledFlight selectedFlight = flightTableView.getSelectionModel().getSelectedItem();
        if(selectedFlight != null) {
            FlightTableEvent event = new FlightTableEvent(FlightTableEvent.FLIGHT_SELECTED, selectedFlight);
            flightTableView.fireEvent(event);
        }
    }

    public void select(ScheduledFlight flight) {
        flightTableView.getSelectionModel().select(flight);
    }

    public void updateFlight(ScheduledFlight scheduledFlight) {
        scheduledFlight.setFlightDesignator(flightDesignatorCol.getText());
        scheduledFlight.setDepartureAirportIdent(departureAirportIdentCol.getText());
        scheduledFlight.setArrivalAirportIdent(arrivalAirportIdentCol.getText());
    }

    public static class FlightTableEvent extends Event {
        public static final EventType<FlightTableEvent> ANY = new EventType<>(Event.ANY, "ANY");

        public static final EventType<FlightTableEvent> FLIGHT_SELECTED = new EventType<>(Event.ANY, "FLIGHT_SELECTED");

        private final ScheduledFlight selectedFlight;

        public FlightTableEvent(EventType<FlightTableEvent> eventType, ScheduledFlight selectedFlight) {
            super(eventType);
            this.selectedFlight = selectedFlight;
        }

        public ScheduledFlight getSelectedFlight() {
            return selectedFlight;
        }
    }
}