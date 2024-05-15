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

public class CapitalsController {

    @FXML
    private ImageView flagDisplay;
    @FXML
    private Text text;
    @FXML
    private Text winStatus;
    @FXML
    private Text realWord;
    @FXML
    private Pane buttons;
    @FXML
    private Label capitalName;
    @FXML
    private Button changeFlagButton;
    @FXML
    private Button hintButton;
    @FXML
    private Pane popupPane; // Added Pane for popup
    @FXML
    private Text popupMessage; // Added Text for popup message

    private int mistakes;
    private int correct;
    private String capital;
    private List<String> answer;
    private CountryData countryData;
    private List<Integer> unrevealedIndices;

    @FXML
    public void initialize() {
        countryData = new CountryData();
        loadNewCountry();
    }

    private void loadNewCountry() {
        Country randomCountry = countryData.getRandomCountry();
        if (randomCountry == null) {
            System.out.println("No country was fetched");
            return;
        }
        try {
            updateFlagImage(randomCountry.getFlagImagePath());
            capital = randomCountry.getCapital();
            if (capital == null) {
                System.out.println("Country name is null");
                return;
            }
            capitalName.setText(capital);
            answer = new ArrayList<>();
            unrevealedIndices = new ArrayList<>();
            for (int i = 0; i < capital.length(); i++) {
                answer.add("_");
                unrevealedIndices.add(i);
            }
            updateDisplayedText();
            winStatus.setText("");
            realWord.setText("");
            popupPane.setVisible(false); // Hide popup initially
            buttons.setDisable(false);
            for (int i = 0; i < buttons.getChildren().size(); i++) {
                if (buttons.getChildren().get(i) instanceof Button) {
                    buttons.getChildren().get(i).setDisable(false);
                }
            }
            hintButton.setDisable(false);
            mistakes = 0;
            correct = 0;
        } catch (FileNotFoundException e) {
            System.out.println("Failed to load image: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void updateFlagImage(String imageName) throws FileNotFoundException {
        String path = "/flags/" + imageName;
        InputStream input = getClass().getResourceAsStream(path);
        if (input == null) {
            throw new FileNotFoundException("Image file not found: " + path);
        }
        Image image = new Image(input);
        flagDisplay.setImage(image);
    }

    @FXML
    private void onClick(ActionEvent event) {
        if (capital == null) {
            System.out.println("Name not initialized");
            return;
        }
        Button clickedButton = (Button) event.getSource();
        String letter = clickedButton.getText();
        System.out.println("Clicked letter: " + letter);
        clickedButton.setDisable(true);
        boolean correctGuess = false;

        for (int i = 0; i < capital.length(); i++) {
            if (Character.toString(capital.charAt(i)).equalsIgnoreCase(letter)) {
                answer.set(i, letter);
                unrevealedIndices.remove((Integer) i);
                correctGuess = true;
                correct++;
            }
        }

        System.out.println("Current answer state: " + answer);
        updateDisplayedText();

        if (correct == capital.length()) {
            popupMessage.setText("You Win!");
            popupPane.setVisible(true);
            buttons.setDisable(true);
            hintButton.setDisable(true);
        } else if (!correctGuess) {
            mistakes++;
            if (mistakes == 6) {
                popupMessage.setText("You Lose! The actual Country was " + capital);
                popupPane.setVisible(true);
                buttons.setDisable(true);
                hintButton.setDisable(true);
            }
        }
    }

    private void updateDisplayedText() {
        String displayedText = String.join(" ", answer);
        text.setText(displayedText);
    }

    @FXML
    private void handleChangeFlag(ActionEvent event) {
        loadNewCountry();
    }

    @FXML
    private void handleHint(ActionEvent event) {
        if (!unrevealedIndices.isEmpty()) {
            int randomIndex = unrevealedIndices.remove(new Random().nextInt(unrevealedIndices.size()));
            String letter = Character.toString(capital.charAt(randomIndex));
            answer.set(randomIndex, letter);
            correct++;
            updateDisplayedText();
            if (correct == capital.length()) {
                popupMessage.setText("You Win!");
                popupPane.setVisible(true);
                buttons.setDisable(true);
                hintButton.setDisable(true);
            }
        }
    }

    @FXML
    private void handlePopupClose(ActionEvent event) {
        popupPane.setVisible(false);
    }
}
