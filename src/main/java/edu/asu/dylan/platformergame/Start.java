package edu.asu.dylan.platformergame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class Start {
    @FXML
    protected void onStartButtonClick() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/asu/dylan/platformergame/Game.fxml"));
        try {
            Scene gameScene = new Scene(fxmlLoader.load(), 1920, 1080);
            Settings.stage.setScene(gameScene);
            Settings.stage.show();
            Game game = fxmlLoader.getController();
            game.StartGame();
        } catch (IOException _) {}
    }
}
