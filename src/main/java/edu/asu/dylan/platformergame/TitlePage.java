package edu.asu.dylan.platformergame;

import edu.asu.dylan.platformergame.sprites.entitys.Player;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;

public class TitlePage {
    @FXML
    private Label titleText;
    @FXML
    private Player player;

    @FXML
    protected void onStartButtonClick() {
        titleText.setText("Welcome to JavaFX Application!");
        player.position = new Point2D(0, 50);
        player.velocity = Point2D.ZERO;
        player.getScene().setOnKeyPressed(player::handleKeyInput);
    }

    @FXML
    protected void titleTextClicked(){
        player.position = new Point2D(0, 50);
        player.velocity = Point2D.ZERO;
    }
}
