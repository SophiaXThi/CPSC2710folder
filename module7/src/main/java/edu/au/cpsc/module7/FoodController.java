package edu.au.cpsc.module7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FoodController {
    private List<String> selectedFoods = new ArrayList<>();

    @FXML private CheckBox bbqBtn;
    @FXML private CheckBox chineseBtn;
    @FXML private CheckBox fastfoodBtn;
    @FXML private CheckBox greekBtn;
    @FXML private CheckBox indianBtn;
    @FXML private CheckBox italianBtn;
    @FXML private CheckBox japaneseBtn;
    @FXML private CheckBox mexicanBtn;
    @FXML private CheckBox vietnameseBtn;
    @FXML private Label selectedFoodLabel;

    @FXML private WebView webView;
    @FXML private Button pickBtn;
    @FXML private Button searchBtn;
    @FXML private Button deleteBtn;
    @FXML private Button quitBtn;

    @FXML private MenuItem closeMenuItem;
    @FXML private MenuItem deleteMenuItem;
    @FXML private MenuItem aboutMenuItem;

    @FXML
    private void initialize() {

        // Set the toggle buttons to call selectFood when toggled
        chineseBtn.setOnAction(event -> toggleFoodSelection(chineseBtn));
        japaneseBtn.setOnAction(event -> toggleFoodSelection(japaneseBtn));
        italianBtn.setOnAction(event -> toggleFoodSelection(italianBtn));
        indianBtn.setOnAction(event -> toggleFoodSelection(indianBtn));
        greekBtn.setOnAction(event -> toggleFoodSelection(greekBtn));
        fastfoodBtn.setOnAction(event -> toggleFoodSelection(fastfoodBtn));
        bbqBtn.setOnAction(event -> toggleFoodSelection(bbqBtn));
        mexicanBtn.setOnAction(event -> toggleFoodSelection(mexicanBtn));
        vietnameseBtn.setOnAction(event -> toggleFoodSelection(vietnameseBtn));

        //Other buttons
        pickBtn.setOnAction(event -> pickRandomFood());
        searchBtn.setOnAction(event -> handleSearchButton());
        deleteBtn.setOnAction(event -> handleDelete());
        quitBtn.setOnAction(event -> quitApplication());

        // Keyboard shortcuts
        closeMenuItem.setAccelerator(KeyCombination.keyCombination("Shortcut+Q"));
        deleteMenuItem.setAccelerator(KeyCombination.keyCombination("Shortcut+D"));
        aboutMenuItem.setAccelerator(KeyCombination.keyCombination("Shortcut+A"));

    }

    @FXML
    public void toggleFoodSelection(CheckBox checkBox) {
        String food = checkBox.getText();
        if (checkBox.isSelected()) {
            selectedFoods.add(food);
            System.out.println(selectedFoods);
        } else {
            selectedFoods.remove(food);
            System.out.println(selectedFoods);
        }
        System.out.println("Current selection: " + selectedFoods);

    }
    @FXML
    private void pickRandomFood() {
        if (!selectedFoods.isEmpty()) {
            System.out.println("Picking random food");
            System.out.println("Selected foods: " + selectedFoods);

            if (!selectedFoods.isEmpty()) {
                Random random = new Random();
                int randomIndex = random.nextInt(selectedFoods.size());
                String selectedFood = selectedFoods.get(randomIndex);

                System.out.println("Randomly selected food: " + selectedFood);

                // Check if selectedFoodLabel is initialized
                if (selectedFoodLabel != null) {
                    selectedFoodLabel.setText("Randomly Selected Food: " + selectedFood);
                } else {
                    System.out.println("selectedFoodLabel is null!");
                }
            } else {
                selectedFoodLabel.setText("Please select at least one food option.");
            }
        }
    }


    private void loadRestaurantSearch(String food) {
        try {
            // Create a new Stage
            Stage stage = new Stage();
            WebView webView = new WebView();
            WebEngine webEngine = webView.getEngine();

            // Load the Google search results
            webEngine.load("https://www.google.com/search?find_desc=" + selectedFoodLabel + "&find_loc=YourLocation");

            // Set up the new scene and stage
            Scene scene = new Scene(webView, 800, 600);
            stage.setScene(scene);
            stage.setTitle("Search Results for " + food);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSearchButton() {
        String food = selectedFoodLabel.getText().replace("Randomly Selected Food: ", "").trim();

        // Call loadRestaurantSearch with the selected food
        if (!food.isEmpty()) {
            loadRestaurantSearch(food);
        } else {
            System.out.println("Please select a food option before searching.");
        }
    }


    @FXML
    private void searchSelectedFood() {
        if (!selectedFoods.isEmpty()) {
            loadRestaurantSearch(selectedFoods.get(0));
        }
    }

    @FXML
    private void quitApplication() {
        System.exit(0);
    }

    //Last minute menu bar stuff
    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleAbout() {
        // Opens up an ABOUT window to explain how to use the app
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Food Picker Application");
        alert.setContentText("This app allows you to pick from a list of favorite foods when you can't decide which one you want to eat. "
        + "Use the checkboxes to select your choices then click 'Pick' to randomly choose. "
        + "The chosen food will be displayed and if you select 'Search' a new window will pop up allowing you to google for restaurants in your area. "
        + "You can delete your choices by deselecting the checkboxes, selecting 'Delete', or going to the menu -> edit -> delete"
        + "The search window can be closed at any time and new choices can be picked. "
        + "Keyboard shortcuts: Ctrl+Q closes the app\n" +
                "Ctrl+D deletes the choices\n" +
                "Ctrl+A opens the about section\n");
        alert.showAndWait();
    }

    @FXML
    private void handleDelete() {
        // Deletes all the selected choices
        selectedFoods.clear();
        System.out.println("All of the selected foods have been deleted");

        // Deselects the boxes
        bbqBtn.setSelected(false);
        chineseBtn.setSelected(false);
        fastfoodBtn.setSelected(false);
        greekBtn.setSelected(false);
        indianBtn.setSelected(false);
        italianBtn.setSelected(false);
        japaneseBtn.setSelected(false);
        mexicanBtn.setSelected(false);
        vietnameseBtn.setSelected(false);

        // Update the UI label to display the default message
        if (selectedFoodLabel != null) {
            selectedFoodLabel.setText("No food has been selected");
        }
    }

}