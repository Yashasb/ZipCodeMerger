package main;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


/**
* <h1>Merge Shipment ZipCodes!</h1>
* The Merge Shipment ZipCodes program implements an application that
* merges the given input ZipCodes by removing redundant ZipCodes.
* <p>
* 
*
* @author Yashas Basavaraju
* @version 1.0
* @since   2020-02-05
*/
public class ZipCodeMerge {

	
public static void main(String[] args) throws IOException {
	
	/**
	   * This is the main method which merges the input ZipCodes from the input file.
	   * @exception IOException On input error.
	   * @see IOException
	   */

	
	PreProcessing preprocess=new PreProcessing();
	String input_string=preprocess.fileReader("input_file");
	System.out.println("Input Ranges: \n"+ input_string);
	List<Range> Old_Range=preprocess.Splitter(input_string);
	List<Range> Sorted_List=preprocess.get_Sorted_Ranges(Old_Range);
	Merger merger=new Merger();
	List<Range> Merged_List=merger.get_Merged_Ranges(Sorted_List);
	merger.print_Merged_Ranges(Merged_List); 
	
}
	
	
	
	 
    
  

	

}
