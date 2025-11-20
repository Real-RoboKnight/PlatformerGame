package edu.asu.dshah177.platformergame.sprites.sprites;

import edu.asu.dshah177.platformergame.Settings;
import edu.asu.dshah177.platformergame.sprites.Entity;
import edu.asu.dshah177.platformergame.sprites.Sprite;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

import static edu.asu.dshah177.platformergame.sprites.Entity.entities;

public class Win extends Sprite {
    @Override
    public Direction interact(Entity entity) {
        if (entity == null) return Direction.None;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/asu/dshah177/platformergame/Win.fxml"));
        try {
            Scene winScene = new Scene(fxmlLoader.load(), 1900, 1000);
            Settings.stage.setScene(winScene);
            Settings.stage.show();
            for(Entity e : entities) {
                e.scheduler.shutdownNow();
            }
        } catch (IOException _) {}

        return Direction.None;
    }
}
