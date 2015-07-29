/**
 * Program to test BoxOffice
 * @author Jessica Fang
 */
public class BoxOfficeTest {

  	public static void main(String[] args) {

		//Example test case for isValidDate() method
		boolean valid = BoxOffice.isValidDate(2, 25);
		System.out.println("Expected: false \t Actual: " + valid);

		//Add 2 more test cases here for the isValidDate() method
		valid = BoxOffice.isValidDate(-5, 33);
		System.out.println("Expected: false \t Actual: " + valid);

		valid = BoxOffice.isValidDate(4, 10);
		System.out.println("Expected: true \t Actual: " + valid);

        //Example valid test case for isWeekday() method
		boolean weekday = BoxOffice.isWeekday(3, 25);
		System.out.println("Expected: true \t Actual: " + weekday);

		//Add 2 more valid test cases here for the isWeekday() method
		weekday = BoxOffice.isWeekday(4, 10);
		System.out.println("Expected: true \t Actual: " + weekday);

		weekday = BoxOffice.isWeekday(5, 4);
		System.out.println("Expected: false \t Actual: " + weekday);


		//Example valid test case for getCost() method
		int cost = BoxOffice.getCost('c', 4, 21, true, 2, 4);
		System.out.println("Expected: 48 \t Actual: " +  cost);

		//Add 7 more valid test cases here for getCost() method
		cost = BoxOffice.getCost('p', 3, 2, true, 4, 4);
		System.out.println("Expected: 72 \t Actual: " +  cost);

		cost = BoxOffice.getCost('G', 4, 8, false, 1, 2);
		System.out.println("Expected: 20 \t Actual: " +  cost);

		cost = BoxOffice.getCost('c', 5, 15, true, 0, 6);
		System.out.println("Expected: 48 \t Actual: " +  cost);

		cost = BoxOffice.getCost('P', 4, 27, false, 5, 0);
		System.out.println("Expected: 55 \t Actual: " +  cost);

		cost = BoxOffice.getCost('c', 3, 12, true, 7, 1);
		System.out.println("Expected: 64 \t Actual: " +  cost);

		cost = BoxOffice.getCost('c', 5, 3, false, 9, 2);
		System.out.println("Expected: 139 \t Actual: " +  cost);

		cost = BoxOffice.getCost('g', 4, 19, true, 2, 3);
		System.out.println("Expected: 45 \t Actual: " +  cost);

		//Invalid test cases are provided for you below - You do NOT
		//need to add additional invalid tests.  Just make sure these
		//pass!
		try {

			System.out.print("Expected: class java.lang.IllegalArgumentException \tActual: ");
			cost = BoxOffice.getCost('x', 4, 21, true, 2, 4);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getClass());
		}

		try {

			System.out.print("Expected: class java.lang.IllegalArgumentException \tActual: ");
			cost = BoxOffice.getCost('c', 4, 21, true, -2, 4);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getClass());
		}

        try {

			System.out.print("Expected: class java.lang.IllegalArgumentException \tActual: ");
			cost = BoxOffice.getCost('c', 1, 21, true, 2, 4);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getClass());
		}

	}
}
