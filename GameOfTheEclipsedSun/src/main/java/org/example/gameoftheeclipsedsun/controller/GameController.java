package org.example.gameoftheeclipsedsun.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.HBox;
import org.example.gameoftheeclipsedsun.model.GameErrorRecorder;
import org.example.gameoftheeclipsedsun.model.SecretWord;
import org.example.gameoftheeclipsedsun.model.LetterValidation;
import org.example.gameoftheeclipsedsun.model.GameResultImages;
import org.example.gameoftheeclipsedsun.view.guide.GameInfo;

import java.util.List;

import static org.example.gameoftheeclipsedsun.controller.WelcomeController.validateWord;

/**
 * Handles the main gameplay logic, including letter validation, error tracking, and user interaction.
 * It manages the game state, such as counting errors and revealing letters.
 *
 * @author Santiago Valencia Aguiño
 * @version 1.0
 * @since 2024
 * @see WelcomeController
 * @see GameErrorRecorder
 * @see SecretWord
 * @serialData Handles user input and displays the game's UI elements.
 */

public class GameController {
    @FXML
    private AnchorPane anchorPaneHangMan;

    @FXML
    private Button startGameBtn;

    @FXML
    private HBox hBoxLetters;

    @FXML
    private AnchorPane anchorPaneWord;

    @FXML
    private Label hintsUsed;

    @FXML
    private Label textBase1;

    @FXML
    private Label labelTries;

    @FXML
    private TextField textFieldLetter;

    @FXML
    private Button hintBtn;

    @FXML
    private ImageView imgViewEclipsed;

    private LetterValidation letterValidation;
    private SecretWord secretWord;
    private TextField txtLetras;
    private List<String> listaControl;
    private GameResultImages gameResultImages;
    private GameErrorRecorder defeated;

    /**
     * Handles the player's input from the letter text field.
     * Validates the input and updates the game state based on whether the letter is correct.
     *
     * @param event ActionEvent triggered when the player enters a letter.
     * @serialField secretWord Validates the secret word against the entered letter.
     */
    @FXML
    void onHandleTextFieldLetter(ActionEvent event) {

        String letraIngresada = textFieldLetter.getText().toLowerCase();
        textFieldLetter.setText("");


        if (letraIngresada.length() != 1 || !validateWord(letraIngresada)) {
            textBase1.setText("¡Carácter inválido! " +
                              "\nIngrese solo una letra.");
            textBase1.setLayoutY(200);
            textBase1.setLayoutX(107);
            return;
        }


        if (!secretWord.getWord().contains(letraIngresada)) {
            Integer cantErrores = secretWord.getErrorCount();
            defeated = new GameErrorRecorder(cantErrores);

            secretWord.incrementErrorCount();
            defeated.setCantErrores(cantErrores);
            labelTries.setText(String.valueOf(secretWord.getErrorCount()));
            imgViewEclipsed.setImage(defeated.getImagenEclipsed());

            if (secretWord.getErrorCount() >= 5) {
                gameResultImages = new GameResultImages();
                hBoxLetters.setVisible(false);
                textFieldLetter.setVisible(false);
                textBase1.setText("¡Lo lamento! Has perdido,\n¡Suerte para la próxima!");
                hintBtn.setVisible(false);
                textBase1.setLayoutX(64);
                textBase1.setLayoutY(216);
                ImageView imageDefeated = gameResultImages.getImageViewLoser();
                anchorPaneWord.getChildren().add(imageDefeated);
                return;
            }

            System.out.println("El carácter ingresado no está en la palabra secreta. Error: " + secretWord.getErrorCount());
        } else {
            letterValidation = new LetterValidation(letraIngresada, this.secretWord);


            if(letterValidation.getResultado()==0){
                for(int i=0;i<secretWord.getArraySecretWord().length;i++){
                    String verificarSeccion = secretWord.getArraySecretWord()[i];

                    if (verificarSeccion.contains(letraIngresada)) {
                        TextField textField = (TextField) hBoxLetters.getChildren().get(i);
                        textField.setText(letraIngresada);
                    }
                }
                int index = 0;
                while (index < listaControl.size()) {
                    String charValidador = listaControl.get(index);
                    if (charValidador.contains(letraIngresada)) {
                        System.out.println("El elemento eliminado fue: " + charValidador);
                        listaControl.remove(index);
                    } else {
                        index++;
                    }
                }
                secretWord.setCopiaArray(listaControl);
            }

            textBase1.setText("INGRESA UNA LETRA DEL ABECEDARIO");
            textBase1.setLayoutY(205);
            textBase1.setLayoutX(27);

        }


        if (listaControl.isEmpty()){
            gameResultImages =new GameResultImages();
            hBoxLetters.setVisible(false);
            textFieldLetter.setVisible(false);
            textBase1.setVisible(false);
            hintBtn.setVisible(false);
            Label ganador=new Label("Felicidades! Has ganado el juego");
            ganador.setAlignment(Pos.CENTER);
            ganador.setPrefWidth(anchorPaneWord.getWidth());
            ImageView imagenGanador= gameResultImages.getImageViewWinner();
            anchorPaneWord.getChildren().addAll(ganador,imagenGanador);
        }
        System.out.println("La lista control es: "+listaControl);
    }

