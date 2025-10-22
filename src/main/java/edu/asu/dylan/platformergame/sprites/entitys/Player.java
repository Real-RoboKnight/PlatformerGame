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
    protected void onSnap(Direction direction) {
        switch (direction) {
            case None -> {}
            case Up -> this.velocity = new Point2D(
                    this.velocity.getX(),
                    Math.max(0, this.velocity.getY())
            );
            case Down -> this.velocity = new Point2D(
                    this.velocity.getX(),
                    Math.min(0, this.velocity.getY())
            );
            case Left -> this.velocity = new Point2D(
                    Math.min(0, this.velocity.getX()),
                    this.velocity.getY()
            );
            case Right -> this.velocity = new Point2D(
                    Math.max(0, this.velocity.getX()),
                    this.velocity.getY()
            );
        }
    }

    @Override
    public Direction interact(Entity entity) {
        return Direction.None;
    }
}
