import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.io.IOException;

import dice.*;


public class TestStatsProcessor {
    private StatsProcessor proc;

    @Before
    public void setUp() {
        Database db = Database.create("mock");
        proc = StatsProcessor.create("concrete", db);
    }

    @Test
    public void getPlayerList() {
        String[] playerList = proc.getPlayerList();

        assertThat(playerList.length, equalTo(2));
        assertThat(playerList[0], equalTo("TAP"));
        assertThat(playerList[1], equalTo("CHS"));
    }
}
