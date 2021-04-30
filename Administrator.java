import java.io.BufferedReader;//imports BufferedReader
import java.io.FileReader;//imports FileReader
import java.io.IOException;//imports IOException

/**
 * This class defines the administrator of the school
 * The administrator runs the simulation of the school
 * <p>
 * school       the school the admin runs
 * random       the Value object used to get random name, gender, age and percentage
 * reader       the BufferedReader to read the simulation from a file
 * fileToRead   the file from where to read the simulation
 */
public class Administrator {

    public School school = new School("");
    public Values random = new Values();
    BufferedReader reader;
    String fileToRead;

    /**
     * This is the constructor for the Administrator
     * The simulation is read from the file and added to the school
     *
     * @param fileToRead the name of the file from where the simulation is read
     */
    public Administrator(String fileToRead) {
        /*
        This is used to try to read the simulation from the file
        If the file is missing the message "Missing file" is printed and the application is stopped
         */
        try {
            reader = new BufferedReader(new FileReader(fileToRead));
        } catch ( IOException e ) {
            System.out.println("Missing file");
            System.exit(1);
        }
        readData(); //this is used to read the data from the simulation file
    }

    /**
     * This is a getter method for the school of the administrator
     *
     * @return the school of the administrator
     */
    public School getSchool() {
        return school;
    }

    /**
     * This method is used to add a random number (from 0 to 2) of students daily
     */
    public void enrolRandomStudents() {
        int numberOfStudentsEnrolledToday = random.generateRandomNumber(); //the random number of students that join

        //This while loop is used to add the correct number of students for a day
        while (numberOfStudentsEnrolledToday != 0) {
            /*
            The name , age and gender are randomly generated for each student
             */
            school.add(new Student(random.generateRandomName() , random.generateRandomGender() , random.generateRandomAgeStudent()));
            numberOfStudentsEnrolledToday--;
        }
    }

    /**
     * This method is used to add instructors to the school each day based on the percentage chance
     */
    public void joinNewInstructors() {
        int newInstrucotrs = 0; //a counter for the number of instructors that joined
        if (random.generatePercentageChance(20)) { //this simulates a 20% chance of a Teacher to join
            //The name , age and gender are randomly generated for each teacher
            school.add(new Teacher(random.generateRandomName() , random.generateRandomGender() , random.generanteRandomAgeInstructor()));
            newInstrucotrs++;
        }

        if (random.generatePercentageChance(10)) { //this simulates a 10% chance of a Demonstrator to join
            //The name , age and gender are randomly generated for each demonstrator
            school.add(new Demonstrator(random.generateRandomName() , random.generateRandomGender() , random.generanteRandomAgeInstructor()));
            newInstrucotrs++;
        }

        if (random.generatePercentageChance(10)) { //this simulates a 10% chance of a OOTrainer to join
            //The name , age and gender are randomly generated for each OOTrainer
            school.add(new OOTrainer(random.generateRandomName() , random.generateRandomGender() , random.generanteRandomAgeInstructor()));
            newInstrucotrs++;
        }

        if (random.generatePercentageChance(5)) { //this simulates a 5% chance of a GUITrainer to join
            //The name , age and gender are randomly generated for each GUITrainer
            school.add(new GUITrainer(random.generateRandomName() , random.generateRandomGender() , random.generanteRandomAgeInstructor()));
            newInstrucotrs++;
        }
        System.out.println("New Instructors " + newInstrucotrs);//prints the number of new instructors daily
    }

    /**
     * This method is used to run a day at the school
     * In a day at the school random number of students join and there are random chance for instructors to join
     * Then aDayAtSchool() is run for the school
     * At the end of the day if a student has all the certificates it will leave the school
     * A student that is not enrolled has 5% chance of leaving the school
     * An instructor which is free has 20% chance of leaving the school
     */
    public void run() {

        //Students and Instrcutors join
        enrolRandomStudents();
        joinNewInstructors();
        school.aDayAtSchool();

        /*
        This for loop is used to find the students that have all the certificates for all the subject in the school
        If a student has all of them it will be removed from the school
         */
        for (int i = 0; i < school.getStudents().size(); i++) {
            if (school.hasAllCertificates(school.getStudents().get(i))) { //verifies if it has all the certificates
                school.remove(school.getStudents().get(i));
            }
        }

        /*
        This for loop is used to get the students which are no enrolled
        Every student that is not enrolled has a 5% percent chance of leaving
        If the chance is successful then the student will be removed from the school
         */
        for (int i = 0; i < school.getStudents().size(); i++) {
            if (!school.getStudents().get(i).isEnrolled()) { //verifies if is not enrolled
                if (random.generatePercentageChance(5)) { //generates 5& chance
                    school.remove(school.getStudents().get(i));
                }
            }
        }

        /*
        This for loop is used to get the instructors which are free
        Every instructor that is free has a 20% percent chance of leaving
        If the chance is successful then the instructor will be removed from the school
         */
        for (int i = 0; i < school.getInstructors().size(); i++) {
            if (school.getInstructors().get(i).isFree()) {
                if (random.generatePercentageChance(20)) {
                    school.remove(school.getInstructors().get(i));
                }
            }
        }
    }

