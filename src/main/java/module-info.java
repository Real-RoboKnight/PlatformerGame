module edu.asu.dshah177.platformergame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires javafx.graphics;
    requires com.almasb.fxgl.core;
    requires annotations;
    requires java.desktop;

    opens edu.asu.dshah177.platformergame;
    exports edu.asu.dshah177.platformergame.sprites;
    exports edu.asu.dshah177.platformergame;
    exports edu.asu.dshah177.platformergame.sprites.entitys;
    exports edu.asu.dshah177.platformergame.sprites.sprites;
}