/**
 * This is the class that defines an instructor
 * The Instructor class extends the Person class. It is a subclass of the Person class
 * <p>
 * assignedCourse       the course that this instructor is assigned to
 */
public abstract class Instructor extends Person {

    Course assignedCourse;

    /**
     * This is the constructor for the instructor
     *
     * @param name   the name of the instructor
     * @param gender the gender of the instructor
     * @param age    the age of the instructor
     */
    public Instructor(String name , char gender , int age) {
        super(name , gender , age);
    }

    /**
     * This method is used to assign a course to the instructor
     * The instructor of the course will become this instructor in order to have a link with a course from
     * both the instructor to the course and from course to the instructor
     *
     * @param courseToAssign the course you want to assign to this instrcutor
     */
    public void assignCourse(Course courseToAssign) {
        assignedCourse = courseToAssign;
        assignedCourse.instructorOfThisCourse = this;
    }

    /**
     * This method is used to unassigne the course from this instructor
     * The assigned course will be made null
     */
    public void unassignCourse() {
        assignedCourse = null;

    }

    /**
     * This is a getter for the assigned course
     *
     * @return the course assigned to this instructor
     */
    public Course getAssignedCourse() {
        return assignedCourse;
    }

    /**
     * This is an abstract method that verifies if the instructor can teach a subject
     *
     * @param subjectToAssign subject that will be assigned
     * @return true if is assigned, false if it is not
     */
    public abstract boolean canTeach(Subject subjectToAssign);

    /**
     * This method is used to verify if the instructor is free
     *
     * @return true if it is free, false if it is not
     */
    public boolean isFree() {
        if (getAssignedCourse() == null) {
            return true;
        } else {
            return false;
        }
    }
}
