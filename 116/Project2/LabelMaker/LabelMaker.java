import java.util.*;

/**
* Creates label with data input by user
* @author Jessica Fang
*/
public class LabelMaker {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		System.out.print("Enter line one: ");
		String first = console.nextLine();

		System.out.print("Enter line two: ");
		String second = console.nextLine();

		System.out.print("Enter line three: ");
		String third = console.nextLine();

		System.out.print("Enter line four: ");
		String fourth = console.nextLine();

		drawLabel(first, second, third, fourth);

	}
    /**
    * Prints top of label
    */
    public static void labelTop() {
    System.out.println(" _________________");
    System.out.println("/                 \\");
    System.out.println("|                 |");
    System.out.println("|                 |");
    }

    /**
    * Prints bottom of label
    */
    public static void labelBottom() {
    System.out.println("|                 |");
    System.out.println("|                 |");
    System.out.println("\\_________________/");
    }

    /**
    * Takes user's input and creates a label
    * @param line1 user's first line
    * @param line2 user's second line
    * @param line3 user's third line
    * @param line4 user's fourth line
    */
    public static void drawLabel(String line1, String line2, String line3, String line4){

        int charcount1 = line1.length();
        int charcount2 = line2.length();
        int charcount3 = line3.length();
        int charcount4 = line4.length();
        int n1 = 17 - charcount1;
        int n2 = 17 - charcount2;
        int n3 = 17 - charcount3;
        int n4 = 17 - charcount4;

        labelTop();

        if(n1%2==0){
            System.out.print("|");
            less(n1);
            System.out.print(line1.toUpperCase());
            less(n1);
            System.out.println("|");
        }
        else{
            System.out.print("|");
            more(n1);
            System.out.print(line1.toUpperCase());
            less(n1);
            System.out.println("|");
        }

        evenOdd(n2, line2);
        evenOdd(n3, line3);
        evenOdd(n4, line4);

		labelBottom();
    }

    /**
    * Determines number of spaces needed on
    * left side if 17 - string length is odd
    */
    public static void more(int n){
        for(int i = 1; i <= (n/2)+1; i++){
            System.out.print(" ");
        }
    }

    /**
    * Determines number of spaces needed on
    * right side if 17 - string length is odd
    * or determines number of spaces needed
    * on either side if 17 - string length is even
    */
    public static void less(int n){
        for(int i = 1; i <= (n/2); i++){
            System.out.print(" ");
        }
	}

	/**
    * Determines if 17 - string length is odd or
    * even and what to print for each case
    */
    public static void evenOdd(int n, String line){
        if(n%2==0){
            System.out.print("|");
            less(n);
            System.out.print(line);
            less(n);
            System.out.println("|");
        }
        else{
            System.out.print("|");
            more(n);
            System.out.print(line);
            less(n);
            System.out.println("|");
        }
    }

}
