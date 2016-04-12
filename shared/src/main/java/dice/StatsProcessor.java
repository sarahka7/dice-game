package dice;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.opencsv.CSVReader;

public abstract class StatsProcessor {
    public static StatsProcessor create(String type) {
        if (type == "mock") {
            return new MockStatsProcessor();
        }
        else {
            return new ConcreteStatsProcessor(
                "src/test/resources/testDatabase.csv");
        }
    }

    public static StatsProcessor create() {
        return create("concrete");
    }

    public abstract String[] getPlayerList();
    public abstract StatsData getPlayerStats(String playerName);

    public abstract RollRecord getFirstRecord() throws IOException;
}

class MockStatsProcessor extends StatsProcessor {
    public String[] getPlayerList() {
        String[] list = new String[3];
        list[0] = "ABC";
        list[1] = "DEF";
        list[2] = "GHI";
        return list;
    }

    public StatsData getPlayerStats(String playerName) {
        if (playerName.equals("ABC")) {
            return new StatsData.Builder()
                .totalRolls(100)
                .avgRollsPerGame(4.3)
                .build();
        }
        return new StatsData.Builder().build();
    }

    public RollRecord getFirstRecord() throws IOException {
        return new RollRecord("", 0, 0, 0, 0, 0);
    }
}


/**
 * A class to process the stats collected in our database (CSV file)
 */
class ConcreteStatsProcessor extends StatsProcessor {
    private CSVReader reader;

    /**
     * Function to take in a CSV file and parse it so that we can access/interpret data from our database
     * @param  filename - a CSV file (our database)
     */
    public ConcreteStatsProcessor(final String filename) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filename);
        }
        catch(IOException e) {
            // TODO: handle properly
            System.out.println("Error opening file");
        }

        reader = new CSVReader(fileReader);

    }

    public String[] getPlayerList() {
        return new String[1];
    }

    public StatsData getPlayerStats(String playerName) {
        return new StatsData.Builder().build();
    }

    /**
     * This function will read the reader object and return the values from a given line in the database.
     * @return RollRecord -> an object containing stats provided from the database
     * @throws IOException   [description]
     */
    public RollRecord getFirstRecord() throws IOException {

        String[] line = reader.readNext();
        line = reader.readNext();

        final String userId = line[0];
        final int gameId = Integer.parseInt(line[1]);
        final int numDice = Integer.parseInt(line[2]);
        final int rollValue = Integer.parseInt(line[3]);
        final int rollsCount = Integer.parseInt(line[4]);
        final int totalScore = Integer.parseInt(line[5]);

        return new RollRecord(userId, gameId, numDice, rollValue, rollsCount,
                              totalScore);
    }
}
