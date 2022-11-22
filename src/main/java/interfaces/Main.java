package interfaces;

import static io.github.pitzzahh.util.utilities.Print.*;

public class Main {

    public static void main(String[] args) {

        Person person = new Clarence();

        println(person.name());
        println(person.age());

    }

}
