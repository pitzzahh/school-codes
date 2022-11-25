package scratch;

import java.util.Comparator;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(4);
        queue.add(2);
        queue.add(1);
        queue.add(3);
        queue.add(5);
        queue.stream().sorted().forEach(System.out::println);
    }
}
