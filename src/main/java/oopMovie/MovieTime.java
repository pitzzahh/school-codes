package oopMovie;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
import java.util.Set;

public class MovieTime {

    private static final int MAX_MOVIES = 3;
    private static final int MAX_SNACKS = 3;

    public static void main(String[] args) {
        Queue<String> movies = new LinkedList<>();
        Queue<String> snacks = new LinkedList<>();
        Scanner input = new Scanner(System.in);

        insertMovies(input, movies);
        insertSnacks(input, snacks);
        System.out.println("Movies to watch are : " + movies);
        System.out.println("Snacks available are: " + snacks);
        checkIsDone(input, snacks);
    }

    private static void insertMovies(Scanner input, Queue<String> movies) {
        while (movies.size() != MAX_MOVIES) {
            System.out.printf("Enter movie %d of %d: ", movies.size() + 1, MAX_MOVIES);
            movies.add(input.nextLine());
            insertMovies(input, movies);
        }
    }

    private static void insertSnacks(Scanner input, Queue<String> snacks) {
        while (snacks.size() != MAX_SNACKS) {
            System.out.printf("Enter snack %d of %d: ", snacks.size() + 1, MAX_SNACKS);
            snacks.add(input.nextLine());
            insertSnacks(input, snacks);
        }
    }
    // di man po ma'am AHHAHA ini na ang new chat
    // how does this work?

    // ewan ko po ma'am HAHAHA basta parang share screen pero di sya delay masyado like sa teams
    // pwede na rin mag video call or with audio
    // nice
    // di man maubos ang data mo? hahahhah
    // idk po AHHAHA
    // di man diit lang naga dl and ul
    // hahahaha baka maubos data mo
    // ano n
    private static void checkIsDone(Scanner scanner, Queue<String> snacks) {
        if (snacks.size() != 0) {
            System.out.print("Press S each time you finish a snack: ");
            String choice = scanner.nextLine().trim();
            Set<String> choices = Set.of("S", "s");
            if (choices.contains(choice)) {
                snacks.poll();
                if (snacks.size() != 0) System.out.println(snacks);
            }
            checkIsDone(scanner, snacks);
        } else System.out.println("NO MORE SNACKS");
    }
}
// anong oras na mag oosu kapa HAHHAHAHAHAH

// wala na nga HAHAHAH
// goodeve po ma'am
