package edu.asu.dylan.platformergame.sprites.entitys;

import edu.asu.dylan.platformergame.Settings;
import edu.asu.dylan.platformergame.sprites.Entity;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyEvent;
import org.jetbrains.annotations.NotNull;

public class Player extends Entity {
//TODO: make the key handler keep state so that we can use multi inputs. Also normalise multi inputs.
    public void handleKeyInput(@NotNull KeyEvent keyEvent) {
//        System.out.println(keyEvent);
        switch (keyEvent.getText()) {
            case "w" -> velocity = velocity.add(0, -Settings.player.inputPower);
            case "s" -> velocity = velocity.add(0, Settings.player.inputPower);
            case "a" -> velocity = velocity.add(-Settings.player.inputPower, 0);
            case "d" -> velocity = velocity.add(Settings.player.inputPower, 0);
        }
//        System.out.println(this);
    }

    @Override
    public void AI(){
        aniClip();
    }

    @Override
    public Point2D interact(Entity entity) {
        return null;
    }
}
