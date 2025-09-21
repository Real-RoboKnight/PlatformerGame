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

    public Entity() {
        scheduler.scheduleAtFixedRate(this::physicsEngine, 0, Settings.physicsFrequencyMS, TimeUnit.MILLISECONDS);
        position = new Point2D(getTranslateX(), getTranslateY());
    }

    protected void physicsEngine() {
        integratePositionVelocityAcceleration();
//        System.out.println("this = " + this);
        calculateDrag();
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
     * Moves the entity to the location shown in the location point
     */
    protected void moveEntity() {
        this.setTranslateX(position.getX());
        this.setTranslateY(position.getY());
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "ImageView=" + super.toString() +
                ", position=" + position +
                ", velocity=" + velocity +
                ", acceleration=" + acceleration +
                '}';
    }
}
