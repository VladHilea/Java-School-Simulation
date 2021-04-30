import java.util.ArrayList;//imports ArrayLists

/**
 * This is the class that defines a course. Each subject can have only one course happening at a time
 * <p>
 * subject                      that subject for which this course is
 * daysUtilStarts               the number of days until the course starts
 * daysToRun                    the number of days the course has to run, depends on the subject
 * instructorOfThisCourse       the instructor of this course
 * finished                     the status of the progress of the course: true if it finished, false if not
 * cancelStatus                 the status of the course: true if has been canceled, false if not
 */
public class Course {

    public Subject subject;
    public int daysUntilStarts;
    public int daysToRun;
    public Instructor instructorOfThisCourse;
    public boolean finished = false;
    public boolean cancelStatus = false;

    /**
     * This is the constructor of the Course
     * daysUntilStarts is incremented by 1 so that when is printed when it is created with the correct number of days
     * before the start
     * daysToRun is set depnding on the duration of the subject
     * The course is added to the course ArrayList of the Subject
     *
     * @param subject         the subject for which this course is
     * @param daysUntilStarts the number of days until it starts
     */
    public Course( Subject subject , int daysUntilStarts ) {
        this.subject = subject;
        this.daysUntilStarts = daysUntilStarts + 1;
        daysToRun = getSubject().duration;
        subject.addCourse(this);
    }

    /**
     * This is a getter method for the subject of the course
     *
     * @return the subject for which this course is
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * This is a getter method for the instructor of this course
     *
     * @return the instructor of this course
     */
    public Instructor getInstructorOfThisCourse() {
        return instructorOfThisCourse;
    }

    /**
     * This method is used to get the statu of the course
     *
     * @return the number of days until it Starts in a negtive version if it hasn't started, 0 if it finished,
     * the number of days is still have to run if is in progress
     */
    public int getStatus() {
        if (daysUntilStarts > 0) {
            return daysUntilStarts * (-1);
        } else if (daysToRun == 0) {
            return 0;
        } else return daysToRun;

    }

    /**
     * This method is used to cancel the course
     * The cancelStatus is changed to true
     */
    public void cancelCourse() {
        cancelStatus = true;
        //The students of the course are freed
        for (Student student : studentsEnrolled) {
            student.enrolled = false;
        }
        //The instructor of this course is freed
        if (getInstructorOfThisCourse() != null) {
            getInstructorOfThisCourse().unassignCourse();
        }
        //The course is removed from the course ArrayList of the subject
        subject.getCoursesOfThisSubject().remove(this);
    }

    /**
     * This method is used to verify if the course is canceled
     *
     * @return true if the course is canceled, false if not
     */
    public boolean isCancelled() {
        if (cancelStatus) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is used to simulate a day that has passed for a course
     * In a day that passed in the course: the daysUntilStarts decreases by 1 if the courses hasn't started, the number
     * of days it has to run (daysToRun) decreases by 1 if the course started
     * <p>
     * If in the day it starts it doesn't have an instructor or a student, the course is canceled
     * If the course has finished in this day all the students are freed, and the instructor is freed too
     */
    public void aDayPasses() {

        if (getStatus() < 0) { //verifies if the course hasn't started
            daysUntilStarts--;
        } else if (getStatus() > 0) { //verifies if the course startes
            daysToRun--;
        }

        if (getStatus() == daysToRun) { //verifies if it is the day in which it should start

            if (!hasInstructor() || studentsEnrolled.isEmpty()) {  //verifies if it has an instructor and at least one student
                cancelCourse();
                finished = true;
            }
        }

        if (getStatus() == 0) { //verifies if the course ended in this day

            /*
            This for loop is used to graduate all students from this subject and free them
            If the days of work are more than 10, then the student is going on a break ( used for extension)

            std - used to iterate through the ArrayList of all the students enrolled in this course
             */
            for (Student std : studentsEnrolled) {
                std.graduate(getSubject());
                std.enrolled = false;
                if (std.daysOfWork > 10) {
                    std.isOnPause = true;
                }
            }

            /*
            The instructor is freed from the course
            If teh days of work are more than 10, the the instructor is going on a break (used for exentsion)
             */
            instructorOfThisCourse.unassignCourse();
            if (instructorOfThisCourse.daysOfWork > 10) {
                instructorOfThisCourse.isOnPause = true;
            }

            finished = true;  //the course status is updated to finished
        }
    }

    ArrayList<Student> studentsEnrolled = new ArrayList<Student>(); //this is the arraylist of the students enrolled

    /**
     * This method is used to get the size of the students enrolled in the course
     *
     * @return the number of students enrolled to this course
     */
    public int getSize() {
        return studentsEnrolled.size();
    }

    /**
     * This method is used to get the Student Array od the students enrolled to this course
     *
     * @return Student Array of students enrolled in this course
     */
    public Student[] getStudents() {
        //converts the ArrayList to Student Array
        Student[] studentArray = studentsEnrolled.toArray(new Student[studentsEnrolled.size()]);
        return studentArray;
    }

    /**
     * This method is used to enrol a student in this course
     *
     * @param studentToEnrol the student you want be enrolled
     * @return true if the student enrolled succefuly, false if not
     */
    public boolean enrolStudent( Student studentToEnrol ) {
        /*
        For a student to be enrolled there has to be enough space in this course ( maximum 3 students ) and
        the course doesn't have to be started

        In order to enrol the student, the enrolled status of the student is updated, and the enrolledCourse of the
        student is updated to this course and the student is added to the ArrayList of the students enrolled in
        this course
         */
        if (getSize() < 3) {
            if (getStatus() < 0) {
                studentToEnrol.enrolled = true;
                studentToEnrol.courseEnrolled = this;
                studentsEnrolled.add(studentToEnrol);
                return true;
            }
        }
        return false; //if not all the conditions where met
    }

    /**
     * This method is used to set the instructor of this course
     *
     * @param instructorToSet this is the instructor you want to set to this course
     * @return true if the instructor was set, false if not
     */
    public boolean setInstructor( Instructor instructorToSet ) {
        /*
        For an instructor to be set it should be able to teach this subject

        In order to set the instructor, the course is assigned to the instructor, and the instructorOfThisCOurse is
        updated to this instructor
         */
        if (instructorToSet.canTeach(this.subject)) {
            instructorToSet.assignCourse(this);
            instructorOfThisCourse = instructorToSet;
            return true;
        } else {
            return false; //if not all the conditions were met
        }
    }

    /**
     * This method is used to verify if this course has instructor
     *
     * @return true if it has instructor, false if not
     */
    public boolean hasInstructor() {
        if (instructorOfThisCourse != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is used to verify if this course is full ( there are already 3 students enrolled)
     *
     * @return true if it is full, flase if not
     */
    public boolean isFull() {
        if (getSize() >= 3) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is used to verify if the course i finished
     *
     * @return true if it is finished, flase if not
     */
    public boolean isFinished() {
        if (finished == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is used to override the toString() method in order to have a better print of the infos of the course
     *
     * @return the string with all the info of teh course
     */
    @Override
    public String toString() {

        //If it is cancelled, it is printed at the end of the info
        if (daysUntilStarts == 0 & this.isCancelled()) {
            return "Course{" +
                    "Subject " + getSubject().description +
                    ", Instructor :" + instructorOfThisCourse +
                    ", Students =" + studentsEnrolled +
                    '}' + "Course has been canceleed";
        } else {
            return "Course{" +
                    "Subject " + getSubject().description +
                    ", Instructor :" + instructorOfThisCourse +
                    ", Students =" + studentsEnrolled +
                    '}';
        }
    }
}
