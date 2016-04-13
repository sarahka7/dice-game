import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.io.IOException;
import dice.*;

public class TestDiceGame {

    @Test
    public void testRoll1Die() {
        for (int rollIdx = 0; rollIdx < 1000; rollIdx++) {

            DiceGame game = new DiceGame();

            try {
                RollResult roll = game.roll(1);
                assertTrue(roll.sum() >= 1 && roll.sum() <= 6);
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
                RollResult roll = game.roll(2);
                assertTrue(roll.sum() >= 2 && roll.sum() <= 12);
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
                RollResult roll = game.roll(3);
                assertTrue(roll.sum() >= 3 && roll.sum() <= 18);
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
            int total = game.roll(1).sum();
            total += game.roll(1).sum();
            total += game.roll(1).sum();

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
            RollResult roll = game.roll(3);

            assertEquals(roll.sum(), game.getScore());
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
                total += game.roll(1).sum();
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
            int total = game.roll(3).sum();
            
            while (total < 23) {
                total += game.roll(3).sum();
            }

            assertThat(game.getScore(), anyOf(equalTo(0), equalTo(46)));
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
