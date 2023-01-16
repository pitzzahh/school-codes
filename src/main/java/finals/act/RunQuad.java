package finals.act;

import java.util.Scanner;

public class RunQuad {

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter :1: for Part 1 or :2: for Part 2 -->: ");
            String choice = input.nextLine();
            if (choice.equals("1")) {
                System.out.print("Press : R : for Rectangle or : S : for Square -->: ");
                String shape = input.nextLine().trim();
                switch (shape) {
                    case "R":
                        System.out.println("A Rectangle:");
                        new Rectangle().showDescription();
                        break;
                    case "S":
                        System.out.println("A Square:");
                        new Square().showDescription();
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            } else if (choice.equals("2")) {
                System.out.println("Select From the Following:");
                System.out.println("R - Rectangle");
                System.out.println("S - Square");
                System.out.println("P - Parallelogram");
                System.out.println("H - Rhombus");
                System.out.println("T - Trapezoid");
                System.out.print(">>: ");
                String shape = input.nextLine().trim();
                switch (shape) {
                    case "R":
                        System.out.println("A Rectangle:");
                        new Rectangle().showDescription();
                        break;
                    case "S":
                        System.out.println("A Square:");
                        new Square().showDescription();
                        break;
                    case "P":
                        System.out.println("A Parallelogram:");
                        new Parallelogram().showDescription();
                        break;
                    case "H":
                        System.out.println("A Rhombus:");
                        new Rhombus().showDescription();
                        break;
                    case "T":
                        System.out.println("A Trapezoid:");
                        new Trapezoid().showDescription();
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            }

        }
    }

    static class Quadrilateral {

        public void showDescription() {
            System.out.println("-is quadrilateral");
        }
    }

    static class Rectangle extends Quadrilateral {
        @Override
        public void showDescription() {
            System.out.println("-has 4 right angles");
            super.showDescription();
        }
    }

    static class Square extends Rectangle {

        @Override
        public void showDescription() {
            System.out.println("-has 4 equal sides");
            super.showDescription();
        }
    }

    static class Parallelogram extends Quadrilateral {

        @Override
        public void showDescription() {
            System.out.println("-has 2 pairs of parallel sides");
            super.showDescription();
        }
    }

    static class Rhombus extends Parallelogram {

        @Override
        public void showDescription() {
            System.out.println("-has 4 congruent sides");
            super.showDescription();
        }
    }

    static class Trapezoid extends Quadrilateral {

        @Override
        public void showDescription() {
            System.out.println("-has 1 pair of parallel sides");
            super.showDescription();
        }
    }
}

