package dice;


public class DiceGame {
    private static final int MAX_TOTAL = 23;

    private Die die;
    private String username;
    private int currentTotal;

    private DiceGame(String username) {
        currentTotal = 0;
        die = new Die();
    }

    public static DiceGame create(String username)
            throws InvalidUsernameException {
        validateUsername(username);
        return new DiceGame(username);
    }

    public static DiceGame create() {
        DiceGame game;
        try {
            game = create("XXX");
        }
        catch (InvalidUsernameException e) {
            game = null;
        }

        return game;
    }

    public RollResult roll(int numDice) throws RollAfterGameOverException {

        if (getCurrentTotal() >= MAX_TOTAL) {
            throw new RollAfterGameOverException();
        }

        RollResult result = new RollResult();

        int rollValue = 0;

        for (int dieIndex = 0; dieIndex < numDice; dieIndex++) {
            rollValue = die.roll();
            result.addRoll(rollValue);
        }

        currentTotal += result.sum();

        return result;
    }

    public int getCurrentTotal() {
        return currentTotal;
    }

    public int getScore() {
        int score;

        int currentTotal = getCurrentTotal();

        if (currentTotal > MAX_TOTAL) {
            score = 0;
        }
        else if (currentTotal == MAX_TOTAL) {
            score = 2 * MAX_TOTAL;
        }
        else {
            score = currentTotal;
        }

        return score;
    }

    private static void validateUsername(String username)
            throws InvalidUsernameException {
        if (username.length() != 3) {
            throw new InvalidUsernameException();
        }
    }
}
