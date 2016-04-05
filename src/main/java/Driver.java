import java.io.IOException;
import dice.*;

public class Driver {
    public static void main(String[] args) {
        StatsProcessor proc =
            new StatsProcessor("src/test/resources/testDatabase.csv");
        try {
            proc.getFirstRecord();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
