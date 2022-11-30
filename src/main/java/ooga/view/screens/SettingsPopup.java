package ooga.view.screens;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ooga.controller.Controller;

import java.util.ResourceBundle;

import static ooga.view.screens.SceneCreator.constants;

public class SettingsPopup extends VBox {
    private ResourceBundle labels;

    private Button saveGame;
    private Button quitGame;
    private ComboBox cssSelector;
    private Stage stage;

    private Stage saveStage;

    private Controller controller;
    //private int popupSize = Integer.parseInt(constants.getString("popupSize"));
    private MainGameScreen main;
    public SettingsPopup(ResourceBundle l, Stage s, MainGameScreen m, Controller c){
        main = m;
        labels = l;
        stage = s;
        controller = c;
        cssSelector = new ComboBox<>();
        cssSelector.setId("cssSelector");
        cssSelector.getItems().addAll(
                labels.getString("css1"), labels.getString("css2"),
                labels.getString("css3"));
        saveGame = new Button(labels.getString("saveGameButton"));
        quitGame = new Button(labels.getString("quitGameButton"));
        this.getChildren().addAll(cssSelector, saveGame, quitGame);
        handleEvents();

    }
    public void handleEvents(){
        saveGame.setOnAction(event->{
            saveStage=new Stage();
            saveStage.initModality(Modality.APPLICATION_MODAL);
            saveStage.initOwner(stage);
            CreateSavePopup csp = new CreateSavePopup(controller, labels);
            saveStage.setScene(csp.makeScene());
            saveStage.show();

        });

        quitGame.setOnAction(event -> {
            stage.close();
            Stage newStage = new Stage();
            StartScreen s = new StartScreen(newStage);
            newStage.setScene(s.makeScene());
            newStage.show();
            Stage toClose = (Stage)((Node) event.getSource()).getScene().getWindow();
            toClose.close();
        });
        cssSelector.setOnAction(event->{
            main.changeStyle((String) cssSelector.getValue());
        });
    }


}
