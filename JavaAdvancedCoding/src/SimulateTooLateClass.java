import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;

public class SimulateTooLateClass {
    private static Set<Student> students;
    private static List<Trainer> trainers;
    private static List<Group> groups;
    private static Set<Student> studentsRo16, studentsRo17, studentsRo18, studentsRo19;
    private static Trainer trainer1, trainer2, trainer3;

    public static void main(String[] args) {
        createClassHierarchy();

        printStudents();
        printTrainers();
        printGroups();

        printStudentsAlphabetically();
        printStudentsAlphabeticallyByFirstName();

        displayGroupWithMaxNumOfStudent_ClassicMethod();
        System.out.println("Grupele cu maxim numar de studenti: ");
        for (Group element : getAllGroupsWithMaxNumOfStudent_ClassicMethod()) {
            System.out.println(" " + element.getNameOfGroup());
        }


        displayGroupWithMaxNumOfStudent_FunctionalMethod();
        displayGroupWithMinNumOfStudent_FunctionalMethod();

        //-----------------------------------

        studentsYoungerThan(25);
        displayStudentsYoungerThan(25);

        //-----------------------------------

        studentsGroupedByTrainer_WithGroups();

        studentsGroupedByTrainer_WithMAp(); //Functioneaza daca nu fac modificari in grupuri

        //-----------------------------------

        displayStudentsWithPreviousJavaKnowledge();

        dispGroupWithMaxNumOfStudentsWithNOJavaKnowledge();

        dispGroupWithMaxNumOfStudentsWithNOJavaKnowledge2();

        dispGroupWithMaxNumOfStudentsWithNOJavaKnowledge3();

        dispGroupWithMaxNumOfStudentsWithNOJavaKnowledge4();

//        removeStudentsYoungerThanFromGroups(25);
//
//        printStudentsAlphabeticallyByFirstName();
        System.out.println("Triplul  " + tripleNumberOfStudentsFromMaxGroup(getAllGroupsWithMaxNumOfStudent_ClassicMethod()));
    }

    private static void printStudents() {
        System.out.println("\n-----------------------------------");
        System.out.print("Lista de studenti: ");
        System.out.println(students);
    }

    private static void printTrainers() {
        System.out.println("\n-----------------------------------");
        System.out.print("Lista de trainers: ");
        System.out.println(trainers);
    }

    private static void printGroups() {
        System.out.println("\n-----------------------------------");
        System.out.print("Lista de grupe: ");
        System.out.println(groups);
    }

    private static void printStudentsAlphabetically() {
        System.out.println("\n-----------------------------------");
        System.out.print("Lista studentilor sortata dupa lastName: ");
        students.stream()
                .sorted(Comparator.comparing(Student::getLastName))    //cu method reference
                .forEach(System.out::print);

//        students.stream()
//                .sorted(Comparator.comparing(student -> student.getLastName()))
//                .forEach(student -> System.out.print(student+ " "));

    }

    private static void printStudentsAlphabeticallyByFirstName() {
        System.out.println("\n-----------------------------------");
        System.out.print("Lista studentilor sortata dupa firstName: ");
        students.stream()
                .sorted(Comparator.comparing(student -> student.getFirstName()))
                .forEach(student -> System.out.print(student + " "));
    }

    private static void displayGroupWithMaxNumOfStudent_ClassicMethod() {
        //classic method

        System.out.println("\n-----------------------------------");
        System.out.print("Grupele cu maxim numar de studenti (classic method_1): ");
        Group maxGroup = new Group(null, null, new LinkedHashSet<>());
        //   Group maxGroup = new Group(null, null );   - nu se poate face deoarece nu poate compara
        for (Group element : groups) {
            if (element.getListOfStudents().size() > maxGroup.getListOfStudents().size()) {
                maxGroup = element;
            }
        }
        System.out.println(maxGroup);
    }

