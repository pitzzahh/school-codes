package peopleInSchool;

import static peopleInSchool.CollegeList.PESO_SIGN;
import java.util.Currency;
import java.util.Scanner;

/**
 * @author Peter John Arao
 */
public class CollegeList {

    public static final String PESO_SIGN = Currency.getInstance("PHP").getSymbol();

    public static void main(String[] args) {
        start(new Scanner(System.in));
    }

    // TODO: continue
    private static void start(Scanner scanner) {
        System.out.print("Press E for Employee, F for Faculty, S for Student, or Q to quit: ");
        String input = scanner.nextLine();
        if (input.trim().equalsIgnoreCase("Q")) System.out.println("Invalid input.");
        else if ("E".equalsIgnoreCase(input.trim())) employee(scanner, createPerson(scanner));
        else if ("F".equalsIgnoreCase(input.trim())) faculty(scanner, createPerson(scanner));
        else if ("S".equalsIgnoreCase(input.trim())) student(scanner, createPerson(scanner));
        else if ("Q".equalsIgnoreCase(input.trim())) System.exit(0);
    }

    /**
     * Invoked when the user wants to create an employee.
     * @param scanner the scanner to use.
     * @param person the person to use.
     */
    private static void employee(Scanner scanner, Person person) {
        Employee employee = new Employee();
        System.out.print("Enter monthly salary      : ");
        employee.setSalary(scanner.nextDouble());
        System.out.print("Enter employee department : ");
        employee.setDepartment(scanner.nextLine());
        printInfo(employee);
        start(scanner);
    }

    /**
     * Invoked when the user wants to create a faculty.
     * @param scanner the scanner to use.
     * @param person the person to use.
     */
    private static void faculty(Scanner scanner, Person person) {
        start(scanner);
    }

    /**
     * Invoked when the user wants to create a student.
     * @param scanner the scanner to use.
     * @param person the person to use.
     */
    private static void student(Scanner scanner, Person person) {
        start(scanner);
    }

    /**
     * Asked after the user has selected a person type.
     * @param scanner the scanner object.
     * @return the person object.
     * @see #start(Scanner)
     * @see #employee(Scanner, Person)
     * @see #faculty(Scanner, Person)
     * @see #student(Scanner, Person)
     * @see Person
     */
    private static Person createPerson(Scanner scanner) {
        System.out.print("Enter name         : ");
        String name = scanner.nextLine();

        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();

        Person person = new Person();
        person.setName(name);
        person.setContactNumber(contactNumber);

        return person;
    }

    private static <T extends Person> void printInfo(T person) {
        System.out.println(person);
    }
}

/**
 * Person class (parent)
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
        return "NAME          : " + getName()          + "\n" +
               "CONTACT NUMBER: " + getContactNumber() + "\n";
    }
}

/**
 * Student class (child of Person class)
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
        return super.toString() + "\n" +
               "PROGRAM       : " + getProgram()      + "\n" +
               "YEAR LEVEL    : " + getYearLevel()    + "\n";
    }
}

/**
 * Employee Class (child of Person class)
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
        return super.toString() + "\n" +
               "SALARY        : " + PESO_SIGN + getSalary()       + "\n" +
               "DEPARTMENT    : " + getDepartment()   + "\n";
    }
}

/**
 * Faculty Class (child of Employee class)
 * @see Employee
 */
class Faculty extends Employee {

    private boolean status;

    public void setStatus(boolean status) {
        this.status = status;
    }

    // TODO: find a way to know if the faculty is full-time (regular) or part-time
    public boolean isRegular() {
        return status;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "STATUS        : " + isRegular()       + "\n";
    }

}

