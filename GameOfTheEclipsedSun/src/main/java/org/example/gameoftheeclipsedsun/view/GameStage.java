package org.example.gameoftheeclipsedsun.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.gameoftheeclipsedsun.controller.GameController;


import java.io.IOException;

/**
 * This class represents the stage for the main game window.
 * It initializes the game interface and controls the game scene.
 *
 * @author Santiago Valencia Aguiño
 * @version 1.0
 * @since 2024
 * @see WelcomeStage
 */

public class GameStage extends Stage {
    private GameController gameController;

    /**
     * Constructor that sets up the game stage by loading the FXML file and initializing the game controller.
     *
     * @throws IOException if there is an error loading the FXML file.
     */
    public GameStage() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/org/example/gameoftheeclipsedsun/game-view.fxml"));
        Parent root = loader.load();
        gameController=loader.getController();
        setTitle("game of the eclipsed sun");
        Scene scene=new Scene(root);
        getIcons().add(new Image(String.valueOf(getClass().getResource("/org/example/gameoftheeclipsedsun/image/favicon.png"))));
        setResizable(false);
        setScene(scene);
        show();
    }

    /**
     * Gets the game controller associated with this stage.
     *
     * @return The game controller.
     */
    public GameController getGameController(){
        return gameController;
    }


    /**
     * Returns a singleton instance of the game stage.
     *
     * @return The instance of the game stage.
     * @throws IOException if there is an error creating the stage.
     */
    public static GameStage getInstance() throws IOException{
        return GameStageHolder.INSTANCE = new GameStage();
    }

    /**
     * Deletes the current instance of the game stage.
     */
    public static void deleteInstance() {
        GameStageHolder.INSTANCE.close();
        GameStageHolder.INSTANCE = null;
    }

    /**
     * Holder class for the singleton instance of GameStage.
     */
    private static class GameStageHolder {
        private static GameStage INSTANCE;
    }
}
