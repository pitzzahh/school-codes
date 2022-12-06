package sample;

interface Carnivore {
    int pieces = 10;

    void eatGrass();

    static int chew() {
        return 13;
    }
}
interface HasWings {
    int getNumberOfWings();
}

abstract class Insect implements HasWings {
    public abstract int getNumberOfLegs();
}

public class DragonFly extends Insect {

    @Override
    public int getNumberOfLegs() {
        return 6;
    }

    @Override
    public int getNumberOfWings() {
        return 4;
    }
}

