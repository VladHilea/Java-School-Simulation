import java.util.ArrayList; //imports ArrayLists
import java.util.Arrays; //imports Arrays
import java.util.List; //imports Lists
import java.util.Random; //imports Random

/**
 * This class is used to define random values for the name gender and age and generate random numbers and percentage
 */
public class Values {

    ArrayList<String> names = new ArrayList<String>();

    /**
     * This method is used to generate a random number from 0 to 2
     * x is the random number
     *
     * @return
     */
    public int generateRandomNumber() {
        Random ran = new Random();
        int x = ran.nextInt(3);
        return x;
    }

    /**
     * This method is used to pick a random name from, the List which has a lot of names. The names in the List are from
     * football players from Steaua Bucharest team
     *
     * @return the random picked name
     */
    public String generateRandomName() {
        //This part is to create a List with all the names from an Array
        String name;
        ArrayList<String> names = new ArrayList<String>();
        List<String> listNames = Arrays.asList("Mitica Dragomir" , "Cristian Balgradean" , "Andrei Vlad" , "Bogdan Planic" , "Iulian Cristea" , "Ionut Pantiru" , "Alexandru Stan" , "Marko Momcilovic" , "Cristian Manea" , "Claudiu Belu" , "Dragos Nedelcu" , "Lucian Filip" , "Ovidiu Popescu" , "Florin Tanase" , "Olimpiu Morutan" , "Florinel Coman" , "Dennis Man" , "Adrian Popa" , "Harlem Gnohéré" , "Gigi Becali");

        names.addAll(listNames); // add all the elemnts from the List in the ArrayList

        //Generates a random position from the array list and the name is the one from that position
        Random rnd = new Random();
        int positionInArray = rnd.nextInt(names.size());
        name = names.get(positionInArray);

        return name;
    }

    /**
     * This method is used to generate random gender M or F
     *
     * @return the random picked gender
     */
    public char generateRandomGender() {
        //This part is to crate a List with the chars M and F
        char gender;
        ArrayList<Character> genders = new ArrayList<Character>();
        List<Character> listGenders = Arrays.asList('M' , 'F');

        genders.addAll(listGenders); // adds all the elemts from the List to the Array List

        //This part generates a random position from the ArrayList and the gender from that position is picked
        Random rnd = new Random();
        int positionGender = rnd.nextInt(2);
        gender = genders.get(positionGender);

        return gender;
    }

    /**
     * This method is used to generate random age for the student
     * The student is aged form 1 to 30
     *
     * @return the age of the student
     */
    public int generateRandomAgeStudent() {
        int age;
        Random rnd = new Random();
        age = rnd.nextInt(29) + 1;
        return age;
    }

    /**
     * This method is used to generate random age for the instructor
     * The instructor iis aged from 30 to 60
     *
     * @return the age of the instructor
     */
    public int generanteRandomAgeInstructor() {
        int age;
        Random rnd = new Random();
        age = rnd.nextInt(30) + 30;
        return age;
    }

    /**
     * This method is used to generate random percentage
     * It is generated a random number from 1 to 100
     * To simulate a random percentage chance I verified if the random number is lower or equal to the percentage that
     * needs to be simulated
     *
     * @param percentage the percentage you want to generate
     * @return true if the percentage chance was successful, false if not
     */
    public boolean generatePercentageChance(int percentage) {

        int valueOfNumber;
        Random rnd = new Random();
        valueOfNumber = rnd.nextInt(99) + 1;

        if (valueOfNumber <= percentage) {
            return true;
        } else {
            return false;
        }
    }
}
