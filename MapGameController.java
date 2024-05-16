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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MapGameController {

    @FXML
    private ImageView mapImageView;
    @FXML
    private TextField guessField;
    @FXML
    private Text resultText;
    @FXML
    private Label timerLabel;
    @FXML
    private Pane popupPane;
    @FXML
    private Text popupMessage;
    @FXML
    private Button continueButton;

    private static final int TIMER_SECONDS = 90; // 1 minute 30 seconds
    private Timeline timer;
    private int timeRemaining;
    private int elapsedTime;
    private String currentCountry;

    private static final List<String> COUNTRIES = Arrays.asList(
            "Algeria.png", "Argentina.png", "Australia.png", "Brazil.png", "Canada.png", "Chile.png",
            "China.png", "Colombia.png", "Egypt.png", "England.png", "Finland.png", "France.png",
            "Germany.png", "Greece.png", "Greenland.png", "Iceland.png", "India.png", "Indonesia.png",
            "Italy.png", "Japan.png", "Lebanon.png", "Libya.png", "Mexico.png", "Mongolia.png",
            "NewZealand.png", "Niger.png", "Norway.png", "PapaNewGuinea.png", "Peru.png", "Portugal.png",
            "Romania.png", "Russia.png", "SaudiArabia.png", "Spain.png", "SriLanka.png", "Sweeden.png",
            "Syria.png", "Turkey.png", "Ukraine.png", "United States.png", "Venezuela.png"
    );

    @FXML
    public void initialize() {
        listAllMaps();
        startNewGame();
    }

    private void startNewGame() {
        loadRandomCountry();
        startTimer();
        guessField.clear();
        resultText.setText("");
    }

    private void loadRandomCountry() {
        currentCountry = getRandomCountry();
        String encodedCountry = URLEncoder.encode(currentCountry, StandardCharsets.UTF_8);
        String imagePath = "/maps/" + encodedCountry;
        try {
            updateMapImage(imagePath);
        } catch (FileNotFoundException e) {
            System.out.println("Failed to load image: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String getRandomCountry() {
        Random random = new Random();
        return COUNTRIES.get(random.nextInt(COUNTRIES.size()));
    }

    private void updateMapImage(String imagePath) throws FileNotFoundException {
        System.out.println("Attempting to load image: " + imagePath);
        URL imageUrl = getClass().getResource(imagePath);
        if (imageUrl == null) {
            throw new FileNotFoundException("Image file not found: " + imagePath);
        }
        Image image = new Image(imageUrl.toString());
        mapImageView.setImage(image);
    }

    @FXML
    private void handleGuess(ActionEvent event) {
        String userGuess = guessField.getText().trim();
        String countryName = currentCountry.replace(".png", "").replace(" ", "");
        if (userGuess.equalsIgnoreCase(countryName)) {
            timer.stop();
            resultText.setText("Correct! The country was " + countryName);
            resultText.setFill(javafx.scene.paint.Color.GREEN);
            popupMessage.setText("Correct! The country was " + countryName + "\nTime taken: " + getElapsedTime());
            continueButton.setVisible(true);
            showPopup();
        } else {
            resultText.setText("Incorrect guess! Try again.");
            resultText.setFill(javafx.scene.paint.Color.RED);
        }
    }

    @FXML
    private void handleRestart(ActionEvent event) {
        popupPane.setVisible(false);
        startNewGame();
    }

    @FXML
    private void handleExit(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("GeoMainPage.fxml"));
            Stage stage = (Stage) mapImageView.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    private void updateTimerLabel() {
        int minutes = timeRemaining / 60;
        int seconds = timeRemaining % 60;
        timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
    }

    private void handleTimeOut() {
        String countryName = currentCountry.replace(".png", "").replace(" ", "");
        popupMessage.setText("Time's up! The country was " + countryName);
        continueButton.setVisible(false);
        showPopup();
    }

    private String getElapsedTime() {
        int minutes = elapsedTime / 60;
        int seconds = elapsedTime % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    private void showPopup() {
        popupPane.setVisible(true);
    }

    private void listAllMaps() {
        try {
            InputStream in = getClass().getResourceAsStream("/maps");
            if (in == null) {
                System.out.println("Maps directory not found");
                return;
            }
            String[] maps = getClass().getResource("/maps").getFile().split(",");
            for (String map : maps) {
                System.out.println("Found map: " + map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
