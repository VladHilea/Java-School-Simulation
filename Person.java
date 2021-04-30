/**
 * This is the class that defines a person
 * This is the super class
 * A person can bea an instructor or a student
 * <p>
 * name         the name of the person
 * gender       M for male, F for female
 * age          the age of the person
 * isOnPause    status of the person if is in pause: true if is on a break, false if is not on a break (used for an extension)
 * daysOfWork   number of days in which the person has worked consecutively (max 10) (used for an extension)
 * daysOfPause  the number of days the person is on a break (2 for a break) (used for an extension)
 */
public class Person {

    public String name;
    public char gender;
    public int age;
    public boolean isOnPause = false;
    public int daysOfWork;
    public int daysOfPause;

    /**
     * This is the constructor for a person
     *
     * @param name   the name of the person
     * @param gender M for male, F for female
     * @param age    the age of the person
     */
    public Person(String name , char gender , int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    /**
     * A getter method for the name of the person
     *
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * A getter method for the gender of the person
     *
     * @return the gender of the person
     */
    public char getGender() {
        return gender;
    }

    /**
     * A getter method for the age of the person
     *
     * @return the age of the person
     */
    public int getAge() {
        return age;
    }

    /**
     * A setter method for the age of the person
     *
     * @param age the age you want t set t the person
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * A method to verify if is on a break or not
     *
     * @return trye if it is on a break, false if not
     */
    public boolean isOnPause() {
        return isOnPause;
    }

    /**
     * This is a method that Overrides the toString() method
     * It is used to have a better print
     *
     * @return the string with all the info about a person
     */
    @Override
    public String toString() {

        /*
        If is not on break only the info is printed
        If is on break at the end of the info is printed that Is on a pause
         */
        if (!isOnPause) {
            return name + " " + gender + " " + age;
        } else {
            return name + " " + gender + " " + age + " Is on pause";
        }
    }
}
