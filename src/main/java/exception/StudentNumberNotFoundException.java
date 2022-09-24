package exception;

/**
 * class used for exception handling if the user was not found.
 * This class extends the {@code RuntimeException}
 */
public class StudentNumberNotFoundException extends RuntimeException {
    public StudentNumberNotFoundException() {
        super("USER DOES NOT EXIST");
    }
    public StudentNumberNotFoundException(String message) {
        super(String.format("%s does not exist", message));
    }
}