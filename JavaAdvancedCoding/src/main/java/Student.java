import java.time.LocalDate;

public class Student extends Person {
    private boolean hasPreviousJavaKnowledge;


    public Student(String firstName, String lastName, LocalDate dateOfBirth, boolean hasPreviousJavaKnowledge) {
        //Aici nu se poate pune ca parametru Person personStudent in loc de primii 3 parametrii,
        //pt.ca avem mostenirea de Person
        super(firstName, lastName, dateOfBirth);
        this.hasPreviousJavaKnowledge = hasPreviousJavaKnowledge;
    }

    public String getLastName(){
        return super.getLastName();
    }

    public String getFirstName(){
        return super.getFirstName();
    }

    public boolean isHasPreviousJavaKnowledge() {
        return hasPreviousJavaKnowledge;
    }

    public int getAge(){
        return LocalDate.now().getYear() - super.getDateOfBirth().getYear();
    }

    public LocalDate getDateOfBirth(){
        return super.getDateOfBirth();
    }

    public void setHasPreviousJavaKnowledge(boolean hasPreviousJavaKnowledge) {
        this.hasPreviousJavaKnowledge = hasPreviousJavaKnowledge;
    }

    @Override
    public String toString() {
        return "\n    Student: " + super.toString() + " - HasPreviousJavaKnowledge: " + hasPreviousJavaKnowledge;
    }
}