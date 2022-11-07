package peopleInSchool;

public class Faculty extends Employee {

    private boolean status;

    public void setStatus(boolean status) {
        this.status = status;
    }

    // TODO: find a way to know if the faculty is full-time (regular) or part-time
    public boolean isRegular() {
        return status;
    }
}
