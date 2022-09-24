import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import regularExpressions.database.DatabaseConnection;
import regularExpressions.Validation;

public class ValidatorTest {

    @Test
    void shouldPassIfStudentNumberIsValid() {
        // given
        String studentNumber = "1234-12-123";
        // when
        boolean result = Validation.isStudentNumberValid.test(studentNumber);
        // then
        Assertions.assertTrue(result);
    }

    @Test
    void shouldPassIfStudentNumberIsInValid() {
        // given
        String studentNumber = "123-12-1234";
        // when
        boolean result = Validation.isStudentNumberValid.test(studentNumber);
        // then
        Assertions.assertFalse(result);
    }

    @Test
    void shouldPassIfStudentNumberIsInValidAndWithNoDash() {
        // given
        String studentNumber = "123456789";
        // when
        boolean result = Validation.isStudentNumberValid.test(studentNumber);
        // then
        Assertions.assertFalse(result);
    }

    @Test
    void shouldPassIfStudentNumberIsInValidAndWithOnlyOneDash() {
        // given
        String studentNumber = "1234-56789";
        // when
        boolean result = Validation.isStudentNumberValid.test(studentNumber);
        // then
        Assertions.assertFalse(result);
    }

    @Test
    void shouldPassIfPasswordOnlyContainsAnyAlphaNumericalCharacters() {
        // given
        String password = "pitzzahh@123";
        // when
        boolean result = Validation.isPasswordValid.test(password);
        // then
        Assertions.assertTrue(result);
    }

    @Test
    void shouldPassIfPasswordContainsAnyBothNonAndAlphaNumericalCharacters() {
        // given
        String password = "pitzzahh@123!";
        // when
        boolean result = Validation.isPasswordValid.test(password);
        // then
        Assertions.assertFalse(result);
    }

    @Test
    void shouldPassIfStudentNumberAlreadyExists() {
        // given
        String studentNumber = "2002-63-444";
        DatabaseConnection.CREATE_TABLE_STATEMENT = "CREATE TABLE IF NOT EXISTS student_info (student_number VARCHAR(11) NOT NULL PRIMARY KEY, password VARCHAR(20) NOT NULL);";
        DatabaseConnection databaseConnection = new DatabaseConnection();
        // when
        boolean result = Validation.isStudentNumberAlreadyExists.test(studentNumber, databaseConnection);
        // then
        Assertions.assertTrue(result);
    }
}






