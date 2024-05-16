package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LoginPageController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button exitbutton;

    @FXML
    private Button Buttontoscene2;

    @FXML
    private HBox rootelement;

    private LoginHandler loginHandler;

    private static final int window_height=600;
    private static final int window_width=600;

    public interface LoginHandler {
        void handle(boolean successful);
    }

    public void setLoginHandler(LoginHandler loginHandler) {
        this.loginHandler = loginHandler;
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        //check if username or password is empty
        if (username.isBlank() || password.isBlank()) {
            // Display an alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter both username and password.");
            alert.showAndWait();
        } else {
            //proceed with login
            System.out.println("Username: " + username + ", Password: " + password);

            // If login is successful, navigate to HomePage.fxml
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("GeoMainPage.fxml"));
                Parent homePage = loader.load();
                Scene homeScene = new Scene(homePage);
                Stage currentStage = (Stage) usernameField.getScene().getWindow();
                currentStage.setScene(homeScene);
                currentStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleExit(ActionEvent event) {
        // Close the application
        Stage stage = (Stage) exitbutton.getScene().getWindow();
        stage.close();
    }
}
