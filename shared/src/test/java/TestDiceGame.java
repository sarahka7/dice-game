import org.junit.*;
import static org.junit.Assert.*;
import java.io.IOException;

import dice.*;

public class TestDiceGame {

    @Test
    public void rollSingelDie() {
        for (int rollIdx = 0; rollIdx < 1000; rollIdx++) {
            DiceGame game = new DiceGame();

            try {
                int roll = game.rollSingle();
                assertTrue(roll >= 1 && roll <= 6);
            }
            catch (RollAfterGameOverException e) {
                fail();
            }

        }
    }

    @Test
    public void testRoll1Die() {
        for (int rollIdx = 0; rollIdx < 1000; rollIdx++) {

            DiceGame game = new DiceGame();

            try {
                int roll = game.roll(1);
                assertTrue(roll >= 1 && roll <= 6);
            }
            catch (RollAfterGameOverException e) {
                fail();
            }
        }
    }

    @Test
    public void testRoll2Dice() {
        for (int rollIdx = 0; rollIdx < 1000; rollIdx++) {

            DiceGame game = new DiceGame();

            try {
                int roll = game.roll(2);
                assertTrue(roll >= 2 && roll <= 12);
            }
            catch (RollAfterGameOverException e) {
                fail();
            }
        }
    }

    @Test
    public void testRoll3Dice() {
        for (int rollIdx = 0; rollIdx < 1000; rollIdx++) {

            DiceGame game = new DiceGame();

            try {
                int roll = game.roll(3);
                assertTrue(roll >= 3 && roll <= 18);
            }
            catch (RollAfterGameOverException e) {
                fail();
            }
        }
    }

    @Test
    public void testGetCurrentTotal() {

        DiceGame game = new DiceGame();

        try {
            int total = game.roll(1);
            total += game.roll(1);
            total += game.roll(1);

            int currentTotal = game.getCurrentTotal();
            assertEquals(total, currentTotal);
        }
        catch (RollAfterGameOverException e) {
            fail();
        }
    }

    @Test
    public void testGetScoreLessThan23() {

        DiceGame game = new DiceGame();

        try {
            int total = game.roll(3);

            assertEquals(total, game.getScore());
        }
        catch (RollAfterGameOverException e) {
            fail();
        }
    }

    @Test
    public void testGetScoreEqualTo23() {

        DiceGame game = new DiceGame();

        int total = 0;
        int index = 0;

        // hack. go until we randomly get a score of 23
        do {
            try {
                total += game.roll(1);
            }
            catch (RollAfterGameOverException e) {
                fail();
            }

            if (total > 23) {
                game = new DiceGame();
                total = 0;
            }

            // failsafe
            index++;
            if (index > 10000) {
                fail();
            }

        } while (total != 23);

        assertEquals(46, game.getScore());
    }

    @Test
    public void testGetScoreOver23() {
        DiceGame game = new DiceGame();

        try {
            int total = game.roll(3);
            
            while (total < 23) {
                total += game.roll(3);
            }

            assertEquals(0, game.getScore());
        }
        catch (RollAfterGameOverException e) {
            fail();
        }
    }
    
    @Test
    public void testZeroScore() {
        DiceGame game = new DiceGame();

        assertEquals(0, game.getScore());
    }
}
