package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h1>PreProcessing!</h1>
 * The PreProcessing class contains all methods to process the input data from reading input file to sorting the ranges
 * <p>
 */

public class PreProcessing {

    /**
     * This method reads the file from the Resources location and generates the input data for processing
     */
    public String fileReader(String filename) throws IOException {

        String input = null;
        BufferedReader br;
        File input_file=new File("src\\resources\\"+ filename );


        br = new BufferedReader(new FileReader(input_file));
        String temp=""; 

        while ((temp=br.readLine()) != null) {
            input=temp;
        }
        br.close();

        return input;

    }


    /**
     * This method splits the input data into individual objects for processing
     */
    public List<Range> Splitter(String input) {

        if(input==null) {
            throw new IllegalArgumentException("Length of input should be > 0");
        }
        input=input.replaceAll("\\s", "");
        Pattern p = Pattern.compile("\\[(.*?)\\]");
        Matcher m = p.matcher(input);

        List<String> ranges=new ArrayList<String>();

        while(m.find()) {
            String patternStr = "\\[[0-9][0-9][0-9][0-9][0-9]\\,[0-9][0-9][0-9][0-9][0-9]\\]";
            Pattern pattern = Pattern.compile(patternStr);
            Matcher matcher = pattern.matcher(m.group());


            if(!matcher.matches()) {
                throw new IllegalArgumentException("Input not in correct format");
            }
            ranges.add(m.group());
        }
        System.out.println("\n");
        
        List<Range> Old_Range=new ArrayList<Range>();
        
        for(int i=0;i<ranges.size();i++) {
            String range_array[]=ranges.get(i).replaceAll("\\[|\\]","").split(",");
            Range range=new Range(Integer.valueOf(range_array[0].trim()),Integer.valueOf(range_array[1].trim()));
            Old_Range.add(range);

            if(range.getLower_Range()>range.getUpper_Range()) {
                throw new IllegalArgumentException("Lower Range greater than upper range");
            }


        }
        return Old_Range;



    }

    /**
     * This method sorts the input ranges based on lower bound of each range
     */
    public List<Range> get_Sorted_Ranges(List<Range> Old_Range) {

        Collections.sort(Old_Range,new CompareRange());

        return Old_Range;

    }

}
