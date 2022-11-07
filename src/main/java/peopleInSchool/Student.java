package peopleInSchool;

public class Student extends Person {

    private String program;
    private int yearLevel;

    public void setProgram(String program) {
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public int getYearLevel() {
        return yearLevel;
    }
}
