package main;


/**
* <h1>Range!</h1>
* This is the Range Bean Class which has methods to get and set individual Ranges
* <p>
*/

public class Range {

	private int Lower_Range;
	private int Upper_Range;
	
	
	public Range(int lower_Range, int upper_Range) {
		super();
		Lower_Range = lower_Range;
		Upper_Range = upper_Range;
	}
	
	public int getLower_Range() {
		return Lower_Range;
	}
	public void setLower_Range(int lower_Range) {
		Lower_Range = lower_Range;
	}
	public int getUpper_Range() {
		return Upper_Range;
	}
	public void setUpper_Range(int upper_Range) {
		Upper_Range = upper_Range;
	}
}
