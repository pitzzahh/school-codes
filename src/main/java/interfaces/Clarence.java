package interfaces;

public class Clarence implements Person {

    /**
     * Name of a person.
     *
     * @return the name of the person.
     */
    @Override
    public String name() {
        return "Clarence Vega";
    }

    /**
     * Age of the person.
     *
     * @return the age of the person.
     */
    @Override
    public int age() {
        return 20;
    }

}
