import java.util.ArrayList;//imports ArrayList
import java.util.Iterator;//imports Iterator

/**
 * This is the class that defines a school
 * A school has a lot of instructors, students, subjects and courses that are created for each subject
 * <p>
 * name                         the name of the schoole
 * studentsInSchool             an ArrayList with all the students in the school
 * instructorsInSchool          an ArrayList with all the instructors in this school
 * coursesInSchool              an ArrayList with all the courses in the school
 * subjectsinSchool             an ArrayList with all the subjects in the school
 */
public class School {

    public String name;
    public ArrayList<Student> studentsInSchool = new ArrayList<Student>();
    public ArrayList<Instructor> instructorsInSchool = new ArrayList<Instructor>();
    public ArrayList<Course> coursesInSchool = new ArrayList<Course>();
    public ArrayList<Subject> subjectsInSchool = new ArrayList<Subject>();

    /**
     * This is the constructor for the School
     *
     * @param name the name of the school
     */
    public School(String name) {
        this.name = name;
    }

    /**
     * This is geeter method for the name of the school
     *
     * @return the name of the school
     */
    public String getName() {
        return name;
    }

    /**
     * This is a getter method for the students in the school
     *
     * @return the ArrayList of all the students in the school
     */
    public ArrayList<Student> getStudents() {
        return studentsInSchool;
    }

    /**
     * This is a getter method for the instructors in the school
     *
     * @return the ArrayList of all the instructor in the school
     */
    public ArrayList<Instructor> getInstructors() {
        return instructorsInSchool;
    }

    /**
     * This is a getter method for the courses in the school
     *
     * @return the ArrayListOf all the courses in the school
     */
    public ArrayList<Course> getCourses() {
        return coursesInSchool;
    }

    /**
     * This is a getter method for the subjects in the school
     *
     * @return the ArrayList of all the subjects in the school
     */
    public ArrayList<Subject> getSubjects() {
        return subjectsInSchool;
    }

    /**
     * This method is used to add a student to the school
     * The student will be added in the students ArrayList
     *
     * @param studentToAdd the student you want to add in the school
     */
    public void add(Student studentToAdd) {
        studentsInSchool.add(studentToAdd);
    }

    /**
     * This method is used to add an instrcutor to the school
     * The instrcutor will be added in the instrcutors ArrayList
     *
     * @param instructorToAdd the instructor you want to add in the school
     */
    public void add(Instructor instructorToAdd) {
        instructorsInSchool.add(instructorToAdd);
    }

    /**
     * This method is used to add a course to the school
     * The course will be added in the courses ArrayList
     *
     * @param courseToAdd the course you want to add in the school
     */
    public void add(Course courseToAdd) {
        coursesInSchool.add(courseToAdd);
    }

    /**
     * This method is used to add a subject to the school
     * The subject will be added in the subjects ArrayList
     *
     * @param subjectToAdd the subject you want to add in the school
     */
    public void add(Subject subjectToAdd) {
        subjectsInSchool.add(subjectToAdd);
    }

    /**
     * This method is used to remove a student from the school
     * The student will be removed from the students ArrayList
     * The Iterator is used to avoid ConcurrentModification
     *
     * @param studentToRemove the student you want to be removed
     */
    public void remove(Student studentToRemove) {
        Iterator<Student> it = getStudents().iterator();
        while (it.hasNext()) {
            Student student = it.next();
            if (student.equals(studentToRemove)) {
                it.remove();
            }
        }
    }

    /**
     * This method is used to remove an instructor from the school
     * The instructor will be removed from the instructors ArrayList
     * The Iterator is used to avoid ConcurrentModification
     *
     * @param instructortoRemove the instructor you want to be removed
     */
    public void remove(Instructor instructortoRemove) {
        Iterator<Instructor> it = getInstructors().iterator();
        while (it.hasNext()) {
            Instructor instructor = it.next();
            if (instructor.equals(instructortoRemove)) {
                it.remove();
            }
        }
    }

    /**
     * This method is used to remove a course from the school
     * The course will be removed from the courses ArrayList
     * The normal for loop is used to avoid ConcurrentModification
     *
     * @param courseToRemove the course you want to be removed
     */
    public void remove(Course courseToRemove) {
        for (int i = 0; i < getCourses().size(); i++) {
            if (getCourses().get(i).equals(courseToRemove)) {
                getCourses().remove(i);
            }
        }
    }

