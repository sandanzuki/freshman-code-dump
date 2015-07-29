import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * White box testing program for DealGame.
 * @author Jessica Fang
 */
public class DealGameTest {

	/** DealGame object to test */
	private DealGame game;

	/**
	 * Constructs a new DealGame object.  This method should be called
	 * at the start of every test method and whenever a new DealGame
	 * object is required (i.e. when the game needs to be started over
	 */
	public void setUp() {
		//Create a DealGame in test mode. The monetary values will
		//be stored in the BoxList in order
		game = new DealGame(true);
	}

	public boolean resetHighScoreFile() {
		try {
			PrintStream out = new PrintStream(new File(DealGame.HIGH_SCORE_FILE));
			out.print("0.0");
			return true;
		} catch (IOException e) {
			System.out.println("Error occurred while resetting high score file " + e);
			return false;
		}
	}

	/**
	 * Tests the "getBoxesRemainingToOpenThisRound method" and prints results
	 */
	public void testGetBoxesRemainingToOpenThisRound() {
		setUp();
		System.out.println("testGetBoxesRemainingToOpenThisRound()");

		//Test that player can only open six boxes in the first round
		int expected = 6;
		int actual = game.getBoxesRemainingToOpenThisRound();
		System.out.printf("   Expected: %d\t\tActual: %d\n", expected, actual);

		//Select the player's box and show that there are still 6 boxes
		//to open
		game.selectBox(0);
		expected = 6;
		actual = game.getBoxesRemainingToOpenThisRound();
		System.out.printf("   Expected: %d\t\tActual: %d\n", expected, actual);

		//Select the first of the six boxes and check that the count is decreased
		game.selectBox(1);
		expected = 5;
		actual = game.getBoxesRemainingToOpenThisRound();
		System.out.printf("   Expected: %d\t\tActual: %d\n", expected, actual);

		//Select remaining boxes and ensure that the count fully decreases
		game.selectBox(2);
		game.selectBox(3);
		game.selectBox(4);
		game.selectBox(5);
		game.selectBox(6);
		expected = 0;
		actual = game.getBoxesRemainingToOpenThisRound();
		System.out.printf("   Expected: %d\t\tActual: %d\n", expected, actual);

		//Check end of round
		if (game.isEndOfRound()) {
			System.out.printf("   End of Round - PASS\n");
		} else {
			System.out.printf("   End of Round - FAIL\n");
		}

		//Move to next round
		game.startNextRound();

		//TODO write test case here - you may want to test how
		//many boxes a player can open in the second round
        expected = 5;
        actual = game.getBoxesRemainingToOpenThisRound();
        System.out.printf("   Expected: %d\t\tActual: %d\n", expected, actual);

        game.selectBox(7);
        expected = 4;
        actual = game.getBoxesRemainingToOpenThisRound();
        System.out.printf("   Expected: %d\t\tActual: %d\n", expected, actual);

        game.selectBox(8);
        game.selectBox(9);
        game.selectBox(10);
        game.selectBox(11);
        expected = 0;
        actual = game.getBoxesRemainingToOpenThisRound();
        System.out.printf("   Expected: %d\t\tActual: %d\n", expected, actual);

        //Check end of round
        if (game.isEndOfRound()) {
            System.out.printf("   End of Round - PASS\n");
        }else{
            System.out.printf("   End of Round - FAIL\n");
        }
	}

	/**
	 * Tests the "getBoxesOpenedThisRound" method and prints results
	 */
	public void testGetBoxesOpenedThisRound() {
		setUp();
		System.out.println("testGetBoxesOpenedThisRound()");

		//Test that there are no open boxes at the start of the game
		int expected = 0;
		int actual = game.getBoxesOpenedThisRound();
		System.out.printf("   Expected: %d\t\tActual: %d\n", expected, actual);

		//TODO write test case here - you may want to test
		//that the number of boxes opened in the round is
		//increased when the player selects his/her box and another box.
		game.selectBox(0);
		game.selectBox(1);
		game.selectBox(2);
		expected = 2;
		actual = game.getBoxesOpenedThisRound();
		System.out.printf("   Expected: %d\t\tActual: %d\n", expected, actual);

	}

	/**
	 * Tests the "getPlayerBoxValue" method and prints results
	 */
	public void testGetPlayerBoxValue() {
		setUp();
		System.out.println("testGetPlayerBoxValue()");

		//Test that the player's box value is 0.01 since the
		//player's box index is initialized to 0
		double expected = 0.01;
		double actual = game.getPlayerBoxValue();
		System.out.printf("   Expected: %.2f\tActual: %.2f\n", expected, actual);

		//TODO write test case here - you may want to test
		//that the player's box value changes to something
		//else when the player selects a box.
        game.selectBox(1);
		expected = 1;
		actual = game.getPlayerBoxValue();
		System.out.printf("   Expected: %.2f\tActual: %.2f\n", expected, actual);
	}