    /**
     * This method is used to run the simulation of the school for a specified number of days
     * At  the start of each day it will be printed info about the courses, students and instructors
     *
     * @param days the number of days in which the simulation will run
     */
    public void run(int days) {
        System.out.println("--------------------------------First Day Of  " + school.name + "--------------------");
        coursesDescription(); //prints info about the courses at the start
        studentDescription(); //prints info about the students at the start
        instructorDescription(); //prints info about the instructors at the start
        System.out.println("--------------------------------------------------------");

        //This whil loop is used to call the method run( for the number of days specified
        while (days != 0) {

            //This is used to have 2 seconds before every print of a new day
            try {
                Thread.sleep(2000);
                run();
            } catch ( InterruptedException e ) {
            }

            coursesDescription(); //prints info about te courses
            studentDescription(); //prints info about the students
            instructorDescription(); //prints info about the instructors
            System.out.println("--------------------------------------------------------");
            days -= 1;//decreasing the number of days
        }
    }

    /**
     * This method is used to print info about the courses of the school
     * If the course will start the number of days until it starts will be displayed
     * If the course started the number of days it still has to run will be displayed
     * If the course finished or canceled it will be printed
     * crs - is used to iterate through the courses ArrayList
     */
    public void coursesDescription() {
        for (Course crs : getSchool().getCourses()) {
            String status = " ";
            if (crs.getStatus() > 0 && !crs.isCancelled()) { //verifies if the course started
                status = "Course is running and has " + crs.daysToRun + " more days";
            } else if (crs.getStatus() == 0) { //verifies if the course finished
                status = "Course has finished";
            } else if (crs.getStatus() < 0 && !crs.isCancelled()) { //verifies if the course hasn't started yet
                status = "This Course will start in " + crs.daysUntilStarts + " days";
            }
            System.out.println(crs.toString() + status); //prints the info about the course
        }
    }

    /**
     * This method is used to print info about the students in the school
     * The string "Student:" plus the info about the student will be printed
     * The certificates of the student will be printed
     * If the student is enrolled the course he is enrolled will be printed
     * If he isn't enrolled it will be printed
     * std - is used to iterate through the students ArrayList
     */
    public void studentDescription() {
        for (Student std : school.getStudents()) {
            String description = " Student: ";
            if (!std.getCertificates().isEmpty()) { //verifies if it has certificates
                description = description + std.toString() + ":Certificates of this student are" + std.getCertificates();
            } else {
                description = description + std.toString() + ":Doesn't have certificates";
            }
            if (std.isEnrolled()) { //verifies if it is enrolled
                description = description + " Student is enrolled in " + std.getCourseEnrolled().toString();
            } else {
                description = description + " Student is not enrolled";
            }
            System.out.println(description); //prints the info about the student
        }
    }

    /**
     * This method is used to print info about the instructors in the school
     * The string "Instructor:" plus the info about the instructor will be printed
     * If the instructor is assigned to a course the course he is assigned to will be printed
     * If he isn't assigned to any course it will be printed
     * istr - is used to iterate through the instructors ArrayList
     */
    public void instructorDescription() {
        for (Instructor istr : school.getInstructors()) {
            if (!istr.isFree()) { //verifies if it is free
                System.out.println("Instructor: " + istr.toString() + ": Assigned course is " + istr.getAssignedCourse().toString());
            } else {
                System.out.println("Instructor: " + istr.toString() + " doesn't have an assigned course");
            }
        }
    }

