package edu.asu.dylan.platformergame.sprites.sprites;

import edu.asu.dylan.platformergame.Settings;
import edu.asu.dylan.platformergame.sprites.Entity;
import edu.asu.dylan.platformergame.sprites.Sprite;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

import static edu.asu.dylan.platformergame.sprites.Entity.entities;

public class Win extends Sprite {
    @Override
    public Direction interact(Entity entity) {
        if (entity == null) return Direction.None;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/asu/dylan/platformergame/Win.fxml"));
        try {
            Scene winScene = new Scene(fxmlLoader.load(), 1920, 1080);
            Settings.stage.setScene(winScene);
            Settings.stage.show();
            for(Entity e : entities) {
                e.scheduler.shutdownNow();
            }
        } catch (IOException _) {}

        return Direction.None;
    }
}
