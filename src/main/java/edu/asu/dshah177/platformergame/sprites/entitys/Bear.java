package edu.asu.dshah177.platformergame.sprites.entitys;

import edu.asu.dshah177.platformergame.Settings;
import edu.asu.dshah177.platformergame.sprites.Entity;
import javafx.geometry.Point2D;

public class Bear extends Entity {

    public Bear() {
        this.velocity = new Point2D(Settings.bearSpeed, 0);
    }
    @Override
    public Direction interact(Entity entity) {
        if (entity == null) return Direction.None;

        entity.kill();
        return Direction.None;
    }

    @Override
    public void AI() {
        antiClip();
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
                    Settings.bearSpeed,
                    this.velocity.getY()
            );
            case Right -> this.velocity = new Point2D(
                    -Settings.bearSpeed,
                    this.velocity.getY()
            );
        }
    }
}
