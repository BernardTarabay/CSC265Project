package com.example.geoquiz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PlacesController {

    @FXML
    private TextField textField;

    @FXML
    private Label messageLabel;

    @FXML
    void checkAnswer(ActionEvent event) {
        // Get the text from the TextField
        String answer = textField.getText();

        // Check if the entered text is "Italy" or "italy"
        if (answer.equalsIgnoreCase("Italy")) {
            // Display a message if the answer is correct
            messageLabel.setText("Correct Answer! Italy is the correct answer.");
        } else {
            // Display a message if the answer is incorrect
            messageLabel.setText("Incorrect Answer! Please try again.");
        }

        // Clear the text field for a new answer
        textField.clear();
    }
}


