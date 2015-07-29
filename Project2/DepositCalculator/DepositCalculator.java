import java.util.*;

/**
* Calculates 1% to 5% daily compounded interest for a deposit
* between a minimum and maximum number of years given by user
* @author Jessica Fang
*/
public class DepositCalculator {

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);

		System.out.print("Enter deposit amount (to the nearest whole dollar): ");
		double depositAmount = console.nextInt();

		System.out.print("Enter minimum number of years: ");
		int minYears = console.nextInt();

		System.out.print("Enter maximum number of years: ");
		int maxYears = console.nextInt();

		System.out.println("Years 1%       2%       3%       4%       5%");


			for(int yearNumber = minYears; yearNumber <= maxYears; yearNumber++){
				System.out.printf("%4d", yearNumber );
				for(int i = 1; i <= 5; i++){
					double amount = calculateAmount(depositAmount, i, yearNumber, 365);
					System.out.printf(" %8.2f", amount);
					}
				System.out.println("");
			}

	}
	/**
	* Calculates final amount of deposit with periodic compounding of interest
	*
	* @param deposit initial deposit amount
	* @param annualInterestRate annual interest rate
	* @param years number of years
	* @param compoundingPeriodsPerYear number of compounding periods per year
	* @return final amount
	*/
	public static double calculateAmount(double deposit, double annualInterestRate, int years, int compoundingPeriodsPerYear) {
			double answer = deposit*Math.pow(1+((annualInterestRate*(.01))/(compoundingPeriodsPerYear)),compoundingPeriodsPerYear*years);

			return answer;
		}

}
