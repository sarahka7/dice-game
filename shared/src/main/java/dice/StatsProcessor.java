package dice;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.opencsv.CSVReader;

/**
 * A class to process the stats collected in our database (CSV file)
 */
public class StatsProcessor {
    private CSVReader reader;

    /**
     * Function to take in a CSV file and parse it so that we can access/interpret data from our database
     * @param  filename - a CSV file (our database)
     */
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
