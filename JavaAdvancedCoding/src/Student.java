import java.time.LocalDate;

public class Student extends Person {
    private boolean hasPreviousJavaKnowledge;

    public String getLastName(){
        return super.getLastName();
    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, boolean hasPreviousJavaKnowledge) {
        super(firstName, lastName, dateOfBirth);
        this.hasPreviousJavaKnowledge = hasPreviousJavaKnowledge;

    }

    @Override
    public String toString() {
        return super.toString() + ", hasPreviousJavaKnowledge " + hasPreviousJavaKnowledge + "}";

    }
}
