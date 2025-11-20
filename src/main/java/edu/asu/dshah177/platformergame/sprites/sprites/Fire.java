package edu.asu.dshah177.platformergame.sprites.sprites;

import edu.asu.dshah177.platformergame.sprites.Entity;
import edu.asu.dshah177.platformergame.sprites.Sprite;

public class Fire extends Sprite {
    @Override
    public Direction interact(Entity entity) {
        if (entity == null) return Direction.None;

        entity.kill();
        return Direction.None;
    }
}
