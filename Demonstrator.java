/**
 * This is the class that defines a demonstrator
 * A demonstrator is a type of instructor that can teach a subject wth the specialism of 2
 * The class Demonstrator extends teh class Instructor. It is a subclass of the Instructor class
 */
public class Demonstrator extends Instructor {

    /**
     * This is the constructor of the Demonstrator
     *
     * @param name   the name of the demonstrator
     * @param gender the gender of the demonstrator
     * @param age    the age of the demonstrator
     */
    public Demonstrator(String name , char gender , int age) {
        super(name , gender , age);
    }

    /**
     * This is an overriding method of the canTeach() that verifies if the demonstrator can teach a subject
     * If the specialism of the subject is 2 than the demonstrator can teach
     *
     * @param subjectToAssign subject that will be assigned
     * @return true if the demonstrator can teach, false if not
     */
    @Override
    public boolean canTeach(Subject subjectToAssign) {
        if (subjectToAssign.specialism == 2) {
            return true;
        } else {
            return false;
        }
    }
}
