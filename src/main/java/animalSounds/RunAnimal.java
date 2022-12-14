package animalSounds;

import java.util.Scanner;
import java.util.Set;

public class RunAnimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> inputs = Set.of("B", "b", "C", "c", "D", "d");
        String input;
        do {
            System.out.print("Choose an animal. Press B for Bird, C for Cat or D for Dog: ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("B")) System.out.println(new Bird());
            else if (input.equalsIgnoreCase("C")) System.out.println(new Cat());
            else if (input.equalsIgnoreCase("D")) System.out.println(new Dog());
            else System.out.println("Invalid input\nThe Program will terminate");
            System.out.println();
        } while (inputs.contains(input));
    }
}

abstract class Animal {

    public abstract String eat();
    public abstract String sleep();
    public abstract String makeSound();

    @Override
    public String toString() {
        return eat().concat(" and ").concat(sleep()).concat("\n").concat(makeSound());
    }

}
class Bird extends Animal {

    @Override
    public String eat() {
        return "Birds love to eat seeds";
    }

    @Override
    public String sleep() {
        return "sleep for 10-12 hours a day";
    }

    @Override
    public String makeSound() {
        return "Tweet Tweet";
    }

}
class Cat extends Animal {

    @Override
    public String eat() {
        return "Cats love to eat fish";
    }

    @Override
    public String sleep() {
        return "cat naps average 78 minutes in length";
    }

    @Override
    public String makeSound() {
        return "Meow Meow";
    }
}
class Dog extends Animal {

    @Override
    public String eat() {
        return "Dogs love to eat meat";
    }

    @Override
    public String sleep() {
        return "sleep for 12-14 hours a day";
    }

    @Override
    public String makeSound() {
        return "Bark Bark";
    }

}
