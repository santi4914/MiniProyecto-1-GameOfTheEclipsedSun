package org.example.gameoftheeclipsedsun;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.gameoftheeclipsedsun.view.WelcomeStage;

import java.io.IOException;

/**
 * The main entry point for the game application. This class initializes the JavaFX application
 * and loads the welcome stage.
 *
 * @author Santiago Valencia Aguiño
 * @version 1.0
 * @since 2024
 * @see WelcomeStage
 */

public class Main extends Application {

    /**
     * The main method that launches the JavaFX application.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {launch(args);}


    /**
     * Starts the JavaFX application by loading the welcome stage.
     *
     * @param primaryStage The primary stage for this application, which is not used as
     *                     {@link WelcomeStage#getInstance()} creates its own stage.
     * @throws IOException if an error occurs during the loading of the welcome stage.
     * @see WelcomeStage
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        WelcomeStage.getInstance();
    }
}
