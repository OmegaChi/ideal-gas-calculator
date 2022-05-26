import java.util.Scanner;
/**
 * Ideal Gas Law Calculator 1.0
 * Authors: Itzhak Estrella
 *
 * The following project is supposed to 'simulate' a calculator that can solve
 * any Ideal Gas Law problem that is looking solving for a single-unknown
 * variable.
 *
 */
public class IdealGasCalc {

    // The following class constants correspond to the index value found within variableList
    private static final int PRESSURE = 0;
    private static final int VOLUME = 1;
    private static final int MOLES = 2;
    private static final int TEMP = 3;

    public static void main(String[] args){
        //PV = nRT
        String[] variableList = {"Pressure", "Volume", "# of Moles", "Temperature"};

        Scanner key = new Scanner(System.in);
        intro();

        boolean isFinished = false;
        while (!isFinished) {
            displayVariableList(variableList);
            String usersInput = key.next();
            isFinished = checkIfDoneCalc(usersInput);

            if(!isFinished) {
                // Here we convert the users input to a double value since we know its a value
                double calcConversion = Double.parseDouble(usersInput);
                System.out.println(calcConversion);
            }
        }

        key.close();
    }

    // Introduction and instructions of the program
    public static void intro() {
        artIntro();
        System.out.println("Greetings, Scientist!");
        System.out.println("Type out either the name or its initial of the known variable to import its value.");
        System.out.println("Be prepared to import the following numerical values with their appropriate unit.");
        System.out.println("When inputting the value of a variable that is unknown, simply type in an 'x' or 'X'");
        System.out.println("Let's solve some ideal gas problems!\n");
    }

    // The following method displays ASCII ary related to chem
    // This ASCII art is NOT original and was found at: https://ascii.co.uk/art/science
    public static void artIntro() {
        System.out.println("Ideal Gas Law Calculator 1.0\n");
        System.out.println(" |-|    *");
        System.out.println(" |-|   _    *  __");
        System.out.println(" |-|   |  *    |/'");
        System.out.println(" |-|   |~*~~~o~|");
        System.out.println(" |-|   |  O o *|");
        System.out.println("/___\\  |o___O__|\n");
    }

    // This void method prints out the list of variables within the Ideal Gas Law equation
    public static void displayVariableList(String[] variableList) {
        System.out.println("Pick a variable to enter its value: ");
        for (int i = 0 ; i < variableList.length; i++) {
            System.out.println(variableList[i]);
        }
        System.out.println();
        System.out.println("If you are done importing values, type in 'finished' or just 'f'");
        System.out.print("Type in here: ");
    }

    // This method checks if the user is done typing in the calculations
    // Preconditions: if the user is truly done, userInput will ALWAYS == "finished" || "f"
    public static boolean checkIfDoneCalc(String usersInput) {
        usersInput = usersInput.toLowerCase();
        if (usersInput.equals("finished")|| usersInput.equals("f") ) {
            return true;
        } else {
            return false;
        }
    }


}
