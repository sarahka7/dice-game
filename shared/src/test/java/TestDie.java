import dice.*;
import org.junit.*;
import static org.junit.Assert.*;


public class TestDie {
    private Die die;

    @Before
    public void setUp() {
        die = new Die();
    }

    @Test
    public void testRoll() {
        // Try 1000 rolls and verify they are always in the proper range
        for (int rollIdx = 0; rollIdx < 1000; rollIdx++) {
            int roll = die.roll();
            assertTrue(roll >= 1 && roll <= 6);
        }
    }
}
