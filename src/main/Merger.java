package main;

import java.util.ArrayList;
import java.util.List;

/**
* <h1>Merger!</h1>
* The Merger class contains  methods to merge the ZipCodes and print it!
* <p>
*/
public class Merger {


	/**
	   * This method merges the sorted ranges
	   */
public List<Range> get_Merged_Ranges(List<Range> Old_Range) {
		
		List<Range> merged_list=new ArrayList<Range>();
		Range Range_to_Merge=null;
		for(int i=0;i<Old_Range.size();i++) {
			
			if(i==0) {
				Range_to_Merge=Old_Range.get(0);
			}
			else {
				
		    if(Old_Range.get(i).getLower_Range()<=Range_to_Merge.getUpper_Range()) {
				Range_to_Merge.setUpper_Range(Math.max(Range_to_Merge.getUpper_Range(),Old_Range.get(i).getUpper_Range()));
				}
			else {
				merged_list.add(Range_to_Merge);
				Range_to_Merge=Old_Range.get(i);
			}
		    
			}
			}
		merged_list.add(Range_to_Merge);
		return merged_list;
		}

/**
 * This method prints the merged ranges
 */
public void print_Merged_Ranges(List<Range> Merged_List) {
	System.out.println("-------Merged Output-----------");
	for(int i=0;i<Merged_List.size();i++) {
		 System.out.println("["+ Merged_List.get(i).getLower_Range() + "," + Merged_List.get(i).getUpper_Range()+"]");
		 
	 }
}

		 
}
