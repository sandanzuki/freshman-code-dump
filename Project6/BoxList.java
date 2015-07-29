import java.util.*;
/**
 * This class is used to provide the box
 * array containing all the boxes of the
 * CSC116 "Deal or No Deal" Game
 * @author Jessica Fang
 */
public class BoxList {
    /**
     * All Boxes in "Deal or No Deal" game
     */
    private Box[] boxArray;

    /**
     * Creates "BoxList" object
     * @param monetaryAmounts all monetary values in "Deal or No Deal" game
     */
    public BoxList(double[] monetaryAmounts){
        boxArray = new Box[monetaryAmounts.length];
        for(int i = 0; i < boxArray.length; i++){
			boxArray[i] = new Box(monetaryAmounts[i]);
		}
    }

    /**
     * Returns value of box at index
     * @param index index of chosen box
     * @return value of box at index
     */
    public double getValue(int index){
        return boxArray[index].getValue();
    }

    /**
     * Returns if box at index is open or not
     * @param index index of chosen box
     * @return true if box is open, false if box is not open
     */
    public boolean isOpen(int index){
        return boxArray[index].isOpen();
    }

    /**
     * Opens box at index
     * @param index index of chosen box
     */
    public void open(int index){
        boxArray[index].open();
    }

    /**
     * Returns average value of unopened boxes
     * @return average monetary value of unopened boxes
     */
    public double averageValueOfUnopenedBoxes(){
        double avgVal = 0;
        int counter = 0;
        for(int i = 0; i < boxArray.length; i++){
			if(boxArray[i].isOpen() == false){
                avgVal += boxArray[i].getValue();
                counter++;
			}
		}
		avgVal /= counter;
		return avgVal;
    }

    /**
     * Shuffles boxes for given number of times
     * @param numberOfSwaps number of times to swap the boxes
     */
    public void shuffle(int numberOfSwaps){
        int counter = 0;
        Random rand = new Random();
        while(counter <= numberOfSwaps){
            int n1 = rand.nextInt(boxArray.length);
            int n2 = rand.nextInt(boxArray.length);

            Box temp = boxArray[n1];
            boxArray[n1] = boxArray[n2];
            boxArray[n2] = temp;
            counter++;
        }
    }

    /**
     * Returns string of contents of boxes
     * @return string of box contents
     */
    public String toString(){
        String s = "";
        for(int i = 0; i < boxArray.length; i++){
            s+= boxArray[i].toString() + ", ";
		}
		return s;
    }

}
