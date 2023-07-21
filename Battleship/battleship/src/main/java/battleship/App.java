package battleship;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import battleship.controllers.PrimaryController;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Game game;

    private static Scene scene;

    private static Stage primaryStage;

    public static PrimaryController controller;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setTitle("Battleship");
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static void setTitle(String title) {
        primaryStage.setTitle(title);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent parent = fxmlLoader.load();
        controller = fxmlLoader.getController();

        return parent;
    }

    public static void main(String[] args) {
        game = new Game();
        launch();
    }

}