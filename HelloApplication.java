package com.example.geoquiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloApplication extends Application {

    private Stage primaryStage;
    private Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        // Load FXML files and get the root nodes
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("LoginPageGeo.fxml"));
        Parent root1 = loader1.load();
        LoginPageController loginPageController = loader1.getController();
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("GeoMainPage.fxml"));
        Parent root2 = loader2.load();

        // Create scenes
        scene1 = new Scene(root1, 600, 400);
        scene2 = new Scene(root2, 600, 400);

        // Set the primaryStage scene
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Login to GeoQuest!");
        primaryStage.show();

        // Set login handler in LoginPageController
        loginPageController.setLoginHandler(this::handleLogin);
    }

    private void handleLogin(boolean successful) {
        if (successful) {
            primaryStage.setScene(scene2);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
