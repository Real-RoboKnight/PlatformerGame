package edu.asu.dylan.platformergame.sprites.sprites;

import edu.asu.dylan.platformergame.sprites.Entity;
import edu.asu.dylan.platformergame.sprites.Sprite;
import javafx.geometry.Point2D;

public class Wall extends Sprite {
    @Override
    public Point2D interact(Entity entity) {
        Direction interaction = this.checkCollision(entity.localToScene(entity.getBoundsInLocal()));
        return switch (interaction) {
            case None -> entity.position;
            case Up -> new Point2D(
                    entity.position.getX(),
                    entity.position.getY() + this.getBoundsInParent().getMinY() - entity.getBoundsInParent().getMaxY()
            );
            case Down -> new Point2D(
                    entity.position.getX(),
                    entity.position.getY() + this.getBoundsInParent().getMaxY() - entity.getBoundsInParent().getMinY()
            );
            case Left -> new Point2D(
                    entity.position.getX() - this.getBoundsInParent().getMaxX() - entity.getBoundsInParent().getMinX(),
                    entity.position.getY()
            );
            case Right -> new Point2D(
                    entity.position.getX() - this.getBoundsInParent().getMinX() - entity.getBoundsInParent().getMaxX(),
                    entity.position.getY()
            );
        };
    }
}
