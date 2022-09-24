package exception;

/**
 * class used for exception handling on invalid username or password logins.
 * This class extends the {@code RuntimeException}
 */
public class InvalidStudentNumberOrPasswordException extends RuntimeException {
    public InvalidStudentNumberOrPasswordException(String message) {
        super(message);
    }
}