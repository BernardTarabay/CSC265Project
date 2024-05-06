package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.util.List;

public class CapitalsController {
    @FXML
    private Label countryName;
    @FXML
    private Button[] answerButtons; // Buttons for each letter
    @FXML
    private Text text;
    @FXML
    private Pane buttons;
    @FXML
    private Text winStatus;
    @FXML
    private Text realWord;
    private int mistakes;
    private int correct;
    private String myWord;
    private List<String> myLetters;
    private List<String> answer;

    public void initialize() {
        // Initialize with country and its capital for the quiz
    }

    private void checkAnswer(String letter) {
    }

    public void onClick(ActionEvent event) {
        String letter = ((Button) event.getSource()).getText();
        ((Button) event.getSource()).setDisable(false);
        boolean correctGuess = false; //null variable to track progress.

        for (int i = 0; i < myLetters.size(); i++) {
            if (myLetters.get(i).equals(letter)) {
                correct++;
                answer.set(i * 2, letter); //letter position
                correctGuess = true;
            }
        }

        if (correctGuess) {
            ((Button) event.getSource()).setDisable(true);

            String res = String.join("", answer);
            text.setText(res);
            if (correct == myWord.length()) {
                winStatus.setText("You Win!");
            }
        } else {
            mistakes++;
            ((Button) event.getSource()).setDisable(true);
            if (mistakes == 1) System.out.println("Incorrect letter, try again!");
            else if (mistakes == 2) System.out.println("Incorrect letter, try again!");
            else if (mistakes == 3) System.out.println("Incorrect letter, try again!");
            else if (mistakes == 4) System.out.println("Incorrect letter, try again!");
            else if (mistakes == 5) System.out.println("Incorrect letter, try again!");
            else if (mistakes == 6)
             {

                winStatus.setText("You Lose!");
                realWord.setText("The actual Country was " + myWord);
                buttons.setDisable(true);

            }
        }
    }

    public void newGame(){
        for(int i=0; i<26; i++){
            buttons.getChildren().get(i).setDisable(false);
        }
        initialize();
    }

}
