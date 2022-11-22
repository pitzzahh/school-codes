package misha;

import java.util.Comparator;
import java.util.PriorityQueue;

public class hatdog {

    static Comparator<String> comp;

    public static void main(String[] args) {
        PriorityQueue<String> prio = new PriorityQueue<>(comp);
        prio.add("cat");
        prio.add("c");
        prio.add("cats");

        while(!prio.isEmpty()){
            System.out.println(prio.remove());
        }

    }

    public hatdog() {
        comp = Comparator.comparing(String::length).reversed();
    }
}
