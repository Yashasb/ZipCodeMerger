package test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;
import main.Merger;
import main.PreProcessing;
import main.Range;


/**
 * <h1>MergeTest!</h1>
 * This MergeTest class contains the Junit test cases for testing the ShipmentZipCodeMerger Application
 * <p>
 */

public class MergeTest extends TestCase {

    public MergeTest(String name) {
        super(name);
    }

    public void testWrongFileNameGiven() {
        PreProcessing preprocess=new PreProcessing();
        try {
            String input_string=preprocess.fileReader("inputt");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            assertEquals("FileNotFoundException",e.getClass().getSimpleName());

        }

    }

    public void testInputNull() throws IOException {
        PreProcessing preprocess=new PreProcessing();
        String input_string=" ";
        try {
            preprocess.Splitter(input_string);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            assertEquals("IllegalArgumentException",e1.getClass().getSimpleName());
        }

    }

    public void testInputWrongformat() throws IOException {
        PreProcessing preprocess=new PreProcessing();
        String input_string="[49679, 52011], [49800, 30000]";
        try {
            preprocess.Splitter(input_string);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            assertEquals("IllegalArgumentException",e1.getClass().getSimpleName());
        }

    }

    public void testLowerValueGreaterthenUpperValue() throws IOException {
        PreProcessing preprocess=new PreProcessing();
        String input_string="[52012, 52011], [30000, 30001]";
        try {
            preprocess.Splitter(input_string);
        } catch (Exception e1) {

            assertEquals("IllegalArgumentException",e1.getClass().getSimpleName());
        }

    }
    public void testSorting() throws IOException {
        PreProcessing preprocess=new PreProcessing();
        String input_string="[52011, 52012], [30000, 30001]";
        List<Range> Sorted_List = null;
        List<Range> Old_Range=null;
        Old_Range=preprocess.Splitter(input_string);
        Sorted_List=preprocess.get_Sorted_Ranges(Old_Range);
        assertTrue(Sorted_List.get(0).getLower_Range()==30000);
    }


    public void testMergingoverlapping() throws IOException {
        PreProcessing preprocess=new PreProcessing();
        String input_string="[52011,52012], [52005,52016]";

        List<Range> Sorted_List = null;
        List<Range> Old_Range=null;
        Old_Range=preprocess.Splitter(input_string);
        Sorted_List=preprocess.get_Sorted_Ranges(Old_Range);
        Merger merger=new Merger();
        List<Range> Merged_List=merger.get_Merged_Ranges(Sorted_List);
        assertEquals(Merged_List.get(0).getUpper_Range(),52016);
    }

    public void testMerging_non_overlapping() throws IOException {
        PreProcessing preprocess=new PreProcessing();
        String input_string="[52011,52012], [52014,52016]";

        List<Range> Sorted_List = null;
        List<Range> Old_Range=null;
        Old_Range=preprocess.Splitter(input_string);
        Sorted_List=preprocess.get_Sorted_Ranges(Old_Range);
        Merger merger=new Merger();
        List<Range> Merged_List=merger.get_Merged_Ranges(Sorted_List);
        assertEquals(Merged_List.get(0).getUpper_Range(),52012);
    }



}
