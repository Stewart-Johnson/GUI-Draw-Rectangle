
package cse360assign3;
/**
 * Class to perform arithmetic calculations and return a history of the 
 * calculations performed.
 * 
 * @author Stewart Johnson sajohn32@asu.edu CSE360 assignment3 pin #414
 *
 */

public class Calculator {

	private int total;
	private String str = " 0 ";
	
	/**
	 * Constructor method of Calculator class
	 * @returns total
	 * 
	 */
	
	public Calculator () {
		total = 0;  // not needed - included for clarity
	}
	
	/**
	 * Gets total from calculations made
	 * @return total
	 */
	
	public int getTotal () {
		return total;
	}
	
	/**
	 * a method that adds value and  concatenates str with a + and value 
	 *  
	 * @param value
	 */
	
	public void add (int value) 
	{
		total = value + total;
		str += "+ " + value+" ";
	}
	
	/**
	 * a method that subtracts value and  concatenates str with a - and value
	 * @param value
	 */
	
	public void subtract (int value) 
	{
		total = value - total;
		str += "- " + value+" ";
	}
	
	/**
	 * a method that multiplies value and  concatenates str with a * and value
	 * @param value
	 */
	
	public void multiply (int value) 
	{
		total = total * value;
		str += "* " + value+" ";
	}
	
	/**
	 * a method that divides value and  concatenates str with a / and value
	 * @param value
	 */
	
	public void divide (int value) 
	{
		if(value == 0)
			{
			total = 0;
			str += "/ " + value+" ";
			}
		else
		{
			total = total/value;
			str += "/ " + value+" ";
		}	
	}
	
	/**
	 * a method that returns string representations of the history of calculator function called
	 * @return String representation of Calculations made
	 */
	public String getHistory () {
		return str;
	}
}