    private static List<Group> getAllGroupsWithMaxNumOfStudent_ClassicMethod() {
        System.out.println("\n-----------------------------------");

        List<Group> maxGroupsList = new ArrayList<>();
        Group maxGroup = new Group(null, null, new LinkedHashSet<>());

        for (Group element : groups) {
            if (element.getListOfStudents().size() > maxGroup.getListOfStudents().size()) {
                maxGroup = element;
                maxGroupsList = new ArrayList<>();
                maxGroupsList.add(element);
            } else if (element.getListOfStudents().size() == maxGroup.getListOfStudents().size()) {
                maxGroupsList.add(element);
            }
            return maxGroupsList;
        }
        //  System.out.print("Grupele cu maxim numar de studenti(classic method): " + maxGroupsList);
        System.out.println("Grupele cu maxim numar de studenti (classic method_2): ");
        for (Group element : maxGroupsList) {
            System.out.println("   " + element.getNameOfGroup());
        }
        return maxGroupsList;
    }

    private static int multiplyingNumberOfStudentsFromMaxGroup(int multiplicator, List<Group> maxGroup) {
        return maxGroup.size() * maxGroup.get(0).getListOfStudents().size() * multiplicator;

    }

    private static int tripleNumberOfStudentsFromMaxGroup(List<Group> maxGroup) {
        return multiplyingNumberOfStudentsFromMaxGroup(3, maxGroup);

    }

    private static void displayGroupWithMaxNumOfStudent_FunctionalMethod() {
        //functional method
        System.out.println("\n-----------------------------------");
        System.out.print("Grupele cu maxim numar de studenti (functional method): ");
        groups.stream()
                .filter(g -> g.getListOfStudents().size() ==
                        groups.stream()
                                .max(Comparator.comparingInt(g1 -> g1.getListOfStudents().size()))
                                .get().getListOfStudents().size())
//                 .max((g1,g2) -> Integer.compare(g1.getListOfStudents().size(),g2.getListOfStudents().size()))
//                   .get().getListOfStudents().size())

                //Altfel (sortat in ordine crescatoare si luat primul element ca max):
                // groups.stream()
                //      .sorted((g1,g2) -> Integer.compare(g2.getListOfStudents().size(),g1.getListOfStudents().size()))
                //      .findFirst().get().getListOfStudents().size())

                //.forEach(g -> System.out.println(g));
                .forEach(System.out::println);
    }

    private static void displayGroupWithMinNumOfStudent_FunctionalMethod() {
        //functional method
        System.out.println("\n-----------------------------------");
        System.out.print("Grupele cu minim numar de studenti (functional method): ");
        groups.stream()
                .filter(g -> g.getListOfStudents().size() ==
                        groups.stream()
                                .min(Comparator.comparingInt(g1 -> g1.getListOfStudents().size()))
                                .get().getListOfStudents().size())
                // .map(Group::getNameOfGroup)       //va lista doar numele grupelor(daca decomentez linia aceasta)
                .forEach(System.out::println);
    }

    private static void studentsYoungerThan(int age) {
        System.out.println("\n-----------------------------------");
        System.out.print("\nLista studentilor mai tineri decat " + age + " ani : ");
        students.stream()
                .filter(student ->
                        Period.between(student.getDateOfBirth(), LocalDate.now()).getYears() < age)
                .forEach(student -> System.out.print(student));
    }

    private static void displayStudentsYoungerThan(int age) {
        System.out.println("\n-----------------------------------");
        System.out.print("\nLista studentilor mai tineri decat " + age + " ani : ");
        students.stream()
                .filter(student -> student.getAge() < age)
                .forEach(student -> System.out.print(student));
    }

    private static void studentsGroupedByTrainer_WithGroups() {
        System.out.println("\n-----------------------------------");
        System.out.print("Lista studentilor grupat dupa traineri: ");
        for (Trainer trainer : trainers) {
            System.out.print("\n" + trainer.getFirstName() + "'s students: ");
            for (Group group : groups) {
                if (trainer.equals(group.getTrainer())) {
                    for (Student student : group.getListOfStudents()) {
                        System.out.print(student);
                    }
                }
            }
        }
    }

    private static void studentsGroupedByTrainer_WithMAp() {
        System.out.println("\n-----------------------------------");
        System.out.print("Lista studentilor grupat dupa traineri: ");
        for (Trainer trainer : trainers) {
            System.out.print("\n" + trainer.getFirstName() + "'s students: ");
            for (Map.Entry<Student, Trainer> mapElement : Group.getStudentTrainerMap().entrySet()) {
                if (trainer.equals(mapElement.getValue())) {
                    System.out.print("  " + mapElement.getKey().toString());
                }
            }
        }
    }