    /**
     * This method is used to remove a subject from the school
     * The subject will be removed from the subjects ArrayList
     *
     * @param subjectToRemove the subject you want to be removed
     */
    public void remove(Subject subjectToRemove) {
        getSubjects().remove(subjectToRemove);
    }

    /**
     * This method is used to get info about each subject to get a better toString()
     * For every subject the courses of the subject will be printed
     * sbj - used to iterate throught the subjects ArrayList
     *
     * @return the string created with the info about the school
     */
    public String getSubjectPlusDetails() {
        String createdString = "";
        for (Subject sbj : getSubjects()) {
            createdString = createdString + "\n\r" + "-------" + sbj.getID() + "-------" + "\n\r";
            createdString = createdString + "The details of this subject are" + "\n\r";
            createdString = createdString + sbj.toString() + "\n\r";
            createdString = createdString + "\n\r" + "-------The courses of this subject are:-------\n\r" +
                    getAllCoursesNames(sbj) + "----------------------------------------------------" + "\n\r" + " ----------------------------------------------------" + "\n\r"
            ;
        }
        return createdString;
    }

    /**
     * This method is used to get info about all the students from the school to get a better toString()
     * prs - used to iterate through the students ArrayList
     *
     * @return the string created with all the students from the school
     */
    public String getAllStudentsNames() {
        String stringCreatedWithAllNames = " ";
        for (Person prs : getStudents()) {
            stringCreatedWithAllNames = stringCreatedWithAllNames + "-" + prs.toString();
            stringCreatedWithAllNames = stringCreatedWithAllNames + "\n\r" + " ";
        }
        return stringCreatedWithAllNames;
    }

    /**
     * This method is used to get info about each course of a subject to get a better toString()
     * crs - used to iterate through the courses ArrayList
     *
     * @param subjectToGetCourses the subject of which courses you want to get the info
     * @return the string created with all the courses info for each subject
     */
    public String getAllCoursesNames(Subject subjectToGetCourses) {
        String stringCreatedWithAllNames = " ";
        for (Course crs : subjectToGetCourses.getCoursesOfThisSubject()) {
            if (!crs.isFinished()) {
                stringCreatedWithAllNames = stringCreatedWithAllNames + crs.toString();
                stringCreatedWithAllNames = stringCreatedWithAllNames + "\n\r" + " ";
            }
        }
        return stringCreatedWithAllNames;
    }

    /**
     * This method is used to get info about all the instructors of from the school to get a better toString()
     * istr - used to iterate through the instructors ArrayList
     *
     * @return the string created with all the instructors from the school
     */
    public String getAllInstructors() {
        String stringInstructorNames = " ";
        for (Instructor istr : getInstructors()) {
            stringInstructorNames = stringInstructorNames + "-" + istr.toString();
            stringInstructorNames = stringInstructorNames + "\n\r" + " ";
        }
        return stringInstructorNames;
    }

    /**
     * This method is used to override the toString() method for a better print
     * It includes info about all the subjects from the course with all the courses and all the students and all the
     * instructor
     *
     * @return the string created with all the info about the school
     */
    @Override
    public String toString() {
        return "-----------------------------School " +
                name + "-----------------------------\n\r" +
                "-----------------------------Subjects of the school----------------------------- " + "\n\r" +
                getSubjectPlusDetails() + "\n\r" +
                "A list of all the students is :" + "\n\r\n\r" +
                getAllStudentsNames() + "\n\r\n\r" +
                "A list with all of the instructors is:" + "\n\r\n\r" +
                getAllInstructors()
                ;
    }

