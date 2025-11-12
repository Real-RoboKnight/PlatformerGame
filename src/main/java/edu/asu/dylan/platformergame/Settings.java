package edu.asu.dylan.platformergame;

import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.HashSet;

public class Settings {
    public static class player{
        public static final double drag = .90;
        public static final double inputPower = 5;
        public static HashSet<KeyCode>  keysPressed = new HashSet<>();
    }
    public static final long framerate = 60;
    public static final double gravity = 0.075;

    public static final int snapingTolarancePX = 16;

    public static Stage stage;

}