    private static void displayStudentsWithPreviousJavaKnowledge() {
        System.out.println("\n-----------------------------------");
        System.out.print("Lista studentilor care au cunostinte Java: ");
        for (Student student : students) {
            if (student.isHasPreviousJavaKnowledge())
                System.out.print(student);
        }
    }

    private static void dispGroupWithMaxNumOfStudentsWithNOJavaKnowledge() {
        System.out.println("\n-----------------------------------");

        int[] arrayOfNumStudents = new int[groups.size()];
        for (int gIndex = 0; gIndex < groups.size(); gIndex++) {
            for (Student student : groups.get(gIndex).getListOfStudents()) {
                if (!student.isHasPreviousJavaKnowledge()) {
                    arrayOfNumStudents[gIndex]++;
                }
            }
        }
        int maxNum = 0;
        int maxIndex = 0;
        for (int i = 0; i < arrayOfNumStudents.length; i++) {
            if (maxNum < arrayOfNumStudents[i]) {
                maxNum = arrayOfNumStudents[i];
                maxIndex = i;
            }
        }
        System.out.print("Grupa cu cei mai multi studenti care nu au cunostinte Java: " + groups.get(maxIndex));
    }

    private static void dispGroupWithMaxNumOfStudentsWithNOJavaKnowledge2() {
        System.out.println("\n-----------------2------------------");

        //afiseaza primul grup (chiar daca sunt mai multe cu acelasi numar de studenti fara cunostinte)
        System.out.print("Grupa cu cei mai multi studenti care nu au cunostinte Java: " +

                groups.stream()
                        .max(Comparator.comparing(g ->
                                g.getListOfStudents().stream()
                                        .filter(st -> st.isHasPreviousJavaKnowledge() == false)
                                        .count()))
                        .get()
                        .toString()
        );
    }

    private static void dispGroupWithMaxNumOfStudentsWithNOJavaKnowledge3() {
        System.out.println("\n-----------------3------------------");

        System.out.print("Grupa cu cei mai multi studenti care nu au cunostinte Java: ");

        groups.stream()
                .filter(group -> group.getListOfStudents().stream()
                        .filter(st -> !st.isHasPreviousJavaKnowledge())
                        .count() ==
                        groups.stream()
                                .max(Comparator.comparing(g ->
                                        g.getListOfStudents().stream()
                                                .filter(st -> !st.isHasPreviousJavaKnowledge())
                                                .count()))
                                .get().getListOfStudents().stream()
                                .filter(student -> !student.isHasPreviousJavaKnowledge())
                                .count()
                )
                .forEach(group -> System.out.println(group));
    }

    private static void dispGroupWithMaxNumOfStudentsWithNOJavaKnowledge4() {
        System.out.println("\n-----------------4------------------");

        //Am facut un getter in clasa Group care numara studentii fara cunostinte Java
        System.out.print("Grupa cu cei mai multi studenti care nu au cunostinte Java: ");

        groups.stream()
                .filter(group -> group.getNumOfStudentsWithNoPrevJavaKnow() ==
                        groups.stream()
                                .max(Comparator.comparing(group1 -> group1.getNumOfStudentsWithNoPrevJavaKnow()))
                                .get().getNumOfStudentsWithNoPrevJavaKnow()
                )
                .forEach(group -> System.out.println(group));
    }


    private static void removeStudentsYoungerThanFromGroups(int age) {
        System.out.println("\n-----------------------------------");


        for (Group group : groups) {
            //     Group auxGroup = new Group(null, null, null);
            Set<Student> auxStudentList = new HashSet<>();
            for (Student student : group.getListOfStudents()) {
                if (Period.between(student.getDateOfBirth(), LocalDate.now()).getYears() >= age) {
                    auxStudentList.add(student);
                }
            }
            group.setListOfStudents(auxStudentList);
        }
        System.out.print("\nLista grupelor dupa stergerea studentilor mai tineri decat " + age + " ani : " + groups);
    }

