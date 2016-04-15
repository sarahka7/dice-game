package dice;

public class InvalidUsernameException extends Exception {
    public InvalidUsernameException() {
        super("Invalid username");
    }
}
