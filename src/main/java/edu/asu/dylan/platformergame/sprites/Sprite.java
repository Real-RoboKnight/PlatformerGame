package edu.asu.dylan.platformergame.sprites;

import edu.asu.dylan.platformergame.Settings;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public abstract class Sprite extends ImageView {
    protected static ArrayList<Sprite> sprites = new ArrayList<>();

    public Sprite() {
        sprites.add(this);
    }

    public enum Direction {
        None, Right, Left, Up, Down
    }
    /**
     * checks how a bound is entering this sprite
     * @param entity the entity that is being checked for collision
     * @return an R² vector that shows how the bound is entering this sprite
     */
    public Direction checkCollision (Entity entity) {
        Bounds entityBound = entity.localToScene(entity.getBoundsInLocal());
        Bounds thisBounds = this.localToScene(this.getBoundsInLocal());
        if (!thisBounds.intersects(entityBound)) return Direction.None;
        if (entityBound.getMaxY() > thisBounds.getMinY() && entityBound.getMaxY() < thisBounds.getMinY() + Settings.snapingTolarancePX) return Direction.Down;
        if (entityBound.getMinY() < thisBounds.getMaxY() && entityBound.getMinY() > thisBounds.getMaxY() - Settings.snapingTolarancePX) return Direction.Up;
        if (entityBound.getMaxX() > thisBounds.getMinX() && entityBound.getMaxX() < thisBounds.getMinX() + Settings.snapingTolarancePX) return Direction.Right;
        if (entityBound.getMinX() < thisBounds.getMaxX() && entityBound.getMinX() > thisBounds.getMaxX() - Settings.snapingTolarancePX) return Direction.Left;

        if (Math.abs(entity.velocity.getY()) > Math.abs(entity.velocity.getX()))
            return entity.velocity.getY() > 0 ? Direction.Down : Direction.Up;
        else
            return entity.velocity.getX() > 0 ? Direction.Right : Direction.Left;
    }

    /**
     * Snaps entity to the edge of this sprite
     *
     * @param entity entity to be snapped to the edge of this sprite
     * @return direction that the entity was snapped from
     */
    public abstract Direction interact(Entity entity);
    

}
