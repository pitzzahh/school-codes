package birthMonth;

import java.util.stream.Collectors;
import java.util.*;

public class BirthMonth {

    private static final int MAX_SIZE = 3;
    private static final ArrayList<String> input = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> group1 = new HashSet<>();
        Set<String> group2 = new HashSet<>();
        Set<String> self = new HashSet<>();

        askBirthMonth(scanner, input);
        Collections.addAll(group1, input.toArray(new String[MAX_SIZE]));

        input.clear();

        askBirthMonth(scanner, input);
        Collections.addAll(group2, input.toArray(new String[MAX_SIZE]));

        printSet(group1, 1);
        printSet(group2, 2);

        System.out.print("Enter your birth month: ");
        self.add(scanner.nextLine().trim());

        printMore(group1, group2, self);

    }

    /**
     * Ask user to enter birth month recursively.
     * @param scanner Scanner
     * @param arrayList ArrayList
     */
    private static void askBirthMonth(Scanner scanner, ArrayList<String> arrayList) {
        if (input.size() != MAX_SIZE) {
            System.out.printf("Enter birth month %d: ", arrayList.size() + 1);
            input.add(scanner.nextLine().trim());
            askBirthMonth(scanner, arrayList);
        }
    }

    /**
     * Prints the content of the set.
     * @param set the set to be printed.
     * @param groupNumber the group number.
     */
    private static void printSet(Set<String> set, int groupNumber) {
        String str = set.stream()
                .map(e -> "'" + e + "'")
                .collect(Collectors.joining(", ", "{", "}"));
        System.out.printf("Group %d: %s%n", groupNumber, str);
    }

    /**
     * Prints the union of the two sets, intersection of the two sets,
     * and the difference of the two sets.
     * @param group1 the first set
     * @param group2 the second set
     * @param self the set containing the user's birth month
     */
    private static void printMore(Set<String> group1, Set<String> group2, Set<String> self) {

        HashSet<String> union = new HashSet<>(group1);
        HashSet<String> difference = new HashSet<>(group1);
        HashSet<String> intersection = new HashSet<>(group1);

        union.addAll(group2);
        union.addAll(self);

        intersection.retainAll(group2);
        difference.removeAll(group2);

        String unionString = union.stream()
                .map(e -> "'" + e + "'")
                .collect(Collectors.joining(", ", "{", "}"));

        String intersectionString = intersection.stream()
                .map(e -> "'" + e + "'")
                .collect(Collectors.joining(", ", "{", "}"));

        String differenceString = difference.stream()
                .map(e -> "'" + e + "'")
                .collect(Collectors.joining(", ", "{", "}"));

        System.out.printf("Union: %s%n", unionString);
        System.out.printf("Intersection: %s%n", intersectionString);
        System.out.printf("Difference: %s%n", differenceString);

        if (union.containsAll(self)) {
            System.out.println("You have the same birth month with one of your classmates.");
        } else {
            System.out.println("You don't have the same birth month as your classmates.");
        }
    }

}
