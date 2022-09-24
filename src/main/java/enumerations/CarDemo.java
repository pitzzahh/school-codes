package enumerations;

public class CarDemo {
    public static void main(String[] args) {
        Car car1 = new Car(1998, Model.SUV, Color.BLUE);
        Car car2 = new Car(2002, Model.HATCHBACK, Color.PINK);
        Car car3 = new Car(2014, Model.CONVERTIBLE, Color.RED);

        car1.display();
        car2.display();
        car3.display();
    }
}
