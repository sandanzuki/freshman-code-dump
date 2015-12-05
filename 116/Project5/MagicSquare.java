import java.util.*;
import java.io.*;

/**
 * Program to test if given input is
 * or isn't a magic square
 * @author Jessica Fang
 */
public class MagicSquare{

    /**
     * Takes file from input by user, reads file and
     * prints true if given data is a magic square
     * @param args
     */
	public static void main(String[] args) {
		if(args.length != 1){
			System.exit(1);
		}
		String filename = args[0];
		Scanner input = null;
		try {
			input = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		int row = Integer.valueOf(input.nextLine());
		int[][] square = new int[row][row];
		for(int i = 0; i < square.length; i++){
			for(int j = 0; j < square[i].length; j++){
					square[i][j] = input.nextInt();
            }
        }

		isMagicSquare(square);
		System.out.println(isMagicSquare(square));
	}

	/**
     * Tests if 2D array from input file is a magic square and
     * prints true if given data is a magic square.
     * @param square square array read from input file
     * @throw IllegalArgumentException if the square does not have the same number of rows and columns
     * @return true if the square is a magic square, false otherwise
     */
	public static boolean isMagicSquare(int[][] square) {
        for(int i = 0; i < square.length; i++){
			if(square[i].length != square.length){
                throw new IllegalArgumentException("Not a square.");
            }
		}

        int maxNum = ((int)Math.pow(square.length, 2));
        int[] temp = new int[maxNum];
        int p = 0;
        for(int i = 0; i < square.length; i++){
            for(int j = 0; j < square[i].length; j++){
				temp[p] = square[j][i];
				p++;
            }
        }

        Arrays.sort(temp);

		for(int n = 1; n <= maxNum; n++){
			if(Arrays.binarySearch(temp, n) < 0){
                return false;
            }
        }

		int magicSum = square.length*((int)Math.pow(square.length, 2) + 1) / 2;
		int sum = 0;
		int n = square.length;

		//for rows
		for(int i = 0; i < square.length; i++){
            for(int j = 0; j < square[i].length; j++){
                sum += square[i][j];
            }
            if(sum != magicSum){
                return false;
            }
            sum = 0;
        }

        //for columns
        for(int i = 0; i < square.length; i++){
            for(int j = 0; j < square[i].length; j++){
                sum += square[j][i];
            }
            if(sum != magicSum){
                return false;
            }
            sum = 0;
        }

        //for diagonals
        int sumDiag1 = 0;
        int i = 0;
        int j = (square[i].length-1);
        while(i < square.length){
            sumDiag1 += square[i][j];
            i++;
            j--;
        }
        if(sumDiag1 != magicSum){
            return false;
        }

        int sumDiag2 = 0;
        int k = 0;
        while(k < square.length){
            sumDiag2 += square[k][k];
            k++;
        }
        if(sumDiag2 == magicSum){
            return true;
        }else{
            return false;
        }
	}
}
