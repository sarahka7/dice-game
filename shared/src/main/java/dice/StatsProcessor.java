package dice;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.opencsv.CSVReader;


public class StatsProcessor {
    private CSVReader reader;

    public StatsProcessor(final String filename) {
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
