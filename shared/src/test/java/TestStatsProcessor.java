import org.junit.*;
import static org.junit.Assert.*;
import java.io.IOException;

import dice.*;


public class TestStatsProcessor {
    private StatsProcessor proc;

    @Before
    public void setUp() {
        proc = StatsProcessor.create();
    }

    @Test
    public void getStatsProcessor() {
        StatsProcessor proc = StatsProcessor.create();
    }

    @Test
    public void testPrintAllLines() {
        try {
            RollRecord record = proc.getFirstRecord();
            assertEquals("TAP", record.getUserId());
            assertEquals(0, record.getGameId());
            assertEquals(2, record.getNumDice());
            assertEquals(10, record.getRollValue());
            assertEquals(2, record.getRollsCount());
            assertEquals(18, record.getTotalScore());
        }
        catch (IOException e) {
        }
    }
}
