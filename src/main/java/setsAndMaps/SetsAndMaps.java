package setsAndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class SetsAndMaps {
    public static void main(String[] args) {
        System.out.println("SET");
        set();
        System.out.println("MAP");
        map();
    }

    /**
     * Set
     */
    private static void set() {

        Set<String> a = new HashSet<>();
        Set<String> b = new HashSet<>();

        // add names to set a using collections.addAll
        Collections.addAll(a, "Mark", "Nika", "Mario", "Kae");
        // add names to set b using collections.addAll
        Collections.addAll(b, "John", "Marco", "Mark");

        Set<String> union = new HashSet<>(a);
        Set<String> intersection = new HashSet<>(a);
        Set<String> difference = new HashSet<>(a);

        union.addAll(b);
        intersection.retainAll(b);
        difference.removeAll(b);

        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
        System.out.println("Difference: " + difference);
    }

    /**
     * Map
     */
    private static void map() {

        Map<String, Person> people = new HashMap<>();

        people.put("M1", new Person("Mark 1", 0));
        people.put("M2", new Person("Mark 2", 21));
        people.put("M3", new Person("Mark 3", 21));

    }
}
record Person(String name, int age) {
    public Person {
        if (age <= 0) throw new IllegalArgumentException("Age cannot be negative");
    }
}
