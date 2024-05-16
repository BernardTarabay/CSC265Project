package com.example.demo1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlagsController {

    //FXML imports
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
    private Label countryName;
    @FXML
    private Button changeFlagButton;
    @FXML
    private Button hintButton;
    @FXML
    private Pane popupPane;
    @FXML
    private Text popupMessage;
    @FXML
    private Button restartButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button continueButton;
    @FXML
    private Label timerLabel;

    //private data fields
    private int mistakes;
    private int correct;
    private int hintCount;
    private static final int MAX_HINTS = 3;
    private static final int TIMER_SECONDS = 90; // 1 minute 30 seconds
    private String name;
    private List<String> answer;
    private CountryData countryData;
    private List<Integer> unrevealedIndices;
    private int countriesGuessedCorrectly;
    private Timeline timer;
    private int timeRemaining;
    private int elapsedTime;

    //Initialize method, loads the new country and sets the guessed countries to 0 (total=8)
    @FXML
    public void initialize() {
        countryData = new CountryData();
        countriesGuessedCorrectly = 0;
        loadNewCountry();
    }

    //Load new country method, calls the getRandomCountry from the CountryData.java class,
    // sets the name of the country to be guessed
    private void loadNewCountry() {
        Country randomCountry = countryData.getRandomCountry();
        if (randomCountry == null) {
            System.out.println("No country was fetched");
            return;
        }
        try {
            updateFlagImage(randomCountry.getFlagImagePath());
            name = randomCountry.getName();
            if (name == null) {
                System.out.println("Country name is null");
                return;
            }
            countryName.setText(name);
            answer = new ArrayList<>();
            unrevealedIndices = new ArrayList<>();
            for (int i = 0; i < name.length(); i++) {
                answer.add("_");
                unrevealedIndices.add(i);
            }
            updateDisplayedText();
            winStatus.setText("");
            realWord.setText("");
            popupPane.setVisible(false);
            buttons.setDisable(false);
            for (int i = 0; i < buttons.getChildren().size(); i++) {
                if (buttons.getChildren().get(i) instanceof Button) {
                    buttons.getChildren().get(i).setDisable(false);
                }
            }
            hintButton.setDisable(false);
            hintCount = 0;
            mistakes = 0;
            correct = 0;
            startTimer();
        } catch (FileNotFoundException e) {
            System.out.println("Failed to load image: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //updateFlagImage method, sets the image.
    private void updateFlagImage(String imageName) throws FileNotFoundException {
        String path = "/flags/" + imageName;
        InputStream input = getClass().getResourceAsStream(path);
        if (input == null) {
            throw new FileNotFoundException("Image file not found: " + path);
        }
        Image image = new Image(input);
        flagDisplay.setImage(image);
    }

    //onClick method, sets up the keyboard, disables used keys,
    // sets up the mistakes and correct guesses,
    // disables buttons when finishes, maximum amount of mistakes =6.
    @FXML
    private void onClick(ActionEvent event) {
        if (name == null) {
            System.out.println("Name not initialized");
            return;
        }
        Button clickedButton = (Button) event.getSource();
        String letter = clickedButton.getText();
        System.out.println("Clicked letter: " + letter);
        clickedButton.setDisable(true);
        boolean correctGuess = false;

        for (int i = 0; i < name.length(); i++) {
            if (Character.toString(name.charAt(i)).equalsIgnoreCase(letter)) {
                answer.set(i, letter);
                unrevealedIndices.remove((Integer) i);
                correctGuess = true;
                correct++;
            }
        }

        System.out.println("Current answer state: " + answer);
        updateDisplayedText();

        if (correct == name.length()) {
            countriesGuessedCorrectly++;
            timer.stop();
            if (countriesGuessedCorrectly == 8) {
                popupMessage.setText("You Win the Game!\nTime taken: " + getElapsedTime());
                showPopup(false);
                countriesGuessedCorrectly = 0; // Reset for a new game
            } else {
                popupMessage.setText("You guessed the country correctly! " + countriesGuessedCorrectly + "/8\nTime taken: " + getElapsedTime());
                showPopup(true);
            }
        } else if (!correctGuess) {
            mistakes++;
            if (mistakes == 6) {
                timer.stop();
                popupMessage.setText("You Lose! The actual Country was " + name);
                showPopup(false);
                countriesGuessedCorrectly = 0; // Reset the count if the game is lost
            }
        }
    }

    //updateDisplayedText method, updates the shown text of the country's name.
    private void updateDisplayedText() {
        String displayedText = String.join(" ", answer);
        text.setText(displayedText);
    }

    //handleChangeFlag method, load a new country using the loadNewCountry method.
    @FXML
    private void handleChangeFlag(ActionEvent event) {
        loadNewCountry();
    }

    //handleHint method, creates a variable unrevealedIndices,
    //stores all the non-guessed letters,
    //randomly picks one of the non-guessed letters when pressed.
    @FXML
    private void handleHint(ActionEvent event) {
        if (hintCount < MAX_HINTS && !unrevealedIndices.isEmpty()) {
            int randomIndex = unrevealedIndices.remove(new Random().nextInt(unrevealedIndices.size()));
            String letter = Character.toString(name.charAt(randomIndex));
            answer.set(randomIndex, letter);
            correct++;
            hintCount++;
            if (hintCount >= MAX_HINTS) {
                hintButton.setDisable(true);
            }
            updateDisplayedText();
            if (correct == name.length()) {
                countriesGuessedCorrectly++;
                timer.stop();
                if (countriesGuessedCorrectly == 8) {
                    popupMessage.setText("You Win the Game!\nTime taken: " + getElapsedTime());
                    showPopup(false);
                    countriesGuessedCorrectly = 0; // Reset for a new game
                } else {
                    popupMessage.setText("You guessed the country correctly! " + countriesGuessedCorrectly + "/8\nTime taken: " + getElapsedTime());
                    showPopup(true);
                }
            }
        }
    }

    //handlePopupClose method, Disables the winStatus popup pane when the newFlag button is pressed.
    @FXML
    private void handleContinue(ActionEvent event) {
        popupPane.setVisible(false);
        handleChangeFlag(event);
    }

    //handleRestart method, restarts the game using the loadNewCountry method.
    //Disables the winStatus popup pane when the newFlag button is pressed.
    @FXML
    private void handleRestart(ActionEvent event) {
        popupPane.setVisible(false);
        countriesGuessedCorrectly = 0;
        loadNewCountry();
    }

    //handleExit method, exit to the homepage using the switchToHomePage method,
    @FXML
    private void handleExit(ActionEvent event) {
        switchToHomePage();
    }

    //switchToHomePage method, loads the homepage into the GeoMainPage.fxml file,
    //Creates a stage, scene for the homePage.
    private void switchToHomePage() {
        try {
            Parent homePage = FXMLLoader.load(getClass().getResource("GeoMainPage.fxml"));
            Scene homeScene = new Scene(homePage);
            Stage primaryStage = (Stage) popupPane.getScene().getWindow();
            primaryStage.setScene(homeScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showPopup(boolean isContinueVisible) {
        continueButton.setVisible(isContinueVisible);
        restartButton.setVisible(true);
        exitButton.setVisible(true);
        popupPane.setVisible(true);
        buttons.setDisable(true);
        hintButton.setDisable(true);
    }

    // Start the timer for the current country
    private void startTimer() {
        timeRemaining = TIMER_SECONDS;
        elapsedTime = 0;
        updateTimerLabel();

        timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            timeRemaining--;
            elapsedTime++;
            updateTimerLabel();
            if (timeRemaining <= 0) {
                timer.stop();
                handleTimeOut();
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    // Update the timer label with the remaining time
    private void updateTimerLabel() {
        int minutes = timeRemaining / 60;
        int seconds = timeRemaining % 60;
        timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
    }

    // Handle the event when time runs out
    private void handleTimeOut() {
        popupMessage.setText("Time's up! The actual Country was " + name);
        showPopup(false);
        countriesGuessedCorrectly = 0; // Reset the count if the game is lost
    }

    // Get the elapsed time in a readable format
    private String getElapsedTime() {
        int minutes = elapsedTime / 60;
        int seconds = elapsedTime % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
