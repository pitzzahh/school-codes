package enumerations;

public class Car {
    private final int year;
    private final Model model;
    private final Color color;

    public Car(int year, Model model, Color color) {
        this.year = year;
        this.model = model;
        this.color = color;
    }
    public void display() {
        System.out.println("YEAR : " + this.year  + "\n" +
                           "MODEL: " + this.model + "\n" +
                           "COLOR: " + this.color + "\n");
    }
}
