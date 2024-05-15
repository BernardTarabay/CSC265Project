package com.example.geoquiz;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainPageController {

    @FXML
    private Label helpText;
    @FXML
    private Button backtologin;

    @FXML
    public void intialize(){
        helpText.setVisible(false);
    }
    @FXML
    public void displaytext(ActionEvent event) {
        // Display help text when the HelpButton is clicked

        helpText.setVisible(true);

        // Create a timeline to hide the help text after 3 seconds
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(3), event1 -> {
                    // Hide the help text after 3 seconds
                    helpText.setVisible(false);
                })
        );
        timeline.play();
    }
    @FXML
    public void goBackToLogin(ActionEvent event) {
        try {
            // Load the login page FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPageGeo.fxml"));
            Parent root = loader.load();

            // Get the stage from the event source
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Create a new scene with the loaded login page root node
            Scene scene = new Scene(root);

            // Set the new scene on the current stage
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void presstoplaces(ActionEvent event) {
        try {
            // Load the Places.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Places.fxml"));
            Parent root = loader.load();

            // Get the stage from the event source
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Create a new scene with the loaded Places.fxml root node
            Scene scene = new Scene(root);

            // Set the new scene on the current stage
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
