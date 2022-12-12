package ooga.controller.gameState;

import java.util.Map;
import java.util.ResourceBundle;
import ooga.controller.Controller;
import ooga.view.EntityView;
import ooga.view.HUD;

/**
 * This subclass helps determine what the win and lose conditions are for our adventure type game.
 *
 * @author James Qu
 */

public class AdventureGameState extends MapGameState {
  private static final ResourceBundle gameScore = ResourceBundle.getBundle(
      "ResourceBundles.Score");
  private int score;

  public AdventureGameState(Map<String, EntityView> viewEntities, Controller controller) {
    super(viewEntities, controller);
  }

  /**
   * Method to determine if the adventure game is won
   * @return boolean representing whether the adventure game is won or not
   */
  @Override
  public boolean determineWin(int score) {
    this.score = score;
    if (this.score >= Integer.parseInt(gameScore.getString("adventureWinScore"))) {
      return true;
    }
    return false;
  }
}