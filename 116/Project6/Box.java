/**
 * This class is used to provide the boxes used in
 * in the CSC116 "Deal or No Deal" Game
 * @author Jessica Fang
 */
public class Box{
	/**
	 * Amount of money in box
	 */
	private double monies;

    /**
     * Whether the box is open or not
     */
	private boolean open;

    /**
     * Creates "Box" object
     * @param value of box
     */
	public Box(double value){
		monies = value;
		open = false;
	}

    /**
     * Returns value of box
     * @return value of box
     */
	public double getValue(){
		return monies;
	}

    /**
     * Returns whether the box is open or not
     * @return true if box is open, false if box is closed
     */
	public boolean isOpen(){
		return open;
	}

	/**
     * opens box
     */
	public void open(){
		open = true;
	}

    /**
     * Returns string whether box is open and value of box
     * @return whether box is open and value of box
     */
    public String toString(){
        return "Open: " + isOpen() + " Value: " + getValue();
    }
}
