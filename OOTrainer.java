/**
 * This is the class that defines a OOTrainer
 * A OOTrainer is a type of instructor that can teach in addition a subject wth the specialism of 1,2,3
 * The class OOTrainer extends the class Teacher. It is a subclass of the Teacher class
 */
public class OOTrainer extends Teacher {

    /**
     * This is the constructor of the Demonstrator
     *
     * @param name   the name of the OOTrainer
     * @param gender the gender of the OOTrainer
     * @param age    the age of the OOTrainer
     */
    public OOTrainer(String name , char gender , int age) {
        super(name , gender , age);
    }

    /**
     * This is an overriding method of the canTeach() that verifies if the OOTrainer can teach a subject
     * If the specialism of the subject is 1,2,3 than the OOTrainer can teach
     *
     * @param subjectToAssign subject that will be assigned
     * @return true if the OOTrainer can teach, false if not
     */
    @Override
    public boolean canTeach(Subject subjectToAssign) {
        if (subjectToAssign.specialism == 1 || subjectToAssign.specialism == 2 || subjectToAssign.specialism == 3) {
            return true;
        } else {
            return false;
        }
    }
}
