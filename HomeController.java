package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {
    @FXML
    private Button capitalsQuizButton;
    @FXML
    private Button flagsQuizButton;

    @FXML
    public void initialize() {
        capitalsQuizButton.setOnAction(e -> loadView("Capitals.fxml"));
        flagsQuizButton.setOnAction(e -> loadView("Flags.fxml"));
    }

    private void loadView(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo1/" + fxml));
            Stage stage = (Stage) flagsQuizButton.getScene().getWindow(); // Using flagsQuizButton just to get the stage
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace(); // Proper error handling should be implemented
        }
    }
}

