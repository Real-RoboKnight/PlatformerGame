package edu.asu.dylan.platformergame.sprites;

import com.almasb.fxgl.core.math.Vec2;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import edu.asu.dylan.platformergame.Settings;
import javafx.scene.image.ImageView;

public class Entity extends ImageView {

    protected Vec2 vel = new Vec2(0, 0);
    private static final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public Entity () {
        scheduler.scheduleAtFixedRate(this::physicsEngin, 0, Settings.physicsFrequencyMS, TimeUnit.MILLISECONDS);
    }

    protected void physicsEngin(){
        this.getLocalToSceneTransform().transform(vel.toPoint2D());
    }

}
