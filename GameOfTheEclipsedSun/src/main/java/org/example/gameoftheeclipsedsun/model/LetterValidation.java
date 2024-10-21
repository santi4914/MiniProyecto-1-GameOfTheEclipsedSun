package org.example.gameoftheeclipsedsun.model;

/**
 * Validates if a letter is part of the secret word.
 * It checks the letter and stores the result of the validation.
 *
 * @author Santiago Valencia Aguiño
 * @version 1.0
 * @since 2024
 * @see SecretWord
 */
public class LetterValidation {
    private Integer resultado;
    private Integer intentosFallidos;

    /**
     * Constructor that checks if the letter exists in the secret word.
     *
     * @param letra The letter to validate.
     * @param secretWord The secret word the player is trying to guess.
     */
    public LetterValidation(String letra, SecretWord secretWord){
        String palabraSecreta= secretWord.getSecretWord();
        System.out.println(letra);

        if (palabraSecreta.contains(letra)){
            resultado = 0;
        } else {
            resultado = 1;
        }
    }

    /**
     * Gets the result of the letter validation.
     *
     * @return 0 if the letter is correct, 1 if the letter is incorrect.
     */
    public Integer getResultado() {
        return resultado;
    }

    /**
     * Sets the result of the letter validation.
     *
     * @param resultado The validation result.
     */
    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }

    /**
     * Gets the number of failed attempts.
     *
     * @return The number of failed attempts.
     */
    public Integer getIntentosFallidos() {
        return intentosFallidos;
    }
}
