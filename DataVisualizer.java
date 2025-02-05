/***************************************************************
* file: DataVisualizer.java
* author: Duve Rodriguez-Garcia
* class: CS 1400 – Introduction to Programming and Problem Solving
*
* assignment: program 3
* date last modified: 11/20/2024
*
* purpose: This program accepts the title of the data, two headers
* and the name and number of a piece of data and organizes the 
* information onto a table for the user to read.
*
****************************************************************/

import java.util.Scanner;

public class DataVisualizer {
    
    // method: main
    // purpose: Takes in the title, headers, and names and number
    // of data and stores it with in an array. It then formats it
    // and outputs it onto a table and a histogram.
    public static void main(String[] arg) {
        Scanner scnr = new Scanner(System.in);

        String listTitle;
        String columnOneHeader;
        String columnTwoHeader;

        System.out.println("Enter a title:");
        listTitle = scnr.nextLine();
        System.out.println("You entered: " + listTitle + "\n");
        
        System.out.println("Enter the column 1 header:");
        columnOneHeader = scnr.nextLine();
        System.out.println("You entered: " + columnOneHeader + "\n");

        System.out.println("Enter the column 2 header:");
        columnTwoHeader = scnr.nextLine();
        System.out.println("You entered: " + columnTwoHeader);
        
        int[] arrayInts = new int[50];
        String[] arrayStrings = new String[50];

        int j = 0;
        while (j >= 0) {

            System.out.println("\nEnter a data point (-1 to stop input):");
            
            String dataLine = scnr.nextLine();

            //Checks for errors
            int commaCount = 0;
            boolean isInt = false;
            for (int i = 0; i < dataLine.length(); i++) {
                if (dataLine.charAt(i) == ',') {
                    commaCount++;
                }
                if (Character.isDigit(dataLine.charAt(i))) {
                    isInt = true;
                }
            }

            if (dataLine.equals("-1")) {
                break;
            }
            else if (!isInt) {
                System.out.println("Error: Comma not followed by an integer");
                continue;
            }
            else if (commaCount > 1) {
                System.out.println("Error: Too many commas in input.");
                continue;
            }
            else if (commaCount == 0) {
                System.out.println("Error: No comma in string.");
                continue;
            }

            arrayInts[j] = findInt(dataLine);
            arrayStrings[j] = dataLine.substring(0, dataLine.indexOf(","));

            System.out.println("Data string: " + arrayStrings[j]);
            System.out.println("Data integer: " + arrayInts[j]);

            j++;

        }
        
        if (j > 1) {
            System.out.printf("\n%33s\n", listTitle);

            System.out.printf("%-20s|%23s\n", columnOneHeader, columnTwoHeader);

            System.out.println("--------------------------------------------------------");
        
            for (int i = 0; i < j; i++) {
                System.out.printf("%-20s|%23d\n", arrayStrings[i], arrayInts[i]);
            }
            System.out.println();

            for (int i = 0; i < j; i++) {
                System.out.printf("%20s ", arrayStrings[i]);
                for (int m = 0; m < arrayInts[i]; m++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    // method: findInt
    // purpose: finds the integer of the data line that the user inputed
    public static int findInt(String input) {
        int index1 = 0;
        int index2 = input.length() - 1;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                index1 = i;
                break;
            }
        }

        if (index1 == index2) {
            int num = Character.getNumericValue(input.charAt(index1));
            return num;
        }
        else {
            return Integer.parseInt(input.substring(index1));
        }
    }

}