package org.example.gameoftheeclipsedsun.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Tracks the number of errors made by the player and displays the corresponding eclipse image.
 * The eclipse progresses with each incorrect guess, up to a maximum number of errors.
 *
 * @author Santiago Valencia Aguiño
 * @version 1.0
 * @since 2024
 * @see SecretWord
 */

public class GameErrorRecorder {
    private ImageView imageViewEclipsed;
    private Image imagenEclipsed;
    private Integer cantErrores;
    private SecretWord secretWord;

    /**
     * Constructor that initializes the error counter and sets the image based on the current number of errors.
     *
     * @param cantErrores The current number of errors made by the player.
     */
    public GameErrorRecorder(Integer cantErrores){
        this.cantErrores=cantErrores;
        imageViewEclipsed = new ImageView();

        List<String> urlPartesEclipsed = new ArrayList<>();
        urlPartesEclipsed.add("/org/example/gameoftheeclipsedsun/image/eclipsed1.png");
        urlPartesEclipsed.add("/org/example/gameoftheeclipsedsun/image/eclipsed2.png");
        urlPartesEclipsed.add("/org/example/gameoftheeclipsedsun/image/eclipsed3.png");
        urlPartesEclipsed.add("/org/example/gameoftheeclipsedsun/image/eclipsed4.png");
        urlPartesEclipsed.add("/org/example/gameoftheeclipsedsun/image/eclipsed5.png");


        imagenEclipsed = new Image(getClass().getResource(urlPartesEclipsed.get(cantErrores)).toString());
        imageViewEclipsed.setImage(imagenEclipsed);
    }

    /**
     * Gets the ImageView representing the current eclipsed image based on errors.
     *
     * @return the ImageView displaying the current eclipse state.
     */

    public ImageView getImageViewEclipsed() {
        return imageViewEclipsed;
    }

    /**
     * Sets the ImageView for the eclipsed image.
     *
     * @param imageViewEclipsed The ImageView to display.
     */
    public void setImageViewEclipsed(ImageView imageViewEclipsed) {
        this.imageViewEclipsed = imageViewEclipsed;
    }

    /**
     * Gets the current eclipse image.
     *
     * @return The current Image of the eclipse.
     */
     public Image getImagenEclipsed() {
        return imagenEclipsed;
    }

    /**
     * Sets the eclipse image.
     *
     * @param imagenEclipsed The Image to set for the eclipse state.
     */
    public void setImagenEclipsed(Image imagenEclipsed) {
        this.imagenEclipsed = imagenEclipsed;
    }

    /**
     * Gets the current number of errors.
     *
     * @return The number of errors made by the player.
     */
    public void setCantErrores(Integer cantErrores) {
        this.cantErrores = cantErrores;
    }

    /**
     * Sets the number of errors.
     *
     * @param cantErrores The number of errors made by the player.
     */
    public Integer getCantErrores() {
        return cantErrores;
    }
}
