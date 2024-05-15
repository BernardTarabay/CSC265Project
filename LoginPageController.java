package com.example.geoquiz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

        // Check if username or password is empty
        if (username.isBlank() || password.isBlank()) {
            // Display an alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter both username and password.");
            alert.showAndWait();
        } else {
            // Proceed with login logic
            // For now, let's just print the credentials
            System.out.println("Username: " + username + ", Password: " + password);

            // If login is successful, call the login handler
            if (loginHandler != null) {
                loginHandler.handle(true);
            }
        }
    }

    @FXML
    private void handleExit(ActionEvent event) {
        // Close the application
        Stage stage = (Stage) exitbutton.getScene().getWindow();
        stage.close();
    }}