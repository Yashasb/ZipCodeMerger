# ZipCodeMerger

This is a java program which merges Zipcodes

# Description

Some items cannot be sent to certain zipcodes. For example for zipcodes ranges:
([49679, 52015], [49800, 50000], [51500, 53479], [45012, 46937], [54012, 59607])
Here, Item cannot be sent to 49680, but can be sent to 45011.

This java program reduces the above ranges to minimum number of ranges required to represent the rule for items shipping.
For example, in above case, ranges can be merged and represented as [45012,46937],[49679,53479],[54012,59607]

# Input
Input is driven from the InputFile text file containing the ranges

# Files
1) resources/input_file : Contains the input data of zipcode ranges.                                                                       
2) main/ZipCodeMerge.java:Main method which reads the input file and processes all other methods from sorting to merging.                 
3) main/CompareRange.java: Comparator to sort ranges based on its lower range value.               
4) main/PreProcessing.java: Contains methods to split & sort the ranges.
5) main/merger.java: Contains main algorithm/logic to merge the sorted ranges.

# Tests
Junit : Contains unit test cases to cover all possible input scenarios.

# Sonar Check
Checks the Code for bugs, Vulnerabilities, coverage, code smell and duplicates.
