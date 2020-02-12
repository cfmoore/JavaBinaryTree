/**
 * Class for storing temporary numbers
 * @author chad
 *
 * number is an integer to be stored
 * spot is the integer of when it was created in the order
 */


public class Number {
	public int number;
	public int spot;
	
	/**
	 * Setter method for the number
	 * @param number sets the number 
	 */
	public void setNumber(int number)
	{
		this.number = number;
	}
	
	/**
	 * Getter method for the number
	 * @return the number that was set by the constructor
	 */
	public int getNumber()
	{
		return this.number;
	}
	
	/**
	 * Setter for the spot of the number when it was generated
	 * @param spot the time when it was generated
	 */
	public void setSpot(int spot)
	{
		this.spot = spot;
	}
	
	/**
	 * Getter method for the spot
	 * @return the spot when the number was created
	 */
	public int getSpot()
	{
		return this.spot;
	}
}
