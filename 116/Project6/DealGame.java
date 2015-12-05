import java.util.*;
import java.io.*;
/**
 * This class provides all functions of the
 * CSC116 "Deal or No Deal" Game
 * @author Jessica Fang
 */
public class DealGame{

    /** This is the number of boxes in the game */
    public static final int NUM_BOXES = 26;


    /** These are the values that will be used in the game */
    public static final double[] BOX_VALUES = {0.01, 1, 5, 10, 25, 50, 75,
                                            100, 200, 300, 400, 500,
                                             750, 1000, 5000, 10000,
                                             25000, 50000, 75000,
                                             100000, 200000, 300000,
                                             400000, 500000, 750000,
                                             1000000};

    /** These are the number of boxes to be opened in each round */
    public static final int[] BOXES_IN_ROUND = {0, 6, 5, 4, 3, 2,
                                                 1, 1, 1, 1, 1};

    /** This is the number of rounds in the game */
    public static final int NUM_ROUNDS = 10;

    /** This is the number of times boxes are swapped during the set up */
    private static final int BOX_SWAPS = 500;

    /** This is the name of the file that contains the high score */
    public static final String HIGH_SCORE_FILE = "highscore.txt";

    File scoreFile = new File(HIGH_SCORE_FILE);

    private BoxList boxes;
    private int playerChoice;
    private boolean chosen;
    private int roundNumber;
    private int numBoxesOpened;
    private int totalBoxesOpened;
    private double highScore;
    private Scanner score;
    private PrintStream newScore;

    /**
     * Creates a new "Deal or No Deal" game
     * @param testing true if test game, false if not test game
     */
    public DealGame(boolean testing){
        boxes = new BoxList(BOX_VALUES);
        if(testing == false){
            boxes.shuffle(BOX_SWAPS);
        }
        if(scoreFile.exists()){
            try{
                score = new Scanner(scoreFile);
            }catch(FileNotFoundException e){
                System.out.println(e.getMessage());
            }
            if(score.hasNextDouble()){
            	highScore = score.nextDouble();
            }
        }else{
            highScore = 0;
        }
        roundNumber = 1;
        numBoxesOpened = 0;
        totalBoxesOpened = 0;

    }

    /**
     * Returns if player has chosen or not
     * @return true if player has chosen, false if player has not chosen
     */
    public boolean hasPlayerChosenBox(){
        return chosen;
    }

    /**
     * If player has chosen a box, the selected box will be opened.
     * If player has not chosen a box, the selected box will become the player's choice box.
     * @param index index of chosen box
     */
    public void selectBox(int index){
        if(chosen == false){
            chosen = true;
            playerChoice = index;
        }else{
            boxes.open(index);
            numBoxesOpened++;
            totalBoxesOpened++;
        }
    }

    /**
     * Calculates and returns the number of boxes left to open in current round
     * @returns remaining boxes in round
     */
    public int getBoxesRemainingToOpenThisRound(){
        return BOXES_IN_ROUND[roundNumber] - numBoxesOpened;
    }

    /**
     * Returns boxes opened in current
     * @return boxes opened in round
     */
    public int getBoxesOpenedThisRound(){
        return numBoxesOpened;
    }

    /**
     * Returns round number
     * @return round number
     */
    public int getRound(){
        return roundNumber;
    }

    /**
     * Starts next round
     */
    public void startNextRound(){
        roundNumber++;
        numBoxesOpened = 0;
    }

    /**
     * Returns if round has ended
     * @return true if end of round, false if not end of round
     */
    public boolean isEndOfRound(){
        if(BOXES_IN_ROUND[roundNumber] == numBoxesOpened){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Returns value of player's box
     * @return value of player's box
     */
    public double getPlayerBoxValue(){
        return boxes.getValue(playerChoice);
    }

    /**
     * Returns if box at index is open or not
     * @return true if box at index is open, false if box at index is not open
     */
    public boolean isBoxOpen(int index){
        return boxes.isOpen(index);
    }

    /**
     * Returns value of box at index
     * @return value of box at index
     */
    public double getValueInBox(int index){
        return boxes.getValue(index);
    }

    /**
     * Calculates and returns current offer
     * @return current offer
     */
    public double getCurrentOffer(){
        return (boxes.averageValueOfUnopenedBoxes() * roundNumber) / NUM_ROUNDS;
    }

    /**
     * Returns high score
     * @return high score
     */
    public double getHighScore(){
        return highScore;
    }

    /**
     * Replaces high score if value is greater than current high score value.
     * @param value final score of game
     * @return true if value is greater than current high score
     */
    public boolean isNewHighScore(double value){
        if(value > highScore){
            try{
                newScore = new PrintStream(new File(HIGH_SCORE_FILE));
                newScore.print(value);
            }catch (FileNotFoundException e){
                System.out.println(e.getMessage());
            }
            highScore = value;
            return true;
        }else{
            return false;
        }
    }

}
