package dice;


public class RollRecord {
    private String userId;
    private int gameId;
    private int numDice;
    private int rollValue;
    private int rollsCount;
    private int totalScore;

    public RollRecord(String userId, int gameId, int numDice, int rollValue,
                      int rollsCount, int totalScore) {
        this.userId = userId;
        this.gameId = gameId;
        this.numDice = numDice;
        this.rollValue = rollValue;
        this.rollsCount = rollsCount;
        this.totalScore = totalScore;
    }

    public String getUserId() {
        return userId;
    }

    public int getGameId() {
        return gameId;
    }

    public int getNumDice() {
        return numDice;
    }

    public int getRollValue() {
        return rollValue;
    }

    public int getRollsCount() {
        return rollsCount;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
