package peopleInSchool;

import java.util.regex.Pattern;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Set;

/**
 * Using Java Generics to shorten the code.
 * @author Peter John Arao
 */
public class CollegeList {

    public static final NumberFormat FORMAT = NumberFormat.getCurrencyInstance();

    public static void main(String[] args) {
        start(new Scanner(System.in));
    }

    private static void start(Scanner scanner) {
        System.out.print("Press E for peopleInSchool.Employee, F for peopleInSchool.Faculty, S for peopleInSchool.Student, or Q to quit: ");
        String input = scanner.nextLine();
        Set<String> choices = Set.of("E", "F", "S", "Q", "e", "f", "s", "q");
        if (!choices.contains(input.trim())) System.out.println("Invalid input.");
        else if ("E".equalsIgnoreCase(input.trim())) {
            Employee employee = employee(scanner);
            printInfo(employee);
        }
        else if ("F".equalsIgnoreCase(input.trim())) {
            Faculty faculty = faculty(scanner);
            printInfo(faculty);
        }
        else if ("S".equalsIgnoreCase(input.trim())) {
            Student student = student(scanner);
            printInfo(student);
        }
        if ("Q".equalsIgnoreCase(input.trim())) System.exit(0);
        else {
            start(scanner);
            System.out.println();
        }
    }

    /**
     * Invoked when the user wants to create an employee.
     * @param scanner the scanner to use.
     */
    private static Employee employee(Scanner scanner) {
        Employee employee = new Employee();
        createPerson(scanner, employee);
        String salary;

        do {
            System.out.print("Enter monthly salary      : ");
            salary = scanner.nextLine();
            boolean isNumber = Pattern.compile("\\d+|\\d+\\.\\d+").matcher(salary).matches();
            if (isNumber) break;
            else System.out.println("NOT A NUMBER!");
        } while (true);

        employee.setSalary(Double.parseDouble(salary));

        System.out.print("Enter employee department : ");
        employee.setDepartment(scanner.nextLine());

        return employee;
    }

    /**
     * Invoked when the user wants to create a faculty.
     * @param scanner the scanner to use.
     */
    private static Faculty faculty(Scanner scanner) {
        Faculty faculty = new Faculty();
        Employee employee = employee(scanner);
        faculty.setName(employee.getName());
        faculty.setContactNumber(employee.getContactNumber());
        faculty.setSalary(employee.getSalary());
        faculty.setDepartment(employee.getDepartment());
        do {
            System.out.print("Is faculty regular        : ");
            String isRegular = scanner.nextLine();
            Set<String> yes = Set.of("Y", "y");
            Set<String> no = Set.of("N", "n");
            if (yes.contains(isRegular)) {
                faculty.setStatus(true);
                break;
            }
            else if (no.contains(isRegular)) {
                faculty.setStatus(false);
                break;
            }
            else System.out.println("Invalid input.");
        } while (true);

        return faculty;
    }

    /**
     * Invoked when the user wants to create a student.
     * @param scanner the scanner to use.
     */
    private static Student student(Scanner scanner) {
        Student student = new Student();
        createPerson(scanner, student);

        System.out.print("Enter Program             : ");
        student.setProgram(scanner.nextLine());

        do {
            System.out.print("Enter year level          : ");
            String yearLevel = scanner.nextLine();
            boolean isNumber = Pattern.compile("^?(1)$|^(2)$|^(3)$|^(4)$").matcher(yearLevel).matches();
            if (isNumber) {
                student.setYearLevel(Integer.parseInt(yearLevel));
                break;
            }
            else System.out.println("NOT A NUMBER!");
        } while (true);

        return student;
    }

    /**
     * Asked after the user has selected a person type.
     * @param scanner the scanner object.
     * @see #start(Scanner)
     * @see #employee(Scanner)
     * @see #faculty(Scanner)
     * @see #student(Scanner)
     * @see Person
     */
    private static <T extends Person> void createPerson(Scanner scanner, T personType) {
        System.out.print("Enter name                : ");
        String name = scanner.nextLine();

        System.out.print("Enter contact number      : ");
        String contactNumber = scanner.nextLine();

        personType.setName(name);
        personType.setContactNumber(contactNumber);
    }

    /**
     * Prints the {@code toString()} method implementations of each class.
     * @param personType the type of person to print.
     * @param <T> the type of person.
     */
    private static <T extends Person> void printInfo(T personType) {
        System.out.println(personType);
    }
}

/**
 * peopleInSchool.Person class (parent)
 */
class Person {

    private String name;
    private String contactNumber;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public String toString() {
        return "\n" +"NAME          : " + getName()          + "\n" +
                     "CONTACT NUMBER: " + getContactNumber();
    }
}

/**
 * peopleInSchool.Student class (child of peopleInSchool.Person class)
 * @see Person
 */
class Student extends Person {

    private String program;
    private int yearLevel;

    public void setProgram(String program) {
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    @Override
    public String toString() {
        return super.toString()                                                    + "\n" +
               "PROGRAM       : " + getProgram()                                   + "\n" +
               "YEAR LEVEL    : " + getYearLevel() + getYearLevelString(yearLevel) + "\n";
    }

    private String getYearLevelString(int yearLevel) {
        return switch (yearLevel) {
            case 1 -> "st Year";
            case 2 -> "nd Year";
            case 3 -> "rd Year";
            case 4 -> "th Year";
            default -> "Invalid Year Level";
        };
    }
}

/**
 * peopleInSchool.Employee Class (child of peopleInSchool.Person class)
 * @see Person
 */
class Employee extends Person {

    private double salary;
    private String department;

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return super.toString()                                + "\n" +
               "SALARY        : " + CollegeList.FORMAT.format(getSalary()) + "\n" +
               "DEPARTMENT    : " + getDepartment();
    }
}

/**
 * peopleInSchool.Faculty Class (child of peopleInSchool.Employee class)
 * @see Employee
 */
class Faculty extends Employee {

    private boolean status;

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isRegular() {
        return status;
    }

    @Override
    public String toString() {
        return "\n" + super.toString()                + "\n" +
                     "STATUS        : " + isRegular() + "\n";
    }

}

