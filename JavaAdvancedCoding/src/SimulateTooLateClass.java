import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class SimulateTooLateClass {
    private static Set<Student> students1;
    private static List<Trainer> trainers;
    private static List<Group> groups;

    public static void main(String[] args) {
//        System.out.println("First name is: " + student1.getFirstName() + " " + "Last name is : " + student1.getLastName() + " " + "Birthdate is: " + student1.getDateOfBirth() + " " +
//                " " + "And the java knowledge is " + student1.isHasPreviousJavaKnowledge());
        createClass();
        printStudents();
        printTrainers();


    }

    private static void printTrainers() {


    }

    private static void printStudents() {

    }

    private static void createClass() {
        //STUDENTS
        Student student1 = new Student("Olteanu", "Alexandru", LocalDate.of(1998, Month.OCTOBER, 12), false);
        Student student2 = new Student("abc", "efsd", LocalDate.of(1998, Month.OCTOBER, 12), false);
        Student student3 = new Student("Oasdsad", "asdas", LocalDate.of(1998, Month.OCTOBER, 12), false);
        Student student4 = new Student("asdasd", "Alexandru", LocalDate.of(1998, Month.OCTOBER, 12), false);
        Student student5 = new Student("zxcazxca", "Alexandru", LocalDate.of(1998, Month.OCTOBER, 12), false);
        Student student6 = new Student("gergrew", "Alexandru", LocalDate.of(1998, Month.OCTOBER, 12), false);
        Student student7 = new Student("cggsf", "Alexandru", LocalDate.of(1998, Month.OCTOBER, 12), false);
        Student student8 = new Student("xcvsfqe", "Alexandru", LocalDate.of(1998, Month.OCTOBER, 12), false);
        Student student9 = new Student("sadzcxv", "Alexandru", LocalDate.of(1998, Month.OCTOBER, 12), false);
        Student student10 = new Student("fjasdhkj", "Alexandru", LocalDate.of(1998, Month.OCTOBER, 12), false);
        students1 = new HashSet<Student>();
        students1.add(student1);
        students1.add(student2);
        students1.add(student3);
        students1.add(student4);
        students1.add(student5);
        students1.add(student6);
        students1.add(student7);
        students1.add(student8);
        students1.add(student9);
        students1.add(student10);


        Set<Student> studentsRo16 = new HashSet<Student>();
        studentsRo16.add(student1);
        studentsRo16.add(student2);
        studentsRo16.add(student3);


        Set<Student> studentsRo17 = new HashSet<Student>();
        studentsRo17.add(student4);
        studentsRo17.add(student5);

        Set<Student> studentsRo18 = new HashSet<Student>();
        studentsRo18.add(student6);
        studentsRo18.add(student7);
        studentsRo18.add(student8);

        Set<Student> studentsRo19 = new HashSet<Student>();
        studentsRo19.add(student9);
        studentsRo19.add(student10);

        Set<Student> distinct1 = new HashSet<Student>();
        for (Student student : students1) {
            distinct1.add(student);
        }
        distinct1.add(student1);

        //TRAINERS
        Trainer trainer1 = new Trainer("abc", "efsd", LocalDate.of(1998, Month.OCTOBER, 12), false);
        Trainer trainer2 = new Trainer("abc", "efsd", LocalDate.of(1998, Month.OCTOBER, 12), false);
        Trainer trainer3 = new Trainer("abc", "efsd", LocalDate.of(1998, Month.OCTOBER, 12), false);
        trainers = new ArrayList<>(trainer1, trainer2, trainer3);

        //GROUPS
        Group JavaRo16 = new Group(trainer1, studentsRo16);
        Group JavaRo17 = new Group(trainer2, studentsRo17);
        Group JavaRo18 = new Group(trainer3, studentsRo18);
        Group JavaRo19 = new Group(null, studentsRo19);
        JavaRo19.setTrainer(trainer3);

        groups = Arrays.asList(JavaRo16, JavaRo17, JavaRo18, JavaRo19);
        System.out.println(JavaRo16);
        System.out.println(JavaRo17);
        System.out.println(JavaRo18);
        System.out.println(JavaRo19);


    }
}
