package edu.asu.dylan.platformergame.sprites;

import javafx.scene.input.KeyEvent;

public class Player extends Entity {

    public Player(){
        setOnKeyPressed(this::handleKeyInput);

    }

    private void handleKeyInput(KeyEvent keyEvent) {
        switch (keyEvent.getCharacter()) {
            case "w" -> vel = vel.add(0, 1);
            case "s" -> vel = vel.add(0, -1);
            case "a" -> vel = vel.add(-1, 0);
            case "d" -> vel = vel.add(1, 0);
        }
    }
}
