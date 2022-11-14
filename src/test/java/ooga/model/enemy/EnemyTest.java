package ooga.model.enemy;

import ooga.controller.EntityParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    private static EntityParser bugParser;
    private static EntityParser magicValueParser;

    @BeforeAll
    public static void setUp() {
        bugParser = new EntityParser("TestBug", new String[]{"Bug", "0", "0"});
        magicValueParser = new EntityParser("TestMagicValue", new String[]{"MagicValue", "0", "0"});
    }

    @Test
    void makeEnemyTest_Bug() {
        Enemy myEnemyBug = Enemy.makeEnemy(Bug.class, bugParser.getAttributeMap(), bugParser.getStateMap());
        assertInstanceOf(Bug.class, myEnemyBug);
    }

    @Test
    void makeEnemyTest_MagicValue() {
        Enemy myEnemyMagicValue = Enemy.makeEnemy(MagicValue.class, magicValueParser.getAttributeMap(), magicValueParser.getStateMap());
        assertInstanceOf(MagicValue.class, myEnemyMagicValue);
    }
}