import java.util.List;
import java.util.Set;


    public class Group {
        private Trainer trainer;
        private Set<Student> students1;

        public Group(Trainer trainer, Set<Student> students1) {
            this.trainer = trainer;
            this.students1 = students1;
        }


        public void setTrainer(Trainer trainer) {
            this.trainer = trainer;
        }

        @Override
        public String toString() {
            return "Group{" +
                    " trainer=" + trainer +
                    ", students=" + students1 +
                    '}';
        }
    }





