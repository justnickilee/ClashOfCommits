package ooga.view;


import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import ooga.controller.Controller;
import ooga.view.screens.ChooseGameScreen;
import ooga.view.screens.StartScreen;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;
import static org.junit.jupiter.api.Assertions.*;

class StartScreenTest extends DukeApplicationTest {

    private Button startGame;

    private Button newGame;
    private ComboBox<String> languageSelector;

    @Override
    public void start(Stage stage) {
        Controller controller = new Controller(stage);
        StartScreen ss = new StartScreen(stage, controller);
        ChooseGameScreen cgs = new ChooseGameScreen(stage, controller);
        stage.setScene(ss.makeScene());
        stage.show();
        startGame = lookup("#startGame").query();
        languageSelector = lookup("#languageSelector").query();
    }
    @Test
    void testNoSelection() {
        clickOn(startGame);
        newGame = lookup("#newGame").query();
        assertText("New Game", newGame.getText());
    }

    @Test
    void testSelectEnglish() {
        String language = "English";
        select(languageSelector,language);
        clickOn(startGame);
        newGame = lookup("#newGame").query();
        assertText("New Game", newGame.getText());
    }

    @Test
    void testSelectGerman() {
        String language = "Deutsch";
        select(languageSelector, language);
        clickOn(startGame);
        newGame = lookup("#newGame").query();
        assertText("Neues Spiel", newGame.getText());
    }

    @Test
    void testSelectSimlish() {
        String language = "Simlish";
        select(languageSelector, language);
        clickOn(startGame);
        newGame = lookup("#newGame").query();
        assertText("New Game", newGame.getText());
    }
/*
    @Test
    void testSelectSpanish() {
        String language = "Español";
        select(languageSelector,language);
        clickOn(startGame);
        newGame = lookup("#newGame").query();
        assertText("Nuevo Juego", newGame.getText());
    }
*/


    private void assertText(String expected, String given) {
        assertEquals(expected, given);
    }

}
