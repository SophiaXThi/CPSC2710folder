package edu.au.cpsc.module3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class AirportApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AirportApplication.class.getResource("hello-view.fxml"));
        // Load the layout from the FXML file
        BorderPane root = fxmlLoader.load();

        // Create the scene with the loaded layout
        Scene scene = new Scene(root); // Set initial size
         // Set the scene on the stage
        stage.setScene(scene);
        stage.setTitle("Airport Application");
        stage.show();

    }
    public static void main(String[] args) {
        launch();
    }

}
