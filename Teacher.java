/**
 * This is the class that defines a Teacher
 * A teacher is a type of instructor that can teach a subject wth the specialism of 1,2
 * The class Teacher extends teh class Instructor. It is a subclass of the Instructor class
 */
public class Teacher extends Instructor {

    /**
     * This is the constructor of the Teacher
     *
     * @param name   the name of the teacher
     * @param gender the gender of the teacher
     * @param age    the age of the teacher
     */
    public Teacher(String name , char gender , int age) {
        super(name , gender , age);
    }

    /**
     * This is an overriding method of the canTeach() that verifies if the teacher can teach a subject
     * If the specialism of the subject is 1,2 than the teacher can teach
     *
     * @param subjectToAssign subject that will be assigned
     * @return true if the teacher can teach, false if not
     */
    @Override
    public boolean canTeach(Subject subjectToAssign) {
        if (subjectToAssign.specialism == 1 || subjectToAssign.specialism == 2) {
            return true;
        } else {
            return false;
        }
    }
}
