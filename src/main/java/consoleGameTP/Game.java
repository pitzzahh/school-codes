package consoleGameTP;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        game.autoMode("Peter");
//        game.start(new Scanner(System.in));
    }

    private void start(Scanner scanner) throws InterruptedException {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();
        System.out.println("Hello " + name + "!");
        printLine(23);
        System.out.printf("%n%s%n", "|Select your game mode|");
        printLine(23);
        System.out.printf("%n%s%n", ": 1 : Auto mode");
        System.out.printf("%n%s%n", ": 2 : Survival mode");

        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                autoMode(name);
                break;
            case "2":
                survivalMode(scanner);
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    private void autoMode(String name) throws InterruptedException {
        printLine(12);
        System.out.printf("%n%s%n", "|Auto mode|");
        printLine(12);

        Player player = new Player();
        Player computer = new Player();
        SecureRandom random = new SecureRandom();

        player.setName(name);

        setRandomHealth(player, random);
        setRandomArmor(player, random);
        setRandomWeapon(player, random);

        computer.setName("Computer");

        setRandomHealth(computer, random);
        setRandomArmor(computer, random);
        setRandomWeapon(computer, random);

        do {
            attackRandom(player, computer, random);
            TimeUnit.MILLISECONDS.sleep(700);
        } while (!computer.isDefeated() && !player.isDefeated());

        checkWinning(player);

        checkWinning(computer);

    }

    private static void checkWinning(Player player) {
        if (player.isDefeated()) System.out.printf("%n%s lost!%n", player.name());
        else System.out.printf("%n%s won!%n", player.name());
    }

    private void survivalMode(Scanner scanner) {

    }

    private void setRandomHealth(Player player, SecureRandom random) {
        player.setHealth(random.nextInt(100) + 1);
    }

    private void setRandomArmor(Player player, SecureRandom random) {
        player.setArmor((random.nextInt(100) + 1) % 2 == 0 ? new GoldArmor() : new IronArmor());
    }

    private void setRandomWeapon(Player player, SecureRandom random) {
        player.setWeapon((random.nextInt(100) + 1) % 2 == 0 ? new Sword() : new Fist());
    }

    private void attackRandom(Player player, Player computer, SecureRandom random) {
        int randomNumber = random.nextInt(100) + 1;
        if (randomNumber % 2 == 0) {
            computer.defend(player.attack(computer.name()));
            setRandomHeal(player, random);
        }
        else {
            player.defend(computer.attack(player.name()));
            setRandomHeal(computer, random);
        }
    }

    private void setRandomHeal(Player player, SecureRandom random) {
        if (random.nextInt() % 2 == 0) {
            player.heal();
        }
    }
    private static void printLine(int count) {
        IntStream.range(0, count)
                .mapToObj(i -> "-")
                .forEach(System.out::print);

    }

}

interface IPlayer {

    default String name() {
        return "Player";
    }

    default int health() {
        return 100;
    }

    int attack(String enemyName);

    void defend(int damage);

    void heal();

    default boolean isDefeated() {
        return health() <= 0;
    }
}

interface IWeapon {

    String name();

    int damage();

}

interface IArmor {
    String name();

    int defense();
}

class Player implements IPlayer {

    private String name;
    private int health;
    private IArmor armor;
    private IWeapon weapon;

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setWeapon(IWeapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(IArmor armor) {
        this.armor = armor;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int health() {
        return health + Optional.ofNullable(armor).map(IArmor::defense).orElse(0);
    }

    @Override
    public int attack(String enemyName) {
        System.out.printf("%n%s attacks %s with %s%n", name(), enemyName, weapon.name());
        return weapon.damage();
    }

    @Override
    public void defend(int damage) {
        health -= damage;
        System.out.printf("%s defends %d damage%n", name, damage);
        printCurrentHealth();
    }

    private void printCurrentHealth() {
        System.out.printf("%s health is now %d%n", name(), health() <= 0 ? 0 : health());
    }

    @Override
    public void heal() {
        health += new SecureRandom().nextInt(10) + 1;
        System.out.printf("%s heal yourself!%n", name());
        printCurrentHealth();
    }

}

class Fist implements IWeapon {

    @Override
    public String name() {
        return "Fist";
    }

    @Override
    public int damage() {
        return 20;
    }

}

class Sword implements IWeapon {

    @Override
    public String name() {
        return "Sword";
    }

    @Override
    public int damage() {
        return 40;
    }

}

class IronArmor implements IArmor {

    @Override
    public String name() {
        return "Iron Armor";
    }

    @Override
    public int defense() {
        return 40;
    }
}

class GoldArmor implements IArmor {

    @Override
    public String name() {
        return "Gold Armor";
    }

    @Override
    public int defense() {
        return 80;
    }
}
