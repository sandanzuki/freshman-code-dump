import java.util.*;
import java.io.*;

/**
 * Program that traverses a file of Olympics data
 * and prints wanted information out to user
 * @author Jessica Fang
 */
public class Olympics {
	public static int numLines = 0;
	public static Scanner console = new Scanner(System.in);

    /**
     * Reads file input by user
     * and prints to file.
     * @param args
     */
	public static void main(String[] args){
		topOfProgram(console);

	}

	/**
     * Provides user interface
     * @param console user input
     */
    public static void topOfProgram(Scanner console){
        numLines = 0;
		Scanner input = null;
		try {
			input = new Scanner(new File("olympics.txt"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		while(input.hasNextLine()){
			input.nextLine();
			numLines++;
		}
		numLines--;

		String[] name = new String[numLines];
		int[] age = new int[numLines];
		String[] country = new String[numLines];
		int[] year = new int[numLines];
		String[] closeCeremony = new String[numLines];
		String[] sport = new String[numLines];
		int[] gold = new int[numLines];
		int[] silver = new int[numLines];
		int[] bronze = new int[numLines];
		int[] totalMedals = new int[numLines];

		input.close();
		try {
			input = new Scanner(new FileReader("olympics.txt"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

			boolean firstLine = true;
			int i = 0;

			while(input.hasNextLine()){
				if(firstLine) {
					firstLine = false;
					input.nextLine();
					continue;
				}
				String temp = input.nextLine();
				Scanner line = new Scanner(temp);
				line.useDelimiter("\t");


				while(line.hasNextLine()){
					name[i] = line.next();
					age[i] = Integer.valueOf(line.nextInt());
					country[i] = line.next();
					year[i] = line.nextInt();
					closeCeremony[i] = line.next();
					sport[i] = line.next();
					gold[i] = line.nextInt();
					silver[i] = line.nextInt();
					bronze[i] = line.nextInt();
					totalMedals[i] = line.nextInt();
					i++;
				}

			}

			System.out.println("Olympics (2000-2012) - Please enter an option below.");
			System.out.println("C - List Total Medals by Country");
			System.out.println("A - List Athletes by Age and Year");
			System.out.println("N - Search by Athlete Name");
			System.out.println("S - Search by Sport and Year");
			System.out.println("Q - Quit the program");
			String userOption = console.next();
			char option = userOption.charAt(0);
			option = Character.toLowerCase(option);

			while(userOption.length() >= 2 && option != 'c' && option != 'a' && option != 'n' && option != 'q'){
				System.out.println("Invalid option.");
				System.out.println("Olympics (2000-2012) - Please enter an option below.");
				System.out.println("C - List Total Medals by Country");
				System.out.println("A - List Athletes by Age and Year");
				System.out.println("N - Search by Athlete Name");
				System.out.println("S - Search by Sport and Year");
				System.out.println("Q - Quit the program");
				System.out.print("Option: ");
				userOption = console.next();
				option = userOption.charAt(0);
				option = Character.toLowerCase(option);
			}

			if(option == 'c'){
				listCountryMedals(country, totalMedals);
			}else if(option == 'a'){
				listByAgeAndYear(console, name, age, country, year, sport, totalMedals);
			}else if(option == 'n'){
				searchByName(console, name, age, country, year, sport, totalMedals);
			}else if(option == 's'){
				searchBySportAndYear(console, name, country, year, sport, totalMedals);
			}else{
				System.out.println("Goodbye!");
				System.exit(1);
			}

	}


	/**
	 * Lists the grand total of medals for each country
	 * @param country array of countries of each person
	 * @param totalMedals array of number of medals for each person
	 */
	public static void listCountryMedals(String[] country, int[] totalMedals) {

		for(int i = 0; i < numLines; i++){
			int medals = 0;
			String current = country[i];
			while(i < numLines  && country[i].equals(current)){
				medals += totalMedals[i];
				i++;
			}
			i--;
			System.out.printf("%s, %d", country[i], medals);
			System.out.println(" medal(s)");
		}
		topOfProgram(console);
	}

	/**
	 * Lists information for all athletes who were that age when competing in that year's Olympic Games
	 * If age < 0 or year is not valid, output error message and return
	 * @param console user input
	 * @param name array of names of each person
	 * @param age array of age of each person
	 * @param country array of countries of each person
	 * @param year array of year of participation of each person
	 * @param sport array of sport of each person
	 * @param totalMedals array of number of medals for each person
	 */
	public static void listByAgeAndYear(Scanner console, String[] name, int[] age, String[] country,
	                                    int[] year, String[] sport, int[] totalMedals) {
		System.out.print("Age: ");
		int ageInput = console.nextInt();
			if(ageInput <= 0){
				System.out.println("Invalid age.");
				topOfProgram(console);
			}else{
				System.out.print("Year: ");
				int yearInput = console.nextInt();
				if(yearInput%2 == 0 && yearInput >= 2000 && yearInput <= 2012){
					for(int i = 0; i < numLines; i++){
						if(ageInput == age[i] && yearInput == year[i]){
							System.out.printf("%s, %s, %s, %d", name[i], country[i], sport[i], totalMedals[i]);
							System.out.println(" medal(s)");
						}
					}
				}else{
				System.out.println("Invalid year.");
				topOfProgram(console);
				}
			}
		topOfProgram(console);
	}

	/**
	 * Lists information for all athletes whose name contains that substring ignoring case
	 * @param console user input
	 * @param name array of names of each person
	 * @param age array of age of each person
	 * @param country array of countries of each person
	 * @param year array of year of participation of each person
	 * @param sport array of sport of each person
	 * @param totalMedals array of number of medals for each person
	 */
	public static void searchByName(Scanner console, String[] name, int[] age, String[] country,
	                                int[] year, String[] sport, int[] totalMedals) {
		System.out.println("Name(is/contains): ");
		String want = console.next();
		for(int i = 0; i < numLines; i++){
			if(containsString(name[i], want)){
				System.out.printf("%s, %d, %s, %s, %d, %d", name[i], age[i], country[i], sport[i], year[i], totalMedals[i]);
				System.out.println(" medal(s)");
			}
		}
	topOfProgram(console);
	}

	
	/**
	 * Lists information for each athlete who competed that year in a sport whose name contains the substring, ignoring case.
	 * @param console user input
	 * @param name array of names of each person
	 * @param age array of age of each person
	 * @param country array of countries of each person
	 * @param year array of year of participation of each person
	 * @param sport array of sport of each person
	 * @param totalMedals array of number of medals for each person
	 */
	public static void searchBySportAndYear(Scanner console, String[] name, String[] country,
	                                        int[] year, String[] sport, int[] totalMedals) {
		System.out.println("Sport(is/contains): ");
		String want = console.next();
		System.out.print("Year: ");
		int yearInput = console.nextInt();
		if(yearInput%2 == 0 && yearInput >= 2000 && yearInput <= 2012){
			for(int i = 0; i < numLines; i++){
				if(containsString(sport[i], want) && yearInput == year[i]){
					System.out.printf("%s, %s, %s, %d", name[i], country[i], sport[i], totalMedals[i]);
					System.out.println(" medal(s)");
				}
			}
		}else{
			System.out.println("Invalid year.");
			topOfProgram(console);
		}
	topOfProgram(console);
	}
	
	/**
	 * Checks if give string contains the given substring, ignoring case.
	 * @param full string to check in
	 * @param contained substring to check for
	 * @return false if the substring is present, true if the substring is not
	 */
	public static boolean containsString(String full, String contained) {
		return full.toLowerCase().contains(contained.toLowerCase());
	}
}
