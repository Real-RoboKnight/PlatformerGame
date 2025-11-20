package edu.asu.dylan.platformergame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class SirensShore extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Settings.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(SirensShore.class.getResource("Start.fxml"));
        Scene startScene = new Scene(fxmlLoader.load(), 1900, 1000);
        stage.setOnCloseRequest((WindowEvent _) -> {
            Platform.exit();
            System.exit(0);
        });
        stage.setTitle("Siren's Shore!");
        stage.setScene(startScene);
        stage.show();
        stage.setResizable(false);
        stage.requestFocus();

    }
}