    private static void createClassHierarchy() {

        addStudents();
        addTrainers();
        addGroups();

        //JavaRo19.setTrainer(trainer3); - pana nu  schimbam pe private trainer
        // List<Person> personList = new ArrayList<>();

    }

    private static void addGroups() {
        //Groups
        Group javaRo16 = new Group("JavaRo16", trainer1, studentsRo16);
        Group javaRo17 = new Group("JavaRo17", trainer2, studentsRo17);
        Group javaRo18 = new Group("JavaRo18", trainer3, studentsRo18);
        Group javaRo19 = new Group("JavaRo19", null, studentsRo19);

        groups = Arrays.asList(javaRo16, javaRo17, javaRo18, javaRo19);
    }

    private static void addTrainers() {
        //Trainers
        trainer1 = new Trainer("Trainer1", "Alexandru", LocalDate.of(1979, Month.OCTOBER, 12), true);
        trainer2 = new Trainer("Trainer2", "Alexandru", LocalDate.of(1965, Month.OCTOBER, 12), true);
        trainer3 = new Trainer("Trainer3", "Alexandru", LocalDate.of(1973, Month.OCTOBER, 12), true);


        trainers = Arrays.asList(trainer1, trainer2, trainer3);
    }

    private static void addStudents() {
        //Students
        Student student1 = new Student("Student01", "CAlexandru", LocalDate.of(1998, Month.OCTOBER, 12), true);
        Student student2 = new Student("Student02", "HAlexandru", LocalDate.of(1992, Month.OCTOBER, 12), false);
        Student student3 = new Student("Student03", "BAlexandru", LocalDate.of(1998, Month.OCTOBER, 12), false);
        Student student4 = new Student("Student04", "NAlexandru", LocalDate.of(1996, Month.OCTOBER, 12), true);
        Student student5 = new Student("Student05", "KAlexandru", LocalDate.of(1998, Month.OCTOBER, 12), true);
        Student student6 = new Student("Student06", "HAlexandru", LocalDate.of(1980, Month.OCTOBER, 12), false);
        Student student7 = new Student("Student07", "DAlexandru", LocalDate.of(1985, Month.OCTOBER, 12), true);
        Student student8 = new Student("Student08", "Alexandru", LocalDate.of(1998, Month.OCTOBER, 12), false);
        Student student9 = new Student("Student09", "TAlexandru", LocalDate.of(1999, Month.OCTOBER, 12), true);
        Student student10 = new Student("Student10", "LAlexandru", LocalDate.of(1998, Month.OCTOBER, 12), false);
        Student student11 = new Student("Student11", "RAlexandru", LocalDate.of(1978, Month.OCTOBER, 12), false);
        Student student12 = new Student("Student12", "MAlexandru", LocalDate.of(1982, Month.OCTOBER, 12), false);
        Student student13 = new Student("Student13", "ZAlexandru", LocalDate.of(1997, Month.OCTOBER, 12), false);
        Student student14 = new Student("Student14", "QAlexandru", LocalDate.of(1987, Month.OCTOBER, 12), false);
        Student student15 = new Student("Student15", "PAlexandru", LocalDate.of(1991, Month.OCTOBER, 12), false);

        System.out.println(student1);

        students = new LinkedHashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);
        students.add(student9);
        students.add(student10);
        students.add(student11);
        students.add(student12);
        students.add(student13);
        students.add(student14);
        students.add(student15);

        // List<Student> students = new ArrayList<>(); //ca sa nu mai fac add-uri
        studentsRo16 = new LinkedHashSet<>();
        studentsRo16.add(student1);
        studentsRo16.add(student2);
        studentsRo16.add(student3);
        studentsRo16.add(student4);

        studentsRo17 = new LinkedHashSet<>();
        studentsRo17.add(student5);
        studentsRo17.add(student6);
        studentsRo17.add(student7);
        studentsRo17.add(student8);
        studentsRo17.add(student15);


        studentsRo18 = new LinkedHashSet<>();
        studentsRo18.add(student9);
        studentsRo18.add(student10);
        studentsRo18.add(student11);

        studentsRo19 = new LinkedHashSet<>();
        studentsRo19.add(student12);
        studentsRo19.add(student13);
        studentsRo19.add(student14);
    }
}