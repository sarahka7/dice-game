import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.io.IOException;

import dice.*;

public class TestRollResult {

    @Test
    public void addRoll() {
        RollResult result = new RollResult();
        result.addRoll(5);
    }

    @Test
    public void sum() {
        RollResult result = new RollResult();
        result.addRoll(5);
        result.addRoll(6);
        assertThat(result.sum(), equalTo(11));
    }

    @Test
    public void rollsCount() {
        RollResult result = new RollResult();
        result.addRoll(5);
        result.addRoll(6);
        assertThat(result.rollCount(), equalTo(2));
    }

    @Test
    public void rollsArray() {
        RollResult result = new RollResult();
        result.addRoll(5);
        result.addRoll(6);
        int[] expected = {5, 6};
        assertThat(result.rollsArray(), equalTo(expected));
    }
}


