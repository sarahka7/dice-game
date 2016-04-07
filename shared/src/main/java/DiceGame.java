package dice;


public class DiceGame {
    private Die die;
    private int currentTotal;
    private static final int MAX_TOTAL = 23;

    public DiceGame() {
        currentTotal = 0;
        die = new Die();
    }

    public int roll(int numDice) throws RollAfterGameOverException {

        if (getCurrentTotal() >= MAX_TOTAL) {
            throw new RollAfterGameOverException();
        }

        int rollTotal = 0;

        for (int dieIndex = 0; dieIndex < numDice; dieIndex++) {
            rollTotal += die.roll();
        }

        currentTotal += rollTotal;

        return rollTotal;
    }

    public int getCurrentTotal() {
        return currentTotal;
    }

    public int getScore() {
        int score;

        if (getCurrentTotal() > MAX_TOTAL) {
            score = 0;
        }
        else if (getCurrentTotal() == MAX_TOTAL) {
            score = 2 * MAX_TOTAL;
        }
        else {
            score = MAX_TOTAL - getCurrentTotal();
        }

        return score;
    }
}
