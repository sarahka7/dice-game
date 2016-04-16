import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.io.IOException;
import dice.*;

public class TestDiceGame {

    @Test
    public void testRoll1Die() {
        for (int rollIdx = 0; rollIdx < 1000; rollIdx++) {

            DiceGame game = DiceGame.create();

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

            DiceGame game = DiceGame.create();

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

            DiceGame game = DiceGame.create();

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

        DiceGame game = DiceGame.create();

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

        DiceGame game = DiceGame.create();

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

        DiceGame game = DiceGame.create();

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
                game = DiceGame.create();
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
        DiceGame game = DiceGame.create();

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
        DiceGame game = DiceGame.create();

        assertEquals(0, game.getScore());
    }

    @Test
    public void usernameDefault() {
        DiceGame game = DiceGame.create();
        assertThat(game.getUsername(), equalTo("XXX"));
    }

    @Test
    public void usernameCustom() {
        DiceGame game = null;
        try {
            game = DiceGame.create("ABC");
        }
        catch (InvalidUsernameException e) {
            fail();
        }

        assertThat(game.getUsername(), equalTo("ABC"));
    }

    @Test
    public void usernameBlankRaisesException() {
        DiceGame game = null;
        try {
            game = DiceGame.create("");
            fail();
        }
        catch (InvalidUsernameException e) {
            assertThat(e.getMessage(), is("Blank username"));
        }
    }
    @Test
    public void usernameTooShortRaisesException() {
        DiceGame game = null;
        try {
            game = DiceGame.create("AB");
            fail();
        }
        catch (InvalidUsernameException e) {
            assertThat(e.getMessage(), is("Username 'AB' too short"));
        }
    }

    @Test
    public void usernameTooLongRaisesException() {
        DiceGame game = null;
        try {
            game = DiceGame.create("ABCD");
            fail();
        }
        catch (InvalidUsernameException e) {
            assertThat(e.getMessage(), is("Username 'ABCD' too long"));
        }
    }
}