	/**
	 * Tests the "isBoxOpen" method and prints results
	 */
	public void testIsBoxOpen() {
		setUp();
		System.out.println("testIsBoxOpen()");

		//Test that all boxes are closed at the start of the
		//game
		int expected = 0;
		int actual = 0;
		for (int i = 0; i < DealGame.NUM_BOXES; i++) {
			if (game.isBoxOpen(i)) {
				actual++;
			}
		}
		System.out.printf("   Expected: %d\t\tActual: %d\n", expected, actual);

		//TODO write test case here
		//Test that if a certain box is opened, that the game
		//knows it is open.  A for loop is NOT the best test
		//here because you want to ensure the specific box you
		//open (via selectBox) is the one that is open.
        game.selectBox(0);
        game.selectBox(1);
        expected = 1;
		actual = 0;
		for (int n = 0; n < DealGame.NUM_BOXES; n++) {
			if (game.isBoxOpen(n)) {
				actual++;
			}
		}
		System.out.printf("   Expected: %d\t\tActual: %d\n", expected, actual);
	}

	/**
	 * Tests the "getCurrentOffer" method and prints results
	 */
	public void testGetCurrentOffer() {
		setUp();
		System.out.println("testGetCurrentOffer()");

		//Test initial current offer - this doesn't match
		//what is actually done in game play since the offer
		//isn't made until the end of the 1st round.  That's
		//ok.  White box tests focus on the method's functionality,
		//not the method's functionality as part of the overall
		//game.
		double expected = 13147.75;
		double actual = game.getCurrentOffer();
		System.out.printf("   Expected: %.2f\tActual: %.2f\n", expected, actual);

		//TODO write test case here
		//Test that if the Player's box and the first box
		//is selected, that the current offer changes.  You'll
		//want to calculate the expected value by hand before you
		//run the test case (you should figure out the expected
		//values BEFORE running your tests - your code may not
		//be right).
		game.selectBox(0);
        game.selectBox(1);
		expected = 13673.66;
		actual = game.getCurrentOffer();
		System.out.printf("   Expected: %.2f\tActual: %.2f\n", expected, actual);
	}

	/**
	 * Tests the "getHighScore" method and prints results
	 */
	public void testGetHighScore() {
		//Start with no high score - do before starting game
		if (resetHighScoreFile()) {
			setUp();
			System.out.println("testGetHighScore()");

			//Test that the high score is 0.0
			double expected = 0.0;
			double actual = game.getHighScore();
			System.out.printf("   Expected: %.2f\tActual: %.2f\n", expected, actual);
		} else {
			System.out.println("   Default high score test failed");
		}

		//TODO write test case here
		//Test that a new high score is saved by setting
		//a new high score and then checking that the value
		//is saved.
		game.isNewHighScore(1337.0);
		double expected = 1337.0;
		double actual = game.getHighScore();
        System.out.printf("   Expected: %.2f\tActual: %.2f\n", expected, actual);
	}

	/**
	 * Tests the "getValueInBox" method and prints results
	 */
	public void testGetValueInBox(){
		setUp();
		System.out.println("testGetValueInBox()");

		//Check that the value in box 0 is 0.01
		double expected = 0.01;
		double actual = game.getValueInBox(0);
		System.out.printf("   Expected: %.2f\tActual: %.2f\n", expected, actual);

		expected = 1;
		actual = game.getValueInBox(1);
		System.out.printf("   Expected: %.2f\tActual: %.2f\n", expected, actual);
	}

	/**
     * Tests the "isNewHighScore" method and prints results
     */
	public void testIsNewHighScore(){
		//Start with no high score - do before starting game
		if(resetHighScoreFile()){
			setUp();
			System.out.println("testGetHighScore()");

			//Test that the new score was recorded
			boolean expected = true;
			boolean actual = game.isNewHighScore(10.0);
			System.out.printf("   Expected: %s\tActual: %s\n", expected, actual);
		}else{
			System.out.println("   Setting a new high score test failed");
		}

		//TODO write test case here
		//Test either that a new, higher, score is set, or
		//that a lower score is NOT set.  The best idea,
		//would be to test both paths.
        if(resetHighScoreFile()){
			setUp();
			boolean expected = true;
			boolean actual = game.isNewHighScore(10000.0);
			System.out.printf("   Expected: %s\tActual: %s\n", expected, actual);

            setUp();
			expected = false;
			actual = game.isNewHighScore(10.0);
			System.out.printf("   Expected: %s\tActual: %s\n", expected, actual);
		}else{
			System.out.println("   Setting a new high score test failed");
		}

	}

	/**
	 * Start the test program
	 * @param args command line arguments
	 */
	public static void main(String [] args) {
		//Create DealGameTest object
		DealGameTest test = new DealGameTest();
		//Call all of the test methods
		test.testGetBoxesRemainingToOpenThisRound();
		test.testGetBoxesOpenedThisRound();
		test.testGetPlayerBoxValue();
		test.testIsBoxOpen();
		test.testGetCurrentOffer();
		test.testGetHighScore();
		test.testGetValueInBox();
		test.testIsNewHighScore();
	}

}
