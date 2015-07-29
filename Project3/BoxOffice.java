import java.util.*;
/**
 * Takes (valid) user input and calculates the cost of the ticket
 * or tickets user buys.
 * @author Jessica Fang
 */
public class BoxOffice{
    public static void main(String[] args){

        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the Wolfpack Theater Box Office! When prompted, please enter the movie you would like see: C (C-aptain Phillips), G (G-ravity), or P (P-hilomena), the date, whether it is a matinee,  and the number of adult and student tickets you would like to purchase.  The total cost of the tickets will then be displayed.");
        System.out.println();

        System.out.print("Movie (C-aptain Phillips, G-ravity, P-hilomena): ");
        String movie = console.next();
        if(movie.length() != 1){
            System.out.println("Invalid input");
            System.exit(1);
        }
        if(!(movie.charAt(0) == 'c' || movie.charAt(0) == 'g' || movie.charAt(0) == 'p' || movie.charAt(0) == 'C' || movie.charAt(0) == 'G' || movie.charAt(0) == 'P')){
            System.out.println("Invalid input");
            System.exit(1);
        }

        System.out.print("Month: ");
        int month = console.nextInt();

        System.out.print("Day: ");
        int day = console.nextInt();
        if(isValidDate(month, day) == false){
            System.out.println("Invalid input");
            System.exit(1);
        }

        System.out.print("Matinee (y, n): ");
        String matineeMovie = console.next();

        System.out.print("Number of adult tickets: ");
        int numAdult = console.nextInt();
        if(numAdult < 0){
            //throw new IllegalArgumentException("Invalid input");
            System.out.println("Invalid input");
            System.exit(1);
        }

        System.out.print("Number of student tickets: ");
        int numStudent = console.nextInt();
        if(numStudent < 0){
            //throw new IllegalArgumentException("Invalid input");
            System.out.println("Invalid input");
            System.exit(1);
        }

        boolean matinee = isMatinee(matineeMovie);
        System.out.println("Cost of tickets: $" + getCost(movie.charAt(0), month, day, matinee, numAdult, numStudent) + ".00");

    }

    /**
     * Return true if the date is a valid date between March 1 and May 15
     * Return false otherwise
     * @param month month user input
     * @param day day user input
     */
    public static boolean isValidDate (int month, int day){
        if(month == 3 || month == 4 || month == 5){
            if(month == 3 && day >= 1 && day <= 31){
                return true;
                }
            if(month == 4 && day >= 1 && day <= 30){
                return true;
                }
            if(month == 5 && day >= 1 && day <= 15){
                return true;
                }
            return false;
        }
        else{
        return false;
        }
    }

    /**
     * Return true if date falls on Monday through Thursday
     * Return false if date falls on Friday through Sunday
     * @param month month
     * @param day day
     */
    public static boolean isWeekday (int month, int day) {
        int year = 2014;
        int w = year - (14 - month) / 12;
        int x = w + w / 4 - w / 100 + w / 400;
        int z = month +  12 * ((14 - month) / 12) - 2;
        int dayOfWeek = (day + x + (31 * z) / 12) % 7;

        if(dayOfWeek > 0 && dayOfWeek < 5){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Return true if date falls on Monday through Thursday
     * Return false if date falls on Friday through Sunday
     * @param matinee whether tickets are matinee or not
     */
    public static boolean isMatinee(String matinee){
        if(matinee.charAt(0) == (int)'y' || matinee.charAt(0) == (int)'Y'){
            return true;
        }
        else{
            return false;
        }
    }

    public static int isMore(int month, int day){
        if(isWeekday(month, day) == true){
            return 0;
        }
        else{
            return 1;
        }
    }

    /**
     * Calculate and return cost of tickets
     * @param movie movie
     * @param month month
     * @param day day
     * @param matinee whether tickets are matinee or not
     * @param numberOfAdultTickets number of adult tickets
     * @param numberOfStudentTickets number of student tickets
     * @throws IllegalArgumentException if movie is invalid, date is invalid, if number of tickets < 0
     * @return total cost of tickets
     */
    public static int getCost (char movie, int month, int day, boolean matinee, int numberOfAdultTickets, int numberOfStudentTickets) {

        movie = Character.toUpperCase(movie);

        //if tickets aren't valid throw exception
        if(numberOfAdultTickets < 0 || numberOfStudentTickets < 0){
            throw new IllegalArgumentException("Invalid input");
        }

        //if movie isn't valid throw exception
        if(!(movie == 'G' || movie == 'C' || movie == 'P')){
            throw new IllegalArgumentException("Invalid input");
        }

        //check date
        if(isValidDate(month, day) ==  false){
            throw new IllegalArgumentException("Invalid input");
        }

        int price;
        if(movie == 'C'){
            price = 10;
        }
        else{
            price = 8;
        }

        int totalTickets = numberOfAdultTickets + numberOfStudentTickets;

        int weekday = isMore(month, day);
        int cost;

        if(matinee == true){
            cost = (weekday * 3)*(totalTickets) + (totalTickets)*(price - 2);
        }
        else{
            cost = (weekday * 3)*(totalTickets) + (numberOfAdultTickets)*(price) + (numberOfStudentTickets)*(price - 2);
        }

        return cost;
    }


}






