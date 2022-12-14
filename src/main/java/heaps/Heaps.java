package heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Heaps {
    public static void main(String[] args) {
        System.out.println("MIN HEAP");
        minHeap();
        System.out.println("MAX HEAP");
        maxHeap();
        System.out.println("PRIORITY QUEUE");
        priorityQueueFirst();
        System.out.println("PRIORITY QUEUE WITH CUSTOM ORDER");
        priorityQueueCustomOrder();
    }

    /**
     * Min Heap
     */
    private static void minHeap() {
        ArrayList<Integer> heap = new ArrayList<>();
        Collections.addAll(heap, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(heap.get(0));
    }

    /**
     * Max heap is a heap where the root node is the largest element in the heap.
     */
    private static void maxHeap() {
        ArrayList<Integer> heap = new ArrayList<>();
        Collections.addAll(heap, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        heap.sort(Comparator.reverseOrder());
        System.out.println(heap.get(0));
    }

    /**
     * Priority Queue
     */
    private static void priorityQueueFirst() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // add unordered numbers on each line
        priorityQueue.add(5);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(4);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove() + " ");
        }
    }

    /**
     * Priority Queue with custom order
     */
    private static void priorityQueueCustomOrder() {
        Comparator<String> comparator = Comparator
                .comparing(String::length)
                .reversed();

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(comparator);

        // add unordered numbers on each line
        priorityQueue.add("cat");
        priorityQueue.add("c");
        priorityQueue.add("cats");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove() + " ");
        }
    }
}
