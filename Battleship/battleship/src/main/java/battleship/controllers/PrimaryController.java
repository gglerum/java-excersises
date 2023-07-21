package battleship.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import battleship.App;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class PrimaryController implements Initializable {
    @FXML
    TextField inputGuess;

    @FXML
    Label statusLabel;

    @FXML
    Button buttonGuess;

    @FXML
    Text scrollingOutput;

    @FXML
    public void guess() {
        String playerGuess = inputGuess.getText();

        addToOutput("Player guessed:" + playerGuess);

        String resultText = "Player had a " + App.game.handleInput(inputGuess.getText());
        statusLabel.setText(resultText);
        addToOutput(resultText);

        buttonGuess.setDisable(true);

        if (App.game.isGameOver()) {
            statusLabel.setText("Game Over");
        }

        delayForComputer();
    }

    public void addToOutput(String output) {
        scrollingOutput.setText(output + "\n" + scrollingOutput.getText());
    }

    public void delayForComputer() {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> {
            String[] result = App.game.playComputer();
            String resultText = "Computer had a " + result[1];

            addToOutput("Computer guessed:" + result[0]);
            addToOutput(resultText);

            if (App.game.isGameOver()) {
                resultText = "Game Over";
                addToOutput(resultText);
            } else {
                App.controller.buttonGuess.setDisable(false);
            }

            App.controller.statusLabel.setText(resultText);

        });
        new Thread(sleeper).start();
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rBundle) {
        App.setTitle("Battleship");
    }
}
