import list.DynamicArray;

import static io.github.pitzzahh.utilities.Print.println;

public class Main {

    public static void main(String[] args) {
        var list = new DynamicArray<Integer>();

        list.insert(1, 3, 2, -1, 25);
        println(list);

        list.sort(true);
        println(list);

    }

}
