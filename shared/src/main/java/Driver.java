import java.io.IOException;
import dice.*;

public class Driver {
    public static void main(String[] args) {
        StatsProcessor proc = StatsProcessor.create();
        try {
            proc.getFirstRecord();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
