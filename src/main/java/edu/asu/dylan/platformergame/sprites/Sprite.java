package edu.asu.dylan.platformergame.sprites;

import edu.asu.dylan.platformergame.Settings;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
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
     * @param bound the bounding rectangle that is being checked
     * @return an R² vector that shows how the bound is entering this sprite
     */
    public Direction checkCollision (Bounds bound) {
        Bounds thisBounds = this.localToScene(this.getBoundsInLocal());
        if (!thisBounds.intersects(bound)) return Direction.None;
        if (bound.getMaxY() > thisBounds.getMinY() && bound.getMaxY() < thisBounds.getMinY() + Settings.snapingTolarancePX) return Direction.Up;
        if (bound.getMinY() < thisBounds.getMaxY() && bound.getMinY() > thisBounds.getMaxY() - Settings.snapingTolarancePX) return Direction.Down;
        if (bound.getMaxX() > thisBounds.getMinX() && bound.getMaxX() < thisBounds.getMinX() + Settings.snapingTolarancePX) return Direction.Right;
        if (bound.getMinX() < thisBounds.getMaxX() && bound.getMinX() > thisBounds.getMaxX() - Settings.snapingTolarancePX) return Direction.Left;
        throw new RuntimeException("Bound is in the object and somehow not?? \n check for race conditions");
    }

    public abstract Point2D interact(Entity entity);
    

}
