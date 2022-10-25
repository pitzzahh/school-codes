package threads;

import static io.github.pitzzahh.util.utilities.Print.println;

public class App {
    public static void main(String[] args) {
        // print I love you 1000 times using functional composition
        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) {
                println("I love you");
            }
        };
        r.run();

    }
}
