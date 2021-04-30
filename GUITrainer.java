/**
 * This is the class that defines a GUITrainer
 * A GUITrainer is a type of teacher that can teach in addition a subject wth the specialism of 4
 * The class GUITrainer extends teh class Teacher. It is a subclass of the Teacher class
 */
public class GUITrainer extends Teacher {

    /**
     * This is the constructor of the GUITrainer
     *
     * @param name          the name of the GUITrainer
     * @param gender        the gender of the GUITrainer
     * @param age           the age of the GUITrainer
     */
    public GUITrainer(String name, char gender, int age) {
        super(name, gender, age);
    }

    /**
     * This is an overriding method of the canTeach() that verifies if the GUITrainer can teach a subject
     * If the specialism of the subject is 1,2,4 than the GUITrainer can teach
     *
     * @param subjectToAssign      subject that will be assigned
     * @return                     true if the GUITrainer can teach, false if not
     */
    @Override
    public boolean canTeach(Subject subjectToAssign) {
        if(subjectToAssign.specialism == 1 || subjectToAssign.specialism == 2 || subjectToAssign.specialism == 4){
            return true;
        } else {
            return false;
        }
    }
}
