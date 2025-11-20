package edu.asu.dylan.platformergame.sprites.entitys;

import edu.asu.dylan.platformergame.sprites.Entity;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;

public class RotatingObstacle extends Entity {
    private int rotation;

    public RotatingObstacle() {
        this.rotation = 0;
        this.acceleration = Point2D.ZERO;

        // Set rotation axis to Z (perpendicular to screen)
        this.setRotationAxis(new Point3D(0, 0, 1));

        // Update pivot when size is available
        this.layoutBoundsProperty().addListener((obs, oldBounds, newBounds) -> {
            double centerX = newBounds.getWidth() / 2;
            double centerY = newBounds.getHeight() / 2;

            // Adjust the translation to rotate around center
            this.setTranslateX(this.getTranslateX() + centerX);
            this.setTranslateY(this.getTranslateY() + centerY);
            this.relocate(this.getLayoutX() - centerX, this.getLayoutY() - centerY);
        });
    }

    @Override
    public Direction interact(Entity entity) {
        if (entity == null) return Direction.None;

        entity.kill();
        return Direction.None;
    }

    @Override
    public void AI() {
        this.rotation = (this.rotation + 1) % 360;
        this.setRotate(this.rotation);
    }

    @Override
    protected void onSnap(Direction direction) {
    }
}