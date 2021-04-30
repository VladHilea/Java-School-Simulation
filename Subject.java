import java.util.ArrayList;//imports ArrayList

/**
 * This is the Subject class
 * It represents what is it about in a course in the school
 * <p>
 * id                    id of the subject
 * specialism            level of complexity for the teacher
 * duration              the duration of the course
 * description           the description of the subject
 * coursesOfThisSubject  an ArrayList with all the courses of the subject
 */
public class Subject {

    public int id;
    public int specialism;
    public int duration;
    public String description;
    public ArrayList<Course> coursesOfThisSubject = new ArrayList<Course>();

    /**
     * This is the constructor used to create a subject
     *
     * @param description the description of the subject
     * @param id          id of the subject
     * @param specialism  level of complexity for the teacher
     * @param duration    the duration of the course
     */
    public Subject(String description , int id , int specialism , int duration) {
        this.description = description;
        this.id = id;
        this.specialism = specialism;
        this.duration = duration;
    }

    /**
     * A getter for the id of the subkect
     *
     * @return the id of the subject
     */
    public int getID() {
        return id;
    }

    /**
     * A getter for the specialism of the subject
     *
     * @return the specialism of the subject
     */
    public int getSpecialism() {
        return specialism;
    }

    /**
     * A getter for the duration of the course
     *
     * @return the duration of the course
     */
    public int getDuration() {
        return duration;
    }

    /**
     * A getter for the description of the course
     *
     * @return the description of the course
     */
    public String getDescription() {
        return description;
    }

    /**
     * A setter for the description of the course
     *
     * @param description the new description of the course
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method is used to add a course to the ArrayList of courses
     *
     * @param courseToAdd the course you want to add
     */
    public void addCourse(Course courseToAdd) {
        coursesOfThisSubject.add(courseToAdd);
    }

    /**
     * A getter for the courses of the subject
     *
     * @return the ArrayList of the courses
     */
    public ArrayList<Course> getCoursesOfThisSubject() {
        return coursesOfThisSubject;
    }

    /**
     * This method is used to verify if all the courses of the subject have finished
     *
     * @return true if all ended, false if there are still active courses
     */
    public boolean allCoursesFinished() {
        for (Course crs : getCoursesOfThisSubject()) {
            if (!crs.isFinished()) {
                return false;
            }
        }
        return true;
    }

    /**
     * This is a method that Overrides toString() to have a better print
     *
     * @return the subject with all the information about it
     */
    @Override
    public String toString() {
        return
                " id=" + id + "\n\r" +
                        " specialism=" + specialism + "\n\r" +
                        " duration=" + duration + "\n\r" +
                        " description='" + description + '\''
                ;
    }
}
