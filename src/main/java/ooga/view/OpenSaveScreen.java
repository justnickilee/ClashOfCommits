package ooga.view;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ResourceBundle;

//this screen is for when the player wishes to load a previously saved game.
public class OpenSaveScreen {
    private SaveSlot slot1;
    private SaveSlot slot2;
    private SaveSlot slot3;
    private Pane background;
    private ResourceBundle labels;

    public OpenSaveScreen(ResourceBundle l){
        labels = l;
    }

    public Scene makeScene(){
        background = new Pane();
        slot1 = new SaveSlot(labels, "1");
        slot2 = new SaveSlot(labels, "2");
        slot3 = new SaveSlot(labels,"3");
        VBox slots = new VBox(slot1,slot2,slot3);
        background.getChildren().add(slots);
        Scene s = new Scene(background, StartScreen.SCREEN_SIZE,StartScreen.SCREEN_SIZE );
        //s.getStyleSheets().add(StartScreen.styles.getString("openSaveScreen");
        return s;
    }
}