    /**
     * Starts the game when the Start Game button is clicked.
     * Initializes the game board, letters, and other game components.
     *
     * @param event ActionEvent triggered when the Start Game button is pressed.
     */

    @FXML
    void onHandleButtonStartGame(ActionEvent event) {

        for (int i = 0; i < secretWord.getSecretWord().length(); i++) {
            txtLetras = new TextField();
            txtLetras.setEditable(false);
            hBoxLetters.getChildren().add(txtLetras);
        }

        textFieldLetter.setVisible(true);
        textBase1.setVisible(true);
        secretWord.setControlShow(true);
        hintBtn.setVisible(true);
        startGameBtn.setVisible(false);
        listaControl=secretWord.getCopiaArray();
        imgViewEclipsed =new ImageView();
        imgViewEclipsed.setImage(new Image(String.valueOf(getClass().getResource("/org/example/gameoftheeclipsedsun/image/eclipsed0.png"))));
        anchorPaneHangMan.getChildren().add(imgViewEclipsed);
    }
    private Integer cantidadPistas=0;

    /**
     * Displays the game instructions when the "?" button is pressed.
     *
     * @param event ActionEvent triggered when the help button is clicked.
     * @see GameInfo#showMessageRuler(String, String, String)
     */

    @FXML
    void onHandleButtonQuestion(ActionEvent event) {

        String tittle="Instrucciones";
        String header ="Instrucciones";
        String content ="Bienvenido,\n" +
                "A continuación, te explico cómo jugar:\n" +
                "\n1. Para descubrir la palabra secreta, deberás ingresar una letra del abecedario en la casilla correspondiente.\n" +
                "\n2. Si la letra que ingresas está contenida en la palabra secreta, comenzará a revelarse poco a poco.\n" +
                "\n3. Debes tener cuidado: solo puedes equivocarte un máximo de cinco veces. Si cometes más errores y no logras descubrir la palabra secreta, perderás el juego, y el sol será eclipsado.\n" +
                "\n4. Para ayudarte a ganar, dispones de hasta tres pistas, a las que puedes acceder presionando el botón 'Ayuda'. Una vez que el juego haya comenzado, haz clic en este botón y recibirás una de las letras contenidas en la palabra secreta.\n" +
                "\n5. Es importante que no dejes el campo de texto vacío y que ingreses solo una letra a la vez. Si ingresas más de una letra, se contará como un error y perderás una oportunidad.\n" +
                "\n¡Buena suerte y diviértete jugando!";
        GameInfo gameInfo =new GameInfo();
        gameInfo.showMessageRuler(tittle,header,content);


    }

    /**
     * Provides a random hint to the player when the "Help" button is clicked.
     * This reveals one letter from the secret word.
     *
     * @param event ActionEvent triggered when the Help button is clicked.
     */

    @FXML
    void onHandleButtonHelp(ActionEvent event) {
        if (cantidadPistas < 3 && !listaControl.isEmpty()) {
            Integer listaSize = listaControl.size();
            Integer pistaAleatoria = (int) (Math.random() * listaSize);
            String letraPista = listaControl.get(pistaAleatoria);


            String tittle = "Pista";
            String header = "Pista";
            String content = "Hola, jugador. \nUna de las letras de la palabra es " + letraPista + ".";
            GameInfo gameInfo = new GameInfo();
            gameInfo.showMessageHint(tittle, header, content);

            for (int i = 0; i < secretWord.getArraySecretWord().length; i++) {
                String verificarSeccion = secretWord.getArraySecretWord()[i];
                if (verificarSeccion.equals(letraPista)) {
                    TextField textField = (TextField) hBoxLetters.getChildren().get(i);
                    textField.setText(letraPista);
                }
            }


            listaControl.remove(letraPista);


            cantidadPistas++;
            hintsUsed.setText(String.valueOf(cantidadPistas));
            System.out.println("La cantidad de pistas dadas son: " + cantidadPistas);
            System.out.println("Letras restantes para pistas: " + listaControl);
        } else {

            String tittle = "Pista";
            String header = "Pista";
            String content = "Ya no puedes acceder a más pistas.";
            GameInfo gameInfo = new GameInfo();
            gameInfo.showMessageHint(tittle, header, content);
        }
    }

    /**
     * Sets the secret word for the game. This word will be used for letter validation and
     * determining if the player has won or lost.
     *
     * @param secretWord The word the player must guess.
     */

    public void setSecretWord(SecretWord secretWord) {
        this.secretWord = secretWord;
    }
}