package edu.asu.dylan.platformergame.sprites.entitys;

import edu.asu.dylan.platformergame.Settings;
import edu.asu.dylan.platformergame.sprites.Entity;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

import java.awt.*;
import java.io.IOException;

public class Player extends Entity {
//TODO: make the key handler keep state so that we can use multi inputs. Also normalise multi inputs.
    public Point2D handleKeyInput() {
        Point2D out = Point2D.ZERO;
        if(Settings.player.keysPressed.contains(KeyCode.W)) out = out.add(0, -Settings.player.inputPower);
        if(Settings.player.keysPressed.contains(KeyCode.S)) out = out.add(0, Settings.player.inputPower);
        if(Settings.player.keysPressed.contains(KeyCode.A)) out = out.add(-Settings.player.inputPower, 0);
        if(Settings.player.keysPressed.contains(KeyCode.D)) out = out.add(Settings.player.inputPower, 0);
        return out.normalize();
    }

    @Override
    public void AI(){
        calculateDrag();
        this.velocity = this.velocity.add(this.handleKeyInput());
        aniClip();
    }

    protected void calculateDrag() {
        velocity = velocity.multiply(Settings.player.drag);
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
    @Override
    public void kill() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/asu/dylan/platformergame/Death.fxml"));
        try {
            Scene deathScene = new Scene(fxmlLoader.load(), 1920, 1080);
            Settings.stage.setScene(deathScene);
            Settings.stage.show();
            for(Entity entity : entities) {
                entity.scheduler.shutdownNow();
            }
        } catch (IOException _) {}
    }
}
