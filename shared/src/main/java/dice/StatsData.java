package dice;


public class StatsData {
    private final int totalRolls;
    private double avgRollsPerGame;

    public int getTotalRolls() {
        return totalRolls;
    }

    public double getAvgRollsPerGame() {
        return avgRollsPerGame;
    }

    // Builder Pattern adapted from here:
    // http://www.informit.com/articles/article.aspx?p=1216151&seqNum=2
    public static class Builder {

        private int totalRolls = 0;
        private double avgRollsPerGame = 0.0;

        public Builder totalRolls(int val) {
            totalRolls = val;
            return this;
        }

        public Builder avgRollsPerGame(double val) {
            avgRollsPerGame = val;
            return this;
        }

        public StatsData build() {
            return new StatsData(this);
        }
    }

    private StatsData(Builder builder) {
        totalRolls = builder.totalRolls;
        avgRollsPerGame = builder.avgRollsPerGame;
    }
}
