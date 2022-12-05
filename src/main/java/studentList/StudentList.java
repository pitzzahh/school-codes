package studentList;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class StudentList {
    public static void main(String[] args) {
        Map<String, String> students = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String lastId = addStudent(scanner, students, 3);
        students.forEach((key, value) -> System.out.println(key + " " + value)); // print each student per line

        students.remove(lastId);
        addStudent(scanner, students, 1);

        students.forEach((key, value) -> System.out.println(key + " " + value)); // print each student per line
        statements();
    }

    private static String addStudent(Scanner sc, Map<String, String> students, int repeat) {
        String lastStudent;
        do {
            System.out.print("Enter student number: ");
            String name = sc.nextLine();
            System.out.print("Enter first name: ");
            String id = sc.nextLine();
            students.put(name, id);
            repeat--;
            lastStudent = name;
        } while (repeat != 0);
        return lastStudent;
    }

    private static void statements() {
        Map<String, String> programs = new HashMap<>();
        programs.put("BSIT", "Bachelor of Science in Information Technology");
        programs.put("BSCS", "Bachelor of Science in Computer Science");
        programs.put("BSIS", "Bachelor of Science in Information System");
        programs.keySet().forEach(System.out::print);
        programs.remove("BSIT");
        System.out.printf("%n%s", programs.containsKey("BSCpE"));
    }

}
