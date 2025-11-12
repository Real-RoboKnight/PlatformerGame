package edu.asu.dylan.platformergame.sprites.sprites;

import edu.asu.dylan.platformergame.sprites.Entity;
import edu.asu.dylan.platformergame.sprites.Sprite;

public class Fire extends Sprite {
    @Override
    public Direction interact(Entity entity) {
        if (entity == null) return Direction.None;

        entity.kill();
        return Direction.None;
    }
}
