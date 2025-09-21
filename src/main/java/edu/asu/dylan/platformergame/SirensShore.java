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
        FXMLLoader fxmlLoader = new FXMLLoader(SirensShore.class.getResource("TitlePage.fxml"));
        Scene titleScene = new Scene(fxmlLoader.load(), 1920, 1080);
        stage.setOnCloseRequest((WindowEvent _) -> {
            Platform.exit();
            System.exit(0);
        });
        stage.setTitle("Siren's Shore!");
        stage.setScene(titleScene);
        stage.show();
    }
}
