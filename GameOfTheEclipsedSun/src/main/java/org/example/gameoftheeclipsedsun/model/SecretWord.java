package org.example.gameoftheeclipsedsun.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Manages the secret word the player is trying to guess.
 * Tracks the word, error count, and displays the correct letters.
 *
 * @author Santiago Valencia Aguiño
 * @version 1.0
 * @since 2024
 * @see LetterValidation
 * @serialData This class contains data about the secret word and its error count.
 */

public class SecretWord {
    private boolean controlShow;
    private String secretWord;
    private String[] arraySecretWord;
    private List<String> copiaArray;
    private int errorCount;

    /**
     * Constructor that initializes the secret word and splits it into an array of characters.
     *
     * @param secretWord The word that the player must guess.
     */
    public SecretWord(String secretWord){
        this.secretWord=secretWord;
        this.arraySecretWord=secretWord.split("");
        this.controlShow=false;
        this.errorCount = 0;

        copiaArray = new ArrayList<>();

        for (int i = 0; i < secretWord.length(); i++) {
            copiaArray.add(Character.toString(secretWord.charAt(i)));
        }

        System.out.println("Lista de caracteres:");
        for (String caracter : copiaArray) {
            System.out.println(caracter);
        }
    }

    /**
     * Gets the array representing the secret word split into characters.
     *
     * @return Array of characters representing the secret word.
     */
    public String[] getArraySecretWord() {
        return arraySecretWord;
    }

    /**
     * Sets the array representing the secret word.
     *
     * @param arraySecretWord Array of characters representing the secret word.
     */
    public void setArraySecretWord(String[] arraySecretWord) { // Corregido el método setArraySecretWord
        this.arraySecretWord = arraySecretWord;
    }

    /**
     * Gets the secret word.
     *
     * @return The secret word.
     */
    public String getSecretWord() {
        return secretWord;
    }

    /**
     * Sets the secret word.
     *
     * @param secretWord The word that the player must guess.
     */
    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    /**
     * Gets the control flag to show the game status.
     *
     * @return True if the game is in progress, false otherwise.
     */
    public boolean getControlShow() {
        return controlShow;
    }

    /**
     * Sets the control flag to show the game status.
     *
     * @param controlShow True if the game is in progress, false otherwise.
     */
    public void setControlShow(boolean controlShow) {
        this.controlShow = controlShow;
    }

    /**
     * Gets the list representing a copy of the secret word array.
     *
     * @return List of characters representing the secret word.
     */
    public List<String> getCopiaArray() {
        return copiaArray;
    }

    /**
     * Sets the list representing a copy of the secret word array.
     *
     * @param copiaArray The list of characters.
     */
    public void setCopiaArray(List<String> copiaArray) {
        this.copiaArray = copiaArray;
    }

    /**
     * Increments the error count by one.
     */
    public void incrementErrorCount() {
        errorCount++;
    }

    /**
     * Gets the current number of errors made by the player.
     *
     * @return The number of errors.
     */
    public int getErrorCount() {
        return errorCount;
    }

    /**
     * Gets the word that the player is trying to guess.
     *
     * @return The secret word.
     */
    public String getWord() {
        return secretWord;
    }
}
