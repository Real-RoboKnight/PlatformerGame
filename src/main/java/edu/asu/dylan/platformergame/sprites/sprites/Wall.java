package edu.asu.dylan.platformergame.sprites.sprites;

import edu.asu.dylan.platformergame.sprites.Entity;
import edu.asu.dylan.platformergame.sprites.Sprite;
import javafx.geometry.Point2D;

public class Wall extends Sprite {
    @Override
    public Direction interact(Entity entity) {

        Direction interaction = this.checkCollision(entity);
        switch (interaction) {
            case None -> {}
            case Down -> entity.position = new Point2D(
                    entity.position.getX(),
                    entity.position.getY() + this.getBoundsInParent().getMinY() - entity.getBoundsInParent().getMaxY()
                    );
            case Up -> entity.position = new Point2D(
                    entity.position.getX(),
                    entity.position.getY() + this.getBoundsInParent().getMaxY() - entity.getBoundsInParent().getMinY()
                    );
            case Left -> entity.position = new Point2D(
                    entity.position.getX() + this.getBoundsInParent().getMaxX() - entity.getBoundsInParent().getMinX(),
                    entity.position.getY()
                    );
            case Right -> entity.position = new Point2D(
                    entity.position.getX() + this.getBoundsInParent().getMinX() - entity.getBoundsInParent().getMaxX(),
                    entity.position.getY()
                    );
        }
        return interaction;
    }
}
