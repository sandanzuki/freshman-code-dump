import java.util.*;
import java.io.*;

/**
 * Reads and encrypts or decrypts file input by user
 * and prints to file.
 * @author Jessica Fang
 */
public class Cipher{
    /**
     * Original alphabet
     */
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * Encoded alphabet
     */
    public static final String REPLACEMENT = "ckdlurmxnwvehbayoifgqzjstpCKDLURMXNWVEHBAYOIFGQZJSTP";
    /**
     * Output printstream
     */
    public static PrintStream output = null;

    /**
     * Reads and encrypts or decrypts file input by user
     * and prints to file.
     * @param args unused.
     */
    public static void main(String[] args){
        userInterface();
    }

    /**
     * Provides the user interface.
     */
    public static void userInterface(){
        Scanner console = new Scanner(System.in);

        System.out.println("Welcome. This is program will encrypt or decrypt a given input file and output the result to an output file.");
        System.out.println("Enter E-ncode, D-ecode, or Q-uit: ");
        String options = console.next();
        char option = options.charAt(0);

        if(Character.toUpperCase(option) == 'Q'){
        System.exit(1);
        }
        else{
            boolean encode;
            if(Character.toUpperCase(option) == 'E'){
                encode = true;
            }
            else{
                encode = false;
            }
            Scanner input = getInputScanner(console);
            PrintStream output = getOutputPrintStream(console);
            processFile(encode, input, output);
        }


    }

    /**
     * Recieves user input for input file's name
     * @param console user input
     * @exception file not found
     * @return Scanner for an input file
     */
    //Use a try/catch block to catch and handle any FileNotFoundException's that occur
    public static Scanner getInputScanner(Scanner console){

        Scanner input = null;
        while (input == null){
            System.out.print("Enter input file: ");
            String filename = console.next();
            try {
                input = new Scanner(new File(filename));
            }
            catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    /**
     * Receives user input for out file's name
     * @param console user input
     * @exception file not found
     * @return PrintStream for an output file
     */
    //Use a try/catch block to catch and handle any FileNotFoundException's that occur
    public static PrintStream getOutputPrintStream(Scanner console){
        System.out.print("Enter output file: ");
        String fileOut = console.next();
        File derp = new File(fileOut);
        while(derp.exists()){
            System.out.println("File already exists");
            System.out.print("Enter output file: ");
            fileOut = console.next();
            derp = new File(fileOut);
        }
        try {
            output = new PrintStream(new File(fileOut));
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return output;
    }


    /**
     * Encodes or decodes input file (depending on user's choice)
     * @param encode true if encoding false if decoding
     * @param input input file
     * @param output output file
     */
    public static void processFile (boolean encode, Scanner input, PrintStream output){
        if(encode == true){
            while(input.hasNextLine()){
            output.println(encodeLine(input.nextLine()));
            }
        }
        else{
            while(input.hasNextLine()){
            output.println(decodeLine(input.nextLine()));
            }
        }
    }

    /**
     * Encodes give line
     * @param line line from input file
     * @return String encoded line
     */
    public static String encodeLine(String line){
        String s = "";
        for (int x = 0; x < line.length(); x++){
            if(ALPHABET.indexOf(line.charAt(x)) == -1)
            {
                s += line.charAt(x);
            }
            else
            {
                s += REPLACEMENT.charAt(ALPHABET.indexOf(line.charAt(x)));
            }
        }
        return s;
    }

    /**
     * Decodes give line
     * @param line line from input file
     * @return String decoded line
     */
    public static String decodeLine(String line){
        String s = "";
        for (int x = 0; x < line.length(); x++){
            if(ALPHABET.indexOf(line.charAt(x)) == -1)
            {
                s += line.charAt(x);
            }
            else
            {
            s += ALPHABET.charAt((REPLACEMENT.indexOf(line.charAt(x))));
            }
        }
        return s;
    }

}
