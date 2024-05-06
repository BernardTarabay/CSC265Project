package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlagsController {

    @FXML
    private ImageView flagDisplay; // ImageView for displaying the flag
    @FXML
    private Text text; // Text for displaying the guessed letters
    @FXML
    private Text winStatus; // Text for displaying win/lose status
    @FXML
    private Text realWord; // Text for displaying the correct country name
    @FXML
    private Pane buttons; // Pane containing letter buttons
    @FXML
    private Label countryName; // Label for displaying the country name

    private int mistakes; // Counter for incorrect guesses
    private int correct; // Counter for correct guesses
    private String myWord; // The name of the country
    private List<String> answer; // List to store correct guesses
    private CountryData countryData; // Instance of CountryData to get country information

    @FXML
    public void initialize() {
        // Initialize CountryData instance
        countryData = new CountryData();
        try {
            // Get a random country
            Country randomCountry = countryData.getRandomCountry();
            // Set the country name label
            countryName.setText(randomCountry.getMyWord());
            // Set the country flag image
            updateFlagImage(randomCountry.getFlagImagePath());
            // Initialize game variables
            myWord = randomCountry.getMyWord();
            answer = new ArrayList<>();
            for (int i = 0; i < myWord.length(); i++) {
                answer.add("_"); // Initialize with underscores for each letter
            }
            // Update displayed text with underscores
            updateDisplayedText();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void updateFlagImage(String imageName) throws FileNotFoundException {
        // Construct the file path
        // Load image from resources
        InputStream input = getClass().getClassLoader().getResourceAsStream(imageName);
        if (input == null) {
            throw new FileNotFoundException("Image file not found: " + imageName);
        }
        Image image = new Image(input);
        flagDisplay.setImage(image);
    }


    @FXML
    private void onClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String letter = clickedButton.getText();
        clickedButton.setDisable(true); // Disable the clicked button
        boolean correctGuess = false;

        // Check if the guessed letter is correct
        for (int i = 0; i < myWord.length(); i++) {
            if (Character.toString(myWord.charAt(i)).equalsIgnoreCase(letter)) {
                answer.set(i, letter);
                correctGuess = true;
                correct++;
            }
        }

        // Update displayed text with correct guesses
        updateDisplayedText();

        // Check win/lose condition
        if (correct == myWord.length()) {
            winStatus.setText("You Win!");
            buttons.setDisable(true); // Disable all buttons
        } else if (!correctGuess) {
            // Increment mistakes counter for incorrect guesses
            mistakes++;
            // Check for losing condition
            if (mistakes == 6) {
                winStatus.setText("You Lose!");
                realWord.setText("The actual Country was " + myWord);
                buttons.setDisable(true); // Disable all buttons
            }
        }
    }

    private void updateDisplayedText() {
        // Combine the answer list into a single string
        String displayedText = String.join(" ", answer);
        // Set the displayed text
        text.setText(displayedText);
    }
}
