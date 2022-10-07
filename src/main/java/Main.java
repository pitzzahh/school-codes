import list.DynamicArray;

import static java.util.stream.IntStream.rangeClosed;

public class Main {

    public static void main(String[] args) {
        DynamicArray<Integer> list = new DynamicArray<>();

        rangeClosed(1, 15).forEach(list::insert);

        System.out.println(list);
    }

}
