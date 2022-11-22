package peopleInSchool;

import io.github.pitzzahh.util.utilities.validation.Validator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CollegeList {

    public static void main(String[] args) {

    }

    // TODO: continue
    private void askUser(Scanner scanner) {
        System.out.print("Press E for Employee, F for Faculty, S for Student, or Q to quit: ");
        String input = scanner.nextLine();
        if (input.trim().equalsIgnoreCase("E")) {
            employee(scanner);
        }

    }

    /**
     * Employee input
     * @param scanner the scanner object.
     */
    private void employee(Scanner scanner) {
        System.out.print("Enter employee name          : ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter employee contact number: ");
        String contactNumber = scanner.nextLine().trim();
        System.out.print("Enter employee salary        : ");
        String salary = scanner.nextLine().trim();
        System.out.print("Enter employee department    : ");
        String department = scanner.nextLine().trim();

//        Employee employee = new Employee();
//
//        employee.setName(name);
//        employee.setContactNumber(contactNumber);
//
//        Pattern pattern = Pattern.compile("^(\\d+\\.\\d+|\\.\\d+|0\\.\\d+)$");
//        boolean isDouble = pattern.matcher(salary).matches();
//
//        if (isDouble) employee.setSalary(Double.parseDouble(salary));

    }
}
