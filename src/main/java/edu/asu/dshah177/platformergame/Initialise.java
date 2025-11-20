package edu.asu.dshah177.platformergame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Initialise extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Settings.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Initialise.class.getResource("Start.fxml"));
        Scene startScene = new Scene(fxmlLoader.load(), 1900, 1000);
        stage.setOnCloseRequest((WindowEvent _) -> {
            Platform.exit();
            System.exit(0);
        });
        stage.setTitle("Bee Flight Game!");
        stage.setScene(startScene);
        stage.show();
        stage.setResizable(false);
        stage.requestFocus();

    }
}
