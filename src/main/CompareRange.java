package main;

import java.util.Comparator;
/**
* <h1>CompareRange!</h1>
* The CompareRange class implement methods to sort the ZipCodes based on ascending order!
* <p>
*/
public class CompareRange implements Comparator<Range> {

	@Override
	public int compare(Range range1, Range range2) {
		
		return range1.getLower_Range()-range2.getLower_Range();
	}

}
