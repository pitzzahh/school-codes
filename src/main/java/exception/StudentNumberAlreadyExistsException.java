package exception;

/**
 * class used for exception handling if the user already exists.
 * This class extends the {@code RuntimeException}
 */
public class StudentNumberAlreadyExistsException extends RuntimeException {
    public StudentNumberAlreadyExistsException(String userName) {
        super(String.format("%s already exists", userName));
    }
}