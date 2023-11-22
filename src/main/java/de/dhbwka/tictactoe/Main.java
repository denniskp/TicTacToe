package de.dhbwka.tictactoe;

import de.dhbwka.tictactoe.game.GameManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Scene scene;

    public static void main(String[] args) {
        new GameManager();
        launch();
    }

    @Override
    public void start(Stage stage) {
        scene = new Scene(loadFXML("menu"), 560, 560);
        stage.setTitle("Tic Tac Toe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
            return fxmlLoader.load();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
            return null;
        }
    }

    public static Parent getRoot() {
        return scene.getRoot();
    }

    public static void setRoot(String fxml) {
        scene.setRoot(loadFXML(fxml));
    }
}
