package edu.asu.dylan.platformergame.sprites.entitys;

import edu.asu.dylan.platformergame.Settings;
import edu.asu.dylan.platformergame.sprites.Entity;
import javafx.scene.input.KeyEvent;
import org.jetbrains.annotations.NotNull;

public class Player extends Entity {

    public void handleKeyInput(@NotNull KeyEvent keyEvent) {
//        System.out.println(this);
        switch (keyEvent.getText()) {
            case "w" -> velocity = velocity.add(0, -Settings.player.inputPower);
            case "s" -> velocity = velocity.add(0, Settings.player.inputPower);
            case "a" -> velocity = velocity.add(-Settings.player.inputPower, 0);
            case "d" -> velocity = velocity.add(Settings.player.inputPower, 0);
        }
//        System.out.println(this);
    }
}
