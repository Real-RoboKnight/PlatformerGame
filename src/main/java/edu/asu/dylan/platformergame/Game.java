package edu.asu.dylan.platformergame;

import edu.asu.dylan.platformergame.sprites.entitys.Player;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;

public class Game {
    @FXML
    private Player player;

    @FXML
    protected void StartGame() {
        player.position = new Point2D(0, 50);
        player.velocity = Point2D.ZERO;
        player.getScene().setOnKeyPressed(event ->
                Settings.player.keysPressed.add(event.getCode()));
        player.getScene().setOnKeyReleased(event ->
                Settings.player.keysPressed.remove(event.getCode()));
    }
}
