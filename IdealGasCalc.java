import java.util.Locale;
import java.util.Scanner;
/**
 * Ideal Gas Law Calculator 1.1
 * Authors: Itzhak Estrella
 *
 * The following project is supposed to 'simulate' a calculator that can solve
 * any Ideal Gas Law problem that is looking solving for a single-unknown
 * variable.
 **/
public class IdealGasCalc {

    // The following class constants correspond to the index value found within variableList
    private static final int PRESSURE = 0;
    private static final int VOLUME = 1;
    private static final int MOLES = 2;
    private static final int TEMP = 3;

    // Constants for units
    public static enum Units {
        // Pressure Units
        ATMOSPHERE, ATM, MMHG, INHG, PASCAL, PA, KILOPASCAL, KPA, PSI,
        // Volume Units
        // Temperature Units
        KELVIN, K, CELSIUS, C
    }

    public static void main(String[] args){
        //PV = nRT
        String[] variableList = {"Pressure", "Volume", "# of Moles", "Temperature"};

        Scanner key = new Scanner(System.in);
        intro();

        boolean isFinished = false;
        calculationProcess(isFinished, variableList, key);

        key.close();
    }

    // Main while loop that iterates the calculation process until user is done entering all known values
    public static int[] calculationProcess(boolean isFinished, String[] variableList, Scanner key) {
        final String[] COPY = variableList;
        int[] importedData = new int[variableList.length];

        while (!isFinished) {
            displayVariableList(variableList);
            String usersInput = key.next();
            isFinished = checkIfDoneCalc(usersInput);

            if(!isFinished) {
                int chosenVariable = grabIndexInVariableList(usersInput);
                String data = getVariablesData(key, chosenVariable, COPY);
                double numData = returnNumData(data);
                String unitData = returnUnitData(data);
                numData = appropriateConversion(data, numData);
                // Here we convert the users input to a double value since we know its a value
                double calcConversion = Double.parseDouble(usersInput);
            }
        }
        return importedData;
    }

    // Introduction and instructions of the program
    public static void intro() {
        artIntro();
        System.out.println("Greetings, Scientist!");
        System.out.println("Type out either the name or the initial of the known variable to then input its value.");
        System.out.println("Be prepared to import the following numerical values with their appropriate unit.");
        System.out.println("Please keep both the data spaced out (Ex: 298 kelvin).");
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
        for (String var : variableList) {
            System.out.println(var);
        }
        System.out.println();
        System.out.println("If you are done importing values, type in 'finished' or just 'f'");
        System.out.print("Type variable here: ");
    }

    // This method checks if the user is done typing in the calculations
    // Preconditions: if the user is truly done, userInput will ALWAYS == "finished" || "f"
    public static boolean checkIfDoneCalc(String usersInput) {
        // Here we trim and lowercase the users input to avoid bugs
        usersInput = usersInput.toLowerCase().trim();
        if (usersInput.equals("finished")|| usersInput.equals("f") ) {
            return true;
        } else {
            return false;
        }
    }

    public static int grabIndexInVariableList(String usersInput) {
        // Here we trim lowercase the users input to avoid bugs
        usersInput = usersInput.toLowerCase().trim();
        if (usersInput.equals("pressure") || usersInput.equals("p")) {
            return PRESSURE;
        } else if (usersInput.equals("volume") || usersInput.equals("v")) {
            return VOLUME;
        } else if (usersInput.equals("temperature") || usersInput.equals("t")) {
            return TEMP;
        } else { // here we are assuming "moles", "m" or "n"
            return MOLES;
        }
    }

    // The following method returns the users input with the value and corresponding unit
    public static String getVariablesData(Scanner key, int chosenVariable, String[] variableList) {
        System.out.println(variableList[chosenVariable] + "'s Value");
        System.out.print("Type here: ");
        String valueWithUnit = key.next();
        return valueWithUnit.toLowerCase();
    }

    // The following method returns the number that the user previously inputted
    public static double returnNumData(String data) {
        Scanner usersInput = new Scanner(data);
        if (usersInput.hasNextDouble()) {
            return usersInput.nextDouble();
        } else { // Must mean that user imported an 'X' or 'x' for unknown
            return 0;
        }
    }

    // The following method return the unit that the user previously inputted
    public static String returnUnitData(String data) {
        Scanner usersInput = new Scanner(data);
        usersInput.next(); // Skip through the numerical data
        if (usersInput.hasNext()) {
            return usersInput.next();
        } else {
            return "DEFUALT";
        }
    }

    // The following method checks if a conversion must be to make sure we are using the right
    // units that correspond with the gas constant R
    public static double appropriateConversion(String data, double numData) {

    }

}
