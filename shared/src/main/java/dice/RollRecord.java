package dice;

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
     * @param  rollValue  The total value of all dice rolled by the player.
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
     * @return string -> userId The players name in the game. Consists of three letters, usually the players initials.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Function to return the gameId
     * @return int -> gameId ID associated with a particualar game.
     */
    public int getGameId() {
        return gameId;
    }

    /**
     * Function to return the total number of dice used in a game.
     * @return int -> numDice Number of dice the player chooses to roll.
     */
    public int getNumDice() {
        return numDice;
    }

    /**
     * Function to return the total value of all dice rolled by the player.
     * @return int -> rollValue The total value of all dice rolled by the player.
     */
    public int getRollValue() {
        return rollValue;
    }

    /**
     * Function to return the total number of rolls by a player in a game.
     * @return int -> rollsCount Number of rolls by the player before the game was finished.
     */
    public int getRollsCount() {
        return rollsCount;
    }

    /**
     * Function to return the total score for a player.
     * @return int -> totalScore Total score after the game is finished.
     */
    public int getTotalScore() {
        return totalScore;
    }
}