    /**
     * This method is used to simulate a day at school
     * On each day it is created a course for a subject that doesn't already have one
     * All the cancelled or finished courses are removed from the school
     * For each course that doesn't have an instructor it will be tried to set one for it
     */
    public void aDayAtSchool() {

        /*
        Creates a course for the subjects which don't already have one
        sbj - used to iterate through the subjects ArrayList
         */
        for (Subject sbj : getSubjects()) {
            if (sbj.getCoursesOfThisSubject().isEmpty() || sbj.allCoursesFinished()) {
                Course course = new Course(sbj , 2);
                add(course);
            }
        }

        /*
        This for loop is used to remove all the cancelled or finished courses from the school
        i - the position from the ArrayList where is the course that has to be removed
         */
        for (int i = 0; i < getCourses().size(); i++) {
            if (getCourses().get(i).isCancelled()) { //verifies if the course is cancelled
                remove(getCourses().get(i));
            } else {
                if (getCourses().get(i).getStatus() == 0) {
                    remove(getCourses().get(i)); //verifies if the course is finished
                }
            }
        }

        /*
        These for loops are used to get the courses that don't have an instructor and try to set one for it
        The instructor can be set if it is free and is not on a break (used for extension)
        The instructor is assigned to the course and the instructor of the course is assigned to that instructor
        crs  - used to iterate through the courses ArrayList
        istr - used to iterate throught the instructors ArrayList
         */
        for (Course crs : getCourses()) {
            if (!crs.hasInstructor() && !crs.isCancelled()) { //verifies if it has instructor and if it hasn't finished
                for (Instructor istr : getInstructors()) {
                    if (istr.isFree()) { //verifies if instructor is free
                        if (!istr.isOnPause()) { //verifies if is on a break (used for extension)
                            crs.setInstructor(istr);
                            istr.assignCourse(crs);
                            break;
                        }
                    }
                }
            }
        }

        /*
        This for loop is used to assign students for courses
        The student can be enrolled to a course if it isn't already enrolled in another, if the course is not full,
        if the student doesn't already have the certificate for the subject of the course and if the student is not
        on a break (used for extension)
        The student is enrolled to the course
        std - used to iterate through the students ArrayList
        crs - used to iterate through the courses ArrayList
         */
        for (Student std : getStudents()) {
            for (Course crs : getCourses()) {
                if (!std.isEnrolled()) { //verifies if student is already enrolled in another course
                    if (!crs.isFull()) { //verifies if the course isn't already full
                        if (!std.hasCertificate(crs.getSubject())) { //verifies if the student doesn't have the certificate
                            if (!std.isOnPause()) { //verifies if the student is on a break (used for extension)
                                crs.enrolStudent(std);
                            }
                        }
                    }
                }
            }
        }

        /*
        This for loop is used to increment the days of work that an enrolled student has
        The maximum of days of work is 10 (used for extension)
        std - used to iterate through the students ArrayList
         */
        for (Student std : getStudents()) {
            if (std.isEnrolled()) {
                std.daysOfWork++;
            }
        }

        /*
        This for loop is used to increment the days of work that an instructor has
        The maximum of days of work is 10 (used for extension)
        istr - used to iterate through the instructors ArrayList
         */
        for (Instructor istr : getInstructors()) {
            if (!istr.isFree()) {
                istr.daysOfWork++;
            }
        }

        /*
        This for loop is used to have a day pass for each course
        crs - used to iterate through the courses ArrayList
         */
        for (Course crs : getCourses()) {
            crs.aDayPasses();
        }

        /*
        This for loop is used to increment the number of days which a student was on a break or to make them stop
        being on a break if the break ended. It simulates being on a break for a student
        The length of a break is 2 days
        std - used to iterate  through the students ArrayList
        (used for extension)
         */
        for (Student std : getStudents()) {
            if (std.isOnPause()) { //verifies if is on a break
                if (std.daysOfPause > 1) {
                    std.isOnPause = false;
                }
                std.daysOfPause++;
            }
        }

        /*
        This for loop is used to increment the number of days which an instructor was on a break or to make them stop
        being on a break if the break ended. It simulates being on a break for an instructor.
        The length of a break is 2 days
        istr - used to iterate  through the instructors ArrayList
        (used for extension)
         */
        for (Instructor istr : getInstructors()) {
            if (istr.isOnPause()) { //verifiers if is on a break
                if (istr.daysOfPause > 1) {
                    istr.isOnPause = false;
                }
                istr.daysOfPause++;
            }
        }
    }

    /**
     * This method is used to verify if a student has all the certificates for all the subjects available in the school
     *
     * @param std the student to verify
     * @return true if it has all of them, false if not
     */
    public boolean hasAllCertificates(Student std) {
        for (Subject sbj : getSubjects()) {
            if (!std.hasCertificate(sbj)) {
                return false;
            }
        }
        return true;
    }
}
