package ooga.view.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ResourceBundle;

/**
 * This class represents the screen that is displayed when the game is won.
 *
 * @author James Qu
 */
public class EndGameScreen extends SceneCreator {
  private Scene endGameScene;
  private Pane pane;
  private Text text;
  private ResourceBundle styles;
  private int screenSize;
  private Stage currentStage;
  private ResourceBundle resources;
  private Button playAgainButton;
  private ResourceBundle constants;
  private VBox buttons;
  private String css;
  private boolean won;

  public EndGameScreen(Stage stage, boolean win) {
    this.resources = getLabels();
    this.constants = getConstants();
    this.currentStage = stage;
    this.styles = getStyles();
    this.screenSize = getScreenSize();
    this.won = win;
  }

  @Override
  public Scene makeScene() {
    this.pane = new StackPane();
    pane.setId("EndGameScreen");
    playAgainButton = new Button(resources.getString("playAgainButton"));
    playAgainButton.setId("playAgainButton");
    determineScreenType(won);
    buttons = new VBox();
    buttons.getChildren().addAll(text, playAgainButton);
    buttons.setAlignment(Pos.CENTER);
    pane.getChildren().add(buttons);
    endGameScene = new Scene(pane, screenSize, screenSize);
    endGameScene.getStylesheets().add(styles.getString(css));
    handleEvents();
    return endGameScene;
  }

  private void returnToBeginning() {
    StartScreen screen = new StartScreen(currentStage);
    currentStage.setScene(screen.makeScene());
    currentStage.show();
  }
  private void handleEvents() {
    playAgainButton.setOnAction(event -> {
      returnToBeginning();
    });
  }

  //TODO: Refactor the Strings out?
  private void determineScreenType(boolean win) {
    if (win) {
      text = new Text("Congratulations!!!");
      text.setId("congratsMessage");
      css = "winScreenCSS";
    }
    else {
      text = new Text("You have lost");
      text.setId("loseMessage");
      css = "loseScreenCSS";
    }
  }
}
