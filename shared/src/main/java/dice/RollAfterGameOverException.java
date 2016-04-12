package dice;

public class RollAfterGameOverException extends Exception {
    public RollAfterGameOverException() {
        super("Roll after game ended");
    }
}
