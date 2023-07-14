package battleship.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import battleship.App;
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
        if (inputGuess.getText().equals("A1")) {
            statusLabel.setText("Hit!");
        }
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
