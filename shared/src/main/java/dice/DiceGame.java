package dice;


public class DiceGame {
    private static final int MAX_TOTAL = 23;

    private Die die;
    private String username;
    private int currentTotal;

    private DiceGame(String username) {
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    private static void validateUsername(String username)
            throws InvalidUsernameException {
        final int VALID_LENGTH = 3;
        if (username.length() == 0) {
            throw new InvalidUsernameException("Blank username");
        }
        else if (username.length() < VALID_LENGTH) {
            String message = "Username '" + username + "' too short";
            throw new InvalidUsernameException(message);
        }
        else if (username.length() > VALID_LENGTH) {
            String message = "Username '" + username + "' too long";
            throw new InvalidUsernameException(message);
        }
    }
}
