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

public class PrimaryController implements Initializable {
    @FXML
    TextField inputGuess;

    @FXML
    Label statusLabel;

    @FXML
    public void guess() {
        String result = App.handleInput(inputGuess.getText());
        statusLabel.setText(String.format("Player had a %s", result));

        if (App.isGameOver()) {
            statusLabel.setText("Game Over");
        }

        delay();
    }

    public static void delay() {
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
            String result = App.playComputer();

            if (App.isGameOver()) {
                Platform.runLater(() -> {
                    App.controller.statusLabel.setText("Game Over");
                });
            } else {
                App.controller.statusLabel.setText(String.format("Computer had a %s",
                        result));
            }
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
