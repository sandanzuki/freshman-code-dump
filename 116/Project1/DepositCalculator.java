/**
* @author Jessica Fang
* Computes multiple types of
* interest compounding methods
* and prints results to screen
*/


/**
* The DepositCalculator class stores information used within the 
* calculations done by this program.
*/
public class DepositCalculator {

    /**
	* Interest rate (as a percentage)
	*/
	public static final int ANNUAL_INTEREST_RATE = 1;
    /**
	* Time period over which interest is (or isn't) compounded in years
	*/
	public static final int NUMBER_OF_YEARS = 5;
    /**
	* Months in a year
	*/
	public static final int MONTHS_PER_YEAR = 12;
    /**
	* Lowest deposit amount
	*/
	public static final int LOW_DEPOSIT_AMOUNT = 1000;
    /**
	* Highest deposit amount
	*/
	public static final int HIGH_DEPOSIT_AMOUNT = 20000;
    /**
	* Amount deposit is increased
	*/
	public static final int DEPOSIT_AMOUNT_INCREMENT = 1000;

    /**
    * @param args unused
    * Prints out results of calculations in a chart format
    */
    public static void main(String[] args) {
               
        System.out.println("initial   none       monthly    continuous");
        System.out.println("------------------------------------------");
        for(double deposit = LOW_DEPOSIT_AMOUNT; deposit <= HIGH_DEPOSIT_AMOUNT; deposit += DEPOSIT_AMOUNT_INCREMENT){
        /**
		* Amount without compounding of interest
		*/
		double NoComp = calculateAmountNoCompounding(deposit, ANNUAL_INTEREST_RATE, NUMBER_OF_YEARS);
        /**
		* Amount with monthly compounding of interest
		*/
		double MonthComp = calculateAmountMonthlyCompounding(deposit, ANNUAL_INTEREST_RATE, NUMBER_OF_YEARS);
        /**
		* Amount with continuous compounding of interest
		*/
		double ContsComp = calculateAmountContinuousCompounding(deposit, ANNUAL_INTEREST_RATE, NUMBER_OF_YEARS);

        System.out.print(deposit + " ");
        System.out.printf("%10.2f", NoComp); System.out.print(" ");
        System.out.printf("%10.2f", MonthComp); System.out.print(" ");
        System.out.printf("%10.2f", ContsComp); System.out.print(" ");
        System.out.println();
        }
    }

        /**
        * Calculates final amount of deposit with no compounding of interest
        *
        * @param deposit deposit amount
        * @param annualInterestRate annual interest rate
        * @param numberOfYears number of years
        * @return final amount
        */
        public static double calculateAmountNoCompounding(double deposit, double annualInterestRate,
                                                    int numberOfYears) {
            /**
			* Calculated amount without compounding of interest
			*/
			double answer = deposit *(1+((.01*annualInterestRate)*numberOfYears));

            return answer;
        }

        /**
        * Calculates final amount of deposit with monthly compounding of interest
        *
        * @param deposit deposit amount
        * @param annualInterestRate annual interest rate
        * @param numberOfYears number of years
        * @return final amount
        */
        public static double calculateAmountMonthlyCompounding(double deposit, double annualInterestRate,
                                                         int numberOfYears) {
            /**
			* Calculated amount with monthly compounding of interest
			*/
			double answer = deposit * Math.pow((1+((.01*annualInterestRate)/MONTHS_PER_YEAR)),(MONTHS_PER_YEAR*numberOfYears));

            return answer;

        }

        /**
        * Calculates final amount of deposit with continuous compounding of interest
        *
        * @param deposit deposit amount
        * @param annualInterestRate annual interest rate
        * @param numberOfYears number of years
        * @return final amount
        */
        public static double calculateAmountContinuousCompounding(double deposit, double annualInterestRate,
                                                            int numberOfYears) {
            /**
			* Calculated amount with continuous compounding of interest
			*/
			double answer = deposit * Math.pow(Math.E,((.01*annualInterestRate)*numberOfYears));

            return answer;


        }

    }

