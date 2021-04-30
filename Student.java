import java.util.ArrayList;//imports ArrayList

/**
 * This is the class that defines a student
 * The Student class extends the Person class. It is a subclass of the Person class
 *
 * certificates    an ArrayList with the certificates of the student
 * enrolled        the status of the student: true if is enrolled in a course, false if it is not
 * courseEnrolled   the curse in which the Student is enrolled
 */
public class Student extends Person {

    ArrayList<Integer> certificates = new ArrayList<Integer>();
    public boolean enrolled = false;
    public Course courseEnrolled;

    /**
     * The constrcutor of the Student
     *
     * @param name          the name of the student
     * @param gender        the gender of the student
     * @param age           teh age of the student
     */
    public Student(String name, char gender, int age) {
        super(name, gender, age);
    }

    /**
     * This method is used to make the student graduate a course, that means the student finished it
     * The ceertificate of the subject is added to the certificate ArrayList of the student
     *
     * @param subjectFinished    the subject the student will get the certificate
     */
    public void graduate(Subject subjectFinished) {
        certificates.add(subjectFinished.getID());
    }

    /**
     * A getter method for the certificates of the student
     *
     * @return      the ArrayList of the certificates of the student
     */
    public ArrayList getCertificates() {
        return certificates;
    }

    /**
     * This method is used to verify if the student has the certificate of a subject
     *
     * @param subjectToVerify   the subject to verify if has certificate
     * @return                  true if it has the certificate, false if not
     */
    public boolean hasCertificate(Subject subjectToVerify) {

        /*
        This for loop is used to go through all the certificates array and see if the subjectToVerify is in it
        crt - used to iterate through the certificates ArrayList
         */
        for(int crt : certificates) {
            if(crt == subjectToVerify.getID())
                return true;
        }
        return false;
    }

    /**
     * This method is used to verify if the student is enrolled
     *
     * @return  true if it is enrolled, false if not
     */
    public boolean isEnrolled() {
        if(enrolled ==  true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * A getter for the course that the student is currently enrolled in
     *
     * @return      the course the student is enrolled in now
     */
    public Course getCourseEnrolled() {
        return courseEnrolled;
    }
}
