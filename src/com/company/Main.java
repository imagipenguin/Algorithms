package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static long countinv = 0;

    public static void log(Object args) {
        //This function was created to make it easier to output to the command line.
        System.out.println(args.toString());
        //Usage: log(string); or log(integer); or log("comment "+integer);
        //This does NOT work with arrays or lists.
    }

    public static void test_mergesort(int[] args) {
        Main.countinv = 0;
        int[] i = mergesortrecursion(args);
        log("The number of inversions is " + countinv);
    }


    public static int[] mergesort(int[] a, int[] b) {
        //Write the code for a sorting a merge here
        //log("Begin Merge");
        int i = 0;
        int j = 0;
        int n = a.length + b.length;
        int[] mergesortout = new int[n];
        //log("Run the for loop");
        for (int k = 0; k < n; k++) {
            System.out.println(Arrays.toString(mergesortout));
            //log("Do the if statement for index " + k + " with i=" + i + " and j=" + j);
            if ((i < a.length) && (j < b.length)) {
                log("length check");
                if ((a[i] <= b[j])) {
                    log("the index of i is " + i);
                    mergesortout[k] = a[i];
                    i++;
                } else if (a[i] > b[j]) {
                    //log("the index of j is " + j);
                    mergesortout[k] = b[j];
                    j++;
                }
            } else if (i == a.length) {
                mergesortout[k] = b[j];
                j++;
            } else if (j == b.length) {
                mergesortout[k] = a[i];
                i++;
            }
        }


        //log("The length of the array is " + n);

        //Keep track of index i and j of the merging arrays
        //Loop from k to length of the merged array
        //If a(i) < b(j) place a(i) in the array
        //Move on to the next index of a

        //Else place b(j) in the array
        //Move on to the next index of b


        //Don't forget edge/end cases!
        log("End of Merge Sort!");
        return mergesortout;
    }

    public static int[] mergesortrecursion(int[] args) {
        //Create the recursion for a merge sort here
        //Split the array into 2 pieces
        //Call mergesort on both arrays
        //Merge the sorted arrays together

        //Don't forget edge/end cases!
        return args;
    }

    public static void main(String[] args) {
        // write your code here
        System.out.println("Begin Code");

        //test case 1 - merge ordered arrays together
        int[] a = new int[]{1, 3, 5, 7};
        int[] b = new int[]{2, 4, 6, 8};
        log("Running mergesort on test case 1");
        int[] c = mergesort(a, b);
        log("Test Case 1 - merging ordered arrays");
        System.out.println(Arrays.toString(c));


        //test case 2 - merge unordered arrays
        int[] a2 = new int[]{1, 5, 3, 7};
        int[] b2 = new int[]{8, 4, 6, 2};
        int[] c2 = mergesortrecursion(a2, b2);
        log("Test Case 2 - merging unordered arrays");
        System.out.println(Arrays.toString(c2));

        /*
        //test case 3 - count the number of inversions for a simple array
        int[] a3 = new int[]{1, 3, 5, 2, 4, 6};
        log("Test case 3 - counting inversions for a simple array");
        log("The answer should be 3");
        test_mergesort(a3);
        */


        /*
        //This is for the actual data...collecting the data takes a lot of time.
        //Only uncomment when you are absolutely ready to test on the real data.
        int[] arr = data();
        int[] testcaseprogressive1 = Arrays.copyOfRange(arr, 0, 10000);
        int[] testcaseprogressive2 = Arrays.copyOfRange(arr, 0, 20000);
        int[] testcaseprogressive3 = Arrays.copyOfRange(arr, 0, 30000);
        int[] testcaseprogressive4 = Arrays.copyOfRange(arr, 0, 40000);
        int[] testcaseprogressive5 = Arrays.copyOfRange(arr, 0, 50000);
        int[] testcaseprogressive6 = Arrays.copyOfRange(arr, 0, 60000);
        int[] testcaseprogressive7 = Arrays.copyOfRange(arr, 0, 70000);
        int[] testcaseprogressive8 = Arrays.copyOfRange(arr, 0, 80000);
        int[] testcaseprogressive9 = Arrays.copyOfRange(arr, 0, 90000);
        int[] testcaseprogressive10 = Arrays.copyOfRange(arr, 0, 100000);
        test_mergesort(testcaseprogressive1);
        test_mergesort(testcaseprogressive2);
        test_mergesort(testcaseprogressive3);
        test_mergesort(testcaseprogressive4);
        test_mergesort(testcaseprogressive5);
        test_mergesort(testcaseprogressive6);
        test_mergesort(testcaseprogressive7);
        test_mergesort(testcaseprogressive8);
        test_mergesort(testcaseprogressive9);
        test_mergesort(testcaseprogressive10);
        */


    }

    public static int[] data() {
        //Reading the text file info.  Do not edit!

        System.out.println("Reading File from Java code");
        //Name of the file
        String fileName = "/Users/Jones Kristin/Desktop/IntegerArray.txt";
        //^^^^^May need to change this file depending on download location.^^^^^
        ArrayList<Integer> ints = new ArrayList<Integer>();
        try {

            //Create object of FileReader
            FileReader inputFile = new FileReader(fileName);

            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);

            //Variable to hold the one line data
            String line;

            // Read file line by line and print on the console
            while ((line = bufferReader.readLine()) != null) {
                ints.add(Integer.parseInt(line));
            }
            //Close the buffer reader
            bufferReader.close();
        } catch (Exception e) {
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }
        int[] arr = ints.stream().mapToInt(i -> i).toArray();

        return arr;
    }


}
