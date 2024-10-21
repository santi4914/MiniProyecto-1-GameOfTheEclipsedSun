package org.example.gameoftheeclipsedsun.view.guide;

import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

/**
 * This class provides different informational messages to be displayed during the game.
 * It implements the {@link IGameInfo} interface and shows various alerts with optional images.
 *
 * @author Santiago Valencia Aguiño
 * @version 1.0
 * @since 2024
 * @see IGameInfo
 */
public class GameInfo implements IGameInfo {

    /**
     * Displays a standard informational message.
     *
     * @param title The title of the alert.
     * @param header The header text of the alert.
     * @param content The content message of the alert.
     */
    @Override
    public void showMessage(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }


    /**
     * Displays a hint message with a hint icon.
     *
     * @param title The title of the alert.
     * @param header The header text of the alert.
     * @param content The hint message content.
     */
    @Override
    public void showMessageHint(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.setGraphic(new ImageView(String.valueOf(getClass().getResource("/org/example/gameoftheeclipsedsun/image/hintImage.png"))));
        alert.showAndWait();
    }

    /**
     * Displays the game rules with a ruler icon.
     *
     * @param title The title of the alert.
     * @param header The header text of the alert.
     * @param content The rules message content.
     */
    @Override
    public void showMessageRuler(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.setGraphic(new ImageView(String.valueOf(getClass().getResource("/org/example/gameoftheeclipsedsun/image/LogoRuler.png"))));
        alert.showAndWait();

    }

}
