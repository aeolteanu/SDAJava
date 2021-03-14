import java.util.List;
import java.util.Set;


    public class Group {
        private Trainer trainer;
        private Set<Student> students;

        public Group(Trainer trainer, Set<Student> students) {
            this.trainer = trainer;
            if(students.size()<=5){
                this.students = students;
            }else{
                throw new MaximumNumberOfStudentsReached("Number of students reached");


        }

        }


        @Override
        public String toString() {
            return "Group{" +
                    " trainer=" + trainer +
                    ", students=" + students +
                    '}';
        }
    }





