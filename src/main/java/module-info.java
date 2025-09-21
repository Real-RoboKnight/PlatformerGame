module edu.asu.dylan.platformergame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires javafx.graphics;
    requires com.almasb.fxgl.core;

    opens edu.asu.dylan.platformergame to javafx.fxml;
    exports edu.asu.dylan.platformergame.sprites to javafx.fxml;
    exports edu.asu.dylan.platformergame;
}