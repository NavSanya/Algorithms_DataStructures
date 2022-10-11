import java.io.*;
import java.util.*;

public class BinarySearch {

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

    protected int binarySearch(int[] arr, int target, int low, int high) {
        if(low>high)
            return -1;
        
        int mid = (low + high) / 2;
        if(target == arr.at(mid))
        {
            return mid;
        }

        if(target < arr.at(mid))
        {
            binarySearch(arr, target, low, mid);
        }

        if(target > arr.at(mid))
        {
            binarySearch(arr, target, mid+1, high);
        } 
    }// binarySearch()
}// Class BinarySearch

class Main {

    public static void main(String args[]) throws IOException {
        BinarySearch bs = new BinarySearch();
        int size = 10;
        int arrAns;
        int arr[] = bs.initializeArrayWithRandomNumbers(size);
        System.out.println("Array that needs to be searched through");
        bs.printArray(arr);

        System.out.println("**********Binary Search**********");
        Arrays.sort(arr);
        Random rand = new Random();
        int tar = rand.nextInt(size);
        System.out.println("Value to be searched: " + tar);
        arrAns = bs.binarySearch(arr, tar, 0, arr.length - 1);
        System.out.println("Value present on Index: " + arrAns);

    }// main()
}// Class Main
