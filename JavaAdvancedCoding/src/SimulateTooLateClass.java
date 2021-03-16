import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class SimulateTooLateClass {
    private static Set<Student> students1;
    private static List<Trainer> trainers;
    private static List<Group> groups;
    private static Set<Student> studentsRo16, studentsRo17, studentsRo18, studentsRo19;
    private static Trainer trainer1, trainer2, trainer3;

    public static void main(String[] args) {
//        System.out.println("First name is: " + student1.getFirstName() + " " + "Last name is : " + student1.getLastName() + " " + "Birthdate is: " + student1.getDateOfBirth() + " " +
//                " " + "And the java knowledge is " + student1.isHasPreviousJavaKnowledge());
        createClass();
        printStudents();
        printTrainers();
        printGroups();
        printStudentsAlphabetically();
        showMaxNumberOfStudentsFromGroup_classicMethod();

    }

    private static void printGroups() {
        System.out.println(groups);
    }

    private static void printTrainers() {
        System.out.println(trainers);
    }

    private static void printStudents() {
        System.out.println(students1);
    }

    private static void showMaxNumberOfStudentsFromGroup_classicMethod() {
        Group aux = new Group(null, new LinkedHashSet<>());
        for (Group group : groups) {
            if (group.getStudents().size() > aux.getStudents().size()) {
                aux = group;
            }
        }
        System.out.println(aux);
    }

    private static void showMaxNumberOfStudentsFromGroup_functionalMethod() {

    }
    private static void printAllMaxNumberOfStudentsFromGroup_functionalMethod() {
        List<Group> groupList = new ArrayList<>();
        Group maxSizeGroup = new Group(null, new LinkedHashSet<>());
        for (Group group : groups) {
            if (group.getStudents().size() > maxSizeGroup.getStudents().size()) {
                maxSizeGroup = group;
                groupList = new ArrayList<>();
                groupList.add(group);
            }else if(group.getStudents().size() == maxSizeGroup.getStudents().size()){

        }
        System.out.println("Max group size is:" + maxSizeGroup);
    }
    }


    private static void printStudentsAlphabetically() {
        students1.stream()
                .sorted(Comparator.comparing(student -> student.getLastName()))
//              .forEach(student -> System.out.println(student));
                .forEach(System.out::println);
    }

    private static void createClass() {
        addStudents();
        addTrainers();
        addGroups();
    }

    private static void addGroups() {
        //GROUPS
        Group JavaRo16 = new Group(trainer1, studentsRo16);
        Group JavaRo17 = new Group(trainer2, studentsRo17);
        Group JavaRo18 = new Group(trainer3, studentsRo18);
        Group JavaRo19 = new Group(null, studentsRo19);

        groups = Arrays.asList(JavaRo16, JavaRo17, JavaRo18, JavaRo19);
    }

    private static void addTrainers() {
        //TRAINERS
        trainer1 = new Trainer("abc", "efsd", LocalDate.of(1998, Month.OCTOBER, 12), false);
        trainer2 = new Trainer("abc", "efsd", LocalDate.of(1998, Month.OCTOBER, 12), false);
        trainer3 = new Trainer("abc", "efsd", LocalDate.of(1998, Month.OCTOBER, 12), false);
        trainers = Arrays.asList(trainer1, trainer2, trainer3);
    }

    private static void addStudents() {
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
        students1 = new LinkedHashSet<>();
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


        studentsRo16 = new LinkedHashSet<>();
        studentsRo16.add(student1);
        studentsRo16.add(student2);
        studentsRo16.add(student3);


        studentsRo17 = new LinkedHashSet<>();
        studentsRo17.add(student4);
        studentsRo17.add(student5);

        studentsRo18 = new LinkedHashSet<>();
        studentsRo18.add(student6);
        studentsRo18.add(student7);
        studentsRo18.add(student8);

        studentsRo19 = new LinkedHashSet<>();
        studentsRo19.add(student9);
        studentsRo19.add(student10);
    }
}
