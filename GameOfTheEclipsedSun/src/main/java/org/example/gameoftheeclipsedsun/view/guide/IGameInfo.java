package org.example.gameoftheeclipsedsun.view.guide;

/**
 * Interface that defines methods for displaying different types of messages in the game.
 * It includes methods for standard, hint, and rule messages.
 *
 * @author Santiago Valencia Aguiño
 * @version 1.0
 * @since 2024
 */

public interface IGameInfo {

    /**
     * Displays a general message to the player.
     *
     * @param title The title of the message.
     * @param header The header text of the message.
     * @param content The content of the message.
     */
    void showMessage(String title, String header, String content);

    /**
     * Displays the game rules.
     *
     * @param title The title of the message.
     * @param header The header text of the message.
     * @param content The content of the message.
     */
    void showMessageRuler(String title, String header, String content);

    /**
     * Displays a hint message to the player.
     *
     * @param title The title of the message.
     * @param header The header text of the message.
     * @param content The content of the message.
     */
    void showMessageHint(String title, String header, String content);
}

