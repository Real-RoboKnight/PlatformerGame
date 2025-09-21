package edu.asu.dylan.platformergame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TitlePage {
    @FXML
    private Label titleText;
    @FXML
    private Button startButton;

    @FXML
    protected void onHelloButtonClick() {
        titleText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void textInteraction(){
        startButton.setText("Meow");
    }
}
