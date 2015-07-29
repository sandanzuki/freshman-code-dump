/**
 * Program to test MagicSquare
 *
 * @author Jessica Fang
 */
public class MagicSquareTest {

  	public static void main(String[] args) {

            int[][] test1 = {{3, 5, 9},
                             {4, 1, 2},
                             {6, 8, 7}};

		//Example valid test case for isMagicSquare() method
		boolean isSquare = MagicSquare.isMagicSquare(test1);
		System.out.println("Expected: false \t Actual: " + isSquare);

		//Add 4 more valid test cases here for the isMagicSquare() method
        //Use arrays with the same number of rows and columns
            test1 = new int[][]{{5, 5, 5},
                                {5, 5, 5},
                                {5, 5, 5}};

		//Example valid test case for isMagicSquare() method
		isSquare = MagicSquare.isMagicSquare(test1);
		System.out.println("Expected: false \t Actual: " + isSquare);

            int[][] test2 = {{17, 24, 1, 8, 15},
                             {23, 5, 7, 14, 16},
                             {4, 6, 13, 20, 22},
                             {10, 12, 19, 21, 3},
                             {11, 18, 25, 2, 9}};

		//Example valid test case for isMagicSquare() method
		isSquare = MagicSquare.isMagicSquare(test2);
		System.out.println("Expected: true \t Actual: " + isSquare);

            test1 = new int[][]{{1, 5, 9},
                                {4, 2, 3},
                                {6, 8, 7}};

		//Example valid test case for isMagicSquare() method
		isSquare = MagicSquare.isMagicSquare(test1);
		System.out.println("Expected: false \t Actual: " + isSquare);

            test1 = new int[][]{{23, 28, 21},
                                {22, 24, 26},
                                {27, 20, 25}};

		//Example valid test case for isMagicSquare() method
		isSquare = MagicSquare.isMagicSquare(test1);
		System.out.println("Expected: false \t Actual: " + isSquare);



		//Invalid test cases are provided for you below - You do NOT
		//need to add additional invalid tests.  Just make sure these
		//pass!
		try {
                	int[][] bad1 = {{3, 5, 9},
                                    {4, 1, 2},
                                    {4, 1, 2},
                                 	{6, 8, 7}};

			System.out.print("Expected: class java.lang.IllegalArgumentException \tActual: ");
			isSquare = MagicSquare.isMagicSquare(bad1);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getClass());
		}

		try {

			int[][] bad2 = {{3, 5, 9},
                		 	{4, 1},
                            {4, 1, 2}};

			System.out.print("Expected: class java.lang.IllegalArgumentException \tActual: ");
			isSquare = MagicSquare.isMagicSquare(bad2);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getClass());
		}



	}
}
