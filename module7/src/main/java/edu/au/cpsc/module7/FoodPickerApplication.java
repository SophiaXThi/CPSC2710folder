package edu.au.cpsc.module7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.io.IOException;

public class FoodPickerApplication extends Application {
    private List<String> selectedFoods = new ArrayList<>();
    private WebView webView;


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("food-picker.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Load the CSS file instead of the FXML file
        scene.getStylesheets().add(getClass().getResource("miscstyle/style.css").toExternalForm());
        stage.setTitle("Are you HUNGRY?!");
        stage.setScene(scene);
        stage.show();

        webView = new WebView();
        WebEngine webEngine;
    }

    public static void main(String[] args) {
        launch();
    }
}