    /**
     * This method is used to read data from the simulation file
     * It reads each line and creates the classes that have to be created based on the data from the file
     */
    public void readData() {

        //This while loop is used to read all the file until the end
        while (fileIsReady()) {

            /*
            This is used to split the string from the line at the ":"
            Based on the type of data before the ":" the right class will be created using the right info from the
            second string after the ":"
             */
            String newLine;
            newLine = getLine();
            String[] dataForName = newLine.split(":");

            if (dataForName[0].equals("school")) {

                //verifies if it is school
                this.school.name = dataForName[1]; //the school name is assigned using the name in the file

            } else if (dataForName[0].equals("subject")) { //verifies if it is subject

                String moreData = dataForName[1];
                String dataForDesciprion[] = moreData.split(","); //the info from the subject is split at the ","
                //The subject is created using the description, id, specialism and duration
                school.add(new Subject(dataForDesciprion[0] , Integer.parseInt(dataForDesciprion[1]) , Integer.parseInt(dataForDesciprion[2]) , Integer.parseInt(dataForDesciprion[3])));

            } else if (dataForName[0].equals("student")) { //verifies if it is student

                String moreData = dataForName[1];
                String dataForDesciprion[] = moreData.split(","); //the info from the student is split at the ","
                //The student is created using the name, gender and age
                school.add(new Student(dataForDesciprion[0] , dataForDesciprion[1].charAt(0) , Integer.parseInt(dataForDesciprion[2])));

            } else if (dataForName[0].equals("Teacher")) { //verifies if it is teacher

                String moreData = dataForName[1];
                String dataForDesciprion[] = moreData.split(","); //the info from the teacher is split at the ","
                //The teacher is created using the name, gender, age
                school.add(new Teacher(dataForDesciprion[0] , dataForDesciprion[1].charAt(0) , Integer.parseInt(dataForDesciprion[2])));

            } else if (dataForName[0].equals("Demonstrator")) { //verifies if it is demonstrator

                String moreData = dataForName[1];
                String dataForDesciprion[] = moreData.split(","); //the info from the demonstrator is split at the ","
                //The demonstrator is created using the name, gender, age
                school.add(new Teacher(dataForDesciprion[0] , dataForDesciprion[1].charAt(0) , Integer.parseInt(dataForDesciprion[2])));

            } else if (dataForName[0].equals("OOTrainer")) { //verifies if it is OOTrainer

                String moreData = dataForName[1];
                String dataForDesciprion[] = moreData.split(","); //the info from the OOTrainer is split at the ","
                //The OOTrainer is created using the name, gender, age
                school.add(new OOTrainer(dataForDesciprion[0] , dataForDesciprion[1].charAt(0) , Integer.parseInt(dataForDesciprion[2])));

            } else if (dataForName[0].equals("GUITrainer")) { //verifies if it is GUITrainer

                String moreData = dataForName[1];
                String dataForDesciprion[] = moreData.split(","); //the info from the GUITrainer is split at the ","
                //The GUITrainer is created using the name, gender, age
                school.add(new GUITrainer(dataForDesciprion[0] , dataForDesciprion[1].charAt(0) , Integer.parseInt(dataForDesciprion[2])));
            }
        }
    }

    /**
     * This method is used to get a line from the file
     *
     * @return the next line from the file if it exists, an empty string if it is the end of the file
     */
    public String getLine() {
        /*
        This is used to handle an IOException in case there are no more lines
        In case there are no more lines the function returns and empty string
        */
        try {
            return reader.readLine();
        } catch ( IOException e ) {
            System.out.println("No more lines");
            return "";
        }
    }

    /**
     * This method is used to verify if the file is ready to be read
     * If the file reaches the end is not ready to be read
     *
     * @return true if is ready to be read, false if is not ready to be read
     */
    public boolean fileIsReady() {
        /*
        This is used to handle the NullPointerException
        In case the file isn't found the function returns false
         */
        try {
            if (reader.ready()) {
                return true;
            } else {
                return false;
            }
        } catch ( Exception e ) {
            return false;
        }
    }

    /**
     * This is the main method of this project
     * It is used to get the file of the simulation and the number of days to run the simulation
     * This method runs the simulation
     *
     * @param args the name of the file where the simulation is and the number of days to run the simulation
     */
    public static void main(String[] args) {

        Administrator admin = new Administrator(args[0]); //initialize new administrator

        /*
        This is used to get the args from the command prompt
        If the args[1] is not an integer the message "Argument args[1] must be an integer" and then the
        application will be stopped
         */
        try {
            admin.run(Integer.parseInt(args[1]));
        } catch ( NumberFormatException e ) {
            System.err.println("Argument" + args[1] + " must be an integer.");
            System.exit(1);
        }
    }


}
