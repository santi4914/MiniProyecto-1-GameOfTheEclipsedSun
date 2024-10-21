package org.example.gameoftheeclipsedsun.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Displays the images for the game results, either the winner or the loser image.
 *
 * @author Santiago Valencia Aguiño
 * @version 1.0
 * @since 2024
 * @see GameErrorRecorder
 */
public class GameResultImages {
    private ImageView imageViewWinner,imageViewLoser;

    /**
     * Constructor that initializes the winner and loser images.
     */
    public GameResultImages(){
        imageViewWinner =new ImageView(new Image(String.valueOf(getClass().getResource("/org/example/gameoftheeclipsedsun/image/winner.png"))));
        imageViewWinner.setLayoutX(17);
        imageViewWinner.setLayoutY(22);
        imageViewWinner.setFitHeight(199);
        imageViewWinner.setFitWidth(265);
        imageViewLoser =new ImageView(new Image(String.valueOf(getClass().getResource("/org/example/gameoftheeclipsedsun/image/defeated.png"))));
        imageViewLoser.setLayoutX(17);
        imageViewLoser.setLayoutY(22);
        imageViewLoser.setFitHeight(199);
        imageViewLoser.setFitWidth(265);
    }

    /**
     * Gets the ImageView representing the winner image.
     *
     * @return the ImageView for the winner.
     */
    public ImageView getImageViewWinner() {
        return imageViewWinner;
    }

    /**
     * Gets the ImageView representing the loser image.
     *
     * @return the ImageView for the loser.
     */
    public ImageView getImageViewLoser() {
        return imageViewLoser;
    }
}
