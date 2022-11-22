package abstractClasses;

public class Cat extends Pet {

    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }

    @Override
    public void speak() {
        System.out.println("meow");
    }

}
