import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.io.IOException;

import dice.*;

public class TestMockStatsProcessor {

    private StatsProcessor proc = StatsProcessor.create("mock");

    @Test
    public void getPlayerList() {
        String[] expected = {"ABC", "DEF", "GHI"};
        String[] observed = proc.getPlayerList();
        assertThat(expected, equalTo(observed));
    }

    @Test
    public void getPlayerStats() {
        StatsData stats = proc.getPlayerStats("ABC");
        assertThat(stats.getTotalRolls(), equalTo(100));
        assertThat(stats.getAvgRollsPerGame(), equalTo(4.3));
    }
}
