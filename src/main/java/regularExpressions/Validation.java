package regularExpressions;

import exception.StudentNumberAlreadyExistsException;
import exception.StudentNumberNotFoundException;
import regularExpressions.database.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import static regularExpressions.database.DatabaseConnection.TABLE_NAME;

public class Validation {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        String student_number;
        String password;
        System.out.println("""
                ██╗   ██╗ █████╗ ██╗     ██╗██████╗  █████╗ ████████╗██╗ ██████╗ ███╗   ██╗
                ██║   ██║██╔══██╗██║     ██║██╔══██╗██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║
                ██║   ██║███████║██║     ██║██║  ██║███████║   ██║   ██║██║   ██║██╔██╗ ██║
                ╚██╗ ██╔╝██╔══██║██║     ██║██║  ██║██╔══██║   ██║   ██║██║   ██║██║╚██╗██║
                 ╚████╔╝ ██║  ██║███████╗██║██████╔╝██║  ██║   ██║   ██║╚██████╔╝██║ ╚████║
                  ╚═══╝  ╚═╝  ╚═╝╚══════╝╚═╝╚═════╝ ╚═╝  ╚═╝   ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝ \s
                """);
        System.out.print("Enter your student number: ");
        student_number = scanner.nextLine();
        if (isStudentNumberValid.test(student_number)) {
            System.out.println("Valid Student Number");
            System.out.print("Enter your password: ");
            password = scanner.nextLine();
            if (isPasswordValid.test(password)) {
                DatabaseConnection.CREATE_TABLE_STATEMENT = "CREATE TABLE IF NOT EXISTS student_info (student_number VARCHAR(11) NOT NULL PRIMARY KEY, password VARCHAR(20) NOT NULL);";
                DatabaseConnection databaseConnection = new DatabaseConnection();
                try {
                    insertValues(student_number, password, databaseConnection);
                } catch (RuntimeException runtimeException) {
                    System.out.println(runtimeException.getMessage());
                }
            } else System.out.println("Invalid Password");
        }
        else System.out.println("Invalid Student Number");
    }
    /**
     * Function that validates the given student number.
     * <blockquote>
     *     Valid student number should have
     *     <pre>
     *      Four (4) digits
     *      A dash
     *      Two (2) digits
     *      A dash
     *      Three (3) digits
     *
     *      Example: 1234-12-123
     * </pre>
     * What to test: studentNumber the student number.
     * </blockquote>
     * Returns {@code true} if the student number is valid.
     */
    public static final Predicate<String> isStudentNumberValid = studentNumber -> studentNumber.matches("\\d{4}-\\d{2}-\\d{3}");

    /**
     * Function that validates if the password is valid.
     */
    public static final Predicate<String> isPasswordValid = password -> !Pattern.compile("[^a-z\\d^*&@]", Pattern.CASE_INSENSITIVE).matcher(password).find();

    /**
     * Function that validates if the student already exists in the table.
     */
    public static final BiPredicate<String, DatabaseConnection> isStudentNumberAlreadyExists = (studentNumber, databaseConnection) -> getStudentNumber(studentNumber, databaseConnection).equals(studentNumber);

    /**
     * Function that returns a query based on the given parameter table.
     */
    private static final BiFunction<String, String, String> getStudentNumberQuery = (tableName, studentNumber) -> "SELECT * FROM " + tableName + " WHERE student_number = " + '\'' +  studentNumber + '\'';

    /**
     * Function that returns a query based on the given parameter table.
     */
    private static final BiFunction<String, String, String> getPasswordQuery = (tableName, studentNumber) -> "SELECT password FROM " + tableName + " WHERE student_number = " + '\'' +  studentNumber + '\'';

    /**
     * Method that gets the student number from the table.
     * @param studentNumber the student number to check if exists in the database
     * @param databaseConnection database connection object.
     * @return the studentNumber.
     */
    private static String getStudentNumber(String studentNumber, DatabaseConnection databaseConnection) {
        try {
            ResultSet resultSet = databaseConnection.connect().createStatement().executeQuery(getStudentNumberQuery.apply(TABLE_NAME, studentNumber));
            if (resultSet.next()) return resultSet.getString("student_number");
        } catch (SQLException sqlException) {
            throw new StudentNumberNotFoundException("Student Number: " + studentNumber);
        }
        return "0";
    }

    /**
     * Method that inserts values into the table.
     * @param student_number the student_number of a user to be inserted in the student_number column in the table.
     * @param password the password of a user to be inserted in the password column in the table.
     */
    private static void insertValues(String student_number, String password, DatabaseConnection databaseConnection)  {
        final String INSERT_STATEMENT = "INSERT INTO " + TABLE_NAME + " (student_number, password) VALUES (?, ?);";
        try {
            PreparedStatement preparedStatement = databaseConnection.connect().prepareStatement(INSERT_STATEMENT);
            preparedStatement.setString(1, student_number);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            if (getStudentNumber(student_number, databaseConnection).equals(student_number)) throw new StudentNumberAlreadyExistsException("Student Number: " + student_number);
            System.out.println(sqlException.getMessage());
        } catch (NullPointerException nullPointerException) {
            System.out.println(nullPointerException.getMessage());
        }
    }
}
