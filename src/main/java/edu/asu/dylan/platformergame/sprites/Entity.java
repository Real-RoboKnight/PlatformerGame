package edu.asu.dylan.platformergame.sprites;

import edu.asu.dylan.platformergame.Settings;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Entity extends ImageView {

    private static final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    public Point2D position;
    public Point2D velocity = Point2D.ZERO;
    public Point2D acceleration = new Point2D(0, Settings.gravity);
    private MovementLockRecord movementLock = new MovementLockRecord(true, true);

    public Entity() {
        scheduler.scheduleAtFixedRate(this::physicsEngine, 0, Settings.physicsFrequencyMS, TimeUnit.MILLISECONDS);
        antiWindup();
    }

    protected void physicsEngine() {
        calculateDrag();
        integratePositionVelocityAcceleration();
        moveEntity();
    }

   protected void calculateDrag(){
        position.multiply(Settings.player.drag);
   }

    protected void integratePositionVelocityAcceleration() {
        velocity = velocity.add(acceleration);
        position = position.add(velocity);
    }

    /**
     * Moves the entity to the location shown in the location point, if movementLock doesn't prevent its move
     * @see MovementLockRecord
     */
    protected void moveEntity() {
        if (!movementLock.getX()) this.setTranslateX(position.getX());
        if (!movementLock.getY()) this.setTranslateY(position.getY());
    }

    /**
     * @param x weather the entity's x position should be locked or not
     */
    public void lockXMovement(boolean x) {
        antiWindupX();
        movementLock = new MovementLockRecord(x, movementLock.getY());
    }

    /**
     * @param y weather the entity's y position should be locked or not
     */
    public void lockYMovement(boolean y) {
        antiWindupY();
        movementLock = new MovementLockRecord(movementLock.getX(), y);
    }
    /**
     * @param x weather the entity's x position should be locked or not
     * @param y weather the entity's y position should be locked or not
     */
    public void lockMovement(boolean x, boolean y) {
        antiWindup();
        movementLock = new MovementLockRecord(x, y);
    }

    private void antiWindupX() {
        velocity = new Point2D(0, velocity.getY());
        position = new Point2D(this.getTranslateX(), position.getY());
    }

    private void antiWindupY() {
        velocity = new Point2D(velocity.getX(), 0);
        position = new Point2D(position.getX(), this.getTranslateY());
    }

    private void antiWindup() {
        velocity = Point2D.ZERO;
        position = new Point2D(this.getTranslateX(), this.getTranslateY());
    }

    /**
     * Locks the Entities x or y position in place
     * @param x
     * @param y
     */
    private record MovementLockRecord(boolean x, boolean y) {
        public boolean getX() {
            return x();
        }

        public boolean getY() {
            return y();
        }
    }

    @Override
    public String toString() {
        return "Entity{" +
                "ImageView=" + super.toString() +
                ", position=" + position +
                ", velocity=" + velocity +
                ", acceleration=" + acceleration +
                ", movementLock=" + movementLock +
                '}';
    }
}
