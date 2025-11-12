package edu.asu.dylan.platformergame.sprites;

import edu.asu.dylan.platformergame.Settings;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class Entity extends Sprite {

    public final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    public Point2D position;
    public Point2D velocity = Point2D.ZERO;
    public Point2D acceleration = new Point2D(0, Settings.gravity);

    protected static ArrayList<Entity> entities = new ArrayList<>();

    public Entity() {
        scheduler.scheduleAtFixedRate(() -> Platform.runLater(this::physicsEngine), 0, 1000 / Settings.framerate, TimeUnit.MILLISECONDS);
        position = new Point2D(getTranslateX(), getTranslateY());
        entities.add(this);
    }

    public abstract void AI();

    protected void physicsEngine() {
        integratePositionVelocityAcceleration();
//        System.out.println("this = " + this);
        calculateDrag();
        AI();
        moveEntity();
    }

    protected void aniClip(){
//        System.out.println("Entity.aniClip");
        Sprite.sprites.stream()
                .filter(sprite -> sprite != this) //Dont check for collisions with self
                .filter(sprite -> sprite.localToScene(sprite.getBoundsInLocal()).intersects(this.localToScene(this.getBoundsInLocal()))) //Only interact with entities that we are contacting
                .forEachOrdered(sprite -> this.onSnap(sprite.interact(this)));
    }

    protected abstract void onSnap(Direction direction);

    protected void calculateDrag() {
        velocity = velocity.multiply(Settings.player.drag);
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

    public void kill(){
        entities.remove(this);
        ((StackPane)this.getParent()).getChildren().remove(this);
    }
}
