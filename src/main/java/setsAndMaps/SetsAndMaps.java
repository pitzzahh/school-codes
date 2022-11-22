package setsAndMaps;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetsAndMaps {
    public static void main(String[] args) {
        System.out.println("SET");
        set();
        System.out.println("MAP");
        map();
    }

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

    private static void map() {

    }
}
