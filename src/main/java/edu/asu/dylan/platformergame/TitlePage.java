package edu.asu.dylan.platformergame;

import edu.asu.dylan.platformergame.sprites.entitys.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TitlePage {
    @FXML
    private Label titleText;
    @FXML
    private Button startButton;
    @FXML
    private Player player;

    @FXML
    protected void onStartButtonClick() {
        titleText.setText("Welcome to JavaFX Application!");
        player.getScene().setOnKeyPressed(player::handleKeyInput);
    }
}
