package ooga;


import javafx.application.Application;
import javafx.stage.Stage;
import ooga.controller.Controller;
import ooga.model.attack.Attack;
import ooga.model.enemy.Bug;
import ooga.model.enemy.Enemy;
import ooga.model.enemy.MagicValue;
import ooga.view.StartScreen;

import java.util.List;

/**
 * Feel free to completely change this code or delete it entirely. 
 */
public class Main extends Application {
    /**
     * A method to test (and a joke :).
     */
    public double getVersion () {
        return 0.001;
    }

    /**
     * Start of the program.
     */

    @Override
    public void start(Stage stage){
        stage.show();
        Controller controller = new Controller(stage);
        controller.startAnimation();
    }

    public static void main (String[] args) {
        launch(args);
//        Enemy bug = Enemy.makeEnemy(Bug.class, 1.0, 1.0);
//        bug.attack();
//        Enemy magicValue = Enemy.makeEnemy(MagicValue.class, 5.0, 2.0);
//        magicValue.attack();
    }
}
