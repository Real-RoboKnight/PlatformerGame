module edu.asu.dylan.platformergame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires javafx.graphics;
    requires com.almasb.fxgl.core;
    requires annotations;

    opens edu.asu.dylan.platformergame;
    exports edu.asu.dylan.platformergame.sprites;
    exports edu.asu.dylan.platformergame;
    exports edu.asu.dylan.platformergame.sprites.entitys;
    exports edu.asu.dylan.platformergame.sprites.sprites;
}