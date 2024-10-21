package org.example.gameoftheeclipsedsun.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.gameoftheeclipsedsun.model.SecretWord;
import org.example.gameoftheeclipsedsun.view.GameStage;
import org.example.gameoftheeclipsedsun.view.WelcomeStage;
import org.example.gameoftheeclipsedsun.view.guide.GameInfo;

import java.io.IOException;

/**
 * Controls the welcome screen where the player sets the secret word.
 * Validates the word and passes it to the game controller for the main gameplay.
 *
 * @author Santiago Valencia Aguiño
 * @version 1.0
 * @since 2024
 * @see SecretWord
 * @see GameStage
 * @see GameController
 */

public class WelcomeController {
    private SecretWord secretWord;
    @FXML
    private TextField textFieldSecretWord;

    @FXML
    private Label textLabelChek;

    /**
     * Validates if a word contains only letters, including accented letters.
     *
     * @param word The word to validate.
     * @return true if the word contains only valid characters, false otherwise.
     * @since 1.0
     */
    public static boolean validateWord(String word){
        String charactersLowerCase = word.toLowerCase();

        return charactersLowerCase.matches("[a-zñáéíóú]*");
    }


    /**
     * Handles the Play button click event. Validates the secret word and
     * initiates the game if the word is valid.
     *
     * @param event ActionEvent triggered when the Play button is pressed.
     * @throws IOException if there is an error loading the game screen.
     * @see GameStage
     * @serialField secretWord Sets the secret word and initiates the game.
     */

    @FXML
    void onHandleButtonPlay(ActionEvent event) throws IOException{
        String palabraSecreta = textFieldSecretWord.getText().toLowerCase();


        if(palabraSecreta.length() < 6 || palabraSecreta.length() > 13 ) {
            textLabelChek.setText("Palabra no admitida");
        } else if ((!validateWord(palabraSecreta))) {
            textLabelChek.setText("Palabra no admitida");

        } else {

            secretWord = secretWord;
            secretWord =new SecretWord(palabraSecreta);
            GameStage.getInstance().getGameController().setSecretWord(secretWord);
            WelcomeStage.deleteInstance();
            System.out.println("Palabra en minúsculas: " + palabraSecreta);

        }

    }


    /**
     * Displays the game rules when the Ruler button is clicked.
     *
     * @param event ActionEvent triggered when the Ruler button is pressed.
     * @see GameInfo#showMessageRuler(String, String, String)
     */

    @FXML
    void onHandleButtonRuler(ActionEvent event){
        String tittle="Reglas del juego";
        String header ="Reglas";
        String content = "Bienvenido," +
                "\nLa regla del juego son las siguientes:" +
                "\n 1- Deberás ingresar una palabra sin números y sin símbolos. " +
                "\n 2- La palabra debe tener entre 6 y 12 caracteres o letras. " +
                "\n 3- No puedes dejar la entrada vacía.";
        GameInfo gameInfo =new GameInfo();
        gameInfo.showMessageRuler(tittle,header,content);

    }

    /**
     * Sets the secret word for the game, passing it to the game controller.
     *
     * @param secretWord The word the player will guess in the game.
     * @since 1.0
     * @see GameController
     */

    public void setSecretWord(SecretWord secretWord) {
        this.secretWord = secretWord;
    }
}
