package org.example.gameoftheeclipsedsun.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class represents the stage for the welcome screen of the game.
 * It initializes the welcome screen interface.
 *
 * @version 1.0
 * @since 2024
 * @author Santiago Valencia Aguiño
 * @see GameStage
 */

public class WelcomeStage extends Stage {
    private WelcomeStage welcomeStage;

    /**
     * Constructor that sets up the welcome stage by loading the FXML file.
     *
     * @throws IOException if there is an error loading the FXML file.
     */
    public WelcomeStage() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/org/example/gameoftheeclipsedsun/welcome-view.fxml"));
        Parent parent = loader.load();
        setTitle("Game Of The Eclipsed Sun");
        Scene scene=new Scene(parent);
        getIcons().add(new Image(String.valueOf(getClass().getResource("/org/example/gameoftheeclipsedsun/image/favicon.png"))));
        setScene(scene);
        setResizable(false);
        show();
    }

    /**
     * Holder class for the singleton instance of WelcomeStage.
     */
    private static class WelcomeStageHolder{
        private static WelcomeStage INSTANCE;
    }

    /**
     * Returns a singleton instance of the welcome stage.
     *
     * @return The instance of the welcome stage.
     * @throws IOException if there is an error creating the stage.
     */
    public static WelcomeStage getInstance() throws IOException {
        return WelcomeStageHolder.INSTANCE = new WelcomeStage();
    }

    /**
     * Deletes the current instance of the welcome stage.
     */
    public static void deleteInstance() {
        WelcomeStageHolder.INSTANCE.close();
        WelcomeStageHolder.INSTANCE = null;
    }

}
