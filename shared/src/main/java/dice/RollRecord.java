package dice;

/**
 * 
 */
public class RollRecord {
    private String userId;
    private int gameId;
    private int numDice;
    private int rollValue;
    private int rollsCount;
    private int totalScore;

    /**
     * Creates an object after a game has been completed. The goal of this object is to provide details in the database.
     * 
     * @param  userId     The players name in the game. Consists of three letters, usually the players initials.
     * @param  gameId     ID associated with a particualar game.
     * @param  numDice    Number of dice the player chooses to roll.
     * @param  rollValue  The totaled value of all dice rolled by the player.
     * @param  rollsCount Number of rolls by the player before the game was finished.
     * @param  totalScore Total score after the game is finished.
     */
    public RollRecord(String userId, int gameId, int numDice, int rollValue,
                      int rollsCount, int totalScore) {
        this.userId = userId;
        this.gameId = gameId;
        this.numDice = numDice;
        this.rollValue = rollValue;
        this.rollsCount = rollsCount;
        this.totalScore = totalScore;
    }

    /**
     * Function to return the userId
     * @return string -> userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Function to return the gameId
     * @return int -> gameId
     */
    public int getGameId() {
        return gameId;
    }

    /**
     * Function to return the total number of dice used in a game.
     * @return int -> numDice
     */
    public int getNumDice() {
        return numDice;
    }

    /**
     * ???
     * @return int -> rollValue
     */
    public int getRollValue() {
        return rollValue;
    }

    /**
     * Function to return the total number of rolls by a player in a game.
     * @return int -> rollsCount
     */
    public int getRollsCount() {
        return rollsCount;
    }

    /**
     * Function to return the total score for a player.
     * @return int -> totalScore
     */
    public int getTotalScore() {
        return totalScore;
    }
}
