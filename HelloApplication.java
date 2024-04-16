package com.example.myproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // Main menu title
        Label titleLabel = new Label("GeoQuest");
        titleLabel.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: white;");

        // Help button for main menu
        Button mainMenuHelpButton = createHelpButton();
        mainMenuHelpButton.setOnAction(e -> showHelpPage("Main Menu", "This is the main menu. You can choose different quizzes to play."));

        // Buttons for each mini-game
        Button worldCapitalButton = createMenuButton("World Capital Quiz");
        worldCapitalButton.setOnAction(e -> redirectToQuizPage("World Capital Quiz"));
        Button worldCountryButton = createMenuButton("World Country Quiz");
        worldCountryButton.setOnAction(e -> redirectToQuizPage("World Country Quiz"));
        Button worldOceanButton = createMenuButton("World Ocean Quiz");
        worldOceanButton.setOnAction(e -> redirectToQuizPage("World Ocean Quiz"));
        Button worldFlagsButton = createMenuButton("World Flags Quiz");
        worldFlagsButton.setOnAction(e -> redirectToQuizPage("World Flags Quiz"));

        // Main menu layout
        VBox mainMenuLayout = new VBox(20);
        mainMenuLayout.setAlignment(Pos.CENTER);
        mainMenuLayout.setBackground(new Background(new BackgroundFill(Color.rgb(50, 150, 200), CornerRadii.EMPTY, Insets.EMPTY)));
        mainMenuLayout.setPadding(new Insets(50));
        mainMenuLayout.getChildren().addAll(
                titleLabel,
                mainMenuHelpButton,
                worldCapitalButton,
                worldCountryButton,
                worldOceanButton,
                worldFlagsButton
        );

        // Set up scene
        Scene scene = new Scene(mainMenuLayout, 600, 400);
        primaryStage.setTitle("GeoQuest");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to create menu buttons
    private Button createMenuButton(String text) {
        Button button = new Button(text);
        button.setPrefWidth(200);
        button.setStyle("-fx-font-size: 18px;");
        return button;
    }

    // Method to create help buttons
    private Button createHelpButton() {
        Button helpButton = new Button("?");
        helpButton.setShape(new Circle(15));
        helpButton.setStyle("-fx-font-size: 14px; -fx-background-color: #dddddd; -fx-text-fill: black;");
        return helpButton;
    }

    // Method to redirect to a quiz page
    private void redirectToQuizPage(String quizName) {
        // Quiz title
        Label titleLabel = new Label(quizName);
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Help button for quiz page
        Button helpButton = createHelpButton();
        helpButton.setAlignment(Pos.TOP_RIGHT);
        helpButton.setOnAction(e -> showHelpPage(quizName, getQuizDescription(quizName)));

        // Back button
        Button backButton = new Button("Back");
        backButton.setAlignment(Pos.TOP_LEFT);
        backButton.setOnAction(e -> start(primaryStage));

        // Quiz page layout
        BorderPane quizLayout = new BorderPane();
        VBox topLayout = new VBox(20);
        topLayout.setAlignment(Pos.TOP_CENTER);
        topLayout.getChildren().addAll(titleLabel, helpButton, backButton);
        quizLayout.setTop(topLayout);
        quizLayout.setBackground(new Background(new BackgroundFill(Color.rgb(50, 150, 200), CornerRadii.EMPTY, Insets.EMPTY)));
        quizLayout.setPadding(new Insets(50));

        // Set up scene
        Scene scene = new Scene(quizLayout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle(quizName);
    }

    // Method to show help page
    private void showHelpPage(String title, String description) {
        // Help page title
        Label titleLabel = new Label(title + " Help");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Help page description
        Label descriptionLabel = new Label(description);

        // Back button
        Button backButton = new Button("Back");
        backButton.setAlignment(Pos.TOP_LEFT);
        backButton.setOnAction(e -> start(primaryStage));

        // Help page layout
        BorderPane helpLayout = new BorderPane();
        VBox topLayout = new VBox(20);
        topLayout.setAlignment(Pos.TOP_CENTER);
        topLayout.getChildren().addAll(titleLabel, backButton);
        helpLayout.setTop(topLayout);
        VBox centerLayout = new VBox(20);
        centerLayout.setAlignment(Pos.TOP_CENTER);
        centerLayout.getChildren().addAll(descriptionLabel);
        helpLayout.setCenter(centerLayout);
        helpLayout.setBackground(new Background(new BackgroundFill(Color.rgb(50, 150, 200), CornerRadii.EMPTY, Insets.EMPTY)));
        helpLayout.setPadding(new Insets(50));

        // Set up scene
        Scene scene = new Scene(helpLayout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle(title + " Help");
    }

    // Method to get quiz description
    private String getQuizDescription(String quizName) {
        // Provide descriptions for each quiz
        switch (quizName) {
            case "World Capital Quiz":
                return "Test your knowledge about world capitals! This Quiz Consists of 10 questions in which a unique " +
                        "country is going to be highlighted and your job is to guess the country's Capital. In each quiz" +
                        " you get a total of 3 lifelines to help you guess the Capitals.";
            case "World Country Quiz":
                return "Test your knowledge about World countries! This Quiz Consists of 10 questions in which a unique " +
                        "country is going to be highlighted and your job is to guess its name. In each quiz you get a " +
                        "total of 3 lifelines to help you guess the Countries.";
            case "World Ocean Quiz":
                return "Learn about oceans and their features! This Quiz Consists of 10 questions in which a unique body" +
                        " of water is going to be highlighted and your job is to guess its name. In each quiz you get a" +
                        " total of 3 lifelines to help you guess the body of water.";
            case "World Flags Quiz":
                return "Guess the country from its flag! This Quiz Consists of 10 questions in which a unique flag is" +
                        " going to be displayed and your job is to guess the country's name. In each quiz you get a " +
                        "total of 3 lifelines to help you guess the Countries.";
            default:
                return "No description available.";
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
