import java.io.*;
import java.util.*;

public class LinearSearch {

    /*
     * creating an array of size n
     * initializing the array with random values
     */

    public int[] initializeArrayWithRandomNumbers(int n) {
        int arr[] = new int[n];
        int i;
        Random rand = new Random();
        for (i = 0; i < n; ++i) {
            arr[i] = rand.nextInt(n);
        }
        return arr;
    }// initializeArrayWithRandomNumbers()

    public void printArray(int arr[]) {
        int i;
        for (i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }// printArray()

    protected int linearSearch(int[] arr, int target) {
        for(int i = 0; i<arr.length; ++i)
    {
        if(target == arr[i])
            return i;
    }
    return -1;
    }// linearSearch()
}// Class LinearSearch

class Main {

    public static void main(String args[]) throws IOException {
        LinearSearch bs = new LinearSearch();
        int size = 10;
        int arrAns;
        int arr[] = bs.initializeArrayWithRandomNumbers(size);
        System.out.println("Array that needs to be searched through");
        bs.printArray(arr);

        System.out.println("**********Linear Search**********");
        Random rand = new Random();
        int tar = rand.nextInt(size);
        System.out.println("Value to be searched: " + tar);
        arrAns = bs.linearSearch(arr, tar);
        System.out.println("Value present on Index: " + arrAns);

    }// main()
}// Class Main
