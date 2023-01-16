package finals.handOn;

public class Exam {
    private String message;
    private String period;
    private String level;
    private double price;
    private boolean status;

    public Exam() {
        this.message = "Good Luck";
    }

    public Exam(String period, String level) {
    }

    public double getPrice() {
        return price;
    }

    public boolean isFinished() {
        return status;
    }
        
}

class Midterm extends Exam {
    public Midterm() {
        super();
        System.out.println("Exam has started.");
    }
}

class Quiz extends Midterm {
    public Quiz() {
        System.out.println("Quiz has started.");
    }
}

class Essay extends Quiz {
    public Essay() {
        super();
        System.out.println("Essay has started.");
    }
}

